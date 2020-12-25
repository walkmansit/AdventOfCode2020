package main.days

object Day25 {

    private const val base = 20201227

    fun transform(loopSize:Int,subject:Long) : Long {

        var current = 1L

        repeat(loopSize){
            current *= subject
            current %= base
        }

        return current
    }

    private fun calculateLoop(target: Long) : Int {

        var loop = 0
        var current = 1L
        val subject = 7

        do {
            current *= subject
            current %= base
            loop++
        }
        while (current != target)
        return loop
    }


    fun getResult() : Long {

        val cardPK = 1717001
        val doorPK = 523731

        val cardLoop = calculateLoop(cardPK.toLong())
        val doorLoop = calculateLoop(doorPK.toLong())

        val cardEncrypt = transform(cardLoop,doorPK.toLong())
        val dorEncrypt = transform(doorLoop,cardPK.toLong())

        return cardEncrypt
    }

    fun getResultAdvanced() : Long {
        return 0
    }
}