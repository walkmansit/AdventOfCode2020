package github.walkmansit.aoc2020.test

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

import github.walkmansit.aoc2020.Day08

class Day08Test : TestableDay {

    @Test
    override fun partOneTestData() {
        assertEquals(5, Day08(TEST_INPUT).getResultPartOne())

    }

    @Test
    override fun partTwoTestData() {
        assertEquals(8, Day08(TEST_INPUT).getResultPartTwo())

    }

    @Test
    override fun partOneRealData() {
        assertEquals(1446, Day08(INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoRealData() {
        assertEquals(1403, Day08(INPUT).getResultPartTwo())
    }

    companion object {
        private val TEST_INPUT = """
            nop +0
            acc +1
            jmp +4
            acc +3
            jmp -3
            acc -99
            acc +1
            jmp -4
            acc +6
        """.trimIndent().lines()

        private val INPUT = javaClass.classLoader.getResourceAsStream("day08.txt").bufferedReader().readLines()
    }

}