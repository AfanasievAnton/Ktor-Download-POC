package com.example.onupdatektor

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch


class DataHandler(
    private val ktor: KtorWrapper, private val updateDataStateWith: (TheData) -> Unit
) {
    private val downloadDispatcher = CoroutineScope(Dispatchers.Default + SupervisorJob())

    private val dataMap = mutableMapOf<String, TheData>()

    fun download() {
        dataMap["test id"] = TheData("test id")
        downloadDispatcher.launch {
            ktor.downloadFile { progress ->
                println("progress: $progress")
                dataMap["test id"]?.copy(state = TheData.State.Downloading(progress))?.let {
                    dataMap[it.id] = it.also(updateDataStateWith)
                }
            }
        }
    }
}

data class TheData(
    val id: String,
    val state: State = State.Idle,
) {
    sealed class State {
        object Idle : State()
        data class Downloading(val progress: Float) : State()
        data class Uploading(val progress: Float) : State()
    }
}
