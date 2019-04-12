package com.fq.luckymoney.repository;

import com.fq.luckymoney.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
