package xyz.sziit.utils;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public StringUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 检测字符串是不是数字
     *
     * @param str   字符串
     * @return true 数字，false 不是数字
     */
    public static boolean isNumber(String str) {
        if (TextUtils.isEmpty(str)) return false;

        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);

        return isNum.matches();
    }


    /**
     * 字符串转整数
     *
     * @param str   字符串
     * @return 字符串对应的整数，不能转换的返回0
     */
    public static int getStringValue(String str) {
        boolean bool = isNumber(str);

        return bool ? Integer.parseInt(str) : 0;
    }
}
