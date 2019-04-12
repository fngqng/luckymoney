package com.fq.luckymoney.service;

import com.fq.luckymoney.entity.Account;
import com.fq.luckymoney.entity.LuckyMoney;
import com.fq.luckymoney.entity.Member;
import com.fq.luckymoney.repository.AccountRepository;
import com.fq.luckymoney.repository.LuckyMoneyRepository;
import com.fq.luckymoney.repository.MemberRepository;
import com.fq.luckymoney.to.LuckyMoneyDTO;
import com.fq.luckymoney.to.LuckyMoneyVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author:fngqng github
 * @Description:fngqng1211@gmail.com
 * @Created:2019/4/11 17:40
 **/
@Service
public class LuckyMoneyService {
    @Autowired
    private LuckyMoneyRepository repository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Transactional
    public LuckyMoneyDTO save(LuckyMoneyVO luckyMoneyVO){
        LuckyMoney entity=new LuckyMoney();
        BeanUtils.copyProperties(luckyMoneyVO,entity);
        Member supplier = memberRepository.findById(luckyMoneyVO.getSupplierId()).orElse(null);
        entity.setSupplier(supplier);
        if (luckyMoneyVO.getConsumerId()!=null){
            Member consumer = memberRepository.findById(luckyMoneyVO.getConsumerId()).orElse(null);
            entity.setComsumer(consumer);
        }
        return LuckyMoneyDTO.convert(repository.save(entity));
    }

    public LuckyMoneyDTO update(Long luckyMId, Long memid) {
        LuckyMoney luckyMoney = repository.findById(luckyMId).orElse(null);
        luckyMoney.setIsReceived(true);
        if (luckyMoney.getComsumer()==null){
            luckyMoney.setComsumer(memberRepository.findById(memid).orElse(null));
            luckyMoney.setIsReceived(true);
            luckyMoney= repository.save(luckyMoney);
        }else if(memid.equals(luckyMoney.getComsumer().getId())){
            Account supplierAcc = luckyMoney.getSupplier().getAccount();
            supplierAcc.setMoney(supplierAcc.getMoney().subtract(luckyMoney.getMoney()));
            Account consumerAcc=luckyMoney.getComsumer().getAccount();
            consumerAcc.setMoney(consumerAcc.getMoney().add(luckyMoney.getMoney()));
            accountRepository.save(supplierAcc);
            accountRepository.save(consumerAcc);
        }else {
            return null;
        }
        return LuckyMoneyDTO.convert(luckyMoney);
    }
}
