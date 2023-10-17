package coroutines

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    runBlocking {
        launch(CoroutineName("myCoroutine")) {
            println("This is a message from ${coroutineContext.get(CoroutineName.Key)}")
        }
    }
}