package xyz.sziit.utils;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;

/**
 * Created by Money on 2017/1/16.
 */

public class PackageUtils {

    private PackageUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 获取包信息
     *
     * @param activity Activity
     * @return 成功返回包信息，失败返回null
     */
    public static PackageInfo getPackageInfo(@NonNull Activity activity) {
        if (activity == null) return null;

        PackageInfo packageInfo = null;
        PackageManager packageManager = activity.getPackageManager();

        try {
            packageInfo = packageManager.getPackageInfo(activity.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return packageInfo;
    }

    /**
     * 获取版本名
     *
     * @param activity Activity
     * @return 成功返回版本名，失败返回null
     */
    public static String getVersionName(@NonNull Activity activity) {
        PackageInfo packageInfo = null;
        if ((packageInfo = getPackageInfo(activity)) == null) return null;

        return packageInfo.versionName;
    }

    /**
     * 获取版本号
     *
     * @param activity  Activity
     * @return 成功返回版本号，失败返回-1
     */
    public static int getVersionCode(@NonNull Activity activity) {
        PackageInfo packageInfo = null;
        if ((packageInfo = getPackageInfo(activity)) == null) return -1;

        return packageInfo.versionCode;
    }

    /**
     * 获取包名
     *
     * @param activity  Activity
     * @return 成功返回包名，失败返回null
     */
    public static String getPackageName(@NonNull Activity activity) {
        PackageInfo packageInfo = null;
        if ((packageInfo = getPackageInfo(activity)) == null) return null;

        return packageInfo.packageName;
    }
}
