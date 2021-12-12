package com.seugnjunlee.myretrofit

import android.icu.number.NumberFormatter
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/*
 * @Program : MyRetrofit
 * @Discription : 
 * @Author : leeseungjun
 * @E-Mail : tmdwns137@naver.com
 * @Created : 2021-12-01
 */interface NaverAPIService {
     @GET("v1/search/news.json")
     fun getSearchNews(
         @Header("X-Naver-Client-Id") clientId: String,
         @Header("X-Naver-Client-Secret") clientSecret: String,
         @Query("query") query: String,
         @Query("Display") display: Int? = null,
         @Query("start") start : Int? = null
     ): Call<SearchModel>
}