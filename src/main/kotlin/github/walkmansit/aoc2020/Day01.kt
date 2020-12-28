package github.walkmansit.aoc2020

class Day01(val input: Collection<String>) : DayAoc<Int, Int> {

    override fun getResultPartOne(): Int {

        val inputInt = input.map { it.toInt() }

        val seen = inputInt.map { 2020 - it }.toSet()

        inputInt.forEach {
            if (seen.contains(it)) return it * (2020 - it)
        }

        return -1
    }

    override fun getResultPartTwo(): Int {

        val inputInt = input.map { it.toInt() }

        val diffSet = mutableMapOf<Int, Int>()

        for (i in inputInt.indices - 1)
            for (j in 1 until inputInt.size)
                diffSet[2020 - inputInt[i] - inputInt[j]] = inputInt[i] * inputInt[j]

        inputInt.forEach {
            if (diffSet.contains(it)) return diffSet[it]!! * it
        }

        return -1
    }
}
