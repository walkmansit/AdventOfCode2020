package github.walkmansit.aoc2020

class Day17(val input: List<String>) : DayAoc<Int, Int> {

    private class Simulation(val inpLines: List<String>, val turns: Int) {

        private fun increaseRange(range: IntRange): IntRange {
            return range.first - 1..range.last + 1
        }

        fun simulate3DAndGetSum(): Int {

            var deep = 0 // z
            var height = 0 // y
            var width = 0 // x

            var activeZ = 0..1
            var activeY = 0..1
            var activeX = 0..1

            fun initGreed(): Array<Array<Array<Boolean>>> {

                val offset = turns + 1

                height = inpLines.size + 2 * offset
                width = inpLines[0].length + 2 * offset
                deep = 1 + 2 * offset

                activeZ = (offset..offset)
                activeX = (offset until offset + inpLines[0].length)
                activeY = (offset until offset + inpLines.size)

                val result = Array(deep) { Array(height) { Array(width) { false } } }

                for ((i, line) in inpLines.withIndex())
                    for ((j, char) in line.withIndex()) {
                        if (char == '#') { // isActive
                            result[offset][offset + i][offset + j] = true
                        }
                    }

                return result
            }

            var greed = initGreed() // Z,Y,X

            fun getNextTurnSimulation(): Array<Array<Array<Boolean>>> {

                fun cloneCurrentGreed(): Array<Array<Array<Boolean>>> {

                    val result = Array(deep) { Array(height) { Array(width) { false } } }

                    for (z in activeZ)
                        for (y in activeY)
                            for (x in activeX)
                                if (greed[z][y][x]) result[z][y][x] = true

                    return result
                }

                fun getActiveNeigbordsCount(z: Int, y: Int, x: Int): Int {

                    val range = -1..1
                    var sum = 0

                    for (i in range)
                        for (j in range)
                            for (k in range) {
                                if (i == 0 && j == 0 && k == 0)
                                    continue
                                if (greed[z + i][y + j][x + k]) sum++
                            }

                    return sum
                }

                val buffer = cloneCurrentGreed()

                for (z in activeZ)
                    for (y in activeY)
                        for (x in activeX) {
                            val activeCount = getActiveNeigbordsCount(z, y, x)
                            buffer[z][y][x] =
                                if (greed[z][y][x]) {
                                    activeCount == 2 || activeCount == 3
                                } else (activeCount == 3)
                        }

                return buffer
            }

            var currentTurn = 0
            while (currentTurn != turns) {
                activeZ = increaseRange(activeZ)
                activeY = increaseRange(activeY)
                activeX = increaseRange(activeX)
                greed = getNextTurnSimulation()
                currentTurn++
            }

            var sum = 0
            for (z in 0 until deep)
                for (y in 0 until height)
                    for (x in 0 until width)
                        if (greed[z][y][x]) sum++

            return sum
        }

        fun simulate4DAndGetSum(): Int {

            var deep = 0 // z
            var height = 0 // y
            var width = 0 // x
            var vsize = 0 // v

            var activeZ = 0..1
            var activeY = 0..1
            var activeX = 0..1
            var activeV = 0..1

            fun initGreed(): Array<Array<Array<Array<Boolean>>>> {

                val offset = turns + 1

                height = inpLines.size + 2 * offset
                width = inpLines[0].length + 2 * offset
                vsize = inpLines.size + 2 * offset
                deep = 1 + 2 * offset

                activeZ = (offset..offset)
                activeX = (offset until offset + inpLines[0].length)
                activeY = (offset until offset + inpLines.size)
                activeV = (offset..offset)

                val result = Array(deep) { Array(height) { Array(width) { Array(vsize) { false } } } }

                for ((i, line) in inpLines.withIndex())
                    for ((j, char) in line.withIndex()) {
                        if (char == '#') { // isActive
                            result[offset][offset + i][offset + j][offset] = true
                        }
                    }

                return result
            }

            var greed = initGreed() // Z,Y,X

            fun getNextTurnSimulation(): Array<Array<Array<Array<Boolean>>>> {

                fun cloneCurrentGreed(): Array<Array<Array<Array<Boolean>>>> {

                    val result = Array(deep) { Array(height) { Array(width) { Array(vsize) { false } } } }

                    for (z in activeZ)
                        for (y in activeY)
                            for (x in activeX)
                                for (v in activeV)
                                    if (greed[z][y][x][v]) result[z][y][x][v] = true

                    return result
                }

                fun getActiveNeigbordsCount(z: Int, y: Int, x: Int, v: Int): Int {

                    val range = -1..1
                    var sum = 0

                    for (i in range)
                        for (j in range)
                            for (k in range)
                                for (m in range) {
                                    if (i == 0 && j == 0 && k == 0 && m == 0)
                                        continue
                                    if (greed[z + i][y + j][x + k][v + m]) sum++
                                }

                    return sum
                }

                val buffer = cloneCurrentGreed()

                for (z in activeZ)
                    for (y in activeY)
                        for (x in activeX)
                            for (v in activeV) {
                                val activeCount = getActiveNeigbordsCount(z, y, x, v)
                                buffer[z][y][x][v] =
                                    if (greed[z][y][x][v]) {
                                        activeCount == 2 || activeCount == 3
                                    } else (activeCount == 3)
                            }

                return buffer
            }

            var currentTurn = 0
            while (currentTurn != turns) {
                activeZ = increaseRange(activeZ)
                activeY = increaseRange(activeY)
                activeX = increaseRange(activeX)
                activeV = increaseRange(activeV)
                greed = getNextTurnSimulation()
                currentTurn++
            }

            var sum = 0
            for (z in 0 until deep)
                for (y in 0 until height)
                    for (x in 0 until width)
                        for (v in 0 until vsize)
                            if (greed[z][y][x][v]) sum++

            return sum
        }
    }

    override fun getResultPartOne(): Int {
        return Simulation(input, 6).simulate3DAndGetSum()
    }

    override fun getResultPartTwo(): Int {
        return Simulation(input, 6).simulate4DAndGetSum()
    }
}
