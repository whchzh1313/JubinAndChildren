package com.example.jubinandchildren

import android.app.Activity

object StringData {
    val genreId: Array<Int> = arrayOf(
        R.string.mypage_genre_action,
        R.string.mypage_genre_shooting,
        R.string.mypage_genre_adventure,
        R.string.mypage_genre_simulation,
        R.string.mypage_genre_roleplaying,
        R.string.mypage_genre_puzzle,
        R.string.mypage_genre_music,)

    private val genre: Array<String> = Array(genreId.size + 1) { "" }

    val genrePhoto: Array<Int> =
        arrayOf(
            R.drawable.mypage_library_action,
            R.drawable.mypage_library_shooting,
            R.drawable.mypage_library_adventure,
            R.drawable.mypage_library_simulation,
            R.drawable.mypage_library_roleplaying,
            R.drawable.mypage_library_puzzle,
            R.drawable.mypage_library_music,
            R.drawable.mypage_missing
        )

    private val dataStringId = arrayOf(
        R.string.mypage_not_input,
        R.string.mypage_more,
        R.string.mypage_close,
        R.string.mypage_please_input
    )

    val dataString: Array<String> = Array(dataStringId.size) { "" }

    fun initStringData(activity: Activity) {
        for (i in genreId.indices) {
            genre[i] = activity.getString(genreId[i])
        }
        for(i in dataStringId.indices){
            dataString[i] = activity.getString(dataStringId[i])
        }
    }
}