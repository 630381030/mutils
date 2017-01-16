package xyz.sziit.utils;

import android.text.InputFilter;
import android.widget.EditText;

public class EditTextUtils {

    private EditTextUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 设置EditText的光标位置为最后一位
     *
     * @param args EditText对象
     */
    public static void setSelection2End(EditText... args) {
        if (args == null) return;

        for (EditText edt : args) {
            edt.setSelection(edt.length());
        }
    }

    /**
     * 限制EditText的输入最大长度
     *
     * @param edt   EditText
     * @param max   最大长度
     */
    public static void setMaxLength(EditText edt, int max) {
        if (edt == null || max < 0) return;

        edt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(max)});
    }
}
