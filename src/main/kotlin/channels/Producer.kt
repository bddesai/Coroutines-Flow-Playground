package channels

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
   // for (y in produceSquares()) println(y)
    // OR
    produceSquares().consumeEach { println(it) }
}

// remember: produceSquares() is an extension on CoroutineScope
// which returns ProducerScope
@OptIn(ExperimentalCoroutinesApi::class)
fun CoroutineScope.produceSquares() = produce {
    for (x in 1..5)
        send(x * x)
}
