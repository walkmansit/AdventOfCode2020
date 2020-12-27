package github.walkmansit.aoc2020.test

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

import github.walkmansit.aoc2020.Day10

class Day10Test : TestableDay {

    @Test
    override fun partOneTestData() {
        assertEquals(35,Day10(TEST_INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoTestData() {
        assertEquals(8L,Day10(TEST_INPUT).getResultPartTwo())
    }

    @Test
    override fun partOneRealData() {
        assertEquals(2310,Day10(INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoRealData() {
        assertEquals(64793042714624L,Day10(INPUT).getResultPartTwo())
    }

    companion object {
        private val TEST_INPUT = """
            16
            10
            15
            5
            1
            11
            7
            19
            6
            12
            4
        """.trimIndent().lines()

        private val INPUT = javaClass.classLoader.getResourceAsStream("day10.txt").bufferedReader().readLines()
    }

}