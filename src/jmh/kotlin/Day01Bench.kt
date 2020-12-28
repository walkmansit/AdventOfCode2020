package github.walkmansit.aoc2020.benchmark

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State

import github.walkmansit.aoc2020.Day01
import github.walkmansit.aoc2020.benchmark.DayBench

@State(Scope.Thread)
class Day01Bench : DayBench<Int, Int> {

    private lateinit var input:Collection<String>

    @Setup
    fun getInput() {
        input = javaClass.classLoader.getResourceAsStream("day01.txt").bufferedReader().readLines()
    }

    @Benchmark
    override fun benchPartOne() = Day01(input).getResultPartOne()

    @Benchmark
    override fun benchPartTwo() = Day01(input).getResultPartTwo()
}
