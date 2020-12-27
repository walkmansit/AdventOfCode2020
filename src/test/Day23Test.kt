package github.walkmansit.aoc2020.test

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

import github.walkmansit.aoc2020.Day23

class Day23Test : TestableDay {

    @Test
    override fun partOneTestData() {
        assertEquals("67384529",Day23(TEST_INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoTestData() {
        assertEquals(149245887792L,Day23(TEST_INPUT).getResultPartTwo())
    }

    @Test
    override fun partOneRealData() {
        assertEquals("72496583",Day23(INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoRealData() {
        assertEquals(41785843847L,Day23(INPUT).getResultPartTwo())
    }

    companion object {
        private val TEST_INPUT = "389125467"

        private val INPUT = javaClass.classLoader.getResourceAsStream("day23.txt").bufferedReader().readText()
    }

}