package github.walkmansit.aoc2020.test

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

import github.walkmansit.aoc2020.Day24

class Day24Test : TestableDay {

    @Test
    override fun partOneTestData() {
        assertEquals(10,Day24(TEST_INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoTestData() {
        assertEquals(2208,Day24(TEST_INPUT).getResultPartTwo())
    }

    @Test
    override fun partOneRealData() {
        assertEquals(388,Day24(INPUT).getResultPartOne())
    }

    @Test
    override fun partTwoRealData() {
        assertEquals(4002,Day24(INPUT).getResultPartTwo())
    }

    companion object {
        private val TEST_INPUT = """
            sesenwnenenewseeswwswswwnenewsewsw
            neeenesenwnwwswnenewnwwsewnenwseswesw
            seswneswswsenwwnwse
            nwnwneseeswswnenewneswwnewseswneseene
            swweswneswnenwsewnwneneseenw
            eesenwseswswnenwswnwnwsewwnwsene
            sewnenenenesenwsewnenwwwse
            wenwwweseeeweswwwnwwe
            wsweesenenewnwwnwsenewsenwwsesesenwne
            neeswseenwwswnwswswnw
            nenwswwsewswnenenewsenwsenwnesesenew
            enewnwewneswsewnwswenweswnenwsenwsw
            sweneswneswneneenwnewenewwneswswnese
            swwesenesewenwneswnwwneseswwne
            enesenwswwswneneswsenwnewswseenwsese
            wnwnesenesenenwwnenwsewesewsesesew
            nenewswnwewswnenesenwnesewesw
            eneswnwswnwsenenwnwnwwseeswneewsenese
            neswnwewnwnwseenwseesewsenwsweewe
            wseweeenwnesenwwwswnew
        """.trimIndent().lines()

        private val INPUT = javaClass.classLoader.getResourceAsStream("day24.txt").bufferedReader().readLines()
    }

}