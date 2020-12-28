package github.walkmansit.aoc2020.test

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

import github.walkmansit.aoc2020.Day09

class Day09Test : TestableDay {

    @Test
    override fun partOneTestData() {
        assertEquals(127L, Day09(TEST_INPUT, 5).getResultPartOne())
    }

    @Test
    override fun partTwoTestData() {
        assertEquals(62L, Day09(TEST_INPUT, 5).getResultPartTwo())
    }

    @Test
    override fun partOneRealData() {
        assertEquals(1309761972L, Day09(INPUT, 25).getResultPartOne())
    }

    @Test
    override fun partTwoRealData() {
        assertEquals(177989832L, Day09(INPUT, 25).getResultPartTwo())
    }

    companion object {
        private val TEST_INPUT = """
            35
            20
            15
            25
            47
            40
            62
            55
            65
            95
            102
            117
            150
            182
            127
            219
            299
            277
            309
            576
        """.trimIndent().lines()

        private val INPUT = javaClass.classLoader.getResourceAsStream("day09.txt").bufferedReader().readLines()
    }

}