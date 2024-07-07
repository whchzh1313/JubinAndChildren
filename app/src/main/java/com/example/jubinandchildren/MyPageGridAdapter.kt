package com.example.jubinandchildren

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.setPadding
import kotlin.math.ceil
import java.util.Queue
import java.util.LinkedList

class MyPageGridAdapter(private val activity: MyPageActivity, private val linear: LinearLayout, mpd: MyPageData): BaseAdapter() {
    private var gridItems: ArrayList<Int> = arrayListOf()
    var next = 2
    private var queue: Queue<Int> = LinkedList()
    private val blackImage = R.drawable.mypage_missing

    /*TODO 추후 삭제. 현재는 자료 대신 사용할 테스트용*/
//    private val itemArray: IntArray = intArrayOf(
//    )

    private val itemArray: IntArray = mpd.libraryPicturesIds

    fun initItem() {
        gridItems = arrayListOf()
        initQueue()
        addItem(3)
    }
    private fun initQueue() {
        for(i in itemArray) queue.add(i)
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

    private fun closeItem() {
        next = 2
        while (queue.isNotEmpty()) {
            queue.remove()
        }
        initItem()
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
        val layout = FrameLayout.inflate(activity, R.layout.layout_my_page_gridview_item, null)
        val imageView = layout.findViewById<ImageView>(R.id.iv_mypage_gv_item)
        val textView = layout.findViewById<TextView>(R.id.tv_mypage_gv_item)
        val sv = activity.findViewById<ScrollView>(R.id.sv_mypage)
        val dpi = activity.resources.displayMetrics.density

        imageView.setImageResource(gridItems[position])

        if(gridItems[position] == blackImage) {
            println(position)
            imageView.setPadding(10 * dpi.toInt())
            imageView.setColorFilter(Color.parseColor("#ff222222"))
            imageView.setBackgroundColor(Color.parseColor("#000000"))
        }

        else {
            layout.setOnClickListener {
                activity.findViewById<ConstraintLayout>(R.id.layout_mypage_select_library)
            }
        }

        if( next < itemArray.size && ( position == next && ((next - 2) % 15 == 0) || (position == 2 && next == 2) ) ) {
            imageView.setColorFilter(Color.parseColor("#7f222222"))
            textView.text = "더보기"
            layout.setOnClickListener {
                moreItem()
                val multiple = gridItems.size / 3 + if(gridItems.size % 3 != 0) 1 else 0
                changeHeight(dpi, multiple, linear)
                this.notifyDataSetChanged()
                sv.post( kotlinx.coroutines.Runnable { run {
                    sv.fullScroll(ScrollView.FOCUS_DOWN)
                } })
            }
        }

        else if(gridItems.size - 1 == position && next >= itemArray.size && gridItems.size > 3) {
            imageView.setColorFilter(Color.parseColor("#7f222222"))
            textView.text = "닫기"
            layout.setOnClickListener {
                closeItem()
                val multiple = gridItems.size / 3 + if(gridItems.size % 3 != 0) 1 else 0
                changeHeight(dpi, multiple, linear)
                this.notifyDataSetChanged()
                sv.post( kotlinx.coroutines.Runnable { run {
                    sv.fullScroll(ScrollView.FOCUS_UP)
                } })
            }
        }

        return layout
    }
}

fun changeHeight(dpi: Float, size: Int, view: View) {
    val params = view.layoutParams
    params.height = measureHeight(dpi, size)
    view.layoutParams = params
}

fun measureHeight(dpi: Float, size: Int): Int {
    val oneItemSize = 100 + 16
    return ceil((size * oneItemSize + 128)* dpi).toInt()
}