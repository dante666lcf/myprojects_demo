package kz.alemtime.alem.support.stat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.util.Objects;

import rx.Subscription;

public class ZUtils {
    public final static int PHONE_TYPE = 0;
    public final static int TAB7_TYPE = 1;
    public final static int TAB10_TYPE = 2;

    //region SECURITY
    @SuppressLint("HardwareIds")
    public static String getIMEI(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }
    //endregion

    //region NETWORKING
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (manager != null)
            networkInfo = manager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public static void unsubscribeSafely(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed())
            subscription.unsubscribe();
    }
    //endregion

    //region TOASTS, SNACKBARS, LOGS
    public static void showRequestError(Context context) {
        try {
            if (!isNetworkAvailable(context)) {
//                showToastSimple(context, context.getString(R.string.common_error_network));
            } else {
//                showToastSimple(context, context.getString(R.string.common_error_backend));
            }
        } catch (Exception e) {
//            Crashlytics.logException(e);
        }
    }

    public static void showRequestError(Throwable throwable) {
//        if (BuildConfig.DEBUG && throwable != null)
//            Crashlytics.logException(throwable);
    }

    public static void showResponseError(Context context, int code, String message) {
        switch (code) {
            case 401:
//                Zprefs.logOut(context);
                break;
            default:
                showToastSimple(context, message);
                break;
        }
    }

    public static void showToastSimple(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
    //endregion

    //region MATERIAL DIALOGS
    //endregion

    //region VALIDATION
    public static boolean isValidEmail(CharSequence email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    //endregion

    //region FORMATTING
    public final static String FORMAT_DATE_0 = "d.MM.yyyy";
    public final static String FORMAT_DATE_1 = "d MMMM";
    public final static String FORMAT_DATE_2 = "yyyy-MM-dd";
    public final static String FORMAT_DATE_3 = "yyyy-MM-dd HH:mm:ss";
    public final static String FORMAT_DATE_4 = "dd.MM.yy HH:mm:ss";
    public final static String FORMAT_DATE_5 = "HH:mm:ss";
    public final static String FORMAT_DATE_6 = "dd.MM.yyyy";
    public final static String FORMAT_DATE_7 = "yyyy-MM-dd HH:mm:ss.SSS";
    //endregion

    public static void hideSoftInputFromWindow(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(Objects.requireNonNull(activity.getCurrentFocus()).getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public static int convertDpToPx(int dp, Context context) {
        return Math.round(dp * (context.getResources().getDisplayMetrics().xdpi / DisplayMetrics.DENSITY_DEFAULT));

    }

    public static int convertPxToDp(int px, Context context) {
        return Math.round(px / (context.getResources().getDisplayMetrics().xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    //region UI AND ANIMATION
    public static void shakeView(View view) {
//        if (view != null)
//            YoYo.with(Techniques.Shake).duration(600).playOn(view);
    }
    //endregion
}