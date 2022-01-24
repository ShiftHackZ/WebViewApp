package com.shifthackz.webviewapp

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.*
import android.widget.Toast
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {

    companion object {
        private const val APP_URL = "https://moroz.cc"
    }

    private val appWebViewClient = object : WebViewClient() {

        @RequiresApi(Build.VERSION_CODES.M)
        override fun onReceivedError(
            view: WebView?,
            request: WebResourceRequest?,
            error: WebResourceError?
        ) {
            super.onReceivedError(view, request, error)
            error?.description?.toString()?.let(::showError)
        }

        override fun onReceivedError(
            view: WebView?,
            errorCode: Int,
            description: String?,
            failingUrl: String?
        ) {
            super.onReceivedError(view, errorCode, description, failingUrl)
            description?.let(::showError)
        }
    }

    private val webView: WebView by lazy { findViewById(R.id.webView) }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webView.apply {
            settings.javaScriptEnabled = true
            webViewClient = appWebViewClient
            loadUrl(APP_URL)
        }
    }

    override fun onBackPressed() {
        when {
            webView.canGoBack() -> webView.goBack()
            else -> super.onBackPressed()
        }
    }

    private fun showError(error: String) {
        Toast.makeText(this@MainActivity, error, Toast.LENGTH_LONG).show()
    }
}