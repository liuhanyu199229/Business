package com.formssi.third.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 是否删除枚举
 */
@Getter
@AllArgsConstructor
public enum IsDeleteEnum {


    FALSE(0, "否"),
    TRUE(1, "是");

    private Integer code;

    private String message;
}
