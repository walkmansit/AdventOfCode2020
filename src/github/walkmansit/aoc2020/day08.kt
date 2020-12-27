package github.walkmansit.aoc2020

import java.lang.IllegalArgumentException

class Day08(val input:List<String>) : DayAoc<Int,Int> {

    private class SequenceOfAction(val lines:List<String>){

        sealed class Action {

            abstract fun apply(acc : Int, position : Int) : Pair<Int, Int>

            abstract fun hasAlternative() : Boolean

            abstract fun toAlternative() : Action

            class NopAction(val value : Int) : Action() {
                override fun apply(acc: Int, position: Int) = acc to position + 1

                override fun hasAlternative() = true

                override fun toAlternative() = JmpAction(value)
            }

            class AccAction(val value : Int) : Action() {
                override fun apply(acc: Int, position: Int) = acc + value to position + 1

                override fun hasAlternative() = false

                override fun toAlternative() = this
            }

            class JmpAction(val value : Int) : Action() {
                override fun apply(acc: Int, position: Int) = acc to position + value

                override fun hasAlternative() = true

                override fun toAlternative() = NopAction(value)
            }

            companion object {
                fun fromString(value : String) : Action {
                    val parts = value.split(' ')
                    return when(parts[0]) {
                        "nop" -> NopAction(parts[1].toInt())
                        "acc" -> AccAction(parts[1].toInt())
                        "jmp" -> JmpAction(parts[1].toInt())
                        else -> throw IllegalArgumentException()
                    }

                }
            }

        }

        fun findAccBeforeLoop() : Int {

            val linesVisited = lines.map { Action.fromString(it) to false }.toMutableList()
            var accumulated = 0
            var idx = 0

            do {
                //apply current line action
                val (a,i) = linesVisited[idx].first.apply(accumulated,idx)

                //update prev line to visited
                linesVisited[idx] = linesVisited[idx].first to true

                //set prev to current
                accumulated = a
                idx = i
            }
            while (!linesVisited[idx].second)
            return accumulated
        }

        fun findTerminateResult() : Int {

            val initialList = lines.map { Action.fromString(it) to false }.toMutableList()
            var list = lines.map { Action.fromString(it) to false }.toMutableList()

            for (i in getAlternativeActionsIds(initialList)) {

                //change action in list to alt
                list[i] = list[i].first.toAlternative() to false

                val (fine,acc) = simulate(list)
                if (fine) return acc
                else{
                    //set list to initial
                    list[i] = list[i].first.toAlternative() to false

                    list = list.map { it.first to false }.toMutableList()
                }

            }

            return 0

        }

        fun simulate(actionsVisited : MutableList<Pair<Action,Boolean>>) : Pair<Boolean, Int> {

            var accumulated = 0
            var idx = 0

            do {
                //apply current line action
                val (a,i) = actionsVisited[idx].first.apply(accumulated,idx)

                //update prev line to visited
                actionsVisited[idx] = actionsVisited[idx].first to true

                //set prev to current
                accumulated = a
                idx = i

                if (idx == actionsVisited.size)
                    return true to accumulated

                if (actionsVisited[idx].second)
                    return false to 0

                if (idx < 0 )
                    return false to 0
            }
            while (idx != actionsVisited.size)
            return true to accumulated
        }

        fun getAlternativeActionsIds(actions : List<Pair<Action,Boolean>>) = sequence {

            for ( (i,v) in actions.withIndex() ) {
                if (v.first.hasAlternative())
                    yield(i)
            }
        }

    }

    override fun getResultPartOne(): Int {
        return SequenceOfAction(input).findAccBeforeLoop()

    }

    override fun getResultPartTwo(): Int {
        return SequenceOfAction(input).findTerminateResult()
    }

}