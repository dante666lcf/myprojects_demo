package kz.alemtime.alem.support.stat

import android.content.SharedPreferences
import com.google.gson.Gson
import com.orhanobut.hawk.Hawk
import kz.alemtime.alem.models.TProfile
import java.util.*

class ZPrefs {

    companion object {

        //region AUTHORIZATION
        var HOST: String = "https://api.alemtime.kz/"

        fun setUserAuthToken(token: String?) {
            Hawk.put(ZVars.PREFERENCE_SECURE_AUTH_TOKEN_V_1, token)
        }

        fun getUserAuthToken(): String? {
            return Hawk.get(ZVars.PREFERENCE_SECURE_AUTH_TOKEN_V_1)
        }

        fun clearUserAuthToken() {
            Hawk.delete(ZVars.PREFERENCE_SECURE_AUTH_TOKEN_V_1)
        }

        fun setUserAuthTokenTTL(ttl: Date?) {
            Hawk.put(ZVars.PREFERENCE_SECURE_AUTH_TOKEN_TTL_V_1, ttl)
        }

        fun getUserAuthTokenTTL(): Date? {
            return Hawk.get(ZVars.PREFERENCE_SECURE_AUTH_TOKEN_TTL_V_1)
        }
        //endregion

        //region PROFILE
        fun setUserProfile(profile: TProfile, preferences: SharedPreferences) {
            preferences.edit()
                    .putString(ZVars.PREFERENCE_PROFILE, Gson().toJson(profile))
                    .apply()
        }

        fun getUserProfile(sharedPreferences: SharedPreferences): TProfile? {
            val str = sharedPreferences.getString(ZVars.PREFERENCE_PROFILE, "")
            var profile: TProfile? = null
            if (!str!!.isEmpty()) {
                profile = Gson().fromJson<Any>(str, TProfile::class.java) as TProfile?
            }
            return profile
        }

        private fun clearUserProfile(preferences: SharedPreferences) {
            preferences.edit().remove(ZVars.PREFERENCE_PROFILE).apply()
        }

        fun logOut(sharedPreferences: SharedPreferences) {
            clearUserAuthToken()
//            clearUserAuthTokenTTL()
//            clearUserRefreshToken()
            clearUserProfile(sharedPreferences)
        }
        //endregion

    }

}