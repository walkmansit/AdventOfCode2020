package github.walkmansit.aoc2020.test

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

import github.walkmansit.aoc2020.Day05

class Day05Test : TestableDay {

    @Test
    override fun partOneTestData() {
        assertEquals(357, Day05(TEST_INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoTestData() {
        assertEquals(expected = true, actual = true) // no data in test example, so skip it
    }

    @Test
    override fun partOneRealData() {
        assertEquals(998, Day05(INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoRealData() {
        assertEquals(676, Day05(INPUT).getResultPartTwo())
    }

    companion object {
        private val TEST_INPUT = "FBFBBFFRLR".lines()
    }

    private val INPUT = javaClass.classLoader.getResourceAsStream("day05.txt").bufferedReader().readLines()

}