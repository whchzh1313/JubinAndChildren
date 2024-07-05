package com.example.jubinandchildren

import android.media.Rating

data class ReviewList(
    val imageName: Int, // 이미지이름 drawable
    val reviewName: String, // 사람이름
    val reviewTitle: String, // 게임제목
    val reviewReview: String, // 리뷰 게시글
    val reviewHash: String, // 해시태그
    val reviewGenre: String, // 장르
    val reviewPrice: Int, // 가격
    val reviewRating: Float, // 별점
    val reviewScreenShot1: Int?, // 인게임 스크린샷
    val reviewScreenShot2: Int?,
    val reviewScreenShot3: Int?,
    val reviewScreenShot4: Int?,
    val reviewScreenShot5: Int?,
    val reviewScreenShot6: Int?
)