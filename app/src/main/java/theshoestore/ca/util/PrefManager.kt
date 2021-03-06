package theshoestore.ca.util

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

class PrefManager(context: Context?) {
    var pref: SharedPreferences? = null
    var editor: Editor? = null

    var PRIVATE_MODE = 0

    private val PREF_NAME = "shoes-welcome"

    private val IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch"

    private val IS_POPULATED = "IsPopulated"

    private val IS_LOGGEDIN = "isLoggedIn"

    init {
        pref = context!!.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref?.edit()
    }

    fun setFirstTimeLaunch(isFirstTime: Boolean) {
        editor!!.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime)
        editor!!.commit()
    }

    fun isFirstTimeLaunch(): Boolean {
        return pref!!.getBoolean(IS_FIRST_TIME_LAUNCH, true)
    }

    fun setPopulated(isPopulated: Boolean) {
        editor!!.putBoolean(IS_POPULATED, isPopulated)
        editor!!.commit()
    }

    fun setLoggedIn(isLoggedIn: Boolean) {
        editor!!.putBoolean(IS_LOGGEDIN, isLoggedIn)
        editor!!.commit()
    }

    fun isLoggedIn(): Boolean {
        return pref!!.getBoolean(IS_LOGGEDIN, false)
    }
}
