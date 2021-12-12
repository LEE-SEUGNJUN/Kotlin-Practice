package com.seugnjunlee.myrecyclerview

import android.media.MediaRouter
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.service.autofill.UserData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.seugnjunlee.myrecyclerview.databinding.ActivityMainBinding
import com.seugnjunlee.myrecyclerview.databinding.ItemListBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //1. 데이터 불러오기
        val data = LoadData()
        //2. 아답터 생성
        val adapter = Adapter(data)
        //3.화면의 RecyclerView와 연결
        binding.recyclerView.adapter = adapter
        //4.레이아웃 매니저 설정
        binding.recyclerView.layoutManager = LinearLayoutManager(this)


        val dividerItemDecoration=DividerItemDecoration(binding.recyclerView.context,LinearLayoutManager(this).orientation)
        binding.recyclerView.addItemDecoration(dividerItemDecoration)
    }




    fun LoadData () : MutableList<Data>{
        val memolist : MutableList<Data> = mutableListOf()
        for (idx in 1..20){
            val memo = Data(no = idx)
            memolist.add(memo)
        }
        return memolist
    }

}


class Adapter(val listdata : MutableList<Data>) : RecyclerView.Adapter<Adapter.Holder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        //1. 사용할 데이터 꺼내고
        val memo=listdata.get(position)
        //2. 폴더에 데이터 전달
        holder.setMemo(memo)
    }

    override fun getItemCount() = listdata.size

    class Holder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root){
        lateinit var currentMemo : Data

        init {
            binding.root.setOnClickListener{

                Toast.makeText(binding.root.context, "${currentMemo.no} 번 사용자 데이터 클릭 되었습니다.",Toast.LENGTH_LONG).show()
            }

        }
        fun setMemo(memo:Data) {
            currentMemo = memo
            with(binding){
                textView1.text = "User No : ${memo.no}       ${memo.no}번 사용자"



            }

        }
    }
}