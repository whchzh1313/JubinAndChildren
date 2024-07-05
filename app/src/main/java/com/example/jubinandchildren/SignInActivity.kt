package com.example.jubinandchildren

import android.graphics.Color
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup

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

        var signin_id = findViewById<EditText>(R.id.text_signin_putid)
        var signin_pw = findViewById<EditText>(R.id.text_signin_putpw)
        var signin_pw_check = findViewById<EditText>(R.id.text_signin_putpw_check)

        val a = findViewById<RadioGroup>(R.id.toggle_button_group)
        val a1 = findViewById<MaterialButton>(R.id.tt1)
        val a2 = findViewById<MaterialButton>(R.id.tt2)
        a.setOnCheckedChangeListener{ radiogroup, checkedId ->
            when(checkedId) {
                R.id.tt1 -> {
                    println("dwdw")
                }
                R.id.tt2 -> {
                    println("dwdw")
                }
            }
        }
//        a1.setOnClickListener {
//            println("dwdw")
//            a1.setBackgroundColor(Color.parseColor("#FFA3C9E9"))
//            a2.setBackgroundColor(Color.parseColor("#FFD4E2ED"))
//        }
//        a2.setOnClickListener {
//            println("wdwd")
//            a1.setBackgroundColor(Color.parseColor("#FFD4E2ED"))
//            a2.setBackgroundColor(Color.parseColor("#FFA3C9E9"))
//        }
    }
}