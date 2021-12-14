package com.example.kotcoroutines

import kotlinx.coroutines.*
import java.lang.Exception

//Executing in a background thread
// Repository class and making the network request

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}
fun main() = runBlocking {
    launch {
        delay(1000L) //non-blocking for 1 second (default time unit is ms)
        println("World!") // print after delay
    }
    println("Hello") //main coroutine continues while a previous one is delayed
}

fun main0() = runBlocking {
    launch { doWorld() }
    println("Hello")
}
suspend fun doWorld() {
    delay(1000L)
    println("World")
}
fun main1() = runBlocking {
    doWorld0()
}

suspend fun doWorld0() = coroutineScope {  // this: CoroutineScope
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello")
}