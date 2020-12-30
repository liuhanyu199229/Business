package com.formssi.third.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author kaigenihao
 * @date 2020-06-03 10:32
 * 帐号启用状态：0->禁用；1->启用
 */
@Getter
@AllArgsConstructor
public enum AccountStatusEnum {
    DISABLE(0, "禁用"),
    ENABLE(1, "启用");

    private Integer code;
    private String message;
}
