package xyz.sziit.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

/**
 * 获得屏幕相关的辅助类 
 * @author Administrator
 *
 */
public class ScreenUtils {

    private ScreenUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 获得屏幕高度 
     *
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context) {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();

        manager.getDefaultDisplay().getMetrics(metrics);

        return metrics.widthPixels;
    }

    /**
     * 获得屏幕宽度 
     *
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context) {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();

        manager.getDefaultDisplay().getMetrics(metrics);

        return metrics.heightPixels;
    }

    /**
     * 获得状态栏的高度 
     *
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        int statusHeight = -1;

        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height").get(object).toString());
            statusHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return statusHeight;
    }

    /**
     * 获取navigation bar的高度（注意：应该在页面可见是调用）
     *
     * @param context   Context
     * @return navigation bar的高度，失败返回0
     */
    public static int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height",
                "dimen", "android");

        int height = resources.getDimensionPixelSize(resourceId);
        if (height <= 0) height = 0;

        return height;
    }

    /**
     * 获取当前屏幕截图，包含状态栏 
     *
     * @param activity
     * @return
     */
    public static Bitmap snapShotWithStatusBar(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();

        int width = getScreenWidth(activity);
        int height = getScreenHeight(activity);
        Bitmap bmp = view.getDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(bmp, 0, 0, width, height);
        view.destroyDrawingCache();

        return bitmap;
    }

    /**
     * 获取当前屏幕截图，不包含状态栏 
     *
     * @param activity
     * @return
     */
    public static Bitmap snapShotWithoutStatusBar(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();

        Bitmap bmp = view.getDrawingCache();
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;

        int width = getScreenWidth(activity);
        int height = getScreenHeight(activity);
        Bitmap bitmap = Bitmap.createBitmap(bmp, 0, statusBarHeight, width, height - statusBarHeight);
        view.destroyDrawingCache();

        return bitmap;
    }
}
