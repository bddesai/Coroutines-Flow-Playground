package coroutines

fun main() {
    val numbers = intArrayOf(55, 55, 50, 50)
    var sum = 0
    numbers.forEach { num ->
        sum += num
    }

    println("sum = $sum")
}

