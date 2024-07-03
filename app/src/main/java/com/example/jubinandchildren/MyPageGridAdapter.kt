package com.example.jubinandchildren

import android.content.Context
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.FrameLayout
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class MyPageGridAdapter(private val context: Context): BaseAdapter() {
    private val gridItems: ArrayList<MyPageGridViewItem> = arrayListOf(
//        MyPageGridViewItem(R.drawable.mypage_test_image2, ""),
//        MyPageGridViewItem(R.drawable.mypage_test_image2, ""),
//        MyPageGridViewItem(R.drawable.mypage_test_image2, ""),
    )
    companion object {
        var next = 0
    }
    fun getItemSize(): Int {
        return next
    }
    fun addItem(item: MyPageGridViewItem) {
        addEmptyItem(gridItems.size)
        setItem(item, next++)
    }
    private fun addEmptyItem(size: Int) {
        repeat(3 - (size % 3)) {
            gridItems.add(MyPageGridViewItem(R.drawable.mypage_test_image2, ""))
        }
    }
    private fun setItem(item: MyPageGridViewItem, size: Int) {
        gridItems[size] = item
        Log.d("setItem", size.toString())
    }

    override fun getCount(): Int = gridItems.size
    override fun getItem(position: Int): Any = gridItems[position]
    override fun getItemId(position: Int): Long = position.toLong()
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layout = FrameLayout.inflate(context, R.layout.layout_my_page_gridview_item, null)
        val imageView = layout.findViewById<ImageView>(R.id.iv_mypage_gv_item)
        imageView.setImageResource(gridItems[position].image)
        val textView = layout.findViewById<TextView>(R.id.tv_mypage_gv_item)
        textView.text = gridItems[position].more
        return layout
    }
}