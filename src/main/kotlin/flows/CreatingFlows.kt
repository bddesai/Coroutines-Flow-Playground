package flows

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        sendNumbers1().collect { println("-> $it") }
        sendNumbers2().collect { println("-> $it") }
        sendNumbers3().collect { println("-> $it") }
    }
}


// Method 1 : flow { emit() }
fun sendNumbers1() = flow {
    for (i in 1..10) emit(i)
}

// Method 2 - asFlow()
fun sendNumbers2() = (1..5).toList().asFlow()

// Method 3 - flowof()
fun sendNumbers3() = flowOf("One", "Two", "Three")