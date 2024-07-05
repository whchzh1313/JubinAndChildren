package com.example.jubinandchildren

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(reviewList: ArrayList<ReviewList>) : RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {
    var item = reviewList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PagerViewHolder((parent))

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        // println(position) 현재 인덱스 번호
        holder.reviewImage.setImageResource(item[position].imageName)
        holder.reviewName.setText(item[position].reviewName)
        holder.reviewTitle.setText(item[position].reviewTitle)
        holder.reviewReview.setText(item[position].reviewReview)
        holder.reviewHash.setText(item[position].reviewHash)
        val context = holder.reviewImage.context
        holder.itemView.setOnClickListener(){
            val intent = Intent(holder.reviewImage.context, DetailActivity::class.java)
            intent.putExtra("index", position)
            context.startActivity(intent)
        }
    }

    inner class PagerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder
        (LayoutInflater.from(parent.context).inflate(R.layout.review_list_item, parent, false)){
        val reviewImage = itemView.findViewById<ImageView>(R.id.iv_main_review)
        val reviewName = itemView.findViewById<TextView>(R.id.tv_main_review_name)
        val reviewTitle = itemView.findViewById<TextView>(R.id.tv_main_review_title)
        val reviewReview = itemView.findViewById<TextView>(R.id.tv_main_review_review)
        val reviewHash = itemView.findViewById<TextView>(R.id.tv_main_review_hash)

    }


}