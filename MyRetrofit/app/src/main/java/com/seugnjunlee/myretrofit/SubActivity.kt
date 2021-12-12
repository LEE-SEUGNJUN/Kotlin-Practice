package com.seugnjunlee.myretrofit

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.seugnjunlee.myretrofit.databinding.ActivitySubBinding

/*
 * @Program : MyRetrofit
 * @Discription : 
 * @Author : leeseungjun
 * @E-Mail : tmdwns137@naver.com
 * @Created : 2021-12-08
 */
class SubActivity : AppCompatActivity() {

    private  val binding by lazy {ActivitySubBinding.inflate(layoutInflater)}

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val newsLink = intent.getStringExtra("newsLink")

        with(binding){
            webViewNews.settings.javaScriptEnabled = true
            webViewNews.webViewClient= WebViewClient()
            webViewNews.webChromeClient= WebChromeClient()
            webViewNews.loadUrl(newsLink.toString())
        }
    }

    override fun onBackPressed() {
        if (binding.webViewNews.canGoBack())
            binding.webViewNews.goBack()
        else
            super.onBackPressed()
    }
}