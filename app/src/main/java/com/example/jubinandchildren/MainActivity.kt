package com.example.jubinandchildren

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator


private lateinit var viewPager_main_reivew: ViewPager2


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        overridePendingTransition(R.drawable.slideright, R.drawable.sliderightout)
        viewPager_main_reivew = findViewById(R.id.viewPager_main_reivew)
        val viewPager_main_indicator = findViewById<DotsIndicator>(R.id.viewPager_main_indicator)
        /* 여백, 너비에 대한 정의 */
        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.review_margin)
        val pagerWidth = resources.getDimensionPixelOffset(R.dimen.review_width)
        val screenWidth = resources.displayMetrics.widthPixels // 스마트폰의 너비 길이를 가져옴
        val offsetPx = screenWidth - pageMarginPx - pagerWidth

        viewPager_main_reivew.setPageTransformer { page, position ->
            page.translationX = position * -offsetPx
        }

        viewPager_main_reivew.offscreenPageLimit = 3 // 몇 개의 페이지를 미리 로드 해둘것인지
        viewPager_main_reivew.adapter = ViewPagerAdapter(getReviewList()) // 어댑터 생성
        viewPager_main_indicator.attachTo(viewPager_main_reivew)
        viewPager_main_reivew.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 방향을 가로로

        // 네비게이터 인텐트
        val main_navigation_bar = findViewById<BottomNavigationView>(R.id.main_navigation_bar)
        main_navigation_bar.setOnNavigationItemSelectedListener() {
            when (it.itemId) {
                R.id.home -> {
                    false
                }
                R.id.search -> {
                    val intent = Intent(this, EventActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.drawable.slideright, R.drawable.sliderightout)
//                    finish()
                    true
                }
                R.id.profile -> {
                    val intent = Intent(this, MyPageActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.drawable.slideright, R.drawable.sliderightout)
//                    finish()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }
}
