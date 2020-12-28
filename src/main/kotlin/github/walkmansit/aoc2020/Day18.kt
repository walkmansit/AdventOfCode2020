package github.walkmansit.aoc2020

import java.util.*

class Day18(val input: List<String>) : DayAoc<Long, Long> {

    class Calculator private constructor(private val expressions: Array<String>) {

        private val operations = setOf('+', '*')

        fun calsEvalSums(): Long {

            var sum = 0L
            for (v in expressions.map { evaluate(0, it, it[0] == '(') })
                sum += v.first

            return sum
        }

        private fun evaluate(startIdx: Int, expr: String, findClose: Boolean): Pair<Long, Int> {

            var acc = 0L
            var value = 0L

            var idx = startIdx
            when (expr[idx]) {
                in arrayOf(')', '*', '+') ->
                    throw IllegalArgumentException("first operand cant be in [')','*','+']")
                '(' -> {
                    val (s, i) = evaluate(idx + 1, expr, true)
                    acc = s
                    idx = i
                }
                else -> {
                    acc = expr[idx].toString().toLong()
                    idx++
                }
            }

            while (idx != expr.length && (!findClose || findClose && expr[idx] != ')')) {

                val isSum = when (expr[idx]) {
                    '+' -> true
                    '*' -> false
                    else ->
                        throw IllegalArgumentException("invalid operator character")
                }
                idx++
                when (expr[idx]) {
                    in arrayOf(')', '*', '+') ->
                        throw IllegalArgumentException("second operand cant be in ['(',')','*','+']")
                    '(' -> {
                        val (s, i) = evaluate(idx + 1, expr, true)
                        value = s
                        idx = i
                    }
                    else -> {
                        value = expr[idx].toString().toLong()
                        idx++
                    }
                }
                acc = if (isSum) acc + value else acc * value
            }

            return acc to ++idx
        }

        fun calculateWithSumPriority(): Long {
            return expressions.asSequence().map { it.toRPR().calculateRPR() }.sum()
        }

        // преобразование выражения в обратную польскую запись
        private fun String.toRPR(): String {

            val sb = StringBuilder()
            val stack = Stack<Char>()

            for (ch in this) {
                if (ch != ' ')
                    when (ch) {
                        '(' -> stack.push(ch)
                        ')' -> {
                            while (stack.last() != '(') {
                                sb.append(stack.pop())
                            }
                            stack.pop()
                        }
                        in operations -> {
                            while (stack.isNotEmpty() && higherOrSamePriority(ch, stack.last())) {
                                sb.append(stack.pop())
                            }
                            stack.push(ch)
                        }
                        else -> sb.append(ch)
                    }
            }

            while (stack.isNotEmpty())
                sb.append(stack.pop())

            return sb.toString()
        }

        private fun String.calculateRPR(): Long {

            val stack = Stack<Long>()

            for (ch in this) {
                if (ch !in operations) {
                    stack.push(ch.toString().toLong())
                } else {
                    val a = stack.pop()
                    val b = stack.pop()
                    stack.push(if (ch == '+') a + b else a * b)
                }
            }
            return stack.pop()
        }

        private fun higherOrSamePriority(curr: Char, other: Char): Boolean {
            if (other == '(') return false
            return other != '*' || curr != '+'
        }

        companion object {

            private fun String.removeWhitespaces(): String {

                val sb = StringBuilder()

                for (ch in this) {
                    if (ch != ' ') sb.append(ch)
                }

                return sb.toString()
            }

            fun fromInput(inp: List<String>): Calculator {
                return Calculator(inp.map { it.removeWhitespaces() }.toTypedArray())
            }
        }
    }

    override fun getResultPartOne(): Long {
        return Calculator.fromInput(input).calsEvalSums()
    }

    override fun getResultPartTwo(): Long {
        return Calculator.fromInput(input).calculateWithSumPriority()
    }
}
