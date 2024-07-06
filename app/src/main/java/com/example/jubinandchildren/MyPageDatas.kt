package com.example.jubinandchildren

data class MyPageData(
    val profile: Profile,
    var genres: Array<String>,
    val gamePicks: Array<GamePick>,
    val libraryPicturesIds: IntArray
)

data class Profile(
    val name: String,
    val isMan: Boolean,
    val description: String,
    val image: Int,
)

data class GamePick(
    val title: String,
    val description: String,
    val image: Int
)

object MyPageDataObject {
    private val myPageDataMap: MutableMap<String, MyPageData> = mutableMapOf()
    private var isDataInitialized = false

    fun initData() {
        if (!isDataInitialized) {
            myPageDataMap["orinugoori9"] =
                MyPageData(
                    Profile("김현지", false, "롤조아~ 롤토체스 조아~", R.drawable.mypage_profile_orinugoori9),
                    arrayOf("롤플레잉", "어드벤처", "액션"),
                    arrayOf(
                        GamePick("리그 오브 레전드", "#AOS #온라인게임 #팀플레이", R.drawable.mypage_gamepick_lol),
                        GamePick("구스 구스 덕", "#추리게임 #마피아 #멀티플레이어", R.drawable.mypage_gamepick_goose),
                        GamePick("슈퍼 버니 맨", "#시뮬레이션 #인디", R.drawable.mypage_gamepick_superbunnyman)
                    ),
                    intArrayOf(
                        R.drawable.mypage_library_vampiresurvivors,
                        R.drawable.mypage_library_planetzoo,
                        R.drawable.mypage_gamepick_goose,
                        R.drawable.mypage_gamepick_superbunnyman,
                        R.drawable.mypage_library_polybridge,
                        R.drawable.mypage_library_islandsofinsight,
                        R.drawable.mypage_library_oxygennotincluded,
                    )
                )
            myPageDataMap["choco"] =
                MyPageData(
                    Profile("이화민", true,"있는게임 다해요! 일단 맛부터 보는 편!", R.drawable.mypage_profile_choco),
                    arrayOf("슈팅", "시뮬레이션", "어드벤처",),
                    arrayOf(
                        GamePick("팩토리오", "#샌드박스 #건설_경영_시뮬레이션 #타워_디펜스 #할인_절대로_안함", R.drawable.mypage_gamepick_factorio),
                        GamePick("코어키퍼", "#샌드박스 #어드벤처 #할인때만_구매추천", R.drawable.mypage_gamepick_corekeeper),
                        GamePick("고스트리콘", "#FPS #택티컬_슈터 #할인때만_구매추천", R.drawable.mypage_gamepick_ghostrecon)
                    ),
                    intArrayOf(
                        R.drawable.mypage_library_corekeeper,
                        R.drawable.mypage_library_factorio,
                        R.drawable.mypage_library_ghostrecon,
                        R.drawable.mypage_library_palworld,
                        R.drawable.mypage_library_party,
                        R.drawable.mypage_library_rainbow,
                    )
                )
            myPageDataMap["mwamwa"] =
                MyPageData(
                    Profile("황주빈", false,"말랑해요", R.drawable.mypage_profile_mwamwa),
                    arrayOf("시뮬레이션", "롤플레잉", "어드벤처",),
                    arrayOf(
                        GamePick("프로젝트 좀보이드", "# 오픈월드 #RPG #인디", R.drawable.mypage_gamepick_projectzomboid),
                        GamePick("스타듀밸리", "#농사 #힐링  #인디", R.drawable.mypage_gamepick_stardewvalley),
                        GamePick("돈스타브 투게더", "# 오픈월드 #시뮬레이션 #인디", R.drawable.mypage_gamepick_dontstarvetogether)
                    ),
                    intArrayOf(
                        R.drawable.mypage_gamepick_projectzomboid,
                        R.drawable.mypage_gamepick_dontstarvetogether,
                        R.drawable.mypage_gamepick_stardewvalley,
                        R.drawable.mypage_library_rustysretirement,
                        R.drawable.mypage_gamepick_goose,
                        R.drawable.mypage_library_humanfallflat,
                        R.drawable.mypage_library_prisonarchitect,
                    )
                )
            myPageDataMap["ruruha545"] =
                MyPageData(
                    Profile("박정호", true,"월오쉽 2만판 55퍼 굿맨 KEINE클랜 머장", R.drawable.mypage_profile_ruruha545),
                    arrayOf("슈팅", "액션", "어드벤처",),
                    arrayOf(
                        GamePick("월드오브워쉽", "#슈팅, #MMO", R.drawable.mypage_gamepick_worldofworships),
                        GamePick("배틀그라운드", "#배틀로얄, #FPS", R.drawable.mypage_gamepick_pubg),
                        GamePick("코드 베인", "#소울라이크", R.drawable.mypage_gamepick_codevein)
                    ),
                    intArrayOf(
                        R.drawable.mypage_gamepick_worldofworships,
                        R.drawable.mypage_gamepick_pubg,
                        R.drawable.mypage_gamepick_codevein,
                        R.drawable.mypage_library_wows1,
                        R.drawable.mypage_library_wows2,
                        R.drawable.mypage_library_wows3,
                        R.drawable.mypage_library_wows4,
                        R.drawable.mypage_library_wows5,
                        R.drawable.mypage_library_wows6,
                        R.drawable.mypage_library_pubg1,
                        R.drawable.mypage_library_pubg2,
                        R.drawable.mypage_library_pubg3,
                        R.drawable.mypage_library_pubg4,
                        R.drawable.mypage_library_pubg5,
                    )
                )
            isDataInitialized = true
        } else {
            println("이미 초기화됨")
        }
    }

    fun addData(id: String) {
        if(!isDataContains(id)) {
            myPageDataMap[id] =
                MyPageData(
                    Profile(
                        UserDataList.userList[id]?.userName ?: "이름",
                        UserDataList.userList[id]?.isMan ?: true,
                        "자기소개가 입력되지 않았습니다.",
                        R.drawable.mypage_profile_base_image),
                    UserDataList.userList[id]?.userGenre ?: arrayOf("", "", ""),
                    arrayOf(
                        GamePick("?", "#추가해주세요!", R.drawable.mypage_background_black),
                        GamePick("?", "#추가해주세요!", R.drawable.mypage_background_black),
                        GamePick("?", "#추가해주세요!", R.drawable.mypage_background_black)
                    ),
                    intArrayOf(

                    )
                )
            while(myPageDataMap[id]!!.genres.size < 3) {
                myPageDataMap[id]!!.genres += ""
            }
        }
    }

    private fun isDataContains(id: String): Boolean = myPageDataMap.keys.contains(id)

    fun getMyData(id: String): MyPageData {
        addData(id)
        return myPageDataMap[id]!!
    }

}

val genrePhoto: Map<String, Int> =
    mapOf(
        "액션" to R.drawable.mypage_library_action,
        "슈팅" to R.drawable.mypage_library_shooting,
        "어드벤처" to R.drawable.mypage_library_adventure,
        "시뮬레이션" to R.drawable.mypage_library_simulation,
        "롤플레잉" to R.drawable.mypage_library_roleplaying,
        "퍼즐" to R.drawable.mypage_library_puzzle,
        "음악" to R.drawable.mypage_library_music,
        "" to R.drawable.mypage_background_black
    )


