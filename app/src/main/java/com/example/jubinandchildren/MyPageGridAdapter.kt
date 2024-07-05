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
import java.util.Queue
import java.util.LinkedList

class MyPageGridAdapter(private val context: Context, private val linear: LinearLayout): BaseAdapter() {
    private val gridItems: ArrayList<MyPageGridViewItem> = arrayListOf()

    var next = 2

    private var queue: Queue<MyPageGridViewItem> = LinkedList()

    val blackImage = MyPageGridViewItem(R.drawable.mypage_background_black)

    /*TODO 추후 삭제. 현재는 자료 대신 사용할 테스트용*/
    private val itemList: List<MyPageGridViewItem> = listOf(
        MyPageGridViewItem(R.drawable.mypage_test_image),
    )

    fun initItem() {
        initQueue()
        addItem(3)
    }
    private fun initQueue() {
        for(i in itemList) queue.add(i)
    }
    private fun addItem(num: Int) {
        repeat(num) {
            gridItems += if(queue.isNotEmpty()) queue.remove() else blackImage
        }
    }

    private fun moreItem() {
        val n = if(queue.size >= 15) 15 else queue.size
        next += 15
        addItem(n)
        addEmptyItem(n)
    }

    private fun addEmptyItem(num: Int) {
        repeat(3 - if(num % 3 == 0) 3 else num % 3) {
            gridItems += blackImage
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

        if( next < itemList.size && ( position == next && ((next - 2) % 15 == 0) || (position == 2 && next == 2) ) ) {
            imageView.setColorFilter(Color.parseColor("#7f222222"))
            textView.text = "더보기"
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
    val oneItemSize = 100 + 16
    params.height = ceil((size * oneItemSize + 128)* dpi).toInt()
    view.layoutParams = params
}