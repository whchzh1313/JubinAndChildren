package com.example.jubinandchildren

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import kotlin.math.ceil

class MyPageGridAdapter(private val context: Context, private val linear: LinearLayout): BaseAdapter() {
    private val additionalGridItems: ArrayList<MyPageGridViewItem> = arrayListOf(
        MyPageGridViewItem(R.drawable.mypage_test_image2, ""),
        MyPageGridViewItem(R.drawable.mypage_test_image2, ""),
        MyPageGridViewItem(R.drawable.mypage_test_image2, ""),
        MyPageGridViewItem(R.drawable.mypage_test_image2, ""),
        MyPageGridViewItem(R.drawable.mypage_test_image2, ""),
        MyPageGridViewItem(R.drawable.mypage_test_image2, ""),
        MyPageGridViewItem(R.drawable.mypage_test_image2, ""),
        MyPageGridViewItem(R.drawable.mypage_test_image2, ""),
        MyPageGridViewItem(R.drawable.mypage_test_image2, ""),
        MyPageGridViewItem(R.drawable.mypage_test_image2, ""),
    )
    private val gridItems: ArrayList<MyPageGridViewItem> = arrayListOf(
        MyPageGridViewItem(R.drawable.mypage_test_image2, ""),
        MyPageGridViewItem(R.drawable.mypage_test_image2, ""),
        MyPageGridViewItem(R.drawable.mypage_test_image2, ""),
    )
    private fun moreItem() {
        gridItems += additionalGridItems
        addEmptyItem(gridItems.size)
    }
    private fun addEmptyItem(size: Int) {
        repeat(3 - (size % 3)) {
            gridItems.add(MyPageGridViewItem(R.drawable.mypage_background_black, ""))
        }
    }

    override fun getCount(): Int = gridItems.size
    override fun getItem(position: Int): Any = gridItems[position]
    override fun getItemId(position: Int): Long = position.toLong()
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layout = FrameLayout.inflate(context, R.layout.layout_my_page_gridview_item, null)
        val imageView = layout.findViewById<ImageView>(R.id.iv_mypage_gv_item)
        val textView = layout.findViewById<TextView>(R.id.tv_mypage_gv_item)
        val dpi = context.resources.displayMetrics.density

        imageView.setImageResource(gridItems[position].image)
        textView.text = gridItems[position].more

        if(position == 2) {
            imageView.setColorFilter(Color.parseColor("#2222229f"))
            textView.text = "더보기+"
            textView.setTextColor(Color.RED)
            layout.setOnClickListener {
                moreItem()
                changeHeight(dpi, gridItems.size / 3 + if(gridItems.size % 3 != 0) 1 else 0, linear)
                this.notifyDataSetChanged()
            }
        }

        return layout
    }
}

fun changeHeight(dpi: Float, size: Int, view: View) {
    val params = view.layoutParams
    params.height = ceil((size * 128 + 128)* dpi).toInt()
    view.layoutParams = params
}