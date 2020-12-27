package github.walkmansit.aoc2020

class Day19(val  input:String) : DayAoc<Int,Int> {

    interface Component {
        val id : Int
        fun isTerminal() : Boolean
    }

    class Terminal(val value:Char, override val id: Int) : Component {
        override fun isTerminal() = true
    }

    class Reference(val pairs:List<List<Int>>, override val id: Int) : Component {
        override fun isTerminal() = false
    }


    private fun calc(replace : Boolean) : Int {
        val parts = input.split("\n\n")
        val rules = parts[0].split("\n").toTypedArray()

        val strings = parts[1].split("\n").toTypedArray()

        fun mapToPair(rule : String) : Pair<Int,String> {
            val parts = rule.split(": ")
            var temp = parts[1]

            if (replace) {
                if (rule == "8: 42") {
                    temp = "42 | 42 8"
                }

                if (rule == "11: 42 31") {
                    temp = "42 31 | 42 11 31"
                }
            }

            return parts[0].toInt() to temp
        }

        val sortedArray = rules.map { mapToPair(it) }.sortedBy { it.first }.map { it.second }.toTypedArray()

        val components = Array<Component>(rules.size){ Terminal('c',-1) }

        fun getComponent(idx : Int, set : MutableSet<Int> = mutableSetOf()) : Int {
            if (set.contains(idx))
                return idx

            val strRule = sortedArray[idx]

            if (strRule.length == 3 && strRule[0] == '"') {
                components[idx] = Terminal(strRule[1],idx)
                return idx
            }
            else {
                val parts = strRule.split(" | ")

                val list: MutableList<List<Int>> = mutableListOf()

                for (part in parts) {
                    val terminals = part.split(" ")
                    set.add(idx)

                    val termIdxs = terminals.asSequence().map { getComponent(it.toInt(),set) }.toList()

                    set.remove(idx)
                    list.add(termIdxs)
                }
                components[idx] = Reference(list.toList(),idx)
                return idx
            }
        }

        fun isValidComponent(component: Component, idx: Int, str:String ) : List<Int> {

            fun validateByMult(idx: Int, str:String, list : List<Int> ) : List<Int> {
                var currentIdxList = listOf(idx)
                for (item in list){

                    var i = currentIdxList.flatMap { isValidComponent(components[item],it,str) }
                    if (i.isNotEmpty()) //valid
                        currentIdxList = i
                    else return listOf()
                }
                return currentIdxList
            }

            if (component is Terminal){
                if (idx >= str.length)
                    return listOf()

                return if (str[idx] == component.value) listOf(idx+1) else listOf()
            }
            else{
                val compRef = component as Reference
                return compRef.pairs.flatMap { validateByMult(idx,str,it) }
            }
        }

        val component = getComponent(0)

        val pairs = strings.asSequence().map { isValidComponent(components[0],0,it) to it.length }
        return pairs.count { it.first.contains(it.second) }
    }

    override fun getResultPartOne(): Int {
        return calc(false)
    }

    override fun getResultPartTwo(): Int {
        return calc(true)
    }
}