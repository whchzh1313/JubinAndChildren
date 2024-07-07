package com.example.jubinandchildren

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserData(
    val userId: String,
    val userName: String,
    val isMan: Boolean?,
    val userBirth: String,
    val userPw: String,
    val userGenre: MutableList<Int?>
):Parcelable


object UserDataList {
    val userList: MutableMap<String, UserData> = mutableMapOf()
    var id = ""
}
