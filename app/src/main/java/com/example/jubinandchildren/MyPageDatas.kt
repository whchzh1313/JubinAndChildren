package com.example.jubinandchildren

data class MyPageData(
    val profile: Profile,
    val genres: Map<String, Int>,
    val gamePicks: GamePick,
    val libraryPicturesIds: Array<Int>
)

data class Profile(
    val name: String,
    val description: String,
    val image: Int,
)
data class GamePick(
    val title: String,
    val description: String,
    val image: Int
)

object LibraryData {
    private val myPageLibraryData: MutableMap<String, ArrayList<MyPageData>> = mutableMapOf()
    private var isDataInitialized = false

    fun initData() {
        if(!isDataInitialized) {
            myPageLibraryData["orinugoori9"] =
                arrayListOf (
                    MyPageData(

                    )
                )
            isDataInitialized = true
        } else {
            println("이미 초기화됨")
        }
    }
}


