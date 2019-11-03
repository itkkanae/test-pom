package com.example.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@ApiModel("产品类")
public class Product implements Serializable {

    @ApiModelProperty(value = "产品id", required = false, example = "")
    private Long id;
    @ApiModelProperty(value = "产品名称", required = false, example = "")
    private String product_name;
    @ApiModelProperty(value = "生产日期", required = false, example = "")
    private Date product_date;
    @ApiModelProperty(value = "产品数量", required = false, example = "")
    private Integer product_sum;
    @ApiModelProperty(value = "产品描述", required = false, example = "")
    private String product_desc;
    @ApiModelProperty(value = "产品价格", required = false, example = "")
    private BigDecimal product_price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Date getProduct_date() {
        return product_date;
    }

    public void setProduct_date(Date product_date) {
        this.product_date = product_date;
    }

    public Integer getProduct_sum() {
        return product_sum;
    }

    public void setProduct_sum(Integer product_sum) {
        this.product_sum = product_sum;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }

    public BigDecimal getProduct_price() {
        return product_price;
    }

    public void setProduct_price(BigDecimal product_price) {
        this.product_price = product_price;
    }
}
