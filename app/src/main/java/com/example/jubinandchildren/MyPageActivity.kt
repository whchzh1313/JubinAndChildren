package com.example.jubinandchildren

import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

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
        val dpi = this.resources.displayMetrics.density
        val iv = findViewById<ImageView>(R.id.iv_mypage_profile_genre1)
        val tv = findViewById<TextView>(R.id.tv_mypage_profile_genre1)
        tv.text = "슈팅"
        iv.setImageResource(R.drawable.mypage_library_shooting)

        val bnv = findViewById<BottomNavigationView>(R.id.bnv_mypage)
        val gridView = findViewById<GridView>(R.id.gv_mypage_libraray)
        val linearLayout = findViewById<LinearLayout>(R.id.linearlayout_mypage_library)
        val adapter = MyPageGridAdapter(this, linearLayout)

        bnv.selectedItemId = R.id.profile

        adapter.initItem()
        gridView.isVerticalScrollBarEnabled = false
        gridView.adapter = adapter

        changeHeight(dpi, 1, linearLayout)

        val stringArray = resources.getStringArray(R.array.mypage_library_genre)

        val genrePhoto: MutableMap<String, Int> =
            mutableMapOf(
                stringArray[0] to R.drawable.mypage_library_action,
                stringArray[1] to R.drawable.mypage_library_shooting,
                stringArray[2] to R.drawable.mypage_library_adventure,
                stringArray[3] to R.drawable.mypage_library_simulation,
                stringArray[4] to R.drawable.mypage_library_roleplaying,
                stringArray[5] to R.drawable.mypage_library_puzzle,
                stringArray[6] to R.drawable.mypage_library_music,
            )

        LibraryData.initData()

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