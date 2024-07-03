//package com.example.jubinandchildren
//
//import android.content.Context
//import android.text.Layout
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.BaseAdapter
//import android.widget.FrameLayout
//import android.widget.ImageView
//
//class MyPageGridAdapter(val context: Context): BaseAdapter() {
//    private val gridItems = ArrayList<MyPageGridViewItem>()
//
//    fun addItem(item: MyPageGridViewItem) {
//        gridItems.add(item)
//    }
//    override fun getCount(): Int = gridItems.size
//
//    override fun getItem(position: Int): Any = gridItems[position]
//
//    override fun getItemId(position: Int): Long = position.toLong()
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        val inflater
//    }
//
//}