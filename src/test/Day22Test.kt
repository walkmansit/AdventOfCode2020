package github.walkmansit.aoc2020.test

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

import github.walkmansit.aoc2020.Day22

class Day22Test : TestableDay {

    @Test
    override fun partOneTestData() {
        assertEquals(306,Day22(TEST_INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoTestData() {
        assertEquals(291,Day22(TEST_INPUT).getResultPartTwo())
    }

    @Test
    override fun partOneRealData() {
        assertEquals(34127,Day22(INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoRealData() {
        assertEquals(32054,Day22(INPUT).getResultPartTwo())
    }

    companion object {
        private val TEST_INPUT = """
            Player 1:
            9
            2
            6
            3
            1

            Player 2:
            5
            8
            4
            7
            10
        """.trimIndent()

        private val INPUT = javaClass.classLoader.getResourceAsStream("day22.txt").bufferedReader().readText().trimIndent()
    }

}