package com.example.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("分页信息类")
public class PageInfo implements Serializable {

    @ApiModelProperty(value = "当前页", required = true, example = "1")
    private Integer currentPage;
    @ApiModelProperty(value = "页面大小", required = true, example = "10")
    private Integer pageSize;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
