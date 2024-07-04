package com.example.jubinandchildren

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val userReview = findViewById<TextView>(R.id.tv_d_user_review)
        val showMore = findViewById<TextView>(R.id.tv_d_show_more)

        showMore.setOnClickListener {
                    if(userReview.maxLines==2) {
                        userReview.maxLines = Int.MAX_VALUE
                        showMore.text = "닫기"
                    }else{
                        userReview.maxLines = 2
                        showMore.text ="더보기"
                    }
                }

        val addCart = findViewById<LinearLayout>(R.id.layout_d_icon_addcart)

        addCart.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://store.steampowered.com/"))
            startActivity(intent)
        }

    }
}