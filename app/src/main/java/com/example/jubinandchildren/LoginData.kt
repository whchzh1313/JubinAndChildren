package com.example.jubinandchildren

data class LoginData(
    val id: String,
    val pwd: String
)

object LoginDataObject {
    private val listLogin: MutableList<LoginData> = mutableListOf(
        LoginData("orinugoori9", "1111"),
        LoginData("choco", "2222"),
        LoginData("mwamwa", "3333"),
        LoginData("ruruha545", "4444"),
        LoginData("apape", "5555")
    )

    fun addList(data: LoginData) = listLogin.add(data)

    fun getList(): List<LoginData> = listLogin

    fun addListWithMpd(data: LoginData) {
        addList(data)
        MyPageDataObject.addData(data.id)
    }
}