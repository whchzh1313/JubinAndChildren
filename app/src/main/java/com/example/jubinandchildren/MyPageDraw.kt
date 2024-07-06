package com.example.jubinandchildren

import android.widget.GridView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.random.Random

// 시간 되면 어댑터로 대체

fun drawMyPage(activity: MyPageActivity, mpd: MyPageData) {
    drawMyPageProfile(activity, mpd)
    drawMyPageGamePick(activity, mpd)
    drawMyPageLibrary(activity, mpd)
}

private fun drawMyPageProfile(activity: MyPageActivity, mpd: MyPageData) {
    val profileName = activity.findViewById<TextView>(R.id.tv_mypage_name)
    val profilePhoto = activity.findViewById<ImageView>(R.id.iv_mypage_profile)
    val profileDesc = activity.findViewById<TextView>(R.id.tv_mypage_description)
    val profileLevel = activity.findViewById<TextView>(R.id.tv_mypage_profile_level)
    val profileBackground = activity.findViewById<ConstraintLayout>(R.id.constraintlayout_mypage_profile)
    val profileImageGenre1 = activity.findViewById<ImageView>(R.id.iv_mypage_profile_genre1)
    val profileImageGenre2 = activity.findViewById<ImageView>(R.id.iv_mypage_profile_genre2)
    val profileImageGenre3 = activity.findViewById<ImageView>(R.id.iv_mypage_profile_genre3)
    val profileTextGenre1 = activity.findViewById<TextView>(R.id.tv_mypage_profile_genre1)
    val profileTextGenre2 = activity.findViewById<TextView>(R.id.tv_mypage_profile_genre2)
    val profileTextGenre3 = activity.findViewById<TextView>(R.id.tv_mypage_profile_genre3)
    val genderText = if(mpd.profile.isMan) "♂" else "♀"

    profileName.text = java.lang.String(mpd.profile.name + " $genderText")
    profilePhoto.setImageResource(mpd.profile.image)
    profileDesc.text =
        if(mpd.profile.description.length <= 20) mpd.profile.description
        else subString(mpd.profile.description, 20)
    profileLevel.text = mpd.libraryPicturesIds.size.toString()
    val notBlack = mpd.gamePicks.filterNot { it.title == "?" }.size
    if(notBlack != 0) profileBackground.setBackgroundResource(mpd.gamePicks[Random.nextInt(notBlack)].image)
    profileTextGenre1.text = mpd.genres[0]
    profileTextGenre2.text = mpd.genres[1]
    profileTextGenre3.text = mpd.genres[2]
    profileImageGenre1.setImageResource(genrePhoto[mpd.genres[0]] ?: R.drawable.mypage_background_black)
    profileImageGenre2.setImageResource(genrePhoto[mpd.genres[1]] ?: R.drawable.mypage_background_black)
    profileImageGenre3.setImageResource(genrePhoto[mpd.genres[2]] ?: R.drawable.mypage_background_black)

}

private fun drawMyPageGamePick(activity: MyPageActivity, mpd: MyPageData) {
    val gamePickImage1 = activity.findViewById<ImageView>(R.id.iv_mypage_gamepick1)
    val gamePickImage2 = activity.findViewById<ImageView>(R.id.iv_mypage_gamepick2)
    val gamePickImage3 = activity.findViewById<ImageView>(R.id.iv_mypage_gamepick3)
    val gamePickTitle1 = activity.findViewById<TextView>(R.id.tv_mypage_gamepick1_name)
    val gamePickTitle2 = activity.findViewById<TextView>(R.id.tv_mypage_gamepick2_name)
    val gamePickTitle3 = activity.findViewById<TextView>(R.id.tv_mypage_gamepick3_name)
    val gamePickTag1 = activity.findViewById<TextView>(R.id.tv_mypage_gamepick1_hashtag)
    val gamePickTag2 = activity.findViewById<TextView>(R.id.tv_mypage_gamepick2_hashtag)
    val gamePickTag3 = activity.findViewById<TextView>(R.id.tv_mypage_gamepick3_hashtag)

    gamePickImage1.setImageResource(mpd.gamePicks[0].image)
    gamePickImage2.setImageResource(mpd.gamePicks[1].image)
    gamePickImage3.setImageResource(mpd.gamePicks[2].image)
    if(mpd.gamePicks[0].image == R.drawable.mypage_missing)
        gamePickImage1.setBackgroundResource(R.drawable.mypage_gamepick_missing_background)
    if(mpd.gamePicks[1].image == R.drawable.mypage_missing)
        gamePickImage2.setBackgroundResource(R.drawable.mypage_gamepick_missing_background)
    if(mpd.gamePicks[2].image == R.drawable.mypage_missing)
        gamePickImage3.setBackgroundResource(R.drawable.mypage_gamepick_missing_background)
    gamePickTitle1.text = mpd.gamePicks[0].title
    gamePickTitle2.text = mpd.gamePicks[1].title
    gamePickTitle3.text = mpd.gamePicks[2].title
    gamePickTag1.text = mpd.gamePicks[0].description
    gamePickTag2.text = mpd.gamePicks[1].description
    gamePickTag3.text = mpd.gamePicks[2].description
}

private fun drawMyPageLibrary(activity: MyPageActivity, mpd: MyPageData) {
    val linearLayout = activity.findViewById<LinearLayout>(R.id.linearlayout_mypage_library)
    val gridView = activity.findViewById<GridView>(R.id.gv_mypage_libraray)
    val adapter = MyPageGridAdapter(activity, linearLayout, mpd)
    val dpi = activity.resources.displayMetrics.density

    adapter.initItem()
    gridView.isVerticalScrollBarEnabled = false
    gridView.adapter = adapter
    changeHeight(dpi, 1, linearLayout)
}

fun subString(str: String, num: Int): String {
    var n = num - 1
    val strBuilder = StringBuilder(str)
    for(i in strBuilder.indices) {
        if(i > n) {
            strBuilder.insert(i, '\n')
            n += num
        }
        println(i)
    }
    println(strBuilder.toString())
    return strBuilder.toString()
}