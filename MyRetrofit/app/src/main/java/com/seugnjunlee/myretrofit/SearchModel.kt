package com.seugnjunlee.myretrofit

import android.accounts.AuthenticatorDescription
import android.telecom.Call

/*
 * @Program : MyRetrofit
 * @Discription : 
 * @Author : leeseungjun
 * @E-Mail : tmdwns137@naver.com
 * @Created : 2021-12-01
 */
class SearchModel (
    var items: List<DetailsModel>
)

class DetailsModel(
    val description: String,
    val link: String,
    val originallink: String,
    val pubDate: String,
    val title: String
)