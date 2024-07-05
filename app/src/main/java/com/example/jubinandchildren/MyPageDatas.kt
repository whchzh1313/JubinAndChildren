package com.example.jubinandchildren

data class MyPageData(val genres: Array<String>, val gamePicks: Array<String>, val libraryPicturesIds: Int)

object LibraryData {
    private val myPageLibraryData: MutableMap<String, ArrayList<MyPageData>> = mutableMapOf()
    private var isDataInitialized = false

    fun initData() {
        if(!isDataInitialized) {
            myPageLibraryData["a4cross072"] =
                arrayListOf ( MyPageData(arrayOf("dwdw"), arrayOf("dwqq"), 1) )
            isDataInitialized = true
        } else {
            println("이미 초기화됨")
        }
    }
}


