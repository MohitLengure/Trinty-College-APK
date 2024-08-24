package com.example.trinityacademycollege

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.trinityacademycollege.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.WebView.loadUrl("https://www.kjei.edu.in/tae/")
        binding.WebView.settings.javaScriptEnabled = true
        binding.WebView.webViewClient= WebViewClient()



    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        // Check whether the key event is the Back button and if there's history.
        if (keyCode == KeyEvent.KEYCODE_BACK && binding.WebView.canGoBack()) {
            binding.WebView.goBack()
            return true
        }
        // If it isn't the Back button or there isn't web page history, bubble up to
        // the default system behavior. Probably exit the activity.
        return super.onKeyDown(keyCode, event)
    }


}