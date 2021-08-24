package com.example.onupdatektor

import io.ktor.client.*
import io.ktor.client.engine.ios.*

class DataHandlerProvider {
    private val updateListener = { theData: TheData -> update(theData) }

    fun createDataHandler(): DataHandler {
        return DataHandler(KtorWrapper(HttpClient(Ios)), updateListener)
    }

    private fun update(theData: TheData) {
        println("data was updated: $theData")
    }
}