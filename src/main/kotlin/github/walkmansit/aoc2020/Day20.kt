package github.walkmansit.aoc2020

import kotlin.math.sqrt

class Day20(val input: String) : DayAoc<Long, Int> {

    private val monsterStr = """
        1                  # 1
        1#    ##    ##    ###1
        1 #  #  #  #  #  #   1
    """.trimIndent()

    private val monster = getMonsterIndices()

    private val bordersMap: MutableMap<Int, MutableSet<Int>> = mutableMapOf()

    private val tilesToBordersMap: MutableMap<Int, MutableSet<Int>> = mutableMapOf()

    private var tiles = mutableListOf<Tile>()

    private fun prepareBordersAndTilesData() {
        val parts = input.split("\n\n")
        tiles = parts.map { Tile.fromString(it) }.toMutableList()

        for (tile in tiles) {
            for (bordConfig in tile.getConfigurations()) {
                for (border in bordConfig.borders()) {
                    if (bordersMap.containsKey(border))
                        bordersMap[border]!!.add(tile.id)
                    else
                        bordersMap[border] = mutableSetOf(tile.id)
                }
            }
        }

        for ((border, tiles) in bordersMap) {
            if (tiles.size == 2)
                for (tile in tiles) {
                    if (!tilesToBordersMap.containsKey(tile))
                        tilesToBordersMap[tile] = mutableSetOf(border)
                    else
                        tilesToBordersMap[tile]!!.add(border)
                }
        }
    }

    private fun markMonstersInConfig(config: Configuration): Int {

        var sum = 0

        val size = config.body.size

        fun drawMonster(y: Int, x: Int, body: Array<Array<Char>>) {
            for ((i, j) in monster)
                body[y + i][x + j] = 'O'
        }

        for (i in 0 until size - Companion.mHeight)
            for (j in 0 until size - mWidth) {
                if (hasMonsterAtBase(i, j, config.body)) {
                    drawMonster(i, j, config.body)
                }
            }

        for (i in 0 until size)
            for (j in 0 until size)
                if (config.body[i][j] == '#') sum++

        return sum
    }

    private fun findConfigWithMonster(config: Configuration): Configuration {

        for (c in getConfigurations(config))
            if (configContainsMonster(c))
                return c

        return config
    }

    private fun hasMonsterAtBase(y: Int, x: Int, body: Array<Array<Char>>): Boolean {

        for ((i, j) in monster) {
            if (body[y + i][x + j] != '#') return false
        }

        return true
    }

    private fun configContainsMonster(config: Configuration): Boolean {

        val size = config.body.size

        for (i in 0 until size - Companion.mHeight)
            for (j in 0 until size - mWidth)
                if (hasMonsterAtBase(i, j, config.body)) return true

        return false
    }

    private fun getConfigurations(config: Configuration) = sequence {
        var currentConfig = config

        repeat(4) {
            currentConfig = currentConfig.rotate()
            yield(currentConfig)

            val vertState = currentConfig.mirrorVert()
            yield(vertState)

            val horState = currentConfig.mirrorHor()
            yield(horState)

            yield(vertState.mirrorHor())
        }
    }

    private fun getPicture(
        cornerId: Int,
        bordersMap: MutableMap<Int, MutableSet<Int>>,
        tiles: List<Tile>
    ): Array<Array<Tile?>> {

        fun setTopLeftConfigForTile(tile: Tile, set: Set<Int>): Boolean {

            for (config in tile.getConfigurations()) {
                if (bordersMap[config.top]!!.size == 1 && bordersMap[config.left]!!.size == 1) {
                    tile.config = config
                    return true
                }
            }

            return false
        }

        fun rotateTileTillMatch(tile: Tile, border: Int, borderIdx: Int) {
            for (config in tile.getConfigurations()) {
                if (config.borders()[borderIdx] == border) {
                    tile.config = config
                    return
                }
            }
        }

        val cornerTile = tiles.first { it.id == cornerId }

        val size = sqrt(tiles.size.toDouble()).toInt()

        val picture: Array<Array<Tile?>> = Array(size) { Array(size) { null as Tile? } }

        for (i in 0 until size)
            for (j in 0 until size) {

                // set first tile
                if (i == 0 && j == 0) {

                    val cornerBordersSet =
                        bordersMap.filter { pair -> pair.value.size == 1 && pair.value.contains(cornerId) }
                            .map { it.key }.toSet()
                    val cornerIsFine = setTopLeftConfigForTile(cornerTile, cornerBordersSet)
                    if (cornerIsFine) {
                        picture[i][j] = cornerTile
                        continue
                    } else
                        return picture
                }

                // set bottom
                if (j == 0) {
                    val prev = picture[i - 1][j]!!
                    val tilesSet = bordersMap[prev.config.bottom]
                    val targetTileIdx = tilesSet!!.first { it != prev.id }
                    val targetTile = tiles.first { it.id == targetTileIdx }
                    rotateTileTillMatch(targetTile, prev.config.bottom, 0)
                    picture[i][j] = targetTile
                }
                // set right
                else {
                    val prev = picture[i][j - 1]!!
                    val tilesSet = bordersMap[prev.config.right]
                    val targetTileIdx = tilesSet!!.first { it != prev.id }
                    val targetTile = tiles.first { it.id == targetTileIdx }
                    rotateTileTillMatch(targetTile, prev.config.right, 3)
                    picture[i][j] = targetTile
                }
            }

        val isValid = validatePicture(picture)

        return picture
    }

    private fun getMonsterIndices(): List<Pair<Int, Int>> {

        val result = mutableListOf<Pair<Int, Int>>()

        val lines = monsterStr.split("\n").map { it.substring(1, it.length - 1) }

        for ((i, line) in lines.withIndex()) {
            for (j in lines[0]!!.indices) {
                if (line[j] == '#') result.add(i to j)
            }
        }

        return result.toList()
    }

    private fun trimPicture(picture: Array<Array<Tile?>>): Array<Array<Char>> {

        val size = picture.size

        val newSize  = size * 8

        val result: Array<Array<Char>> = Array(newSize) { Array((newSize)) { '-' } }

        fun printTile(tile: Tile, baseI: Int, baseJ: Int) {
            for (i in 1 until 9)
                for (j in 1 until 9) {
                    result[baseI + i - 1][baseJ + j - 1] = tile.config.body[i][j]
                }
        }

        for (i in 0 until size)
            for (j in 0 until size) {
                val tile = picture[i][j]!!
                printTile(tile, i * 8, j * 8)
            }

        return result
    }

    private fun validatePicture(picture: Array<Array<Tile?>>): Boolean {

        val size = picture.size

        fun validateRightBorder(i: Int, j: Int): Boolean {

            if (j == size - 1) return true

            val tile = picture[i][j] ?: return false

            val rightTile = picture[i][j + 1] ?: return false

            for (row in 0 until 10) {
                if (tile.config.body[row][9] != rightTile.config.body[row][0]) return false
            }

            return true
        }

        fun validateBottomBorder(i: Int, j: Int): Boolean {

            if (i == size - 1) return true

            val tile = picture[i][j] ?: return false

            val bottomTile = picture[i + 1][j] ?: return false

            for (col in 0 until 10) {
                if (tile.config.body[9][col] != bottomTile.config.body[0][col]) return false
            }

            return true
        }

        for (i in 0 until size)
            for (j in 0 until size)
                if (!validateRightBorder(i, j) || !validateBottomBorder(i, j)) return false

        return true
    }

    private fun printBody(body: Array<Array<Char>>): String {
        val sb = StringBuilder()

        for (i in body.indices)
            for (j in body.indices) {
                sb.append(body[i][j])
                if (j == body.size - 1) sb.append("\n")
            }

        return sb.toString()
    }

    data class Configuration(val body: Array<Array<Char>>) {
        var top = 0
        var right = 0
        var bottom = 0
        var left = 0

        init {

            val size = body[0].size

            for (i in 0 until size) {

                if (i == 0) {
                    for (j in 0 until size) {
                        val k = size - j - 1
                        if (body[i][j] == '#') {
                            top = top or (1 shl k)
                        }
                    }
                }

                if (i == size - 1) {
                    for (j in 0 until 10) {
                        val k = size - j - 1
                        if (body[i][j] == '#') {
                            bottom = bottom or (1 shl k)
                        }
                    }
                }

                if (body[i][size - 1] == '#') {
                    val k = size - i - 1
                    right = right or (1 shl k)
                }

                if (body[i][0] == '#') {
                    val k = size - i - 1
                    left = left or (1 shl k)
                }
            }
        }

        fun borders() = arrayOf(top, right, bottom, left)

        fun rotate(): Configuration {
            val newBody: Array<Array<Char>> = Array(body.size) { Array(body.size) { '-' } }
            for (i in body.indices)
                for (j in body.indices)
                    newBody[i][j] = body[body.size - j - 1][i]

            return Configuration(newBody)
        }

        fun mirrorVert(): Configuration {

            val newBody: Array<Array<Char>> = Array(body.size) { Array(body.size) { '-' } }
            val half = body.size / 2
            for (i in body.indices)
                for (j in 0..half) {
                    newBody[i][j] = body[i][body.size - j - 1]
                    newBody[i][body.size - j - 1] = body[i][j]
                }

            return Configuration(newBody)
        }

        fun mirrorHor(): Configuration {
            val newBody: Array<Array<Char>> = Array(body.size) { Array(body.size) { '-' } }
            val half = body.size / 2
            for (i in 0..half) {
                newBody[i] = body[body.size - i - 1]
                newBody[body.size - i - 1] = body[i]
            }

            return Configuration(newBody)
        }
    }

    class Tile private constructor(
        val id: Int,
        body: Array<Array<Char>>,
        var config: Configuration = Configuration(body)
    ) {

        fun getConfigurations() = sequence {
            var currentConfig = config

            repeat(4) {
                currentConfig = currentConfig.rotate()
                yield(currentConfig)

                val vertState = currentConfig.mirrorVert()
                yield(vertState)

                val horState = currentConfig.mirrorHor()
                yield(horState)

                yield(vertState.mirrorHor())
            }
        }

        companion object {

            fun fromString(str: String): Tile {

                val parts = str.split(":\n")
                val id = parts[0].split(" ")[1].toInt()

                val body: Array<Array<Char>> = Array(10) { Array(10) { ' ' } }

                for ((i, line) in parts[1].lines().withIndex()) {
                    for (j in 0 until 10) {
                        body[i][j] = line[j]
                    }
                }

                return Tile(id, body)
            }
        }
    }

    companion object {
        private const val mHeight = 3
        private const val mWidth = 20
    }

    override fun getResultPartOne(): Long {

        prepareBordersAndTilesData()

        return tilesToBordersMap.filter { pair -> pair.value.size == 4 }.map { it.key.toLong() }
            .reduce { a, b -> a * b }
    }

    override fun getResultPartTwo(): Int {

        prepareBordersAndTilesData()

        val cornersList = tilesToBordersMap.filter { pair -> pair.value.size == 4 }.toList()

        val picture = getPicture(cornersList.first().first, bordersMap, tiles)

        val trimmedPict = trimPicture(picture)

        val config = findConfigWithMonster(Configuration(trimmedPict))

        return markMonstersInConfig(config)
    }
}
