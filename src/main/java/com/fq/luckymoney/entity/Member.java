package com.fq.luckymoney.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @Author:fngqng github
 * @Description:fngqng1211@gmail.com
 * @Created:2019/4/11 17:54
 **/
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne(fetch =FetchType.LAZY ,mappedBy = "member")
    private Account account;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
