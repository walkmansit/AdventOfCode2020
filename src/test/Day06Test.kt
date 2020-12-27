package github.walkmansit.aoc2020.test

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

import github.walkmansit.aoc2020.Day06

class Day06Test : TestableDay {

    @Test
    override fun partOneTestData() {
        assertEquals(11,Day06(TEST_INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoTestData() {
        assertEquals(6,Day06(TEST_INPUT).getResultPartTwo())
    }

    @Test
    override fun partOneRealData() {
        assertEquals(6351,Day06(INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoRealData() {
        assertEquals(3143,Day06(INPUT).getResultPartTwo())
    }

    companion object {
        private val TEST_INPUT = """
            abc

            a
            b
            c

            ab
            ac

            a
            a
            a
            a

            b
        """.trimIndent().split("\n\n")

        private val INPUT = javaClass.classLoader.getResourceAsStream("day06.txt").bufferedReader().readText().trimIndent().split("\n\n")
    }

}