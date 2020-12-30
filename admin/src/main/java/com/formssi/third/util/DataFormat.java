package com.formssi.third.util;

import org.springframework.stereotype.Service;

/**
 * 批量传输数据格式化
 * lhy
 */
@Service
public class DataFormat {

    //private String flag = " |#| ";

    /**
     * 增加间隔符
     * 补齐域长度
     * @param sb
     * @param str
     * @param lr   (Left or Right)
     * @param num
     * @param flag
     */
    public void formatLine(StringBuilder sb, String str, String lr, String num,String flag){

        if(null != str && !"".equals(str.trim())){
            sb.append(StringDeal.buildFillString(lr, str, " ", Integer.parseInt(num))).append(flag);
        }else {
            sb.append(StringDeal.buildFillString(lr, "", " ", Integer.parseInt(num))).append(flag);
        }
    }
}
