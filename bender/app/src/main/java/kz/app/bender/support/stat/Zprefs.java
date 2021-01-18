package kz.app.bender.support.stat;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.orhanobut.hawk.Hawk;

import kz.app.bender.models.TSignIn;
import kz.app.bender.support.Config;

class Zprefs {

    public static String getHost(SharedPreferences preference) {
//        if (BuildConfig.DEBUG) {
        //TODO: if project have beta data base
//            return getDebugHost(preference);
//        } else {
        return Config.HOST_BASE;
//        }
    }

    public static void setUser(TSignIn signIn, SharedPreferences preferences) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(Zvars.PREFERENCE_USER_DATA, new Gson().toJson(signIn));
        editor.apply();
    }

    @Nullable
    public static TSignIn getUser(SharedPreferences preferences) {
        String str = preferences.getString(Zvars.PREFERENCE_USER_DATA, "");
        TSignIn userData = null;
        if (!str.isEmpty()) {
            try {
                userData = new Gson().fromJson(str, TSignIn.class);
            } catch (Exception ignored) {

            }
        }
        return userData;
    }

    public static void clearUser(SharedPreferences preferences) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(Zvars.PREFERENCE_USER_DATA);
        editor.apply();
    }

    public static void setUserAuthToken(String token) {
        Hawk.put(Zvars.PREFERENCE_SECURE_AUTH_TOKEN_V_1, token);
    }

    public static String getUserAuthToken() {
        return Hawk.get(Zvars.PREFERENCE_SECURE_AUTH_TOKEN_V_1);
    }

    public static void clearUserAuthToken() {
        Hawk.delete(Zvars.PREFERENCE_SECURE_AUTH_TOKEN_V_1);
    }
}
