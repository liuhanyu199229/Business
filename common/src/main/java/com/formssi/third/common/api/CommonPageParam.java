package com.formssi.third.common.api;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: layne
 * \* Date: 2020/5/26
 * \* Time: 14:10
 * \* Description: 分页请求查询参数
 * \
 */
@Data
public class CommonPageParam {

    @ApiModelProperty(value = "当前页码")
    private Integer pageNum = 1;

    @ApiModelProperty(value = "页码数量")
    private Integer pageSize = 5;
}
