package github.walkmansit.aoc2020.test

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

import github.walkmansit.aoc2020.Day25

class Day25Test : TestableDay {

    @Test
    override fun partOneTestData() {
        assertEquals(14897079L, Day25(TEST_INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoTestData() {
        assertEquals(-1, Day25(INPUT).getResultPartTwo())
    }

    @Test
    override fun partOneRealData() {
        assertEquals(2679568L, Day25(INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoRealData() {
        assertEquals(-1, Day25(INPUT).getResultPartTwo())
    }

    companion object {
        private val TEST_INPUT = """
            5764801
            17807724
        """.trimIndent().lines()

        private val INPUT = javaClass.classLoader.getResourceAsStream("day25.txt").bufferedReader().readLines()
    }

}