package com.formssi.third.util;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 格式化日期工具类
 * lhy
 */
@Service
public class DateUtil {
    /**
     * 获取时间
     * @param format 格式 例子：YYYYMMDD
     * @return
     */
    public String getDate(String format){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        String time = dateFormat.format(date);
        return time;
    }
}
