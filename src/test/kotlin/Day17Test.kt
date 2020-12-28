package github.walkmansit.aoc2020.test

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

import github.walkmansit.aoc2020.Day17

class Day17Test : TestableDay {

    @Test
    override fun partOneTestData() {
        assertEquals(112, Day17(TEST_INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoTestData() {
        assertEquals(848, Day17(TEST_INPUT).getResultPartTwo())
    }

    @Test
    override fun partOneRealData() {
        assertEquals(218, Day17(INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoRealData() {
        assertEquals(1908, Day17(INPUT).getResultPartTwo())
    }

    companion object {
        private val TEST_INPUT = """
            .#.
            ..#
            ###
        """.trimIndent().lines()

        private val INPUT = javaClass.classLoader.getResourceAsStream("day17.txt").bufferedReader().readLines()
    }

}