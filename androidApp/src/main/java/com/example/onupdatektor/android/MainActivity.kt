package com.example.onupdatektor.android

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.onupdatektor.TheData
import com.example.onupdatektor.DataHandlerProvider


class MainActivity : AppCompatActivity() {

    private val dataHandler = DataHandlerProvider().createDataHandler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv: Button = findViewById(R.id.button)
        tv.setOnClickListener {
            dataHandler.download()
        }
    }
}
