package com.fq.luckymoney.entity;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Entity
public class LuckyMoney {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private BigDecimal money;

    private String description;

    /**
     * 是否领取红包
     */
    private Boolean isReceived=false;
    /*
    * 发红包人*/
    @NotNull
    @ManyToOne
    private Member supplier;
    /*收红包人
    * */
    @ManyToOne
    private Member comsumer;

    public LuckyMoney() {
    }

    public Boolean getIsReceived() {
        return isReceived;
    }

    public void setIsReceived(Boolean received) {
        isReceived = received;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Member getComsumer() {
        return comsumer;
    }

    public void setComsumer(Member comsumers) {
        this.comsumer = comsumers;
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

    public Member getSupplier() {
        return supplier;
    }

    public void setSupplier(Member supplier) {
        this.supplier = supplier;
    }


}
