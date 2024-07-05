package com.example.jubinandchildren

import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButtonToggleGroup

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
        tv.text = "로그\n라이크"
        iv.setImageResource(R.drawable.mypage_test_image2)

        val bnv = findViewById<BottomNavigationView>(R.id.bnv_mypage)
        val gridView = findViewById<GridView>(R.id.gv_mypage_libraray)
        val linearLayout = findViewById<LinearLayout>(R.id.linearlayout_mypage_library)
        val adapter = MyPageGridAdapter(this, linearLayout)



        adapter.initItem()

        bnv.selectedItemId = R.id.profile

        gridView.isVerticalScrollBarEnabled = false

        val dpi = this.resources.displayMetrics.density

        changeHeight(dpi, 1, linearLayout)

        gridView.adapter = adapter

        bnv.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                R.id.search -> {
                    val intent = Intent(this, EventActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                else -> true
            }
        }
    }


}