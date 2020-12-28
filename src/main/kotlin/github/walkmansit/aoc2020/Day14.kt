package github.walkmansit.aoc2020

class Day14(val input: List<String>) : DayAoc<Long, Long> {

    private class MaskMachine(val commands: Collection<String>) {

        fun applyCommandsAndGetSum(): Long {

            var zeroMask = Long.MAX_VALUE // for mult

            var oneMask = Long.MIN_VALUE // for add

            val dict: MutableMap<Int, Long> = mutableMapOf()

            fun updateMasks(mask: String) {
                zeroMask = 0L
                oneMask = 0L

                for (i in mask.indices) {
                    val idx = mask.length - i - 1

                    if (mask[idx] == '1') {
                        oneMask = oneMask or (1L shl i)
                        continue
                    }
                    if (mask[idx] == '0') {
                        zeroMask = zeroMask or (1L shl i)
                    }
                }
                zeroMask = (zeroMask.inv() shl 28) ushr 28
            }

            fun applyMemoryCommand(key: Int, value: Long) {
                dict[key] = (value and zeroMask) or oneMask
            }

            for (command in commands) {
                val parts = command.split(" = ")
                if (parts[0] == "mask") {
                    updateMasks(parts[1])
                } else {
                    applyMemoryCommand(
                        parts[0].subSequence(4, parts[0].length - 1).toString().toInt(),
                        parts[1].toLong()
                    )
                }
            }

            return dict.values.sum()
        }

        fun applyCommandsWithMemory(): Long {

            val dict: MutableMap<Long, Long> = mutableMapOf()

            var mask = ""

            var address = 0L

            fun getAddresses(inp: List<Long>, currentIdx: Int): List<Long> {

                if (currentIdx == 36)
                    return inp

                val maskIdx = mask.length - currentIdx - 1

                when (mask[maskIdx]) {
                    '0' -> {
                        val adrVal = address and (1L shl currentIdx)
                        if (adrVal != 0L)
                            return getAddresses(inp.map { x -> x or (1L shl currentIdx) }, currentIdx + 1)
                        return getAddresses(inp, currentIdx + 1)
                    }
                    '1' -> {
                        return getAddresses(inp.map { x -> x or (1L shl currentIdx) }, currentIdx + 1)
                    }
                    else -> { // X
                        return getAddresses(inp + inp.map { x -> x or (1L shl currentIdx) }, currentIdx + 1)
                    }
                }
            }

            for (command in commands) {

                val parts = command.split(" = ")
                if (parts[0] == "mask") {
                    mask = parts[1]
                } else {
                    address = parts[0].subSequence(4, parts[0].length - 1).toString().toLong()
                    val value = parts[1].toLong()
                    for (adr in getAddresses(mutableListOf(0L), 0))
                        dict[adr] = value
                }
            }

            return dict.values.sum()
        }
    }

    override fun getResultPartOne(): Long {
        return MaskMachine(input).applyCommandsAndGetSum()
    }

    override fun getResultPartTwo(): Long {
        return MaskMachine(input).applyCommandsWithMemory()
    }
}
