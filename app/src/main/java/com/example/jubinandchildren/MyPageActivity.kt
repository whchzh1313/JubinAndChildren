package com.example.jubinandchildren

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.GridView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

/*

0. 로그아웃 기능 구현과 id 받고 있기 - 협업 필수
1. 가입한 사용자의 LibraryData
1. 레이아웃 더보기 클릭 시 해당 위치로 이동, 더보기의 반대인 줄이기 또는 닫기 구현할지
2. 내 거 게임 정보도 넣기(테스트 고려해야 함. 라이브러리 30개 이상, 소개 글자 엄청 길게)
3. 배경화면(프로필 뒤에 있는 사진)을 게임 픽 중에 랜덤으로 하거나, 시간 되면 클릭 시 해당 게임 사진으로 고정 가능하게
4.
5. 모션 및 애니메이션 고려
6. 라이브러리 클릭 시 확대돼서 가운데에 띄우기(지금 못 쓰는 기능이면 패스)

 */

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
        MyPageDataObject.initData()
        val mpd = MyPageDataObject.getMyData(UserDataList.id)
        val bnv = findViewById<BottomNavigationView>(R.id.bnv_mypage)
        val btnLogout = findViewById<ImageView>(R.id.iv_mypage_logout)
        val btnEdit = findViewById<ImageView>(R.id.iv_mypage_edit)

        drawMyPage(this, mpd)

        bnv.selectedItemId = R.id.profile
        bnv.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    //overridePendingTransition(R.drawable.slideup, R.drawable.slideout)
                    //finish()
                    true
                }
                R.id.search -> {
                    val intent = Intent(this, EventActivity::class.java)
                    startActivity(intent)
                    //overridePendingTransition(R.drawable.slideup, R.drawable.slideout)
                    //finish()
                    true
                }
                else -> true
            }
        }

        btnEdit.setOnClickListener {
            Toast.makeText(this, "미구현된 기능입니다.", Toast.LENGTH_SHORT).show()
        }

        btnLogout.setOnClickListener {
            /*TODO 싱글톤 로그아웃 기능 추가*/
            val intent = Intent(this, LogInActivity::class.java)
            finish()
            startActivity(intent)
        }
    }
}