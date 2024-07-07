package com.example.jubinandchildren

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomnavigation.BottomNavigationView

class EventActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_event)

        // 메인 레이아웃(업데이트) 뷰 객체 생성
        // 텍스트 뷰(1개), 1차메뉴 선택 버튼 대용
        var tv_event_update_title:TextView = findViewById<TextView>(R.id.tv_event_updated_game)

        // 레이아웃 뷰(1개), 1차메뉴와 연동된 뷰
        var lv_event_update_container:HorizontalScrollView = findViewById<HorizontalScrollView>(R.id.scrlv_event_update_scroll)

        // 이미지 뷰(4개), 2차메뉴 선택버튼 대용으로 사용됨
        val btn_event_update_minecraft:ImageView = findViewById<ImageView>(R.id.imgv_update_scrimg_minecraft)
        val btn_event_update_wows:ImageView = findViewById<ImageView>(R.id.imgv_update_scrimg_wows)
        val btn_event_update_lol:ImageView = findViewById<ImageView>(R.id.imgv_update_scrimg_lol)
        val btn_event_update_civ7:ImageView = findViewById<ImageView>(R.id.imgv_update_scrimg_civ7)

        // 메인 레이아웃(추천) 뷰 객체 생성
        // 텍스트 뷰(1개), 1차메뉴 선택 버튼 대용
        var tv_event_recommand_title:TextView = findViewById<TextView>(R.id.tv_event_recommanded_game)

        // 레이아웃 뷰(1개), 1차메뉴와 연동된 뷰
        var lv_event_recommand_container:HorizontalScrollView = findViewById<HorizontalScrollView>(R.id.scrlv_event_rec_scroll)

        // 이미지 뷰(7개), 2차메뉴 선택버튼 대용으로 사용됨
        val btn_event_rec_littlenightmare:ImageView = findViewById<ImageView>(R.id.imgv_event_scrimg_little_nightmare)
        val btn_event_rec_helldiver2:ImageView = findViewById<ImageView>(R.id.imgv_event_scrimg_helldivers2)
        val btn_event_rec_frostpunk:ImageView = findViewById<ImageView>(R.id.imgv_event_scrimg_frostpunk)
        val btn_event_rec_fm24:ImageView = findViewById<ImageView>(R.id.imgv_event_scrimg_fm24)
        val btn_event_rec_elden:ImageView = findViewById<ImageView>(R.id.imgv_event_scrimg_eldenring)
        val btn_event_rec_civ6:ImageView = findViewById<ImageView>(R.id.imgv_event_scrimg_civ6)
        val btn_event_rec_cities:ImageView = findViewById<ImageView>(R.id.imgv_event_scrimg_cities)

        // 메인 레이아웃(업데이트/추천) 선택 시 처리용 로직
        // 기본 화면(메뉴 및 레이아웃 초기화)
        lv_event_recommand_container.visibility = View.GONE
        lv_event_update_container.visibility = View.VISIBLE

        // 업데이트 선택 시
        tv_event_update_title.setOnClickListener{
            // 선택 메뉴(1.0) 및 다른 메뉴(0.2)의 투명도 조정
            tv_event_update_title.alpha = 1.0f
            tv_event_recommand_title.alpha = 0.2f

            // 각 메뉴와 연결된 레이아웃 렌더링 조정
            lv_event_recommand_container.visibility = View.GONE
            lv_event_update_container.visibility = View.VISIBLE
        }

        // 추천 선택 시
        tv_event_recommand_title.setOnClickListener{
            // 선택 메뉴(1.0) 및 다른 메뉴(0.2)의 투명도 조정
            tv_event_recommand_title.alpha = 1.0f
            tv_event_update_title.alpha = 0.2f

            // 각 메뉴와 연결된 레이아웃 렌더링 조정
            lv_event_update_container.visibility = View.GONE
            lv_event_recommand_container.visibility = View.VISIBLE
        }


        // 메인 레이아웃(하단 네비게이션) 뷰 객체 생성/초기화
        // 하단 네비 뷰(1개)
        val event_btm_navi:BottomNavigationView = findViewById(R.id.inc_event_bot_navi)
        event_btm_navi.selectedItemId = R.id.search

        // 메인 레이아웃(하단 네비게이션) 뷰 선택 시 처리용 로직
        event_btm_navi.setOnNavigationItemSelectedListener { ele ->
            when (ele.itemId) {
                // 홈 메뉴 선택 >> 메인 액티비티 호출(왼쪽으로 이동)
                R.id.home -> {
                    val intent_call_Main:Intent
                    intent_call_Main = Intent(this, MainActivity::class.java)
                    startActivity(intent_call_Main)
                    overridePendingTransition(R.drawable.slideleft, R.drawable.slideleftout)

                    true
                }
                // 프로필 메뉴 선택 >> 마이 페이지 액티비티 호출(오른쪽으로 이동)
                R.id.profile -> {
                    val intent_call_MyPage:Intent
                    intent_call_MyPage = Intent(this, MyPageActivity::class.java)
                    startActivity(intent_call_MyPage)
                    overridePendingTransition(R.drawable.slideright, R.drawable.sliderightout)

                    true
                }
                // 탐색 메뉴(자기자신) 선택, 예외 케이스 >> 아무것도 안함
                else -> { false }
            }
        }

        // 이미지-웹사이트 연결용 이벤트/인텐트 로직
        // 업데이트 파트
        // 1) 마인크래프트
        btn_event_update_minecraft.setOnClickListener {
            val intent_event_upgo_minecraft:Intent
            intent_event_upgo_minecraft = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://youtu.be/NG-5L34HqOs"))
            startActivity(intent_event_upgo_minecraft)
        }
        // 2) 월오쉽
        btn_event_update_wows.setOnClickListener {
            val intent_event_upgo_wows:Intent
            intent_event_upgo_wows = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.youtube.com/watch?v=-duJjccmhtg"))
            startActivity(intent_event_upgo_wows)
        }
        // 3) 롤
        btn_event_update_lol.setOnClickListener {
            val intent_event_upgo_lol:Intent
            intent_event_upgo_lol = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://youtu.be/SN0SKBt9Z3E"))
            startActivity(intent_event_upgo_lol)
        }
        // 4) 문명7
        btn_event_update_civ7.setOnClickListener {
            val intent_event_upgo_civ7:Intent
            intent_event_upgo_civ7 = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://youtu.be/4mEfXfDeChY"))
            startActivity(intent_event_upgo_civ7)
        }

        // 추천 파트
        // 1) 리틀 나이트메어
        btn_event_rec_littlenightmare.setOnClickListener {
            val intent_event_recgo_little:Intent
            intent_event_recgo_little = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://youtu.be/lVcL5wNFUGs"))
            startActivity(intent_event_recgo_little)
        }
        // 2) 헬다2
        btn_event_rec_helldiver2.setOnClickListener {
            val intent_event_recgo_helldivers2:Intent
            intent_event_recgo_helldivers2 = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://youtu.be/0_KKdcmOB7U"))
            startActivity(intent_event_recgo_helldivers2)
        }
        // 3) 프펑
        btn_event_rec_frostpunk.setOnClickListener {
            val intent_event_recgo_frostpunk:Intent
            intent_event_recgo_frostpunk = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://youtu.be/YPCgltNJoHI"))
            startActivity(intent_event_recgo_frostpunk)
        }
        // 4) 에펨24
        btn_event_rec_fm24.setOnClickListener {
            val intent_event_recgo_fm24:Intent
            intent_event_recgo_fm24 = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://youtu.be/fDBZMvpYUsA"))
            startActivity(intent_event_recgo_fm24)
        }
        // 엘든링
        btn_event_rec_elden.setOnClickListener {
            val intent_event_recgo_elden:Intent
            intent_event_recgo_elden = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://youtu.be/Uenqx3PIiD4"))
            startActivity(intent_event_recgo_elden)
        }
        // 문명6
        btn_event_rec_civ6.setOnClickListener {
            val intent_event_recgo_civ6:Intent
            intent_event_recgo_civ6 = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://youtu.be/uULVgaeHPqg"))
            startActivity(intent_event_recgo_civ6)
        }
        // 시티즈
        btn_event_rec_cities.setOnClickListener {
            val intent_event_recgo_cities:Intent
            intent_event_recgo_cities = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://youtu.be/0gI2N10QyRA"))
            startActivity(intent_event_recgo_cities)
        }

    }
}