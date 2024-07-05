package com.example.jubinandchildren

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var signin_name = findViewById<EditText>(R.id.text_signin_putname)
        var signin_gender = findViewById<MaterialButtonToggleGroup>(R.id.toggle_button_group)
        var toggle_gender1 = findViewById<MaterialButton>(R.id.toggle_btn_gender1)
        var toggle_gender2 = findViewById<MaterialButton>(R.id.toggle_btn_gender2)
        var signin_birth = findViewById<EditText>(R.id.text_signin_putbirth)
        var signin_id = findViewById<EditText>(R.id.text_signin_putid)
        var signin_id_check = findViewById<Button>(R.id.btn_signin_check_id)
        var signin_pw = findViewById<EditText>(R.id.text_signin_putpw)
        var signin_pw_check = findViewById<EditText>(R.id.text_signin_putpw_check)

        var signin_genre = findViewById<ChipGroup>(R.id.chip_si)
        var signin_genre_chip1 = findViewById<Chip>(R.id.chip_signin_genre1)
        var signin_genre_chip2 = findViewById<Chip>(R.id.chip_signin_genre2)
        var signin_genre_chip3 = findViewById<Chip>(R.id.chip_signin_genre3)
        var signin_genre_chip4 = findViewById<Chip>(R.id.chip_signin_genre4)
        var signin_genre_chip5 = findViewById<Chip>(R.id.chip_signin_genre5)
        var signin_genre_chip6 = findViewById<Chip>(R.id.chip_signin_genre6)
        val btn_signup = findViewById<Button>(R.id.btn_signin_complete)
        var str_toggle = String()
        //성별 토글버튼
        //회원가입 버튼 눌렀을 때
        // 조건 : 모든 정보가 기입 되어야 함, 비밀번호와 비밀번호 체크가 동일, 아이디 중복 확인이 통과된 상태에서 끝나야함
        btn_signup.setOnClickListener {
            if (signin_name.text.toString().trim().isEmpty() || signin_birth.text.toString().trim()
                    .isEmpty() || signin_id.text.toString().trim()
                    .isEmpty() || signin_pw.text.toString().trim()
                    .isEmpty()
            // 칩 + 토글버튼 입력 추가
            )
                Toast.makeText(this, "입력 되지 않은 정보가 존재 합니다.", Toast.LENGTH_SHORT).show()
        }
        //칩 최대 3개까지 선택 가능하게
    }
}