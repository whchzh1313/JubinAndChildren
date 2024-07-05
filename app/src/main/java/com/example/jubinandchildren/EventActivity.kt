package com.example.jubinandchildren

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class EventActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_event)

        // 메인 레이아웃(업데이트) 뷰 객체 생성
        // 이미지 뷰(4개), 버튼 대용으로 사용됨
        val btn_event_update_minecraft:ImageView = findViewById<ImageView>(R.id.imgv_update_scrimg_minecraft)
        val btn_event_update_wows:ImageView = findViewById<ImageView>(R.id.imgv_update_scrimg_wows)
        val btn_event_update_lol:ImageView = findViewById<ImageView>(R.id.imgv_update_scrimg_lol)
        val btn_event_update_civ7:ImageView = findViewById<ImageView>(R.id.imgv_update_scrimg_civ7)
        // 텍스트 뷰(8개)  언어 전환 시 쓸 객체, 근데 이거 필요한가 ??
        val tv_event_update_minecraft_title:TextView = findViewById<TextView>(R.id.tv_event_update_title_minecraft)
        val tv_event_update_minecraft_tag:TextView = findViewById<TextView>(R.id.tv_event_update_tag_minecraft)
        val tv_event_update_wows_title:TextView = findViewById<TextView>(R.id.tv_event_update_title_wows)
        val tv_event_update_wows_tag:TextView = findViewById<TextView>(R.id.tv_event_update_tag_wows)
        val tv_event_update_lol_title:TextView = findViewById<TextView>(R.id.tv_event_update_title_lol)
        val tv_event_update_lol_tag:TextView = findViewById<TextView>(R.id.tv_event_update_tag_lol)
        val tv_event_update_civ7_title:TextView = findViewById<TextView>(R.id.tv_event_update_title_civ7)
        val tv_event_update_civ7_tag:TextView = findViewById<TextView>(R.id.tv_event_update_tag_civ7)

        // 메인 레이아웃(추천) 뷰 객체 생성
        // 이미지 뷰(7개), 버튼 대용으로 사용됨
        val btn_event_rec_littlenightmare:ImageView = findViewById<ImageView>(R.id.imgv_event_scrimg_little_nightmare)
        val btn_event_rec_helldiver2:ImageView = findViewById<ImageView>(R.id.imgv_event_scrimg_helldivers2)
        val btn_event_rec_frostpunk:ImageView = findViewById<ImageView>(R.id.imgv_event_scrimg_frostpunk)
        val btn_event_rec_fm24:ImageView = findViewById<ImageView>(R.id.imgv_event_scrimg_fm24)
        val btn_event_rec_elden:ImageView = findViewById<ImageView>(R.id.imgv_event_scrimg_eldenring)
        val btn_event_rec_civ6:ImageView = findViewById<ImageView>(R.id.imgv_event_scrimg_civ6)
        val btn_event_rec_cities:ImageView = findViewById<ImageView>(R.id.imgv_event_scrimg_cities)

        // 메인 레이아웃(하단 네비게이션) 뷰 객체 생성/초기화
        // 하단 네비 뷰(1개)
        val event_btm_navi:BottomNavigationView = findViewById(R.id.navigation)
        event_btm_navi.selectedItemId = R.id.search

        // 메인 레이아웃(하단 네비게이션) 뷰 선택 시 처리용 로직
        event_btm_navi.setOnNavigationItemSelectedListener { ele ->
            when (ele.itemId) {
                // 홈 메뉴 선택 >> 메인 액티비티 호출
                R.id.home -> {
                    val intent_call_Main:Intent
                    intent_call_Main = Intent(this, MainActivity::class.java)
                    startActivity(intent_call_Main); finish()

                    true
                }
                // 프로필 메뉴 선택 >> 마이 페이지 액티비티 호출
                R.id.profile -> {
                    val intent_call_MyPage:Intent
                    intent_call_MyPage = Intent(this, MyPageActivity::class.java)
                    startActivity(intent_call_MyPage); finish()

                    true
                }
                // 탐색 메뉴(자기자신) 선택, 예외 케이스 >> 아무것도 안함
                else -> false
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