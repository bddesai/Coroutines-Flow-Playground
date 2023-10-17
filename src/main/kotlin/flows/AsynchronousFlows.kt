package flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        println("Receiving prime numbers")
        sendPrimes().collect {
            println("-> $it")
        }
        println("\nFinished")
    }
}


fun sendPrimes(): Flow<Int> = flow {
    val primeList = listOf(2, 3, 5, 7, 11, 13, 17, 19, 23)
    primeList.forEach {
        delay(it * 100L)
        emit(it)

    }
}