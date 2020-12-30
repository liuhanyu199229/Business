package com.formssi.third.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Created by Mybatis Generator on 2020/06/12
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BmsBusiness implements Serializable {
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "商户ID")
    private String businessCode;

    @ApiModelProperty(value = "商户名称")
    private String businessName;

    @ApiModelProperty(value = "手机号")
    private String businessMobile;

    @ApiModelProperty(value = "省份编码")
    private String provinceCode;

    @ApiModelProperty(value = "省份名称")
    private String provinceName;

    @ApiModelProperty(value = "城市编码")
    private String cityCode;

    @ApiModelProperty(value = "城市名称")
    private String cityName;

    @ApiModelProperty(value = "区域编码")
    private String districtCode;

    @ApiModelProperty(value = "区域名称")
    private String districtName;

    @ApiModelProperty(value = "详细地址")
    private String detailAddress;

    @ApiModelProperty(value = "商户简介")
    private String description;

    @ApiModelProperty(value = "商户网址")
    private String website;

    @ApiModelProperty(value = "是否删除，0：否，1：是")
    private Integer isDelete;

    @ApiModelProperty(value = "创建人主键")
    private Long createBy;

    @ApiModelProperty(value = "创建人名称")
    private String createName;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改人主键")
    private Long updateBy;

    @ApiModelProperty(value = "修改人名称")
    private String updateName;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", businessCode=").append(businessCode);
        sb.append(", businessName=").append(businessName);
        sb.append(", businessMobile=").append(businessMobile);
        sb.append(", provinceCode=").append(provinceCode);
        sb.append(", provinceName=").append(provinceName);
        sb.append(", cityCode=").append(cityCode);
        sb.append(", cityName=").append(cityName);
        sb.append(", districtCode=").append(districtCode);
        sb.append(", districtName=").append(districtName);
        sb.append(", detailAddress=").append(detailAddress);
        sb.append(", description=").append(description);
        sb.append(", website=").append(website);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createBy=").append(createBy);
        sb.append(", createName=").append(createName);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateName=").append(updateName);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}