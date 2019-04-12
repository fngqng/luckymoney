package com.fq.luckymoney.to;

import com.fq.luckymoney.entity.LuckyMoney;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

/**
 * @Author:fngqng github
 * @Description:fngqng1211@gmail.com
 * @Created:2019/4/11 18:01
 **/
public class LuckyMoneyDTO {

    private Long id;
    private BigDecimal money;
    private String description;
    private Long supplierId;
    private String supplierName;
    private Long consumerId;
    private String consumerName;
    private Boolean isReceived;



    public static LuckyMoneyDTO convert(LuckyMoney entity){
        LuckyMoneyDTO dto=new LuckyMoneyDTO();
        BeanUtils.copyProperties(entity,dto);
        dto.setSupplierId(entity.getSupplier().getId());
        dto.setSupplierName(entity.getSupplier().getName());
        if (entity.getComsumer()!=null){
            dto.setConsumerId(entity.getComsumer().getId());
            dto.setConsumerName(entity.getComsumer().getName());
        }
        return dto;
    }
    public Boolean getIsReceived() {
        return isReceived;
    }

    public void setIsReceived(Boolean received) {
        isReceived = received;
    }
    public LuckyMoneyDTO() {
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

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }
}
