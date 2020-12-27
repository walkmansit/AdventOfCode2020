package github.walkmansit.aoc2020.test

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

import github.walkmansit.aoc2020.Day02

class Day02Test : TestableDay {

    @Test
    override fun partOneTestData() {
        assertEquals(2, Day02(TEST_INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoTestData() {
        assertEquals(1,Day02(TEST_INPUT).getResultPartTwo())
    }

    @Test
    override fun partOneRealData() {
        assertEquals(416, Day02(INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoRealData() {
        assertEquals(688,Day02(INPUT).getResultPartTwo())
    }

    companion object {
        private val TEST_INPUT = """
            1-3 a: abcde
            1-3 b: cdefg
            2-9 c: ccccccccc
        """.trimIndent().lines()

        private val INPUT = javaClass.classLoader.getResourceAsStream("day02.txt").bufferedReader().readLines()
    }

}