package github.walkmansit.aoc2020

class Day09(val input:List<String>, val windowSize:Int) : DayAoc<Long,Long> {

    private class SlidingWindow(val nums : Array<Long>, val size: Int){

        private var window = 0 until size

        private val summWeight : MutableMap<Long,Int> = mutableMapOf()

        init {
            for (i in 0..size-2)
                for (j in i+1 until size){
                    val sum = nums[i] + nums[j]
                    if (summWeight.containsKey(sum)) {
                        summWeight[sum]  = summWeight[sum]!! + 1
                    }
                    else
                        summWeight[sum] = 1

                }
        }

        fun findWrongSum(): Long {

            for (i in size until nums.size){
                if (!summWeight.contains(nums[i]))
                    return nums[i]
                else
                    moveWindow()
            }


            return -1L
        }

        fun findWeakness(target: Long) : Long {

            var left = 0
            var right = 1
            val list = mutableListOf(nums[left],nums[right])
            var sum  = list.sum()

            while (sum != target){
                if (sum < target && right < nums.size){
                    sum += nums[++right]
                    list.add(nums[right])
                }
                else if (sum > target && left < right) {
                    sum -= nums[left++]
                    list.removeAt(0)
                }
            }

            return list.max()!! + list.min()!!
        }




        fun moveWindow(){

            val removeCandidate = nums[window.first]

            for (i in window.first+1..window.last) {
                val sum = removeCandidate + nums[i]

                //remove left from summs
                if (summWeight.containsKey(sum)){
                    val newCount = summWeight[sum]!! - 1
                    if (newCount == 0)
                        summWeight.remove(sum)
                    else
                        summWeight[sum] == newCount

                }

                //add right to sums
                val newSumm = nums[i] + nums[window.last + 1]

                if (summWeight.containsKey(newSumm)) {
                    summWeight[newSumm] = summWeight[newSumm]!! + 1
                } else
                    summWeight[newSumm] = 1

            }
            window = window.first+1..window.last+1
        }


    }

    override fun getResultPartOne(): Long {
        return SlidingWindow( input.map { it.toLong() }.toTypedArray(),windowSize).findWrongSum()

    }

    override fun getResultPartTwo(): Long {
        val model = SlidingWindow( input.map { it.toLong() }.toTypedArray(), windowSize)
        val target = model.findWrongSum()
        return model.findWeakness(target)
    }

}