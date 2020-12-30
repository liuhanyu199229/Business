package com.formssi.third.util;

import java.util.Calendar;

public class TimeUtil {

    /**
     * 获取特定时间的 毫秒数
     */
    public static Long getMiol() {
        Calendar ca = Calendar.getInstance();
        //失效的时间
        ca.set(Calendar.HOUR_OF_DAY, 23);
        ca.set(Calendar.MINUTE, 59);
        ca.set(Calendar.SECOND, 59);
        long millis = ca.getTimeInMillis();
        return millis;
    }
}
