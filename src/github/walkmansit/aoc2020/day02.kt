package github.walkmansit.aoc2020

class Day02(val input:List<String>) : DayAoc<Int,Int> {

    private class PasswordWithPolicy private constructor(val start: Int, val end:Int, val target: Char, val password: String){

        fun isValidPolicy1() : Boolean {
            var count = 0
            password.forEach {
                if (it==target) {
                    count++
                    if (count > end) return false
                }
            }
            return count>=start
        }

        fun isValidPolicy2() = (password[start-1]==target && password[end-1]!=target) || (password[start-1]!=target && password[end-1]==target)

        companion object {

            private val REGULAR_EXPRESSION = Regex(  """(\d+)-(\d+) ([a-z]): ([a-z]+)""")

            fun fromInputLine(line : String) : PasswordWithPolicy {
                val res = REGULAR_EXPRESSION.matchEntire(line)!!
                return PasswordWithPolicy(res.groupValues[1].toInt(),res.groupValues[2].toInt(),res.groupValues[3].first(),res.groupValues[4])
            }
        }
    }

    override fun getResultPartOne(): Int {
        return input.asSequence().map { PasswordWithPolicy.fromInputLine(it) }.count{ it.isValidPolicy1() }
    }

    override fun getResultPartTwo(): Int {
        return input.asSequence().map { PasswordWithPolicy.fromInputLine(it) }.count{ it.isValidPolicy2() }
    }


}