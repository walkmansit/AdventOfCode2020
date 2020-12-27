package github.walkmansit.aoc2020

import java.util.*

class Day22(val input:String) : DayAoc<Int,Int> {

    class Game private  constructor (private val deckA:Collection<Int>, private val deckB:Collection<Int>){


        fun getScore() : Int {

            val deck1dq : Deque<Int> = ArrayDeque(deckA)

            val deck2dq : Deque<Int> = ArrayDeque(deckB)

            while (deck1dq.isNotEmpty() && deck2dq.isNotEmpty()) {

                val  a = deck1dq.pop()
                val  b = deck2dq.pop()

                if (a>b){
                    deck1dq.addLast(a)
                    deck1dq.addLast(b)
                }
                else {
                    deck2dq.addLast(b)
                    deck2dq.addLast(a)
                }
            }

            return if (deck1dq.isNotEmpty()) calcScore(deck1dq) else calcScore(deck2dq)
        }

        private fun calcScore(deck : Deque<Int>) : Int {
            var sum =0
            for((i,v) in deck.withIndex()){
                sum+=v*(deck.size-i)
            }
            return sum
        }

        private fun copyNFirst(deque: Deque<Int>, n : Int) : Deque<Int> {
            val result = ArrayDeque<Int>()
            for (i in 0 until n){
                result.add(deque.elementAt(i))
            }
            return result
        }

        private fun isFirstWin(first:Deque<Int>, second:Deque<Int>, calScore : Boolean = false) : Pair<Boolean,Int> {

            val cache : MutableSet<String> = mutableSetOf()

            while (first.isNotEmpty() && second.isNotEmpty()) {

                val key = "${first.joinToString(",")} ${second.joinToString(",")}"

                if (cache.contains(key)) return true to (if (calScore) calcScore(first) else 0)

                val  a = first.pop()
                val  b = second.pop()

                var firstWinRound = false

                firstWinRound = if (first.size >= a && second.size >= b)
                    isFirstWin(copyNFirst(first,a),copyNFirst(second,b)).first
                else
                    a>b

                if (firstWinRound){
                    first.addLast(a)
                    first.addLast(b)
                }
                else {
                    second.addLast(b)
                    second.addLast(a)
                }
                cache.add(key)
            }
            return if (first.isEmpty()) {
                false to calcScore(second)
            }
            else {
                true to calcScore(first)
            }
        }

        fun getScoreRecurs() : Int {

            val deck1dq : Deque<Int> = ArrayDeque(deckA)

            val deck2dq : Deque<Int> = ArrayDeque(deckB)

            return isFirstWin(deck1dq,deck2dq,true).second

        }

        companion object {

            fun fromInput(input:String) : Game {

                val parts = input.split("\n\n")

                val deck1 = parts[0].substring(10,parts[0].length).split("\n").map { it.toInt() }
                val deck2 = parts[1].substring(10,parts[1].length).split("\n").map { it.toInt() }
                return Game(deck1,deck2)
            }

        }

    }

    override fun getResultPartOne(): Int {
        return Game.fromInput(input).getScore()
    }

    override fun getResultPartTwo(): Int {
        return Game.fromInput(input).getScoreRecurs()
    }
}