package xyz.sziit.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class SharePUtils {

    private SharePUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    private static SharedPreferences getPreferences(Context context, String filename) {
        if (filename == null) {
            return PreferenceManager.getDefaultSharedPreferences(context);
        } else {
            return context.getSharedPreferences(filename, Context.MODE_PRIVATE);
        }
    }

    private static Editor getEditor(Context context, String filename) {
        if (filename == null) {
            return PreferenceManager.getDefaultSharedPreferences(context).edit();
        } else {
            return context.getSharedPreferences(filename, Context.MODE_PRIVATE).edit();
        }
    }

    public static boolean getBoolean(Context context, String key, boolean defValue) {
        return getPreferences(context, null).getBoolean(key, defValue);
    }

    public static boolean getBoolean(Context context, String filename, String key, boolean defValue) {
        return getPreferences(context, filename).getBoolean(key, defValue);
    }

    public static float getFloat(Context context, String key, float defValue) {
        return getPreferences(context, null).getFloat(key, defValue);
    }

    public static float getFloat(Context context, String filename, String key, float defValue) {
        return getPreferences(context, filename).getFloat(key, defValue);
    }

    public static int getInt(Context context, String key, int defValue) {
        return getPreferences(context, null).getInt(key, defValue);
    }

    public static int getInt(Context context, String filename, String key, int defValue) {
        return getPreferences(context, filename).getInt(key, defValue);
    }

    public static long getLong(Context context, String key, long defValue) {
        return getPreferences(context, null).getLong(key, defValue);
    }

    public static long getLong(Context context, String filename, String key, long defValue) {
        return getPreferences(context, filename).getLong(key, defValue);
    }

    public static String getString(Context context, String key, String defValue) {
        return getPreferences(context, null).getString(key, defValue);
    }

    public static String getString(Context context, String filename, String key, String defValue) {
        return getPreferences(context, filename).getString(key, defValue);
    }

    public static boolean setShare(Context context, String key, boolean value) {
        return getEditor(context, null).putBoolean(key, value).commit();
    }

    public static boolean setShare(Context context, String filename, String key, boolean value) {
        return getEditor(context, filename).putBoolean(key, value).commit();
    }

    public static boolean setShare(Context context, String key, float value) {
        return getEditor(context, null).putFloat(key, value).commit();
    }

    public static boolean setShare(Context context, String filename, String key, float value) {
        return getEditor(context, filename).putFloat(key, value).commit();
    }

    public static boolean setShare(Context context, String key, int value) {
        return getEditor(context, null).putInt(key, value).commit();
    }

    public static boolean setShare(Context context, String filename, String key, int value) {
        return getEditor(context, filename).putInt(key, value).commit();
    }

    public static boolean setShare(Context context, String key, long value) {
        return getEditor(context, null).putLong(key, value).commit();
    }

    public static boolean setShare(Context context, String filename, String key, long value) {
        return getEditor(context, filename).putLong(key, value).commit();
    }

    public static boolean setShare(Context context, String key, String value) {
        return getEditor(context, null).putString(key, value).commit();
    }

    public static boolean setShare(Context context, String filename, String key, String value) {
        return getEditor(context, filename).putString(key, value).commit();
    }

    public static void removeShare(Context context, String key) {
        getEditor(context, null).remove(key).commit();
    }

    public static void removeShare(Context context, String filename, String key) {
        getEditor(context, filename).remove(key).commit();
    }
}
