package github.walkmansit.aoc2020.benchmark

interface DayBench<out T,out K> {

    fun getInput() : List<String>

    fun benchPartOne() : T

    fun benchPartTwo() : K

}