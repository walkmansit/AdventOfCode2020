package github.walkmansit.aoc2020.test

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

import github.walkmansit.aoc2020.Day16

class Day16Test : TestableDay {

    @Test
    override fun partOneTestData() {
        assertEquals(71, Day16(TEST_INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoTestData() {
        assertEquals(98, Day16(TEST_INPUT).getResultPartTwo())
    }

    @Test
    override fun partOneRealData() {
        assertEquals(23925, Day16(INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoRealData() {
        assertEquals(964373157673L, Day16(INPUT).getResultPartTwo())
    }

    companion object {
        private val TEST_INPUT = """
            class: 1-3 or 5-7
            row: 6-11 or 33-44
            seat: 13-40 or 45-50

            your ticket:
            7,1,14

            nearby tickets:
            7,3,47
            40,4,50
            55,2,20
            38,6,12
        """.trimIndent()

        private val INPUT =
            javaClass.classLoader.getResourceAsStream("day16.txt").bufferedReader().readText().trimIndent()
    }

}