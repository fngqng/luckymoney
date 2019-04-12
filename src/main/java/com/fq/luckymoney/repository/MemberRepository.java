package com.fq.luckymoney.repository;

import com.fq.luckymoney.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member,Long>{
}
