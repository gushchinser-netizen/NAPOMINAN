package com.example.sergej

/*
Это приложение для отображения сайта "НАПОМИНАЛКА" на смартфонах.
Предполагается, что его будет запускать по расписанию приложение MacroDroid (из Google Play).
Когда настройка свойств и запуск browser.loadUrl выполнялся из onCreate 
иногда интернет-соединение не успевало сработать и на экране выходила ошибка.
Надо подождать. Установка задержки delay недопустимо в onCreate (экран виснет), 
поэтому запуск browser.loadUr выплняется так сложно (по рекомендации ИИ)
*/

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        // Запуск функции внутри области видимости жизненного цикла Activity
        lifecycleScope.launch {
            myCustomMainFunction()
        }
    }

    // Ключевое слово suspend позволяет функции "замирать" без зависания экрана
    suspend fun myCustomMainFunction() {
         setContentView(R.layout.activity_main)

        val browser: WebView = findViewById(R.id.webBrowser)
        
        // Назначаем WebViewClient, чтобы ссылки открывались внутри приложения
        browser.webViewClient = WebViewClient()
        
        browser.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            cacheMode = WebSettings.LOAD_NO_CACHE
        }

        browser.clearCache(true)
        browser.clearHistory()
        // задержка, чтоб успело соединиться с интернетом
        delay(2000L) // Задержка 2 секунды (экран при этом НЕ виснет)
        browser.loadUrl("http://v964988b.beget.tech/") 
    }
}
