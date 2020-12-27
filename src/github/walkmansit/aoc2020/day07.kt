package github.walkmansit.aoc2020

class Day07(val input:List<String>) : DayAoc<Int,Int> {

    private class Graph {

        private val nodes : MutableMap<String,Node> = mutableMapOf()

        fun addNodeWithParent(parentName : String, name : String, weight : Int){

            fun findWithCreate(value: String) : Node {
                return if (!nodes.containsKey(value)) {
                    val newNode = Node(value)
                    nodes[value] = newNode
                    newNode
                } else
                    nodes[value]!!
            }

            val parent = findWithCreate(parentName)


            var node = findWithCreate(name)

            parent.kids.add(node to weight)
            node.parents[parent.value] = parent

        }

        fun countParentsForNode(name : String) : Int {

            fun getUniqueParents(node : Node, result : MutableSet<String> ){


                for ((k,v) in node.parents) {
                    result.add(k)
                    getUniqueParents(v,result)
                }

            }


            if (nodes.containsKey(name)){
                val targetNode = nodes[name]!!
                val result = mutableSetOf<String>()
                getUniqueParents(targetNode,result)
                return result.size

            }

            return 0
        }

        fun countKidsForNode(name : String): Int {

            fun getKidsCountWithWeight(node:Node) : Int {
                if (node.kids.isEmpty())
                    return 1
                return node.kids.asSequence().map { it.second * getKidsCountWithWeight(it.first) }.sum() + 1
            }


            if (nodes.containsKey(name)){
                val targetNode = nodes[name]!!
                return getKidsCountWithWeight(targetNode)
            }

            return 0
        }

        private class Node(val value: String) {
            val parents : MutableMap<String,Node> = mutableMapOf()
            val kids : MutableList<Pair<Node,Int>> = mutableListOf()
        }

        companion object {

            fun fromInput(lines : List<String>) : Graph {
                //val lines = inp.split(".\n")

                val gph = Graph()

                for(i in lines.indices) {
                    val lineParts = lines[i].dropLast(1).split(" bags contain ")
                    val parent = lineParts[0]
                    val components = lineParts[1].split(", ")
                    for (component in components) {
                        val compParts = component.split(" ")
                        if (compParts[0] != "no")
                            gph.addNodeWithParent(parent, "${compParts[1]} ${compParts[2]}", compParts[0]!!.toInt())
                    }
                }
                return gph
            }
        }

    }

    override fun getResultPartOne(): Int {
        return Graph.fromInput(input).countParentsForNode("shiny gold")

    }

    override fun getResultPartTwo(): Int {
        return Graph.fromInput(input).countKidsForNode("shiny gold") - 1
    }
}