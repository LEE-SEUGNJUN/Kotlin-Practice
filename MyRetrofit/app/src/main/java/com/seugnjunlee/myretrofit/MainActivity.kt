package com.seugnjunlee.myretrofit

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.view.accessibility.AccessibilityManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.seugnjunlee.myretrofit.databinding.ActivityMainBinding
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration

class MainActivity : AppCompatActivity() {
    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.recyclerView.layoutManager= LinearLayoutManager(this)
        val detailsModel = listOf<DetailsModel>()

        binding.recyclerView.adapter = RecyclerAdapter()

        binding.btnArticle.setOnClickListener{
            val searchArticle=binding.editText.text.toString()
            if (searchArticle ==""){
                AlertDialog.Builder(this)
                    .setTitle("검색어가 입력되지 않았습니다")
                    .setMessage("기사를 조회할 검색어를 입력하세요.")
                    .setPositiveButton("OK",null)
                    .create().show()
            }
            else{
                naverNewsRetrofitAPI(searchArticle)

        val dividerItemDecoration=DividerItemDecoration(binding.recyclerView.context,LinearLayoutManager(this).orientation)
        binding.recyclerView.addItemDecoration(dividerItemDecoration)
            }
        }
    }
    private  fun naverNewsRetrofitAPI(searchArticle :String){
        val clientid="xPQna0HGqLAJfcXGBQWm"
        val clientSecret="bbe4vqG4KI"
        val url="https://openapi.naver.com/"

        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val getNaverAPIService=retrofit.create(NaverAPIService::class.java)

        val callGetSearchNews=getNaverAPIService.getSearchNews(clientid,clientSecret,searchArticle,100,1)

        callGetSearchNews.enqueue(object: Callback<SearchModel> {
            override fun onResponse(call: retrofit2.Call<SearchModel>, response: Response<SearchModel>) {
            if(response.isSuccessful){
                response.body()?.items?.let { result ->
                    val adapter = binding.recyclerView.adapter as RecyclerAdapter
                    adapter.setItems(result)
                }
            }else{
                //http 에러
                val code=response.code() //에러코드
                //에러 코드에 따라 사용자에게 오류 안내 메시지 출력
                when(code){
                    400 -> Toast.makeText(this@MainActivity,"400에러에 해당하는 내용",Toast.LENGTH_SHORT).show()
                }

            }
            }

            override fun onFailure(call: retrofit2.Call<SearchModel>, t: Throwable){

            }
        }
        )
}}
