package github.walkmansit.aoc2020


class Day05(val input:List<String>) : DayAoc<Int,Int> {

    private class Seat private constructor(row:Int, column: Int){

        val id = row * 8 + column

        companion object {
            fun fromCode(code:String) : Seat {

                fun String.asBinarySequence() = sequence {
                    for (ch in asSequence()) {
                        yield(if (ch == 'F' || ch == 'L') 0 else 1)
                    }
                }

                fun numberFromString(line:String) : Int {
                    return line.asBinarySequence().reduce { acc, i -> acc * 2 + i  }
                }

                val column = numberFromString(code.substring(7,10))
                val row = numberFromString(code.substring(0,7))

                return Seat(row,column)

            }
        }
    }



    override fun getResultPartOne(): Int {
        return input.map { Seat.fromCode(it).id }.max() ?: 0
    }

    override fun getResultPartTwo(): Int {
        val sortedIds =  input.map { Seat.fromCode(it).id }.sorted()

        for ( (i,v) in sortedIds.withIndex()){
            if (sortedIds[i+1] - v == 2) return v+1
        }

        return 0
    }
}