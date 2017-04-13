package xyz.sziit.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;


public class PermissionUtils {

    private PermissionUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 申请权限
     * @param activity          Activity
     * @param permission        权限
     * @param REQUEST_CODE      请求码
     */
    public static void requestPermissions(@NonNull final Activity activity,
                                          @NonNull final String permission,
                                          @NonNull final int REQUEST_CODE) {

        if (activity == null || TextUtils.isEmpty(permission)) {
            throw new NullPointerException("传入参数不能为空!");
        }

        if (ContextCompat.checkSelfPermission(activity, permission)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(activity, new String[]{permission}, REQUEST_CODE);
        }
    }

    /**
     * 申请所需的全部权限(按组申请，每组只需申请一个，即可获取全组的权限)
     *
     * @param activity  Activity
     */
    public static void requestAllPermissions(@NonNull final Activity activity) {
        if (activity == null) {
            throw new NullPointerException("传入参数不能为空!");
        }

        List<String> permissionList = new ArrayList<>();

        if (!checkPermissions(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }

        if (!checkPermissions(activity, Manifest.permission.RECORD_AUDIO)) {
            permissionList.add(Manifest.permission.RECORD_AUDIO);
        }

        if (!checkPermissions(activity, Manifest.permission.ACCESS_FINE_LOCATION)) {
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }

        if (!checkPermissions(activity, Manifest.permission.CAMERA)) {
            permissionList.add(Manifest.permission.CAMERA);
        }

        if (!checkPermissions(activity, Manifest.permission.READ_PHONE_STATE)) {
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }

        if (permissionList.size() >= 1) {
            String[] permissions = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(activity, permissions, 1);
        }
    }

    /**
     * 检查权限是否开启
     * @param context       Context
     * @param permission    权限
     * @return true 有权限；false 没有权限
     */
    public static boolean checkPermissions(@NonNull final Context context,
                                           @NonNull final String permission) {
        if (context == null || TextUtils.isEmpty(permission)) {
            throw new NullPointerException("传入参数不能为空");
        }

        return ContextCompat.checkSelfPermission(context, permission)
                == PackageManager.PERMISSION_GRANTED;
    }
}