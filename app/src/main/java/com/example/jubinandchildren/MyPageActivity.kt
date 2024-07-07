package com.example.jubinandchildren

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.GridView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.google.android.material.bottomnavigation.BottomNavigationView

/*

해결0. 로그아웃 기능 구현과 id 받고 있기 - 협업 필수
해결1. 가입한 사용자의 LibraryData
해결2. 레이아웃 더보기 클릭 시 해당 위치로 이동, 더보기의 반대인 줄이기 또는 닫기 구현할지
해결?3. 더보기 자간, 폰트 수정
해결3. 마지막 자리에 더보기 닫기 추가 및 빈칸 이미지 ? 있는 이미지로 수정 고려
해결3. primary background로 기본 배경 설정
해결3. 로그아웃 시 인텐트 플래그 추가
앞에 걸로 적용함4. 배경화면(프로필 뒤에 있는 사진)을 게임 픽 중에 랜덤으로 하거나, 시간 되면 클릭 시 해당 게임 사진으로 고정 가능하게
해결4. 디테일 페이지에서 오면 뒤로가기 활성화(isVisible, Enable)

- 노가다 -
1.string.xml, ko 작성
3. 내 거 게임 정보도 넣기(테스트 고려해야 함. 라이브러리 30개 이상, 소개 글자 엄청 길게)

- 간단 -

- 시간 남으면 해결 -
6. 라이브러리 클릭 시 확대돼서 가운데에 띄우기(프레임 레이아웃으로 전체를 싸고, 일반 화면 위에 사진, 배경색은 살짝 투명한 검정색, x 버튼 추가한 레이아웃 만들기)
8. 마이페이지 수정 가능하게 변경
7. 시간 남으면 게임픽이랑 장르에도 어댑터 추가

5. 모션 및 애니메이션 고려 - 추가될 곳이 있나?

 */

class MyPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_page)
        MyPageDataObject.initData()

        val mpdStr = intent.getStringExtra("reviewerId") ?: UserDataList.id
        val mpd = MyPageDataObject.getMyData(mpdStr)
        val bnv = findViewById<BottomNavigationView>(R.id.bnv_mypage)
        val btnLogout = findViewById<ImageView>(R.id.iv_mypage_logout)
        val btnEdit = findViewById<ImageView>(R.id.iv_mypage_edit)
        val btnBack = findViewById<ImageView>(R.id.iv_mypage_back)
        val btnClose = findViewById<ImageView>(R.id.iv_mypage_select_library_close)
        val layoutSelectLibrary = findViewById<ConstraintLayout>(R.id.layout_mypage_select_library)

        layoutSelectLibrary.isVisible=false

        drawMyPage(this, mpd)

        if(intent.getStringExtra("reviewerId") != null) btnBack.isVisible = true

        bnv.selectedItemId = R.id.profile
        bnv.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.drawable.slideright, R.drawable.sliderightout)
                    finish()
                    true
                }
                R.id.search -> {
                    val intent = Intent(this, EventActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.drawable.slideright, R.drawable.sliderightout)
                    finish()
                    true
                }
                else -> true
            }
        }

        resources.getString(R.string.mypage_not_input)

        btnEdit.setOnClickListener {
            Toast.makeText(this, R.string.mypage_not_implement, Toast.LENGTH_SHORT).show()
        }

        btnLogout.setOnClickListener {
            /*TODO 싱글톤 로그아웃 기능 추가*/
            val intent = Intent(this, LogInActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            finish()
            startActivity(intent)
        }

        btnBack.setOnClickListener {
            finish()
        }

        btnClose.setOnClickListener {
            layoutSelectLibrary.isVisible=false
        }

        layoutSelectLibrary.setOnClickListener{
            layoutSelectLibrary.isVisible=false
        }

    }
}