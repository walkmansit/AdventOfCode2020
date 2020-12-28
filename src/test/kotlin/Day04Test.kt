package github.walkmansit.aoc2020.test

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

import github.walkmansit.aoc2020.Day04

class Day04Test : TestableDay {

    @Test
    override fun partOneTestData() {
        assertEquals(2, Day04(TEST_INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoTestData() {
        assertEquals(2, Day04(TEST_INPUT).getResultPartTwo())
    }

    @Test
    override fun partOneRealData() {
        assertEquals(200, Day04(INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoRealData() {
        assertEquals(116, Day04(INPUT).getResultPartTwo())
    }

    companion object {
        private val TEST_INPUT = """
            ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
            byr:1937 iyr:2017 cid:147 hgt:183cm

            iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884
            hcl:#cfa07d byr:1929

            hcl:#ae17e1 iyr:2013
            eyr:2024
            ecl:brn pid:760753108 byr:1931
            hgt:179cm

            hcl:#cfa07d eyr:2025 pid:166559648
            iyr:2011 ecl:brn hgt:59in
        """.trimIndent().split("\n\n")

        private val INPUT =
            javaClass.classLoader.getResourceAsStream("day04.txt").bufferedReader().readText().trimIndent()
                .split("\n\n")
    }

}