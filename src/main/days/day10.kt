package main.days

object Day10 {

    private val input = """
        103
        131
        121
        151
        118
        12
        7
        2
        90
        74
        160
        58
        15
        83
        153
        140
        166
        1
        148
        33
        165
        39
        100
        135
        68
        77
        25
        9
        54
        94
        101
        55
        141
        22
        97
        35
        57
        117
        102
        64
        109
        114
        56
        51
        125
        82
        154
        142
        155
        45
        75
        158
        120
        5
        19
        61
        34
        128
        106
        88
        84
        137
        96
        136
        27
        6
        21
        89
        69
        162
        112
        127
        119
        161
        38
        42
        134
        20
        81
        48
        73
        87
        26
        95
        146
        113
        76
        32
        70
        8
        18
        67
        124
        80
        93
        29
        126
        147
        28
        152
        145
        159
    """.trimIndent()

    private class AdaptersChain(val adapters : List<Int>){


        fun findDiffMult() : Int {

            val set = adapters.toMutableSet()
            var oneDiff = 0
            var threeDiff = 1
            var current = 0

            fun nextIterate(current : Int) : Int {

                for (i in 1..3){
                    if (set.contains(current+i)){
                        if (i == 1) oneDiff++
                        if ( i == 3 ) threeDiff++

                        set.remove(current+i)
                        return current + i
                    }
                }
                return -1
            }

            while (current != -1 || set.isNotEmpty()){
                current = nextIterate(current)
            }

            return oneDiff * threeDiff
        }

        fun countDistinctArrangments() : Long {

            val sortedList = adapters.sortedDescending()
            val dp = Array<Long>(sortedList.size) { 0 }

            for ( (i,v) in sortedList.withIndex() ){
                if (i == 0){
                    dp[i] = 1
                    continue
                }
                for (k in i-1 downTo i-3){
                    if ( k >=0 && sortedList[k] - v < 4 ){
                        dp[i] += dp[k]
                    }
                }
            }
            return dp.last()
        }



    }

    fun getResult() : Int {
        return AdaptersChain(input.split("\n").map { it.toInt() }).findDiffMult()
    }

    fun getResultAdvanced() : Long {
        return AdaptersChain(("$input\n0").split("\n").map { it.toInt() } ).countDistinctArrangments()
    }

}