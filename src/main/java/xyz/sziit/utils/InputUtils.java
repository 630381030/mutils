package xyz.sziit.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class InputUtils {

    private InputUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 检测字符是否全是空格
     *
     * @param text  检测的字符串
     * @return text为null或length==0或全是空格时返回true，其他情况返回false
     */
    public static boolean isAllSpaces(String text) {
        if (TextUtils.isEmpty(text)) {
            return true;
        }

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                return false;
            }
        }

        return true;
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
