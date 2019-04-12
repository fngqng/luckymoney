package com.fq.luckymoney.to;


import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author:fngqng github
 * @Description:fngqng1211@gmail.com
 * @Created:2019/4/11 18:00
 **/
public class LuckyMoneyVO {

    private Long id;
    private BigDecimal money;
    private String description;
    @ApiModelProperty("发红包人")
    private Long supplierId;
    @ApiModelProperty("收红包人")
    private Long consumerId;
    private Boolean isReceived;

    public Boolean getIsReceived() {
        return isReceived;
    }

    public void setIsReceived(Boolean received) {
        isReceived = received;
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }


}
