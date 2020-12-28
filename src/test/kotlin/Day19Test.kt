package github.walkmansit.aoc2020.test

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

import github.walkmansit.aoc2020.Day19

class Day19Test : TestableDay {

    @Test
    override fun partOneTestData() {
        assertEquals(2, Day19(TEST_INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoTestData() {
        assertEquals(2, Day19(TEST_INPUT).getResultPartTwo())
    }

    @Test
    override fun partOneRealData() {
        assertEquals(111, Day19(INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoRealData() {
        assertEquals(343, Day19(INPUT).getResultPartTwo())
    }

    companion object {
        private val TEST_INPUT = """
            0: 4 1 5
            1: 2 3 | 3 2
            2: 4 4 | 5 5
            3: 4 5 | 5 4
            4: "a"
            5: "b"

            ababbb
            bababa
            abbbab
            aaabbb
            aaaabbb
        """.trimIndent()

        private val INPUT =
            javaClass.classLoader.getResourceAsStream("day19.txt").bufferedReader().readText().trimIndent()
    }

}