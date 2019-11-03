package com.example.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "质检类")
public class Quality implements Serializable {

    @ApiModelProperty(value = "质检id", required = false, example = "")
    private Long id;
    @ApiModelProperty(value = "检测结果", required = false, example = "")
    private Integer score;
    @ApiModelProperty(value = "质检描述", required = false, example = "")
    private String quality_desc;
    @ApiModelProperty(value = "产品id", required = false, example = "")
    private Long product_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getQuality_desc() {
        return quality_desc;
    }

    public void setQuality_desc(String quality_desc) {
        this.quality_desc = quality_desc;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }
}
