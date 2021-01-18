package kz.app.deliveryapp.support.stat;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class Zutils {

    private static boolean isNetworkAvailable(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (manager != null)
            networkInfo = manager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public static void showRequestError(Context context) {
        try {
            if (!isNetworkAvailable(context)) {
//                showToastSimple(context, context.getString(R.string.common_error_network));
            } else {
//                showToastSimple(context, context.getString(R.string.common_error_backend));
            }
        } catch (Exception e) {
            //TODO: send errors to crashlytics(Fabric)
//            Crashlytics.logException(e);
        }
    }

    public static void showRequestError(Throwable throwable) {
        //TODO: для аналитики
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

//    public static void unsubscribeSafely(Subscription subscription) {
//        if (subscription != null && !subscription.isUnsubscribed())
//            subscription.unsubscribe();
//    }

}
