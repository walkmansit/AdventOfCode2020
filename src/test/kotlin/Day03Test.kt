package github.walkmansit.aoc2020.test

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

import github.walkmansit.aoc2020.Day03

class Day03Test : TestableDay {

    @Test
    override fun partOneTestData() {
        assertEquals(7, Day03(TEST_INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoTestData() {
        assertEquals(336L, Day03(TEST_INPUT).getResultPartTwo())
    }

    @Test
    override fun partOneRealData() {
        assertEquals(252, Day03(INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoRealData() {
        assertEquals(2608962048L, Day03(INPUT).getResultPartTwo())
    }

    companion object {
        private val TEST_INPUT = """
            ..##.......
            #...#...#..
            .#....#..#.
            ..#.#...#.#
            .#...##..#.
            ..#.##.....
            .#.#.#....#
            .#........#
            #.##...#...
            #...##....#
            .#..#...#.#
        """.trimIndent().lines()

        private val INPUT = javaClass.classLoader.getResourceAsStream("day03.txt").bufferedReader().readLines()
    }

}