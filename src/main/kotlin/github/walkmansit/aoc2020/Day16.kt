package github.walkmansit.aoc2020

class Day16(val input: String) : DayAoc<Int, Long> {

    private class TicketScanner private constructor(
        val fieldValidators: LinkedHashMap<String, Array<IntRange>>,
        val myTicket: Array<Int>,
        val nearbyTickets: Array<Array<Int>>
    ) {

        fun getScanningErrorRate(): Int {

            /*fun getInvalidNumbersInTicket(ticket:Array<Int>) : List<Int> {
                val allRanges = fieldValidators.values.flatMap { it.toList() }
                return ticket.filter { num -> allRanges.all { range -> !range.contains(num) } }
            }*/

            val allRanges = fieldValidators.values.flatMap { it.toList() }
            return nearbyTickets.flatMap { t -> t.toList() }
                .filter { num -> allRanges.all { range -> !range.contains(num) } }.sum()
        }

        fun getDepartmentValuesMult(): Long {

            val validTickets: MutableList<Array<Int>> = mutableListOf()

            val allRanges = fieldValidators.values.flatMap { it.toList() }
            validTickets.add(myTicket)
            validTickets.addAll(nearbyTickets.filter { nums -> nums.all { num -> allRanges.any { it.contains(num) } } })

            fun getColumnBy(col: Int): Array<Int> {

                val result = Array(validTickets.size) { 0 }

                for (i in validTickets.indices)
                    result[i] = validTickets[i][col]

                return result
            }

            fun numsValidForField(nums: Array<Int>, column: String): Boolean {
                return nums.all { num -> fieldValidators[column]!!.any { r -> r.contains(num) } }
            }

            val n = fieldValidators.size
            val mt = Array(n) { -1 }
            val g = Array(n) { mutableListOf<Int>() }
            val used = mutableListOf<Int>()

            for ((i, key) in fieldValidators.keys.withIndex()) {
                for (col in myTicket.indices) {
                    if (numsValidForField(getColumnBy(col), key)) {
                        g[i].add(col)
                    }
                }
            }

            fun tryKuhn(v: Int): Boolean {

                if (used.contains(v)) return false
                used.add(v)

                for (i in g[v].indices) {
                    val to = g[v][i]
                    if (mt[to] == -1 || tryKuhn(mt[to])) {
                        mt[to] = v
                        return true
                    }
                }
                return false
            }

            for (i in g.indices) {

                used.clear()
                tryKuhn(i)
            }

            var mult = 1L

            for ((i, v) in mt.withIndex()) {
                if (v < 6 && i != -1) {
                    mult *= myTicket[i]
                }
            }
            return mult
        }

        companion object {

            private val FIELD_REGEX = Regex("([a-z ]+): (\\d+)-(\\d+) or (\\d+)-(\\d+)")

            fun fromInput(inp: String): TicketScanner {
                val parts = inp.split("\n\n")

                val fields: LinkedHashMap<String, Array<IntRange>> = linkedMapOf()
                for (field in parts[0].split("\n")) {
                    val fieldMatch = FIELD_REGEX.matchEntire(field)!!
                    fields[fieldMatch.groupValues[1]] = arrayOf(
                        fieldMatch.groupValues[2].toInt()..fieldMatch.groupValues[3].toInt(),
                        fieldMatch.groupValues[4].toInt()..fieldMatch.groupValues[5].toInt()
                    )
                }

                val myTicket = parts[1].split("\n")[1].split(",").map { it.toInt() }.toTypedArray()

                val nearbyLines = parts[2].split("\n")
                val height = nearbyLines.size - 1
                val width = nearbyLines[1].split(",").size

                val massive = Array(height) { Array(width) { 0 } }

                for (i in 0 until height) {
                    val line = nearbyLines[i + 1].split(",").map { it.toInt() }
                    for (j in 0 until width) {
                        massive[i][j] = line[j]
                    }
                }

                return TicketScanner(fields, myTicket, massive)
            }
        }
    }

    override fun getResultPartOne(): Int {
        return TicketScanner.fromInput(input).getScanningErrorRate()
    }

    override fun getResultPartTwo(): Long {
        return TicketScanner.fromInput(input).getDepartmentValuesMult()
    }
}
