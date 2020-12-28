package github.walkmansit.aoc2020

class Day23(val input: String) : DayAoc<String, Long> {

    private class Game(input: String, extra: IntRange = 0..1) {

        private class Node(val value: Int, var left: Node?, var right: Node?)

        private var current: Node? = null

        private var nodesArr: Array<Node?>? = null

        init {
            var head = Node(0, null, null)
            var tale = head

            nodesArr = if (extra.first == 0) {
                Array(10) { null }
            } else {
                Array(1000001) { null }
            }

            for ((i, v) in input.withIndex()) {
                val vInt = v.toString().toInt()
                if (i == 0) {
                    head = Node(v.toString().toInt(), null, null)
                    nodesArr!![vInt] = head
                    tale = head
                    continue
                }
                val new = Node(vInt, tale, null)
                nodesArr!![vInt] = new
                tale.right = new
                tale = new
            }

            if (extra.first != 0) {
                for (e in extra) {
                    val new = Node(e, tale, null)
                    nodesArr!![e] = new
                    tale.right = new
                    tale = new
                }
            }

            tale.right = head
            head.left = tale

            current = head
        }

        fun turn() {

            val cutSet = mutableSetOf<Int>()

            val cutStart = current!!.right!!
            cutSet.add(cutStart.value)
            cutSet.add(cutStart.right!!.value)
            val cutEnd = cutStart.right!!.right!!
            cutSet.add(cutEnd.value)

            cutEnd.right!!.left = current
            current!!.right = cutEnd.right!!

            cutStart.left = null
            cutEnd.right = null

            fun findDestination(): Node {

                fun decrement(value: Int): Int {
                    var suppose = value - 1
                    val max = if (nodesArr!!.size == 10) 9 else 1000000
                    return if (suppose == 0) max else suppose
                }

                var destValue: Int = decrement(current!!.value)

                while (cutSet.contains(destValue))
                    destValue = decrement(destValue)

                return nodesArr!![destValue]!!
            }

            val destination = findDestination()

            destination.right!!.left = cutEnd
            cutEnd.right = destination.right!!
            cutStart.left = destination
            destination.right = cutStart

            current = current!!.right!!
        }

        fun getNextTo(destValue: Int): String {

            val sb = StringBuilder()

            var search = nodesArr!![destValue]!!.right

            do {
                sb.append(search!!.value)
                search = search!!.right!!
            } while (search!!.value != destValue)

            return sb.toString()
        }

        fun multNextToOne(): Long {
            val first = nodesArr!![1]

            val a = first!!.right!!.value.toLong()
            val b = first!!.right!!.right!!.value
            return a * b
        }
    }

    override fun getResultPartOne(): String {
        val game = Game(input)
        repeat(100) { game.turn() }
        return game.getNextTo(1)
    }

    override fun getResultPartTwo(): Long {
        val game = Game(input, 10..1000000)
        repeat(10000000) { game.turn() }
        return game.multNextToOne()
    }
}
