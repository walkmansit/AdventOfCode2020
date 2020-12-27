package github.walkmansit.aoc2020

class Day15(val input:String) : DayAoc<Int,Int> {

    private val inputArray = input.split(',').map { it.toInt() }

    class NumberGame(private val initNums: Collection<Int>){

        fun play(targetTurn:Int) : Int {

            val dict : MutableMap<Int, Pair<Int,Int>> = mutableMapOf()

            for ( (i,v) in initNums.withIndex())
                dict[v] = i + 1 to -1

            var lastNumber = initNums.last()
            var currentTurn = initNums.size+1

            fun getNextTurn() : Int {

                val (last,prev) = dict[lastNumber]!!

                val res = if (prev == -1) 0 else last - prev

                if (dict.containsKey(res)){
                    val (lt,_) = dict[res]!!
                    dict[res]  = currentTurn to lt
                }
                else
                    dict[res]  = currentTurn to -1


                return res
            }

            while (currentTurn != targetTurn + 1){
                lastNumber = getNextTurn()
                currentTurn++
            }
            return lastNumber
        }

    }

    override fun getResultPartOne(): Int {
        return NumberGame(inputArray).play(2020)
    }

    override fun getResultPartTwo(): Int {
        return NumberGame(inputArray).play(30000000)
    }

}