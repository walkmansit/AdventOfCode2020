package github.walkmansit.aoc2020.test

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

import github.walkmansit.aoc2020.Day21

class Day21Test : TestableDay {

    @Test
    override fun partOneTestData() {
        assertEquals(5,Day21(TEST_INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoTestData() {
        assertEquals("mxmxvkd,sqjhc,fvjkl",Day21(TEST_INPUT).getResultPartTwo())
    }

    @Test
    override fun partOneRealData() {
        assertEquals(2874,Day21(INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoRealData() {
        assertEquals("gfvrr,ndkkq,jxcxh,bthjz,sgzr,mbkbn,pkkg,mjbtz",Day21(INPUT).getResultPartTwo())
    }

    companion object {
        private val TEST_INPUT = """
            mxmxvkd kfcds sqjhc nhms (contains dairy, fish)
            trh fvjkl sbzzf mxmxvkd (contains dairy)
            sqjhc fvjkl (contains soy)
            sqjhc mxmxvkd sbzzf (contains fish)
        """.trimIndent().lines()

        private val INPUT = javaClass.classLoader.getResourceAsStream("day21.txt").bufferedReader().readLines()
    }

}