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

class MyPageGridAdapter(private val context: Context): BaseAdapter() {
    private val gridItems: ArrayList<MyPageGridViewItem> = arrayListOf(
        MyPageGridViewItem(R.drawable.mypage_test_image2, ""),
        MyPageGridViewItem(R.drawable.mypage_test_image2, ""),
        MyPageGridViewItem(R.drawable.mypage_test_image2, ""),
    )
    fun addItem(item: MyPageGridViewItem) {
        val initSize = gridItems.size
        addEmptyItem(gridItems.size)
        setItem(item, initSize)
    }
    private fun addEmptyItem(size: Int) {
        repeat(3 - (size % 3)) {
            gridItems.add(MyPageGridViewItem(R.drawable.mypage_test_image2, ""))
        }
    }
    fun setItem(item: MyPageGridViewItem, size: Int) {
        gridItems[size] = item
    }

    override fun getCount(): Int = gridItems.size
    override fun getItem(position: Int): Any = gridItems[position]
    override fun getItemId(position: Int): Long = position.toLong()
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layout = FrameLayout.inflate(context, R.layout.layout_my_page_gridview_item, null)
        val imageView = layout.findViewById<ImageView>(R.id.iv_mypage_gv_item)
        imageView.setImageResource(gridItems[position].image)
        return layout
    }
}