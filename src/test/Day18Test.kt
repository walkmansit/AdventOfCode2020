package github.walkmansit.aoc2020.test

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

import github.walkmansit.aoc2020.Day18

class Day18Test : TestableDay {

    @Test
    override fun partOneTestData() {
        assertEquals(71L,Day18(TEST_INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoTestData() {
        assertEquals(231L,Day18(TEST_INPUT).getResultPartTwo())
    }

    @Test
    override fun partOneRealData() {
        assertEquals(8929569623593L,Day18(INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoRealData() {
        assertEquals(231235959382961L,Day18(INPUT).getResultPartTwo())
    }

    companion object {
        private val TEST_INPUT = """
            1 + 2 * 3 + 4 * 5 + 6
        """.trimIndent().lines()

        private val INPUT = javaClass.classLoader.getResourceAsStream("day18.txt").bufferedReader().readLines()
    }

}