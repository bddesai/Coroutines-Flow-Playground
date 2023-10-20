package channels

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce

fun main() = runBlocking {
    val producer = produceNewNumbers()

    // multiple coroutines receive from the same producer channel
    repeat(5) {
        launchProcess(it, producer)
    }
    delay(1000L)
    producer.cancel()
}

@OptIn(ExperimentalCoroutinesApi::class)
fun CoroutineScope.produceNewNumbers() = produce {
    var x = 1
    while (true) {
        send(x++)
        delay(100L)
    }
}


fun CoroutineScope.launchProcess(id: Int, channel: ReceiveChannel<Int>){
    launch {
        for(message in channel){
            println("Processor $id received $message")
        }
    }
}