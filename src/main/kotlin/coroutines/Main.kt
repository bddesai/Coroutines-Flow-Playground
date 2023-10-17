package coroutines

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
fun main(vararg args: String) {

    GlobalScope.launch {
        delay(1000)
        println("Hello world!")
    }

    println("Hello")
    Thread.sleep(2000)
}