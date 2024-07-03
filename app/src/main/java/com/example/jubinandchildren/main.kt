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
        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.review_margin) // dimen 파일 안에 크기를 정의해두었다.
        val pagerWidth = resources.getDimensionPixelOffset(R.dimen.review_width) // dimen 파일이 없으면 생성해야함
        val screenWidth = resources.displayMetrics.widthPixels // 스마트폰의 너비 길이를 가져옴
        val offsetPx = screenWidth - pageMarginPx - pagerWidth

        viewPager_main_reivew.setPageTransformer { page, position ->
            page.translationX = position * -offsetPx
        }

        viewPager_main_reivew.offscreenPageLimit = 1 // 몇 개의 페이지를 미리 로드 해둘것인지
        viewPager_main_reivew.adapter = ViewPagerAdapter(getReviewList()) // 어댑터 생성
        viewPager_main_reivew.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 방향을 가로로

    }

    // 뷰 페이저에 들어갈 아이템
    private fun getReviewList(): ArrayList<Int> {
        return arrayListOf<Int>(
            R.drawable.game_cover_lethal_company,
            R.drawable.game_cover_palworld,
            R.drawable.game_cover_party_animals,
            R.drawable.game_cover_planet_zoo,
            R.drawable.game_cover_project_zomboid,
            R.drawable.game_cover_raft,
            R.drawable.game_cover_rimworld,
            R.drawable.game_cover_satisfactory,
            R.drawable.game_cover_slime_rancher,
            R.drawable.game_cover_stardew_valley,
            R.drawable.game_cover_supper_bunny_man,
            R.drawable.game_cover_vampire_survivor,
            R.drawable.game_cover_zelda,
            R.drawable.game_cover_apex_legend,
            R.drawable.game_cover_back_4_blood,
            R.drawable.game_cover_core_keeper,
            R.drawable.game_cover_cyberpunk_2077,
            R.drawable.game_cover_dont_starve_together,
            R.drawable.game_cover_dying_light,
            R.drawable.game_cover_factorio,
            R.drawable.game_cover_feign,
            R.drawable.game_cover_ghost_recon,
            R.drawable.game_cover_goose_duck,
            R.drawable.game_cover_gta_5,
            R.drawable.game_cover_gunfire_reborn,
            R.drawable.game_cover_hogwarts_legacy,
            R.drawable.game_cover_human_fall_flat,
            R.drawable.game_cover_left_4_dead
        )
    }

}
