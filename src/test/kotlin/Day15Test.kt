package github.walkmansit.aoc2020.test

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

import github.walkmansit.aoc2020.Day15

class Day15Test : TestableDay {

    @Test
    override fun partOneTestData() {
        assertEquals(436, Day15(TEST_INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoTestData() {
        assertEquals(175594, Day15(TEST_INPUT).getResultPartTwo())
    }

    @Test
    override fun partOneRealData() {
        assertEquals(1618, Day15(INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoRealData() {
        assertEquals(548531, Day15(INPUT).getResultPartTwo())
    }

    companion object {
        private val TEST_INPUT = "0,3,6"

        private val INPUT = javaClass.classLoader.getResourceAsStream("day15.txt").bufferedReader().readLine()
    }

}