package com.example.jubinandchildren

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.transition.Transition.TransitionListener
import com.google.android.material.bottomnavigation.BottomNavigationView
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
        //변수할당
        val backgroundImage = findViewById<ImageView>(R.id.iv_d_background_game_image)
        val userRecommendGame = findViewById<TextView>(R.id.tv_d_user_recommend_game)
        val userHashtag = findViewById<TextView>(R.id.tv_d_user_hashtag)
        val gamePrice = findViewById<TextView>(R.id.tv_d_price)

        val userNameRating = findViewById<TextView>(R.id.tv_d_username_rating)
        val ratingBar = findViewById<RatingBar>(R.id.rb_d_user_rating)
        val userNameReview = findViewById<TextView>(R.id.tv_d_username_review)
        val userReview = findViewById<TextView>(R.id.tv_d_user_review)
        val showMore = findViewById<TextView>(R.id.tv_d_show_more)

        val screenshotList = listOf(
            findViewById<ImageView>(R.id.iv_d_screenshot_1),
            findViewById<ImageView>(R.id.iv_d_screenshot_2),
            findViewById<ImageView>(R.id.iv_d_screenshot_3),
            findViewById<ImageView>(R.id.iv_d_screenshot_4),
            findViewById<ImageView>(R.id.iv_d_screenshot_5),
            findViewById<ImageView>(R.id.iv_d_screenshot_6)
        )


        val userIndex = intent.getIntExtra("index", 0)

        val ReviewList = getReviewList().get(userIndex)

        val navigation = findViewById<BottomNavigationView>(R.id.d_navigation)

        navigation.setOnNavigationItemSelectedListener(){
            when(it.itemId){
                R.id.home -> {
                    val homeIntent = Intent(this,MainActivity::class.java)
                    startActivity(homeIntent)
                    true
                }
                R.id.search -> {
                    val searchIntent = Intent(this,EventActivity::class.java)
                    startActivity(searchIntent)
                    true
                }
                R.id.profile -> {
                    val profileIntent = Intent(this,MyPageActivity::class.java)
                    startActivity(profileIntent)
                    true
                }
                else -> {
                    false
                }
            }
        }

        //각 요소들에 ReviewList에서 가져온 정보 넣어주기
        backgroundImage.setImageResource(ReviewList.imageName)
        userRecommendGame.text = ReviewList.reviewTitle
        userHashtag.text = ReviewList.reviewHash

        userNameRating.text = ReviewList.reviewName
        ratingBar.rating = ReviewList.reviewRating
        userNameReview.text = ReviewList.reviewName
        userReview.text = ReviewList.reviewReview


        val screenshot = listOf(
            ReviewList.reviewScreenShot1,
            ReviewList.reviewScreenShot2,
            ReviewList.reviewScreenShot3,
            ReviewList.reviewScreenShot4,
            ReviewList.reviewScreenShot5,
            ReviewList.reviewScreenShot6
        )

        for (i in 0..screenshot.size - 1) {
            val screenshotsrc = screenshot[i]
            if (screenshotsrc == null) {
                screenshotList[i].visibility = View.GONE
            } else {
                screenshotList[i].visibility = View.VISIBLE
                screenshotList[i].setImageResource(screenshotsrc)
            }

        }

        //가격 Regex 추가
        gamePrice.text = priceRegex(ReviewList.reviewPrice.toString())


        //더보기 버튼 구현
        userReview.maxLines = Int.MAX_VALUE

        userReview.viewTreeObserver.addOnGlobalLayoutListener(object :
            ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                if (userReview.lineCount <= 2) {
                    showMore.visibility = View.GONE
                } else {
                    showMore.visibility = View.VISIBLE
                }

                userReview.maxLines = 2
                userReview.viewTreeObserver.removeOnGlobalLayoutListener(this)
            }
        })
        showMore.setOnClickListener {
            if (userReview.maxLines == 2) {
                userReview.maxLines = Int.MAX_VALUE
                showMore.text = "닫기"
            } else {
                userReview.maxLines = 2
                showMore.text = "더보기"
            }
        }

        //뒤로가기 버튼 구현
        val back = findViewById<ImageView>(R.id.iv_icon_back)

        back.setOnClickListener {
            finish()
        }

        //스팀페이지로 이동
        val addCart = findViewById<LinearLayout>(R.id.layout_d_icon_addcart)

        addCart.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://store.steampowered.com/"))
            startActivity(intent)
        }


        //애니메이션 구현시 해시태그 maxline 속성 변경

        val headerMotionLayout = findViewById<MotionLayout>(R.id.layout_d_background)
        val mainMotionLayout = findViewById<MotionLayout>(R.id.main)

        mainMotionLayout.setTransitionListener(object : MotionLayout.TransitionListener {

            override fun onTransitionStarted(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int
            ) {
                userHashtag.maxLines = Int.MAX_VALUE
            }

            override fun onTransitionChange(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int,
                progress: Float
            ) {
                userHashtag.maxLines = Int.MAX_VALUE
            }


            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                // 전환 완료 시


                when (currentId){
                    R.id.start-> {
                        userHashtag.maxLines = Int.MAX_VALUE
                    }
                    R.id.end -> {
                        userHashtag.maxLines = 1
                        userHashtag.ellipsize = TextUtils.TruncateAt.END
                    }
                }
                Log.d("currentId", ": $currentId")


            }

            override fun onTransitionTrigger(
                motionLayout: MotionLayout?,
                triggerId: Int,
                positive: Boolean,
                progress: Float
            ) {
            }

        })


    }

    //가격에 콤마찍기 정규식
    fun priceRegex(priceString: String): String {
        var finalPrice = ""
        if (priceString == "0") {
            finalPrice = "무료 게임"
        } else {
            val regex = Regex("(\\d)(?=(\\d{3})+(?!\\d))")
            finalPrice = "₩ " + priceString.replace(regex, "$1,")
        }

        return finalPrice

    }
}