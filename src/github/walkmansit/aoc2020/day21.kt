package github.walkmansit.aoc2020

class Day21(val input:List<String>) : DayAoc<Int,String> {

    class Finder(val input:List<String>) {

        fun count() : Int {
            val ingridientSet = mutableSetOf<String>()

            val totalList: MutableList<Set<String>> = mutableListOf()

            val allergentMap:MutableMap<String,Set<String>> = mutableMapOf()

            for (line in input){

                //create set
                val tempIngrSet = mutableSetOf<String>()

                val blocks = line.split(" (contains ")

                val parts = blocks[0].split(" ")
                for(i in parts.indices){
                    tempIngrSet.add(parts[i])
                    ingridientSet.add(parts[i])
                }
                totalList.add(tempIngrSet.toSet())

                //get allergents

                val allgParts = blocks[1].substringBefore(")").split(", ")

                for (allgKey in allgParts) {
                    if (!allergentMap.contains(allgKey)){
                        allergentMap[allgKey] = tempIngrSet.toSet()
                    }
                    else {
                        val tempSet = mutableSetOf<String>()
                        val currentSet = allergentMap[allgKey]!!
                        for (item in tempIngrSet) {
                            if (currentSet.contains(item))
                                tempSet.add(item)
                        }
                        allergentMap[allgKey] = tempSet.toSet()
                    }
                }
            }

            fun mapContainsItem(item:String) : Boolean {
                allergentMap.values.forEach {
                    if (it.contains(item)) return true
                }
                return false
            }

            fun findCount(set:MutableSet<String>) : Int {

                var sum = 0

                for (line in totalList) {
                    for (item in set){
                        if (line.contains(item)) sum++
                    }
                }

                return sum

            }

            val targetSet = mutableSetOf<String>()
            for (item in ingridientSet) {
                if (!mapContainsItem(item))
                    targetSet.add(item)
            }

            return findCount(targetSet)
        }

        fun dangerousIngredientList() : String {
            val ingridientSet = mutableSetOf<String>()

            val totalList: MutableList<Set<String>> = mutableListOf()

            val allergentMap:MutableMap<String,Set<String>> = mutableMapOf()

            for (line in input){

                //create set
                val tempIngrSet = mutableSetOf<String>()

                val blocks = line.split(" (contains ")

                val parts = blocks[0].split(" ")
                for(i in parts.indices){
                    tempIngrSet.add(parts[i])
                    ingridientSet.add(parts[i])
                }
                totalList.add(tempIngrSet.toSet())

                //get allergents

                val allgParts = blocks[1].substringBefore(")").split(", ")

                for (allgKey in allgParts) {
                    if (!allergentMap.contains(allgKey)){
                        allergentMap[allgKey] = tempIngrSet.toSet()
                    }
                    else {
                        val tempSet = mutableSetOf<String>()
                        val currentSet = allergentMap[allgKey]!!
                        for (item in tempIngrSet) {
                            if (currentSet.contains(item))
                                tempSet.add(item)
                        }
                        allergentMap[allgKey] = tempSet.toSet()
                    }
                }
            }

            val algArray = allergentMap.keys.sorted().toTypedArray() // from
            val ingrArray =  allergentMap.values.flatten().toSet().toTypedArray() //to

            val n = ingrArray.size
            val mt = Array(n) { - 1}
            val used = mutableListOf<Int>()

            val g = Array(n) { mutableListOf<Int>()}

            for ((key, set) in allergentMap){
                val ingrList = mutableListOf<Int>()

                for (item in set){
                    ingrList.add(ingrArray.indexOf(item))
                }
                g[algArray.indexOf(key)] = ingrList
            }

            fun tryKuhn(v:Int) : Boolean {

                if (used.contains(v)) return false
                used.add(v)

                for (i in g[v].indices){
                    val to = g[v][i]
                    if (mt[to] == -1 || tryKuhn(mt[to])){
                        mt[to] = v
                        return true
                    }
                }
                return false
            }

            for (i in g.indices){
                used.clear()
                tryKuhn(i)
            }

            val result = mutableListOf<String>()

            for (i in algArray.indices){
                val idx = mt.indexOf(i)
                if (idx != -1 ) {
                    result.add(ingrArray[idx])
                }
            }

            return result.joinToString(",")
        }
    }

    override fun getResultPartOne(): Int {
        return Finder(input).count()
    }

    override fun getResultPartTwo(): String {
        return Finder(input).dangerousIngredientList()
    }
}