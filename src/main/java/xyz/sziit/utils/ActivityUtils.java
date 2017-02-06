package xyz.sziit.utils;

import android.app.Activity;
import android.content.Intent;


public class ActivityUtils {

    private ActivityUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static void startActivity(Activity currentActivity,
                                     Class nextActivity) {

        if (currentActivity == null || nextActivity == null)
            throw new NullPointerException("参数为空");

        Intent intent = new Intent(currentActivity, nextActivity);
        currentActivity.startActivity(intent);
    }

    public static void startActivityAndFinish(Activity currentActivity,
                                              Class nextActivity) {

        startActivity(currentActivity, nextActivity);
        currentActivity.finish();
    }
}
