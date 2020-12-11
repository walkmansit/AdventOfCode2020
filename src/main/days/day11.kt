package main.days

object Day11 {

    private val input = """
        LLLLLLLLLL.LLLL.LLLLLLL.LLLLLLL..LLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLL.LL.LLLLLLL
        LLLL.LLLLL.LLLLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLLLLL.LLLLLLLLLLLLLLLLL.LLLL.LLLLLLLLLL
        LL.LLLLLLLLLLLLLLLLLLLL..LLLLLL..LLLLLLL.LLLLLLL.LLLLLL.LLLL.LLLLLLL.LLLLLLLLL.LLLLLLL.LLLLLLL
        LLLL.LLLLL.LLL.LLLLLLLL.LLLLLLL.LLLLLLLL.LLLLLLL.LLLLLL.LLLLLLLLLLLL.LLLLLLLLL.LLLL.LLLLLLL.LL
        LLLLLLLLLL.LLLL.LLLLLLL.LLLLLLL.LLLLLLLL..LLLLLL.LLLLLL.LLLL.LLLLLLL.LLLLLLLLL.LLLL.LLLLLLLLLL
        LLLLLLLLLLLLLLL.LLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLLLLLLLL.LLLLLLL.LLLLLLLLL.LLLL..LLLLLLLLL
        LLLLLLLLLL.LLLL.LLLLLLL.LLLLLLL.LLLLLLLLLL.LLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLL..LLLLLLLLLL.LLLL
        LLLLLLLLLL.LLLL.LLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLL..LLLL.LLLLLLLLLLLLLLL.LLL.LLLLLLLLLLLLL
        LLLLLLLLLL.LL.L.LLLLLLL.LLLLLL..LLLLLLLL.LLLLLLL.L.LLLL.LLLL.LLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLL
        LLLL.LLLLL.LLLL.L.LLLLL.LLLLLLLLL.LLLLLL.LLLLLLLLLLLLLL.LLLLL.LLLLLLLLLLLL.LLL.LLLL..LLLLLLLLL
        L..LL.L.LL.........LLL...LLL.........LL..LL.L..LL..L...L..L....LL.LL.L.LL.L..L...LLL......LL.L
        LL.LLLLLLLLLLLL.LLLLLLL.LLLLLLL.LLLLLLLL.LLLLLLL.LLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL
        LLLLLLLLLL.LLLL.LLLLLLL.LLLLLLL.LLLLL.LLLLLLLLLLLLLLLLL.LLLL.LLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLL
        LLLLLLLLLL.LLLLLLLLLLLL.LLLLLLL.LLLLLLLLLLLLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLL.LLLL.LLLLLLLLLL
        LLLLLLLLLL.LLLLLLLLLLLLLL.LLLL.LLLLLLL.L.LLLLLLL.LLLLLL.LLLLLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLLL
        LLLLLLLLLL.LLLL.LLLLLLL.LLLLLLL.LLLLLLLL.LLLLLLL.LLLLLL.LLLL.LLLLLLL.LLLLLLLLL.LLLL.LLLLLLLLLL
        LLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLLLLLLLLLL.LLLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLL.LLLLLL.LLL
        LLLLLLLLLL.LLLL.L.LLLLL.LLLLLLL.LLLLLLLLLLLLLLLL.LLL.LL.LLLLLLLLLLLL.L.LLLLLLL.LLLL.LLLLLLLLLL
        LLLLLLLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLLLLLLLLLLLLLL.LL.LLLL.LLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLL
        LLLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLL.LLLL.LLLLLLLLLLLLLLLLL.LLLL.LLLLLLLLLL
        ...L..L.LL......L..L..LL..LLL..L.L.L....L.LLLLL...L...L....L..L..........L..LL.LL.L........LL.
        LLLLLLLLLLLLLLL.LLLLL.L.LLLLLLL.LLLLLLLLLL.LLLLLLLLL.LLLLLLL.LLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLLL
        LLLLLLLLLL.LLLL.LLLLLLLLLLLLLLL.LLL.LLLL.LLLLLLL.LLLLLL.LLLL.LLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLL
        LLLLLLLLLL.LLLL..LLLLLL.LLLLLLL.LLLLLLLL.LLLLLLL.LLLLLL.LLLL.LLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLLL
        .LLLLLLLLL.LLLL..LLLLLL.LLLLLL..LLLLL.LL.LLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLL.LLLL.LLLLLLLLLL
        LLLLL.LLLL.LLLLLLLLLLL..LLLLLLLLLLLLLLLLLLLLLLLL.LLLLLL.LL.L.LLLLLLL..LLLLLLLL.LLLL.LLLLLLLLLL
        LLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLLLLLLLL.L.LLLLLLL.LLLLLLLLLLL.LLLLLLLLLLLLLL.LL.LLLLLLLLLLLLLLL
        LLLLLLLL.L.LLLL.LLLLLLL.LLLLLLL.LLLLLLLLLLL.LLLL..LLLLL..LLL.LLLLLLLLLLLLLLLLL.LLLL.LLLLLLLLLL
        .LL..LLL.LLL..LL.LL....LLLL.....LLLL..LLLL.L.L...........L...L.LLLLLL..LL..LL.LL.L.....LL.L...
        LLLLLLLL.LLLLLL.LLLLLLLLLL.L.LLLLLLLLLLL.LLLLLLLLLLLLLLLLLLL..LLLLLL.LLLLLLLLLLL.LL.LLLLLLLLLL
        LLLLLLLLLLLLLLL.LLLLLLL.LLLLLLL.LLL.LLLL.LLLLLLL.LLLLLL.LLLL.LLLLLLL.LLLLLLLLL.LLLL.LLLLLLLLLL
        LLLLLLLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLL..LLLLLL.LLLLLL.LLLL.LLLLLLL.LLLLLLLLL.LLLL.LLLLLLLLLL
        LLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLLL..LLLLLL.LLLLLLLLLLLL.LLLLLLLLL.LLLL.LLLLLLLLLL
        LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLLLLLLLL.LLLL.LLLLL.LLL.LLLL.LLLLLLL.LL
        ...............L.....L.....L....L.L....L.L.L.L.L.L..L..LL..L.......L.LLL.L.L.L...L..L.L.L..LLL
        LLLLLLLL.LLLLLL.LLLLLLL.LLLLLLL..LLLLLLLLLLLLLLL..LLLLLLLLLL.LLLLLLLLLLLLLLLLL.LLLL..LLLLLLLLL
        L.LLLLLLLL.LLLLLLLLLLLL.LLLLL.L.LL.LLLLL.LLLLLLL.LLLLLL.LLLL.LLLLLLL.LLLLL.LLL.LLLL.LLLLLLLL.L
        LLLLLLLLLL.LLLL.LLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLL.LLLLLLLLLL
        LLLLLLLLLL.LLLL.LLLLLLL..LLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLL
        LLLLLLLLLL.LLLL..LLLLLL.LLLLLLL.LLLLLLLLL.LL.LLL.LLLLLLLLLLL.LLLLLL..LLLLLL.LL.LLLLLLLLLLLLLLL
        LLLLLLLLLL.LLLL.L.LLLLL.LLLLLLL.LLLLLLLL.L.LLLLL.LLLLLL.LLLL.LLLLL.LLLLLLLLLLL.L..L.LLLLLLLLLL
        LLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLL.LLLL.LLLL.LLLLLLLLLL
        LLLLLLLLLL.LLLLLLLLLLLL.LLLLLLLLLLLLLLLL.L.LLLLLLLLLLLLLLLLL.LLLLLLL.LLLL.LLLL.LLLL.L.LLLLLLLL
        .LLL..L.L.LL.L.LL.LL.LLL.L..L.L.....L....L...L.L......L.LL....L.LL..L.......L..L...L..L...LLL.
        LLLLLLLLLL.LLLL.LLLLLLL.LLLLLL..LLLLLLLL.LLLLLLL.LLLLLL.LLLLLLLLLLLL.L.LLLLLLL..LLLL.LLLLLLLLL
        L..LLLLLLLLLLLL.LLLLLLL.LLLLLLL.LLLLL.LL.LLLLLLLLLLLLLLLLLLL.LLL.LLL.LL.LLLLLL.LLLL.LLLLLLLLLL
        LLLLLLLLLL.LLLL.LLLLLLL.LLLLLLL..LLLLLLLLLLLLLLL.LLLLLL.LLLL.LLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLL
        LLLLLLLLLL.LLLL.LLLLLLL.LLLLLLL.LLLLLLLL.LLLLLLL.LLLLLL.LLLLLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLL.LL
        LLL.LLLLLL.LLLL.LLLLLLL.LLLLLLLLLLLLLLL..LLLLLLLLLLLLLLLLLL..LLLLLLL.LLLLLLLLL.LL.LLLLLL.LLLLL
        LLL.LLLLLL.LLLL.LLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLL.LLLLLL.LLLL.LLLLLLLLLLLLLLLLL.LLLL.LLLLLLLLLL
        ..L...LLL......L....L..LL..LLLLL..L...L..LL.L.L....L...L.LL..L..L.LLL.....L.L...L......L.LL..L
        LL.LLLLLLL.LLLL.LLLL.LL.LLLLLLL..LLLLLLL.LLLLLLL.LLLL.LLLLLLLLLLLLLL.LLLLLLLL...LLL.L.LLLLLLLL
        LLLLLLLLLL.L.LL.L.LLLLL.LLLLLLLLLLLLLLLL.LLLLLLL.LLLLLL.L.LLLLLLLLLL.LLLLLLLLLLLLLLLLL.LLLL.LL
        LLLLLLLLLL.LLLL.LLLLLLL.LLLLLLL.LLLLLLLLLLLLLLLL.LLLLLL.LLLLLLLLL.LL.LLLLLLLLL.LLLLLLLLLLLLLLL
        LLLLLLLLLLLLLLL.LLLLLLL.LLLLLLL.LLLLLLLL.LLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLLL
        L.LLLLLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLLLLLLLLLL.LLLLLL.LLLLLLLLLLLL.LLLLLLLLL.LLLL.LLLLLLLLLL
        LLLL.LLLLL.LLLL.LLLLLLL.LLLLLLL.LLLLLLLLLLLLL.LL.LLLLLL.LLLLLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLLL
        LL......LL...L......L.L...LL..L.L...LL.L........L.LL.LL.LL...L...LL.....L..LL.L....L.L..LLL..L
        LLLLLLLLLL.LLLL.L.LLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLL.LLLLLL.LL.LLLL.LLLLLLLLLL
        LLLLLLLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLL.LLLLLLL.LLLLLL.LLLL.LLLLLLL.LLLLLLLLL.LLLLL.LLLLL.LLL
        LLLL.LL.LL.LLLL.LLLLLLLLLL..LLL.LLLLLLLL.LLLLLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLL.L.LLLLLLLL
        LLLL.LLLLL.LLLL.LLLLLLL.LLLLLLL.LLLLLLLLLLLLLLLL.LLLLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLL
        LLLLLLLLLL.LLLLLLLLLLLL.LLLLLLL.LLLLLLLLLLLLLLL..LLLLLL.LLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLL
        LLLLLLLLLL.LLLL.LLLLLLL.LLLLLLL.LLLLLLLL.LLLLLLL.LLLLLLLLLLL.LLLLLLLLLL.LLL.LLLLLLL.LLLLLLLLL.
        LLLLLLLLLL.LLLL.LLLLLLL.LLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLL.L..LLLLLLLLLLL.LLL.LLLLLL
        LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLL.LLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLL
        LLLLLLLLLLLLLLLLL.LLLLL.LLLLLLLLLLLLLLLL.LLLLLLLLLLL.LL.LLLL.LLLLLL..LLLLLLLLL.LLLL.LLLLLLLLLL
        .....LL..LL.......L.L.....L.....L....L..L.L...L.L.L.L...L.L..L.LLL.............L...........L.L
        L.LLLLLLLL.LLLL.LLLLLLLLLLLLLLL.LLLL.LLLLLLLLLL.LLLLLLL.LLLL.LLLLLLL.LLLLLLLLL.LLLL.LLLLLLLLLL
        LLLLLLLLLL.LLLL.LLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLLL..LLLLLLLLLLLLLLLLLLLLL.LL.L.L.LLLLLLLL
        LLLLLLLLLL.LLLL.LLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLL.LLLL.LLLLLLL.LLLLLL.LLLLLL..LLLLLLLLLL
        LLLLLLLLLL.LLLLLLLLLLLL.LLLLLLL.LLLLLLLL.LLLLLLL.LLLLLL.LLLL.LLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLL
        LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL..LLLLLL.LLLLLL.LLLL.LLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLL
        LLLLLLLLLL.LLLLLLLLLLLL.LLLLLLLLLLLL.LLL.LLLLLLL.LLLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLL
        .LLL.....L...L.LLL.L.....L.L........L..LL.L.L.LL.....L..L.L.LL.LLLLLL..LL...L..L...LL.L.LL....
        LLLLLLLLLL.LLLLLLLLLLLL.LLLLLLL.LLLLLLLL.LLLLLLL.LLLLLL.LLLL.LLLLL.L.LLLLLLLLL.LLLL.LLLLLLL.LL
        LLLLLLLL.LLLLLLLLLLLLLL.LLLLLLL.LLLLLLLL.LLLLLLL.LLLLLL.LLLL.LL.LLLLLLLLLLLLLLLLLLL.LLLLLLLLLL
        LLLLLLLLLL.LLLL.LLLLLLL.LL.LLLL.LLLLLLLL.LLLLLLL.LLLLLL.LLLL...LLLLL.LLLLLLLLL.LLLL.LLLLLLLLLL
        LLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLLLL.LLLLLLL.LLLLLLLLLLLLLL.LLLLLL.LLL
        LLLLLLLLL..LLLL.LLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLL
        .L..L.L.LL..........L..L.............LLLL..L.......LL....L..L.......L.........L..L.L..LL....LL
        LLLLLLLLLL.LLLL.LLLLLLL.LLLLLLL.LLLLLLLL.LLLLLLL.LLLLLLLLLLL.LLLLLLL.LLLL.LLLL.LLLL.LLLLLLLLLL
        LLLLLLLLLL.LLLL.LLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLL.LLLLLLLLLLL
        LLLLLLLLLL.LLLL.LLLLLLL.LLLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLLL.LLLL.LLLLLLL.LL
        LLLLLLLLLL.LLLL.LLL.LLLLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLL
        LLLLL.LLLL.LLLL.LLLLLLL.LLLLLLL.LLLLLLLL.LLLLL.L.LLLLLLL.LLL.LLLLLLL.LLLLLLLLL.LLLL.LLLLLLLLLL
        ..L.....L......L....L..LLL..L.L..L....L..LL....L.L........LL...L.......L..L.L.L..LL..L.L.....L
        LLLLLLLLLL.LLLL.LLLLLLL.LLLLLLL.LL.LLLLLLLLLLLLL.LLLLLL.LLLLLL.LLLLL.LLLLLLLLL.LLLLLLLLLLLLLLL
        LLLLLLLLLL.LLLL.LLLLLLL.LLLLLLL.LLLLLLLL.LLLLLLL.LLLLLLLLLLL.LLLLLLLLLLLLLLLLL.LLL..LLLLLLLLLL
        LLLLLLLLLL.LLLLLLLLLLLL.LLLLLLL.LLLLLLLL.LL..LLL.LLLLLL.LLLL.LLLLLLL.LLLLLLLL..LL.L.LLLLLLL.LL
        LLLLLLLLLL.LLLL.LLLLLLL.LLLLLLLLLLLLLLLL..LLL.LLLLLLLLLLLLLL.LLL.LLL.LLL.LLLLLLLLLLLLLLLLLLLL.
        LLLLLLLLLL.LL.L.LLLLLLL.LLLLLLL.LLLLLLLL.LLLLLLL.LLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLL
        LLLLLLLLLL.LLLL.LLLLLLL.LLLLLLLLLLLLLLLL.LLLLLLL.LLLLLL.LLLL.LLLLLLL.LLLLLLLLLLL.LL.LLLLLLLLLL
    """.trimIndent()

    private class SeatsTable(input: String){

        // Point(Y,X)
        private val neighbords = arrayOf (
                arrayOf(0 to 1, 1 to 1, 1 to 0), // 0 TOP LEFT
                arrayOf(1 to 0, 1 to -1, 0 to -1), // 1 TOP RIGHT
                arrayOf(0 to 1, 1 to 1, 1 to 0, 1 to -1, 0 to -1), // 2 TOP
                arrayOf(-1 to 0, -1 to 1, 0 to 1), // 3 BOTTOM LEFT
                arrayOf(-1 to 0, -1 to 1, 0 to 1, 1 to 1, 1 to 0), // 4 LEFT
                arrayOf(0 to -1, -1 to -1, -1 to 0), // 5 BOTTOM RIGHT
                arrayOf(0 to -1, -1 to -1, -1 to 0, -1 to 1, 0 to 1), // 6 BOTTOM
                arrayOf(1 to 0, 1 to -1, 0 to -1, -1 to -1, -1 to 0), // 7 RIGHT
                arrayOf(0 to 1, 1 to 1, 1 to 0,1 to -1, 0 to -1, -1 to -1, -1 to 0, -1 to 1 ) // 8 FULL
        )

        private enum class CellType {
            FLOOOR,
            SEAT,
            OCCUPIED
        }



        private lateinit var cells : Array<Array<CellType>>

        private lateinit var buffer : Array<Array<CellType>>

        private var height : Int = 0
        private var width : Int = 0

        private lateinit var neigboarPosIdx : Array<Array<Int>>

        init {
            val lines = input.split("\n").toTypedArray()
            height = lines.size
            width = lines[0].length

            cells = Array(height) { Array(width){CellType.SEAT}  }
            neigboarPosIdx = Array(height) { Array(width){8}  }
            //buffer = cells.clone()

            for (i in 0 until height)
                for (j in 0 until width){

                    //init cells
                    if (lines[i][j] == '.'){
                        cells[i][j] = CellType.FLOOOR
                    }

                    if (i == 0){
                        if (j == 0) {
                            neigboarPosIdx[i][j] = 0 //top left
                            continue
                        }
                        if (j == width - 1) {
                            neigboarPosIdx[i][j] = 1 //top right
                            continue
                        }
                        neigboarPosIdx[i][j] = 2 //top
                        continue

                    }
                    if (j == 0 ){
                        if (i == height -1) {
                            neigboarPosIdx[i][j] = 3 //bottom left
                            continue
                        }
                        neigboarPosIdx[i][j] = 4 //bottom
                        continue
                    }
                    if (i == height -1) {
                        if (j == width -1){
                            neigboarPosIdx[i][j] = 5 //bottom right
                            continue
                        }
                        neigboarPosIdx[i][j] = 6 //bottom
                        continue
                    }
                    if (j == width -1){
                        neigboarPosIdx[i][j] = 7 //right
                    }

                }
        }

        private fun countOccupied() : Int {
            var sum = 0
            for (i in 0 until height)
                for (j in 0 until width)
                    if (cells[i][j] == CellType.OCCUPIED) sum++

            return sum
        }

        fun simulateIteration(withDirections : Boolean, ngbCount : Int) : Boolean {

            fun countOccupiedNeigbords(y: Int, x : Int) : Int {
                var sum = 0
                for ((i,j) in neighbords[neigboarPosIdx[y][x]]){
                    if (cells[y+i][x+j] == CellType.OCCUPIED)
                        sum++
                }
                return sum
            }

            fun countNeigbordsWithDirections(y: Int, x : Int) : Int {

                fun isDirectionOccupied(y:Int,x:Int, dy : Int, dx:Int) : Boolean {
                    var nextY = y+dy
                    var nextX = x+dx

                    while (nextY in 0 until height && nextX in 0 until width){
                        if (cells[nextY][nextX] == CellType.OCCUPIED) return true
                        if (cells[nextY][nextX] == CellType.SEAT) return false
                        nextX+=dx
                        nextY+=dy
                    }
                    return false
                }

                var sum = 0

                for ((dy,dx) in neighbords[neigboarPosIdx[y][x]]){
                    if (isDirectionOccupied(y,x,dy,dx)) sum++
                }

                return sum
            }

            buffer = clone2DimArray(cells)
            var hasChanges = false

            for (i in 0 until height)
                for (j in 0 until width){

                    val occupiedSum = if (withDirections) countNeigbordsWithDirections(i,j) else countOccupiedNeigbords(i,j)

                    when(cells[i][j]){
                        CellType.SEAT -> {
                            if (occupiedSum == 0) {
                                buffer[i][j] = CellType.OCCUPIED
                                hasChanges = true
                            }
                        }
                        CellType.OCCUPIED -> {
                            if (occupiedSum > ngbCount - 1) {
                                buffer[i][j] = CellType.SEAT
                                hasChanges = true
                            }
                        }
                    }


                }

            cells = buffer

            return hasChanges
        }

        fun clone2DimArray(array:Array<Array<CellType>>) : Array<Array<CellType>> {

            val result = Array(height) { Array(width) {CellType.SEAT}}

            for (i in 0 until height)
                for (j in 0 until width){
                    result[i][j] = array[i][j]
                }


            return result

        }

        fun simulateStillStable(withDirections : Boolean, ngbCount : Int) : Int {
            var hasChanges = true

            while (hasChanges){
                hasChanges = simulateIteration(withDirections,ngbCount)
            }

            return countOccupied()


        }

    }

    fun getResult() : Int {
        return SeatsTable(input).simulateStillStable(false,4)
    }

    fun getResultAdvanced() : Int {
        return SeatsTable(input).simulateStillStable(true, 5)
    }
}