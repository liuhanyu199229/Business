package com.formssi.third.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 门店营业状体
 */
@Getter
@AllArgsConstructor
public enum ShopStatusEnum {

    FALSE(1, "正常"),
    TRUE(2, "关闭");

    private Integer code;

    private String message;
}
