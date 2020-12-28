package github.walkmansit.aoc2020.test

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

import github.walkmansit.aoc2020.Day12

class Day12Test : TestableDay {

    @Test
    override fun partOneTestData() {
        assertEquals(25, Day12(TEST_INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoTestData() {
        assertEquals(286, Day12(TEST_INPUT).getResultPartTwo().toInt())
    }

    @Test
    override fun partOneRealData() {
        assertEquals(1441, Day12(INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoRealData() {
        assertEquals(61616, Day12(INPUT).getResultPartTwo().toInt())
    }

    companion object {
        private val TEST_INPUT = """
            F10
            N3
            F7
            R90
            F11
        """.trimIndent().lines()

        private val INPUT = javaClass.classLoader.getResourceAsStream("day12.txt").bufferedReader().readLines()
    }

}