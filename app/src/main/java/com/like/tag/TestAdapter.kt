package com.like.tag

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.view.text.addTag

/**
 *
 * @author like
 * @date 4/22/22 4:32 PM
 */
class TestAdapter(val context: Context, val mList: MutableList<ItemBean>) :
    RecyclerView.Adapter<TestAdapter.TextViewHolder>() {


    class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: AppCompatTextView = itemView.findViewById(R.id.text)
        val imageView: AppCompatImageView = itemView.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        return TextViewHolder(
            LayoutInflater.from(context).inflate(R.layout.adapter_test, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        val bean = mList[position]
        holder.textView.text = bean.text
        if (bean.config != null) {
            holder.textView.addTag(bean.config)
        }
        Glide.with(context).load(bean.url).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

}