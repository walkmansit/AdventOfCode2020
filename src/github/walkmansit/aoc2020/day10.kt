package github.walkmansit.aoc2020

class Day10 (val input:List<String>) : DayAoc<Int,Long> {

    private class AdaptersChain(val adapters : List<Int>){


        fun findDiffMult() : Int {

            val set = adapters.toMutableSet()
            var oneDiff = 0
            var threeDiff = 1
            var current = 0

            fun nextIterate(current : Int) : Int {

                for (i in 1..3){
                    if (set.contains(current+i)){
                        if (i == 1) oneDiff++
                        if ( i == 3 ) threeDiff++

                        set.remove(current+i)
                        return current + i
                    }
                }
                return -1
            }

            while (current != -1 || set.isNotEmpty()){
                current = nextIterate(current)
            }

            return oneDiff * threeDiff
        }

        fun countDistinctArrangments() : Long {

            val sortedList = adapters.sortedDescending()
            val dp = Array<Long>(sortedList.size) { 0 }

            for ( (i,v) in sortedList.withIndex() ){
                if (i == 0){
                    dp[i] = 1
                    continue
                }
                for (k in i-1 downTo i-3){
                    if ( k >=0 && sortedList[k] - v < 4 ){
                        dp[i] += dp[k]
                    }
                }
            }
            return dp.last()
        }



    }

    override fun getResultPartOne(): Int {
        return AdaptersChain(input.map { it.toInt() }).findDiffMult()
    }

    override fun getResultPartTwo(): Long {
        return AdaptersChain((input + listOf("0")).map { it.toInt() }).countDistinctArrangments()
    }

}