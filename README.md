# WebViewApp

This is sample Android application, which allows to use any website as native Android application.

### Features

- Handles pressing of physical or virtual back button, and loads previous page (if any).
- Uses system android webView kit, that can be changed in Developer mode settings.

### Usage

To build the app for your own website, clone project in Android Studio, go to MainActivity.kt and change:

<pre>
private const val APP_URL = "https://yourwebsite.com"
</pre>
