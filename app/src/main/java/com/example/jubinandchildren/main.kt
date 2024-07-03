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

    // 뷰 페이저에 들어갈 아이템
    private fun getReviewList(): ArrayList<ReviewList> {
        return arrayListOf(
            ReviewList("name",R.drawable.game_cover_lethal_company,"nameHere","lethal_company","reviewHere","hashHere",""),
            ReviewList("name",R.drawable.game_cover_palworld,"nameHere","palworld","reviewHere","hashHere",""),
            ReviewList("name",R.drawable.game_cover_party_animals,"nameHere","party_animals","reviewHere","hashHere",""),
            ReviewList("name",R.drawable.game_cover_planet_zoo,"nameHere","planet_zoo","reviewHere","hashHere",""),
            ReviewList("name",R.drawable.game_cover_project_zomboid,"nameHere","project_zomboid","reviewHere","hashHere",""),
            ReviewList("name",R.drawable.game_cover_raft,"nameHere","raft","reviewHere","hashHere",""),
            ReviewList("name",R.drawable.game_cover_rimworld,"nameHere","rimworld","reviewHere","hashHere",""),
            ReviewList("name",R.drawable.game_cover_satisfactory,"nameHere","satisfactory","reviewHere","hashHere",""),
            ReviewList("name",R.drawable.game_cover_slime_rancher,"nameHere","slime_rancher","reviewHere","hashHere",""),
            ReviewList("name",R.drawable.game_cover_stardew_valley,"nameHere","stardew_valley","reviewHere","hashHere",""),
            ReviewList("name",R.drawable.game_cover_supper_bunny_man,"nameHere","supper_bunny_man","reviewHere","hashHere",""),
            ReviewList("name",R.drawable.game_cover_vampire_survivor,"nameHere","vampire_survivor","reviewHere","hashHere",""),
            ReviewList("name",R.drawable.game_cover_zelda,"nameHere","zelda","reviewHere","hashHere",""),
            ReviewList("name",R.drawable.game_cover_apex_legend,"nameHere","apex_legend","reviewHere","hashHere",""),
            ReviewList("name",R.drawable.game_cover_back_4_blood,"nameHere","back_4_blood","reviewHere","hashHere",""),
            ReviewList("name",R.drawable.game_cover_core_keeper,"nameHere","core_keeper","reviewHere","hashHere",""),
            ReviewList("name",R.drawable.game_cover_cyberpunk_2077,"nameHere","cyberpunk_2077","reviewHere","hashHere",""),
            ReviewList("name",R.drawable.game_cover_dont_starve_together,"nameHere","dont_starve_together","reviewHere","hashHere",""),
            ReviewList("name",R.drawable.game_cover_dying_light,"nameHere","dying_light","reviewHere","hashHere",""),
            ReviewList("name",R.drawable.game_cover_factorio,"nameHere","factorio","reviewHere","hashHere",""),
            ReviewList("name",R.drawable.game_cover_feign,"nameHere","feign","reviewHere","hashHere",""),
            ReviewList("name",R.drawable.game_cover_ghost_recon,"nameHere","ghost_recon","reviewHere","hashHere",""),
            ReviewList("name",R.drawable.game_cover_goose_duck,"nameHere","goose_duck","reviewHere","hashHere",""),
            ReviewList("name",R.drawable.game_cover_gta_5,"nameHere","gta_5","reviewHere","hashHere",""),
            ReviewList("name",R.drawable.game_cover_gunfire_reborn,"nameHere","gunfire_reborn","reviewHere","hashHere",""),
            ReviewList("name",R.drawable.game_cover_hogwarts_legacy,"nameHere","hogwarts_legacy","reviewHere","hashHere",""),
            ReviewList("name",R.drawable.game_cover_human_fall_flat,"nameHere","human_fall_flat","reviewHere","hashHere",""),
            ReviewList("name",R.drawable.game_cover_left_4_dead,"nameHere","left_4_dead","reviewHere","hashHere","")
        )
    }

}
