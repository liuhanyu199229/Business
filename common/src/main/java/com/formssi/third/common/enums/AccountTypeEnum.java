package com.formssi.third.common.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * 账号类型（1官方，2供应商）
 */
@Getter
@AllArgsConstructor
public enum AccountTypeEnum {
    OFFICIAL(1, "官方"),
    SUPPLIER(2, "供应商");

    private Integer code;
    private String message;

    public static String getMessage(Integer value){
        if(null!=value) {
            for (AccountTypeEnum typeEnum : AccountTypeEnum.values()) {
                if (typeEnum.getCode().intValue() == value) {
                    return typeEnum.getMessage();
                }
            }
        }
        return "";
    }
}
