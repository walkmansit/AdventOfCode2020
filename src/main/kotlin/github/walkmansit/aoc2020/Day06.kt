package github.walkmansit.aoc2020

class Day06(val input: List<String>) : DayAoc<Int, Int> {

    data class Group(val answers: List<String>) {

        fun uniqueAnswersCount(): Int {
            return answers.map { it.asSequence().toSet() }.reduce { acc, set -> acc.union(set) }.size
        }

        fun intersectAnswersCount(): Int {
            return answers.map { it.asSequence().toSet() }.reduce { acc, set -> acc.intersect(set) }.size
        }
    }

    override fun getResultPartOne(): Int {
        return input.asSequence().map { Group(it.split("\n")).uniqueAnswersCount() }.sum()
    }

    override fun getResultPartTwo(): Int {
        return input.asSequence().map { Group(it.split("\n")).intersectAnswersCount() }.sum()
    }
}
