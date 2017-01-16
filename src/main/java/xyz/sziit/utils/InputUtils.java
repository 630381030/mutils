package xyz.sziit.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class InputUtils {

    private InputUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 强制隐藏软键盘
     *
     * @param context
     * @param view 操作的View（例如光标在输入框中，点击Button隐藏软键盘，需要将Button传入）
     */
    public static void hideSoftInput(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
