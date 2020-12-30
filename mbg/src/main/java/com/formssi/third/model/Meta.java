package com.formssi.third.model;

import io.swagger.annotations.ApiModelProperty;

public class Meta {
    @ApiModelProperty(value = "前端名称")
    private String title;

    @ApiModelProperty(value = "前端图标")
    private String icon;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
