package xyz.sziit.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetUtils {

    private NetUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 当前网络是否可用
     *
     * @param context Context
     * @return true 可用；false 不可用
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (cm == null) return false;

        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo == null) return false;

        if (netInfo.isConnected() && netInfo.isAvailable()) {
            if (netInfo.getState() == NetworkInfo.State.CONNECTED) return true;
        }

        return false;
    }
}
