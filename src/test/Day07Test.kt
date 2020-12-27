package github.walkmansit.aoc2020.test

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

import github.walkmansit.aoc2020.Day07

class Day07Test : TestableDay {

    @Test
    override fun partOneTestData() {
        assertEquals(4,Day07(TEST_INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoTestData() {
        assertEquals(32,Day07(TEST_INPUT).getResultPartTwo())
    }

    @Test
    override fun partOneRealData() {
        assertEquals(151,Day07(INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoRealData() {
        assertEquals(41559,Day07(INPUT).getResultPartTwo())
    }

    companion object {
        private val TEST_INPUT = """
            light red bags contain 1 bright white bag, 2 muted yellow bags.
            dark orange bags contain 3 bright white bags, 4 muted yellow bags.
            bright white bags contain 1 shiny gold bag.
            muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
            shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
            dark olive bags contain 3 faded blue bags, 4 dotted black bags.
            vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
            faded blue bags contain no other bags.
            dotted black bags contain no other bags.
        """.trimIndent().lines()

        private val INPUT = javaClass.classLoader.getResourceAsStream("day07.txt").bufferedReader().readLines()
    }

}