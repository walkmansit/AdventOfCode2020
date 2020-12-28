package github.walkmansit.aoc2020.test

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

import github.walkmansit.aoc2020.Day13

class Day13Test : TestableDay {

    @Test
    override fun partOneTestData() {
        assertEquals(295, Day13(TEST_INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoTestData() {
        assertEquals(1068781, Day13(TEST_INPUT).getResultPartTwo())
    }

    @Test
    override fun partOneRealData() {
        assertEquals(261, Day13(INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoRealData() {
        assertEquals(807435693182510L, Day13(INPUT).getResultPartTwo())
    }

    companion object {
        private val TEST_INPUT = """
            939
            7,13,x,x,59,x,31,19
        """.trimIndent().lines()

        private val INPUT = javaClass.classLoader.getResourceAsStream("day13.txt").bufferedReader().readLines()
    }

}