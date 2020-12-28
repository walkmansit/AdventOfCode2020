package github.walkmansit.aoc2020.test

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

import github.walkmansit.aoc2020.Day01

class Day01Test : TestableDay {

    @Test
    override fun partOneTestData() {
        assertEquals(514579, Day01(TEST_INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoTestData() {
        assertEquals(241861950, Day01(TEST_INPUT).getResultPartTwo())

    }

    @Test
    override fun partOneRealData() {
        assertEquals(444019, Day01(INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoRealData() {
        assertEquals(29212176, Day01(INPUT).getResultPartTwo())
    }

    companion object {
        private val TEST_INPUT = """
            1721
            979
            366
            299
            675
            1456
        """.trimIndent().lines()

        private val INPUT = javaClass.classLoader.getResourceAsStream("day01.txt").bufferedReader().readLines()
    }

}