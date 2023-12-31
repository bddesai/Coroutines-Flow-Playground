package channels

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val numbers = produceNumbers()
    val squares = square(numbers)
    for (i in 1..10)
        println(squares.receive())

    println("Done!")
    coroutineContext.cancelChildren()  // cancel all children
}

// remember: produceSquares() is an extension on CoroutineScope
// which returns ProducerScope
@OptIn(ExperimentalCoroutinesApi::class)
fun CoroutineScope.produceNumbers() = produce {
    var x = 1
    while (true)
        send(x++)
}

// numbers generated by produceNumbers() will become input to square()
fun CoroutineScope.square(numbers: ReceiveChannel<Int>) = produce {
    for (x in numbers)
        send(x * x)
}
