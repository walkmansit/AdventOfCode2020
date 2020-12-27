package github.walkmansit.aoc2020

import kotlin.math.ceil

class Day13(val input:List<String>) : DayAoc<Int,Long> {

    private class BusSchedule (val earliestTime : Int , val busTs : Array<Int>) {

        fun findEarliest() : Int {

            var minDt = Int.MAX_VALUE
            var id = 0

            for (ts in busTs){
                if (ts != -1){

                    val closest = ceil(earliestTime / ts.toDouble()).toInt()  * ts

                    val t = closest - earliestTime

                    if (t < minDt){
                        minDt = t
                        id = ts
                    }
                }
            }

            return id * minDt
        }

        private fun findMaxWithId() : Pair<Int,Int> {
            var pair = 0 to 0
            for ( (i,v) in busTs.withIndex()){
                if (v > pair.second)
                    pair = i to v
            }
            return pair

        }

        fun findEarliestOffsetMatch() : Long {

            val maxPair = findMaxWithId() // Index, Value
            var candidate : Long = maxPair.second.toLong()

            while (!fullMatch(candidate,maxPair)){
                candidate += maxPair.second
            }

            return candidate - maxPair.first
        }

        private fun fullMatch(candidateMax : Long, maxPair : Pair<Int,Int>) : Boolean {

            for ( (i,v) in busTs.withIndex()){
                if ( v != -1 && i != maxPair.first) {
                    val candidate = candidateMax - (maxPair.first - i)

                    if (candidate % v != 0L) return false
                }
            }

            return true
        }

        fun findWithChineeseTheoreme() : Long {


            fun mod(a : Int, b : Int) : Int{
                var ar = a
                while (ar < b)
                    ar+=a

                return ar % b
            }

            fun mod(a : Long, b : Long) : Long {
                var ar = a
                while (ar < b)
                    ar+=a

                return ar % b
            }

            fun getPositiveAi(i : Int, mi : Int) : Int {
                var result = -i

                while (result<0)
                    result += mi

                return result
            }

            fun findMi(mi : Array<Int>) : Array<Long> {

                val result = Array(mi.size) { 0L }

                for ( i in mi.indices ){
                    var mult = 1L
                    for( (j,k) in mi.withIndex() ){
                        if ( i != j) mult *= k
                    }
                    result[i] = mult
                }
                return result
            }

            fun findYi(idx : Int, Mi : Array<Long>,ai : Array<Int>,mi : Array<Int>) : Int {
                var y = 1

                val MiS = (Mi[idx] % mi[idx]).toInt()

                while (true){
                    if ((((MiS * y) - ai[idx]) % mi[idx]) == 0 )
                        return y
                    y++
                }
                return y
            }

            val aiB = mutableListOf<Int>()
            val miB = mutableListOf<Int>()

            for ( (i,v) in busTs.withIndex()){
                if (v != -1) {
                    miB.add(v)
                    aiB.add(getPositiveAi(i,v))
                }
            }

            val ai = aiB.toTypedArray()
            val mi = miB.toTypedArray()

            val Mi = findMi(mi)

            val yi = Array(ai.size) { 0 }

            var sum  = 0L

            for (i in yi.indices) {
                yi[i] = findYi(i, Mi, ai, mi)

                sum += Mi[i] * yi[i]
            }

            val M0 : Long = mi[0] * Mi[0]

            return mod (sum , M0)
        }


        companion object {
            fun fromInput(lines : List<String>) : BusSchedule {
                return BusSchedule(lines[0].toInt(),lines[1].split(",").map { i -> if (i == "x") -1 else i.toInt() }.toTypedArray())
            }
        }
    }

    override fun getResultPartOne(): Int {
        return BusSchedule.fromInput(input).findEarliest()
    }

    override fun getResultPartTwo(): Long {
        return BusSchedule.fromInput(input).findWithChineeseTheoreme()
    }


}