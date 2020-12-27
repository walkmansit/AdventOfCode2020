package github.walkmansit.aoc2020.test

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

import github.walkmansit.aoc2020.Day11

class Day11Test : TestableDay {

    @Test
    override fun partOneTestData() {
        assertEquals(37,Day11(TEST_INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoTestData() {
        assertEquals(26,Day11(TEST_INPUT).getResultPartTwo())
    }

    @Test
    override fun partOneRealData() {
        assertEquals(2251,Day11(INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoRealData() {
        assertEquals(2019,Day11(INPUT).getResultPartTwo())
    }

    companion object {
        private val TEST_INPUT = """
            L.LL.LL.LL
            LLLLLLL.LL
            L.L.L..L..
            LLLL.LL.LL
            L.LL.LL.LL
            L.LLLLL.LL
            ..L.L.....
            LLLLLLLLLL
            L.LLLLLL.L
            L.LLLLL.LL
        """.trimIndent().lines()

        private val INPUT = javaClass.classLoader.getResourceAsStream("day11.txt").bufferedReader().readLines()
    }

}