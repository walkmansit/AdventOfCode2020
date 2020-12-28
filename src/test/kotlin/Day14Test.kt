package github.walkmansit.aoc2020.test

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

import github.walkmansit.aoc2020.Day14

class Day14Test : TestableDay {

    @Test
    override fun partOneTestData() {
        assertEquals(165L, Day14(TEST_INPUT1).getResultPartOne())
    }

    @Test
    override fun partTwoTestData() {
        assertEquals(208L, Day14(TEST_INPUT2).getResultPartTwo())
    }

    @Test
    override fun partOneRealData() {
        assertEquals(9967721333886L, Day14(INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoRealData() {
        assertEquals(4355897790573L, Day14(INPUT).getResultPartTwo())
    }

    companion object {
        private val TEST_INPUT1 = """
            mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X
            mem[8] = 11
            mem[7] = 101
            mem[8] = 0
        """.trimIndent().lines()

        private val TEST_INPUT2 = """
            mask = 000000000000000000000000000000X1001X
            mem[42] = 100
            mask = 00000000000000000000000000000000X0XX
            mem[26] = 1
        """.trimIndent().lines()


        private val INPUT = javaClass.classLoader.getResourceAsStream("day14.txt").bufferedReader().readLines()
    }

}