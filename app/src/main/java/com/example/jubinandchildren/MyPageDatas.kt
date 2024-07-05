package com.example.jubinandchildren

data class MyPageData(val genres: Array<String>, val gamePicks: Array<String>, val libraryPicturesIds: Int)

object LibraryData {
    val myPageLibraryData: MutableMap<String, ArrayList<MyPageData>> = mutableMapOf()

    fun initData(idArray: Array<String>) {
        idArray.forEach {
            myPageLibraryData[it] = arrayListOf()
        }
    }
}