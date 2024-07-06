package com.example.jubinandchildren

import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class SignInActivity : AppCompatActivity() {

    private lateinit var checkedChipIds: MutableList<Int?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)

        var signin_name = findViewById<EditText>(R.id.text_signin_putname)

        var signin_gender = findViewById<MaterialButtonToggleGroup>(R.id.toggle_button_group)
        var toggle_gender1 = findViewById<MaterialButton>(R.id.toggle_btn_gender1)
        var toggle_gender2 = findViewById<MaterialButton>(R.id.toggle_btn_gender2)

        var signin_id = findViewById<EditText>(R.id.text_signin_putid)
        var signin_id_check = findViewById<Button>(R.id.btn_signin_check_id)
        var signin_pw = findViewById<EditText>(R.id.text_signin_putpw)
        var signin_pw_check = findViewById<EditText>(R.id.text_signin_putpw_check)

        var signin_genre = findViewById<ChipGroup>(R.id.chip_si)
//        var signin_genre_chip1 = findViewById<Chip>(R.id.chip_signin_genre1)
//        var signin_genre_chip2 = findViewById<Chip>(R.id.chip_signin_genre2)
//        var signin_genre_chip3 = findViewById<Chip>(R.id.chip_signin_genre3)
//        var signin_genre_chip4 = findViewById<Chip>(R.id.chip_signin_genre4)
//        var signin_genre_chip5 = findViewById<Chip>(R.id.chip_signin_genre5)
//        var signin_genre_chip6 = findViewById<Chip>(R.id.chip_signin_genre6)
//        var signin_genre_chip7 = findViewById<Chip>(R.id.chip_signin_genre7)
//        val checkedChipIds = signin_genre.checkedChipIds

        val btn_signup = findViewById<Button>(R.id.btn_signin_complete)

        val np_group = findViewById<ConstraintLayout>(R.id.np_group)

        val np_year = findViewById<NumberPicker>(R.id.np_signin_putyear)
        val np_month = findViewById<NumberPicker>(R.id.np_signin_putmonth)
        val np_day = findViewById<NumberPicker>(R.id.np_signin_putday)

        np_year.minValue = 1950
        np_year.maxValue = 2024
        np_month.minValue = 1
        np_month.maxValue = 12
        np_day.minValue = 1
        np_day.maxValue = 31

        var np_value =
            np_year.value.toString() + np_month.value.toString() + np_day.value.toString()



        var b_toggle: Boolean? = null
        //성별 토글버튼
        toggle_gender1.setOnClickListener {
            b_toggle = true
        }
        toggle_gender2.setOnClickListener {
            b_toggle = false
        }

        var isChecked: Boolean? = null

        signin_id_check.setOnClickListener {
            if (signin_id.text.toString() in UserDataList.userList ) {
                Toast.makeText(this, "이미 존재하는 아이디입니다.", Toast.LENGTH_SHORT).show()
                isChecked = false
            } else {
                Toast.makeText(this, "중복 확인이 완료 되었습니다.", Toast.LENGTH_SHORT).show()
                isChecked = true
            }
        }


        //칩 최대 3개까지 선택 가능하게
        checkedChipIds = mutableListOf()
        val firstChip = R.id.chip_signin_genre1
        val secondChip = R.id.chip_signin_genre7
        println("${R.id.chip_signin_genre1}, ${R.id.chip_signin_genre7}")
        println(firstChip + 6 == secondChip)
        signin_genre.setOnCheckedStateChangeListener { group, checkedIds ->
            val list: List<Int> = (0..6).filter { firstChip + it !in checkedIds }
            checkedChipIds = checkedIds
            if (checkedIds.size > 2) {
                list.forEach {
                    findViewById<Chip>(firstChip + it).isEnabled = false
                }
//                Toast.makeText(this, "최대 3개의 장르를 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
//                Log.d("checked", "test${checkedChipIds.size}")
//                Log.d("checked", "test$checkedChipIds")
            } else {
                list.forEach {
                    findViewById<Chip>(firstChip + it).isEnabled = true
                }

//                Log.d("checked", "testElse${checkedChipIds.size}")
//                Log.d("checked", "testElse$checkedChipIds")
            }
        }
        //인트 > 스트링 > if > contains (함수) >  / 정규식 / numpicker
        //회원가입 버튼 눌렀을 때
        // 조건 : 모든 정보가 기입 되어야 함, 비밀번호와 비밀번호 체크가 동일, 아이디 중복 확인이 통과된 상태에서 끝나야함
        // 생년월일 : . 이나 -를 없애서 인트? 값으로 하고 이걸 다시 스트링 8글자 (size)로 확인 한 다음에 통과
        btn_signup.setOnClickListener {
            if (signin_name.text.isEmpty()) {
                Toast.makeText(this, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else if (signin_id.text.isEmpty()) {
                Toast.makeText(this, "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else if (signin_pw.text.isEmpty()) {
                Toast.makeText(this, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else if (b_toggle == null) {
                Toast.makeText(this, "성별을 선택 해주세요.", Toast.LENGTH_SHORT).show()
            } else if (signin_pw.text.trim() != signin_pw_check.text.trim()) {
                Toast.makeText(this, "비밀번호와 비밀번호 확인이 서로 다릅니다.", Toast.LENGTH_SHORT).show()
            } else if (isChecked == false || isChecked == null) {
                Toast.makeText(this, "아이디 중복 확인을 다시 해주세요.", Toast.LENGTH_SHORT).show()
            } else if (checkedChipIds.size != 3) {
                Toast.makeText(this, "3가지의 장르를 선택해주세요.", Toast.LENGTH_SHORT).show()
                Log.d("checked", "$checkedChipIds")
            } else {
                val userData = UserData(
                    signin_id.text.toString(),
                    signin_name.text.toString(),
                    b_toggle,
                    np_value,
                    signin_pw.text.toString(),
                    checkedChipIds.map { it!! - firstChip }.toMutableList()
                )
                UserDataList.userList[signin_id.text.toString()] = userData
                UserDataList.id = signin_id.text.toString()
                Toast.makeText(this, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LogInActivity::class.java)
                intent.putExtra("userData", userData)
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }

}
