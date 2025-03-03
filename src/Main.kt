const val NUMCAGES = 8
const val EMPTY = "---"

fun main() {
    //-------------------------------------------------
    println("Setting up the cages...")

    val cages = setupCages()

    listAllCages(cages)
    println()

    //-------------------------------------------------
    println("Placing monkeys into cages...")

    placeMonkeyInCage(cages, 1, "Kevin")
    placeMonkeyInCage(cages, 8, "Sally")
    placeMonkeyInCage(cages, 4, "Pam")
    placeMonkeyInCage(cages, 3, "Samson")
    placeMonkeyInCage(cages, 5, "Frank")
    placeMonkeyInCage(cages, 6, "Jim")

    println()

    listAllCages(cages)
    println()

    listAllMonkeys(cages)
    println("Monkeys: ${monkeyCount(cages)}")
    println()

    listEmptyCages(cages)
    println("Empty: ${emptyCount(cages)}")
    println()

    showMonkeyCages(cages)
    println()

    check(monkeyCount(cages) == 6)
    check(emptyCount(cages) == 2)

    //-------------------------------------------------
    println("Clearing out some monkeys...")

    clearCage(cages, 5)
    println()

    showMonkeyCages(cages)
    println()

    check(monkeyCount(cages) == 5)
    check(emptyCount(cages) == 3)

    //-------------------------------------------------
    println("Moving some monkeys around...")

    swapCages(cages, 1, 8)
    println()

    showMonkeyCages(cages)
    println()

    //--------------------

    swapCages(cages, 5, 8)
    println()

    showMonkeyCages(cages)
    println()

    check(monkeyCount(cages) == 5)
    check(emptyCount(cages) == 3)

}


fun setupCages(): MutableList<String> {
    val cageList = mutableListOf<String>()
    for (i in 1..NUMCAGES) cageList.add(EMPTY)
    return cageList
}


fun placeMonkeyInCage(cageList: MutableList<String>, cageNum: Int, name: String) {
    println("+++ Putting $name into cage $cageNum")
    cageList[cageNum - 1] = name
}


fun listAllCages(cageList: List<String>) {
    println("CAGES")
    for ((i, name) in cageList.withIndex()) {
        println("- Cage ${i+1}: $name")
    }
}

fun listAllMonkeys(cageList: List<String>) {
    println("MONKEYS")
    for (name in cageList) {
        if (name != EMPTY) {
            println("- $name")
        }
    }
}

fun listEmptyCages(cageList: List<String>) {
    println("EMPTY CAGES")
    for ((i, name) in cageList.withIndex()) {
        if (name == EMPTY) {
            println("- Cage ${i + 1}")
        }
    }
}

fun listAllMonkeysAndCages(cageList: List<String>) {
    println("MONKEYS & CAGES")
    for ((i, name) in cageList.withIndex()) {
        if (name != EMPTY) {
            println("- ${name.padEnd(6)} (Cage ${i + 1})")
        }
    }
}

fun monkeyCount(cageList: List<String>): Int {
    var count = 0
    for (name in cageList) {
        if (name != EMPTY) {
            count++
        }
    }
    return count
}

fun emptyCount(cageList: List<String>): Int {
    return cageList.size - monkeyCount(cageList)
}

fun showMonkeyCages(cageList: List<String>) {
    println("+--------".repeat(cageList.size) + "+")

    for (i in 0 ..< cageList.size) {
        print("| Cage ${i+1} ")
    }
    println("|")

    println("+--------".repeat(cageList.size) + "+")

    for ((i, name) in cageList.withIndex()) {
        print("| ${name.padEnd(6)} ")
    }
    println("|")

    println("+--------".repeat(cageList.size) + "+")
}


fun clearCage(cageList: MutableList<String>, cageNum: Int) {
    println("--- Clearing cage $cageNum")
    cageList[cageNum - 1] = EMPTY
}

fun swapCages(cageList: MutableList<String>, cageNum1: Int, cageNum2: Int) {
    println("<-> Swapping cages $cageNum1 and $cageNum2")
    val temp = cageList[cageNum1 - 1]
    cageList[cageNum1 - 1] = cageList[cageNum2 - 1]
    cageList[cageNum2 - 1] = temp
}



