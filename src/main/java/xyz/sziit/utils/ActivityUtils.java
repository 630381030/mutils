package xyz.sziit.utils;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;


public class ActivityUtils {

    private ActivityUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 跳转到指定的Activity
     * @param currentActivity   当前的Activity
     * @param nextActivity      跳转的Activity
     */
    public static void startActivity(@NonNull Activity currentActivity,
                                     @NonNull Class nextActivity) {

        if (currentActivity == null || nextActivity == null)
            throw new NullPointerException("参数为空");

        Intent intent = new Intent(currentActivity, nextActivity);
        currentActivity.startActivity(intent);
    }

    /**
     * 跳转到指定的Activity并finish掉当前的Activity
     * @param currentActivity   当前的Activity
     * @param nextActivity      跳转的Activity
     */
    public static void startActivityAndFinish(@NonNull Activity currentActivity,
                                              @NonNull Class nextActivity) {

        startActivity(currentActivity, nextActivity);
        currentActivity.finish();
    }
}
