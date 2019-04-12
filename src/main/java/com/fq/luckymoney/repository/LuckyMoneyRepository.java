package com.fq.luckymoney.repository;

import com.fq.luckymoney.entity.LuckyMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


public interface LuckyMoneyRepository extends JpaRepository<LuckyMoney,Long> {
}
