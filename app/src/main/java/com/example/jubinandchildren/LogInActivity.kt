package com.example.jubinandchildren

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import kotlin.math.log

// 1. 로그인 가능하게
// 2. 회원가입에서 로그인 페이지로 이동 가능하게 (0)
// 3. 아이디 가져올 수 있는 기능 추가(0)
// 4. 뷰페이저 가능하면 / 시간 안되면 랜덤 이미지로 택스트 찍어서

class LogInActivity : AppCompatActivity() {

    private lateinit var LauncherLogIn: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val btn_login = findViewById<Button>(R.id.btn_login_login)
        val btn_signin = findViewById<Button>(R.id.btn_login_signin)
        val login_text_id = findViewById<EditText>(R.id.text_login_putid)
        val login_text_pw = findViewById<EditText>(R.id.text_login_putpw)

        val iv_signin_random = findViewById<ImageView>(R.id.iv_login_introduce)
        val random = when ((1..4).random()) {
            1 -> R.drawable.iv_login_image_1
            2 -> R.drawable.iv_login_image_2
            3 -> R.drawable.iv_login_image_3
            else -> R.drawable.iv_login_image_1
        }
        iv_signin_random.setImageDrawable(ResourcesCompat.getDrawable(resources,random,null))

        //회원가입 > 로그인으로 올 때 아이디 / 비밀번호 데려올 수 있는 기능
        LauncherLogIn =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == Activity.RESULT_OK) {
                    val userData = it.data?.getParcelableExtra<UserData>("userData")
                    login_text_id.setText(userData?.userId?:"")
                    login_text_pw.setText(userData?.userPw?:"")
                }
            }

        //회원가입 페이지 이동
        btn_signin.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            LauncherLogIn.launch(intent)
        }


        //로그인 기능
        btn_login.setOnClickListener {

            val loginData = LoginDataObject.getList()

            val loginMap = loginData.map{it.id to it.pwd}.toMap()

            if (login_text_id.text.toString().trim().isEmpty() || login_text_pw.text.trim().isEmpty()) {
                Toast.makeText(this, "아이디 또는 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else if (login_text_id.text.toString() in UserDataList.userList || login_text_id.text.toString().trim() in loginMap) {
                if (UserDataList.userList[login_text_id.text.toString()]?.userPw == login_text_pw.text.toString()
                    || loginMap[login_text_id.text.toString()]==login_text_pw.text.toString()) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "올바른 비밀번호가 아닙니다.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "존재하지 않는 아이디 입니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}