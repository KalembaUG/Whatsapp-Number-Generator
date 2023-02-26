package ug.kalemba.whatsappnumbergenerator.util

import java.util.*

fun getMyno(): String {
    val availableCodes = arrayListOf(
        "0705",
        "0706",
        "0701",
        "0702",
        "0707",
        "0708",
        "0709",
        "0751",
        "0752",
        "0753",
        "0755",
        "0755",
        "0756",
        "0757",
        "0758",
        "0759",
        "0771",
        "0772",
        "0773",
        "0774",
        "0776",
        "0777",
        "0778",
        "0779",
        "0781",
        "0782",
        "0783",
        "0784",
        "0786",
        "0787",
        "0788",
        "0789",
    )
    val mySt = Calendar.getInstance().timeInMillis.toString()
    val myRand = kotlin.random.Random.nextInt(1000, 9999).toString()
    return availableCodes[kotlin.random.Random.nextInt(0,availableCodes.size)]+myRand + mySt.substring(mySt.length - 3, mySt.length - 1)

}