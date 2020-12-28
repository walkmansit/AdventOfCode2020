package github.walkmansit.aoc2020

class Day25(val input: List<String>) : DayAoc<Long, Int> {

    private fun transform(loopSize: Int, subject: Long): Long {

        var current = 1L

        repeat(loopSize) {
            current *= subject
            current %= base
        }

        return current
    }

    private fun calculateLoop(target: Long): Int {

        var loop = 0
        var current = 1L
        val subject = 7

        do {
            current *= subject
            current %= base
            loop++
        } while (current != target)
        return loop
    }

    override fun getResultPartOne(): Long {
        val cardPK = input[0].toInt()
        val doorPK = input[1].toInt()

        val cardLoop = calculateLoop(cardPK.toLong())
        val doorLoop = calculateLoop(doorPK.toLong())

        val cardEncrypt = transform(cardLoop, doorPK.toLong())
        val dorEncrypt = transform(doorLoop, cardPK.toLong())

        return cardEncrypt
    }

    override fun getResultPartTwo(): Int {
        return -1
    }

    companion object {
        private const val base = 20201227
    }
}
