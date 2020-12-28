package github.walkmansit.aoc2020

class Day03(val input: List<String>) : DayAoc<Int, Long> {

    private val appendPoint = Point(3, 1)

    private data class Point(val x: Int, val y: Int)

    private class CustomMap(val lines: List<String>) {

        private val points = listOf(Point(1, 1), Point(3, 1), Point(5, 1), Point(7, 1), Point(1, 2))

        private val width = lines[0].length

        private val treeChar = '#'

        fun isTreeInPosition(p: Point): Boolean {
            return lines[p.y][p.x] == treeChar
        }

        fun containsPoint(p: Point): Boolean {
            return p.y < lines.count() && p.x < lines[0].length
        }

        fun appendPointToInitial(init: Point, append: Point): Point {
            val x = (init.x + append.x) % width
            return Point(x, init.y + append.y)
        }

        fun countTrees(point: Point): Int {
            return slope(point).filter { isTreeInPosition(it) }.count()
        }

        fun countTreesForPoints(): Long {
            return points.map { countTrees(it).toLong() }.reduce { a, b -> a * b }
        }

        private fun slope(point: Point) = sequence {
            var currentPoint = point

            while (containsPoint(currentPoint)) {
                yield(currentPoint)
                currentPoint = appendPointToInitial(currentPoint, point)
            }
        }
    }

    override fun getResultPartOne(): Int {
        val map = CustomMap(input)
        return map.countTrees(appendPoint)
    }

    override fun getResultPartTwo(): Long {
        val map = CustomMap(input)
        return map.countTreesForPoints()
    }
}
