package github.walkmansit.aoc2020

class Day11 (val input:List<String>) : DayAoc<Int,Int> {


    private class SeatsTable(lines: List<String>){

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

    override fun getResultPartOne(): Int {
        return SeatsTable(input).simulateStillStable(false,4)
    }

    override fun getResultPartTwo(): Int {
        return SeatsTable(input).simulateStillStable(true, 5)
    }
}