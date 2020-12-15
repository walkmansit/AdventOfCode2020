package main.days

object Day15 {

    private val input = arrayOf(0,13,1,8,6,15)
    
    class NumberGame(private val initNums: Array<Int>){

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

    fun getResult() : Int {
        return NumberGame(input).play(2020)
    }

    fun getResultAdvanced() : Int {

        return NumberGame(input).play(30000000)
    }

}