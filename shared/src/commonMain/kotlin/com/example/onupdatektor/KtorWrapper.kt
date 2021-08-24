package com.example.onupdatektor

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*

private const val DownloadUrl = "https://storage.googleapis.com/downloads.webmproject.org/av1/exoplayer/bbb-av1-480p.mp4"

class KtorWrapper(
    private val client: HttpClient,
) {
    suspend fun downloadFile(progressCallback: (Float) -> Unit) {
        client.get<Unit>(DownloadUrl) {
            onDownload { bytesSendTotal: Long, contentLength: Long ->
                progressCallback((bytesSendTotal / contentLength.toFloat()) * 100)
            }
        }
    }
}