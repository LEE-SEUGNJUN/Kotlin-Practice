package com.seugnjunlee.myretrofit

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.SurfaceHolder
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.seugnjunlee.myretrofit.databinding.ItemRecyclerBinding


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    private var _items : MutableList<DetailsModel> = mutableListOf()
    private val items : List<DetailsModel> = _items

    override fun onCreateViewHolder(parent: ViewGroup,viewType:Int): ViewHolder {
        val binding =ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
     }
    override fun onBindViewHolder(holder: ViewHolder,position:Int){
        holder.bindDetailsModel(items[position])

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context,SubActivity::class.java)
            intent.putExtra("newsLink",items.get(position).originallink)
            startActivity(holder.itemView.context,intent , null)
            Toast.makeText(holder.itemView.context,"이름: ${HtmlCompat.fromHtml(items.get(position).title,HtmlCompat.FROM_HTML_MODE_LEGACY).toString()})",Toast.LENGTH_SHORT).show()

        }
    }
    fun setItems(items:List<DetailsModel>){
        this._items.clear()
        this._items.addAll(items)
        this.notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return items.size
    }
    class ViewHolder(val binding: ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bindDetailsModel(holderModel: DetailsModel){
            binding.textTitle.text=HtmlCompat.fromHtml(holderModel.title,HtmlCompat.FROM_HTML_MODE_LEGACY).toString()
            binding.textPubDate.text="날짜 : ${holderModel.pubDate}"
            binding.textOriginalLink.text ="링크 : ${holderModel.originallink}"
            binding.textDescription.text="기사내용 : ${HtmlCompat.fromHtml(holderModel.description,HtmlCompat.FROM_HTML_MODE_LEGACY).toString()}"
        }
    }


}