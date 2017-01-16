package xyz.sziit.utils;

import android.app.Dialog;
import android.os.Handler;

/**
 * Created by Money on 2017/1/13.
 */

public class DialogUtils {

    private DialogUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * dismiss掉Dialog
     *
     * @param dialog        Dialog
     * @param delayTime     延时时间（毫秒）
     */
    public static void dismiss(final Dialog dialog, long delayTime) {
        if (dialog == null || delayTime < 0) return;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (dialog.isShowing()) dialog.dismiss();
            }
        }, delayTime);
    }
}
