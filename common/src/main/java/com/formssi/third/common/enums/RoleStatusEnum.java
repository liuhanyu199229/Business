package com.formssi.third.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author kaigenihao
 * @date 2020-07-03 11:51
 */
@Getter
@AllArgsConstructor
public enum RoleStatusEnum {
    DISABLE(0, "禁用"),
    ENABLE(1, "启用");

    private Integer code;
    private String message;
}
