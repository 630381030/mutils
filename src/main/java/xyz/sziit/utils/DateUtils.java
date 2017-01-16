package xyz.sziit.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    private DateUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 获取当前的时间
     *
     * @return 当前的时间(String)，格式比如：2017-01-16 10:51:10
     */
    public static String getCurrDate() {
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        String currentTime = sdf.format(dt);
        return currentTime;
    }

    /**
     * 当前时间转Date对象
     *
     * @param str   当前的时间(格式比如：2017-01-16 10:51:10)
     * @return 成功转换返回对应的Date对象，失败返回Null
     */
    public static Date stringToDate(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        Date currentTime;
        try {
            currentTime = sdf.parse(str);
            return currentTime;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
