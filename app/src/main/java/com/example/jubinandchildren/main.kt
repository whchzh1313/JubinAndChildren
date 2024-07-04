package com.example.jubinandchildren

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2


private lateinit var viewPager_main_reivew: ViewPager2
class main : AppCompatActivity() {

    private val MIN_SCALE = 0.9f // 뷰가 몇퍼센트로 줄어들 것인지
    private val MIN_ALPHA = 0.7f // 어두워지는 정도를 나타낸 듯 하다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_list)

        viewPager_main_reivew = findViewById(R.id.viewPager_main_reivew)

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
        viewPager_main_reivew.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 방향을 가로로
    }
}
