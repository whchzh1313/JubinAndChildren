package com.example.jubinandchildren

import android.graphics.Color
import android.graphics.PorterDuff
import android.media.Image
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.widget.GridView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MyPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mypage_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val iv = findViewById<ImageView>(R.id.iv_mypage_profile_genre1)
        val tv = findViewById<TextView>(R.id.tv_mypage_profile_genre1)
        tv.text = "마크"
        iv.setImageResource(R.drawable.mypage_test_image2)

        val scrollView = findViewById<ScrollView>(R.id.sv_mypage)
        val stickyHeader = findViewById<ConstraintLayout>(R.id.constraintlayout_mypage_profile)

        val gridView = findViewById<GridView>(R.id.gv_mypage_libraray)
        val adapter = MyPageGridAdapter(this)
        gridView.adapter = adapter
        adapter.addItem(MyPageGridViewItem(R.drawable.mypage_test_image, ""),)

//        scrollView.viewTreeObserver.addOnScrollChangedListener {
//            val scrollY = scrollView.scrollY
//            Log.d("scroll", scrollY.toString())
//            stickyHeader.translationY = scrollY.toFloat()
//            stickyHeader.translationZ = 1f
//        }
    }
}