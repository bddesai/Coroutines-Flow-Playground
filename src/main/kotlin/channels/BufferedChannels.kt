package channels

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    // channel with capacity of 4
    val channel = Channel<Int>(4)

    // sends 10 values to channel.
    // It will pause after 4 until new capacity becomes available
    val sender = launch {
        repeat(10){
            channel.send(it)
            println("Sent $it")
        }
    }

    // receive values to make the capacity available
    repeat(3){
        delay(1000)
        println("Received ${channel.receive()}")
    }

    // cancel the channel
    sender.cancel()
}




