package com.example.jubinandchildren

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserData(
    val id: String,
    val pwd: String,
    val userName: String,
    val isMan: Boolean?,
    val userBirth: String,
    val userGenre: MutableList<Int?>
): Parcelable
object UserDataObject {
    private val userMap: MutableMap<String, UserData> = mutableMapOf(
        ("orinugoori9" to UserData("orinugoori9", "1111", "김현지", false, "17770707", mutableListOf(4, 2, 0))),
        ("choco" to UserData("choco", "2222", "이화민", true, "19970715", mutableListOf(1, 3, 2))),
        ("mwamwa" to UserData("mwamwa", "3333", "황주빈", false, "19970427", mutableListOf(3, 4, 2))),
        ("ruruha545" to UserData("ruruha545", "4444", "박정호", true, "19991225", mutableListOf(1, 0, 2))),
        ("apape" to UserData("apape", "5555", "공명선", true, "20010209", mutableListOf(2, 5, 0))),
    )
    private var loginId: String = ""

    fun addMap(id: String, data: UserData) = userMap.put(id, data)

    fun getMap(): Map<String, UserData> = userMap

    fun getUserData(id: String): UserData =
        userMap[id] ?: UserData("n1u2l3l4", "", "Null", true, "20240707", mutableListOf(0, 1, 2))

    fun setId(id: String) {
        loginId = id
    }

    fun getId() = loginId

}