package com.example.sergej

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val browser: WebView = findViewById(R.id.webBrowser)
        
        // Назначаем WebViewClient, чтобы ссылки открывались внутри приложения
        browser.webViewClient = WebViewClient()
        
        browser.settings.apply {
            javaScriptEnabled = true
            cacheMode = WebSettings.LOAD_NO_CACHE
            databaseEnabled = false
            domStorageEnabled = false
        }

        browser.clearCache(true)
        browser.clearHistory()

        browser.loadUrl("http://v964988b.beget.tech/")
    }
}
