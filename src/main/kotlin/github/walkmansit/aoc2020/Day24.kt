package github.walkmansit.aoc2020

class Day24(val input: List<String>) : DayAoc<Int, Int> {

    class Floor {

        private val deltaForSideMap = mapOf(
            "e" to Pair(1, 0),
            "se" to Pair(0, 1),
            "sw" to Pair(-1, 1),
            "w" to Pair(-1, 0),
            "nw" to Pair(0, -1),
            "ne" to Pair(1, -1)
        )

        private var tilesSet: MutableSet<Pair<Int, Int>> = mutableSetOf()

        fun addRoute(route: String) {

            fun getDirectionsFromRoute(route: String) = sequence {
                var i = 0

                do {
                    val candidate = route[i]
                    if (candidate != 'n' && candidate != 's')
                        yield(candidate.toString())
                    else {
                        yield(candidate.toString() + route[++i])
                    }
                    i++
                } while (i != route.length)
            }

            var current = 0 to 0

            for (direction in getDirectionsFromRoute(route)) {
                val delta = deltaForSideMap[direction]!!
                current = current.first + delta.first to current.second + delta.second
            }

            if (!tilesSet.contains(current)) {
                tilesSet.add(current)
            } else
                tilesSet.remove(current)
        }

        fun turnOneDay() {

            fun countBlackNeighbors(current: Pair<Int, Int>): Int {

                var sum = 0

                for (direction in deltaForSideMap.values) {
                    val candidate = current.first + direction.first to current.second + direction.second
                    if (tilesSet.contains(candidate))
                        sum++
                }

                return sum
            }

            val blackCountForWhiteTile: MutableMap<Pair<Int, Int>, Int> = mutableMapOf()

            val buffer: MutableSet<Pair<Int, Int>> = mutableSetOf()

            for (blackTile in tilesSet) {

                for (direction in deltaForSideMap.values) {
                    val candidate = blackTile.first + direction.first to blackTile.second + direction.second

                    if (!tilesSet.contains(candidate)) {

                        if (!blackCountForWhiteTile.containsKey(candidate))
                            blackCountForWhiteTile[candidate] = 1
                        else
                            blackCountForWhiteTile[candidate] = blackCountForWhiteTile[candidate]!! + 1
                    }
                }

                val blackNeighbors = countBlackNeighbors(blackTile)

                if (blackNeighbors == 1 || blackNeighbors == 2) {
                    buffer.add(blackTile)
                }
            }

            for (whiteForTurn in blackCountForWhiteTile.filterValues { it == 2 }) {
                buffer.add(whiteForTurn.key)
            }

            tilesSet = buffer
        }

        fun countBlackTiles(): Int {
            return tilesSet.count()
        }
    }

    override fun getResultPartOne(): Int {
        val floor = Floor()
        for (route in input) {
            floor.addRoute(route)
        }
        return floor.countBlackTiles()
    }

    override fun getResultPartTwo(): Int {
        val floor = Floor()
        for (route in input) {
            floor.addRoute(route)
        }
        repeat(100) { floor.turnOneDay() }
        return floor.countBlackTiles()
    }
}
