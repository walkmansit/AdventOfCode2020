package github.walkmansit.aoc2020.benchmark

interface DayBench<out T,out K> {

    fun benchPartOne() : T

    fun benchPartTwo() : K

}