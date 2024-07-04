package com.example.jubinandchildren

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class EventActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.lv_event_eventlayout)

        // 하단 레이아웃(게임소개 란) 이미지 뷰 객체 생성
        val btn_event_update_minecraft:ImageView = findViewById<ImageView>(R.id.imgv_update_scrimg_minecraft)
        val btn_event_update_wows:ImageView = findViewById<ImageView>(R.id.imgv_update_scrimg_wows)
        val btn_event_update_lol:ImageView = findViewById<ImageView>(R.id.imgv_update_scrimg_lol)
        val btn_event_update_civ7:ImageView = findViewById<ImageView>(R.id.imgv_update_scrimg_civ7)

        // 하단 레이아웃(게임소개 란) 이미지 뷰 객체 생성
        val btn_event_rec_littlenightmare:ImageView = findViewById<ImageView>(R.id.imgv_event_scrimg_little_nightmare)
        val btn_event_rec_helldiver2:ImageView = findViewById<ImageView>(R.id.imgv_event_scrimg_helldivers2)
        val btn_event_rec_frostpunk:ImageView = findViewById<ImageView>(R.id.imgv_event_scrimg_frostpunk)
        val btn_event_rec_fm24:ImageView = findViewById<ImageView>(R.id.imgv_event_scrimg_fm24)
        val btn_event_rec_elden:ImageView = findViewById<ImageView>(R.id.imgv_event_scrimg_eldenring)
        val btn_event_rec_civ6:ImageView = findViewById<ImageView>(R.id.imgv_event_scrimg_civ6)
        val btn_event_rec_cities:ImageView = findViewById<ImageView>(R.id.imgv_event_scrimg_cities)

        // 이미지-웹사이트 연결용 이벤트/인텐트 로직
        // 업데이트 페이지 파트
        // 1) 마인크래프트
        btn_event_update_minecraft.setOnClickListener {
            val intent_event_upgo_minecraft:Intent = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://youtu.be/NG-5L34HqOs"))
            startActivity(intent_event_upgo_minecraft)
        }
        // 2) 월오쉽
        btn_event_update_wows.setOnClickListener {
            val intent_event_upgo_wows:Intent = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.youtube.com/watch?v=-duJjccmhtg"))
            startActivity(intent_event_upgo_wows)
        }
        // 3) 롤
        btn_event_update_lol.setOnClickListener {
            val intent_event_upgo_lol:Intent = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://youtu.be/SN0SKBt9Z3E"))
            startActivity(intent_event_upgo_lol)
        }
        // 4) 문명7
        btn_event_update_civ7.setOnClickListener {
            val intent_event_upgo_civ7:Intent = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://youtu.be/4mEfXfDeChY"))
            startActivity(intent_event_upgo_civ7)
        }

        // 추천 페이지 파트
        // 1) 리틀 나이트메어
        btn_event_rec_littlenightmare.setOnClickListener {
            val intent_event_recgo_little:Intent = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://youtu.be/lVcL5wNFUGs"))
            startActivity(intent_event_recgo_little)
        }
        // 2) 헬다2
        btn_event_rec_helldiver2.setOnClickListener {
            val intent_event_recgo_helldivers2:Intent = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://youtu.be/0_KKdcmOB7U"))
            startActivity(intent_event_recgo_helldivers2)
        }
        // 3) 프펑
        btn_event_rec_frostpunk.setOnClickListener {
            val intent_event_recgo_frostpunk:Intent = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://youtu.be/YPCgltNJoHI"))
            startActivity(intent_event_recgo_frostpunk)
        }
        // 4) 에펨24
        btn_event_rec_fm24.setOnClickListener {
            val intent_event_recgo_fm24:Intent = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://youtu.be/fDBZMvpYUsA"))
            startActivity(intent_event_recgo_fm24)
        }
        // 엘든링
        btn_event_rec_elden.setOnClickListener {
            val intent_event_recgo_elden:Intent = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://youtu.be/Uenqx3PIiD4"))
            startActivity(intent_event_recgo_elden)
        }
        // 문명6
        btn_event_rec_civ6.setOnClickListener {
            val intent_event_recgo_civ6:Intent = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://youtu.be/uULVgaeHPqg"))
            startActivity(intent_event_recgo_civ6)
        }
        // 시티즈
        btn_event_rec_cities.setOnClickListener {
            val intent_event_recgo_cities:Intent = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://youtu.be/0gI2N10QyRA"))
            startActivity(intent_event_recgo_cities)
        }

    }
}