package github.walkmansit.aoc2020

import kotlin.math.absoluteValue
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin

class Day12(val input: List<String>) : DayAoc<Int, Int> {

    class ShipNavigator(val commands: Array<String>) {

        private class Direction {

            val directions = arrayOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)

            var value = directions[0] // EAST

            fun rotate(dir: String, angle: Int) {
                val step: Int = (angle / 90) % 4

                if (dir == "R") {
                    value = directions[(directions.indexOf(value) + step) % 4]
                } else if (dir == "L") {
                    value = directions[((directions.indexOf(value) - step) % 4 + 4) % 4]
                }
            }
        }

        fun getFinalManhattanDistance(): Int {

            var y = 0
            var x = 0
            val direction = Direction()
            /*Action N means to move north by the given value.
            Action S means to move south by the given value.
            Action E means to move east by the given value.
            Action W means to move west by the given value.
            Action L means to turn left the given number of degrees.
            Action R means to turn right the given number of degrees.
            Action F means to move forward by the given value in the direction the*/
            commands.forEach {
                when (it[0]) {
                    'N' -> y -= it.substring(1).toInt()
                    'S' -> y += it.substring(1).toInt()
                    'E' -> x += it.substring(1).toInt()
                    'W' -> x -= it.substring(1).toInt()
                    'L' -> direction.rotate("L", it.substring(1).toInt())
                    'R' -> direction.rotate("R", it.substring(1).toInt())
                    'F' -> {
                        val value = it.substring(1).toInt()
                        y += direction.value.first * value
                        x += direction.value.second * value
                    }
                }
            }

            return y.absoluteValue + x.absoluteValue
        }

        fun getFinalManhattanDistanceWithWp(): Int {

            fun rotate(y: Int, x: Int, angle: Double): Pair<Int, Int> {

                val radAngle = (angle / 180) * Math.PI

                val nx = x * cos(radAngle) - y * sin(radAngle)
                val ny = x * sin(radAngle) + y * cos(radAngle)

                return ny.roundToInt() to nx.roundToInt()
            }

            var y = 0
            var x = 0
            var wy = y + 1
            var wx = x + 10

            commands.forEach {
                when (it[0]) {
                    'N' -> wy += it.substring(1).toInt()
                    'S' -> wy -= it.substring(1).toInt()
                    'E' -> wx += it.substring(1).toInt()
                    'W' -> wx -= it.substring(1).toInt()
                    'L' -> {
                        val (ny, nx) = rotate(wy, wx, it.substring(1).toDouble())
                        wy = ny
                        wx = nx
                    }
                    'R' -> {
                        val (ny, nx) = rotate(wy, wx, 360 - it.substring(1).toDouble())
                        wy = ny
                        wx = nx
                    }
                    'F' -> {
                        val value = it.substring(1).toInt()
                        y += wy * value
                        x += wx * value
                    }
                }
            }

            return y.absoluteValue + x.absoluteValue
        }
    }

    override fun getResultPartOne(): Int {
        return ShipNavigator(input.toTypedArray()).getFinalManhattanDistance()
    }

    override fun getResultPartTwo(): Int {
        return ShipNavigator(input.toTypedArray()).getFinalManhattanDistanceWithWp()
    }
}
