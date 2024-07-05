package com.example.jubinandchildren

data class UserData(
    val userName: String,
    val isMan: Boolean,
    val userBirth: String,
//    val userId: String,
    //유저 리스트 첫번째에 아이디 작성해주기
    val userPw: String,
    val userGenre: String
)

object UserDataList {
    val userList: MutableMap<String, UserData> = mutableMapOf("a4cross072" to UserData("공명선",true,"YYYY_MM_DD","gongms",""),)
}
