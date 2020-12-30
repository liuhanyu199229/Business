package com.formssi.third.util;

/**
 * @author luowenyan 异常处理工具类
 * // 获取嵌套异常中的最终信息
 * @date 2020-07-20 15:43
 */
public class ExceptionUtil {

    public static String getRealMessage(Throwable e) {
        // 如果e不为空，则去掉外层的异常包装
        while (e != null) {
            Throwable cause = e.getCause();
            if (cause == null) {
                return e.getMessage();
            }
            e = cause;
        }
        return "";
    }
}
