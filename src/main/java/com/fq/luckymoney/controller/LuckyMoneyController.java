package com.fq.luckymoney.controller;

import com.fq.luckymoney.entity.LuckyMoney;
import com.fq.luckymoney.repository.LuckyMoneyRepository;

import com.fq.luckymoney.service.LuckyMoneyService;
import com.fq.luckymoney.to.LuckyMoneyDTO;
import com.fq.luckymoney.to.LuckyMoneyVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LuckyMoneyController {
    @Autowired
    private LuckyMoneyRepository repository;
    @Autowired
    private LuckyMoneyService service;
    @GetMapping("luckyMoneyList")
    @ApiOperation(value = "获取红包列表")
    public List<LuckyMoney> list(){
        return repository.findAll();
    }

    @PostMapping("luckyMoney")
    @ApiOperation(value = "创建红包")
    public LuckyMoneyDTO save(@ModelAttribute("LuckyMoneyVO") LuckyMoneyVO luckyMoneyVO, BindingResult result) throws Exception {
        if (result.hasFieldErrors()){
            throw new RuntimeException();
        }
        return service.save(luckyMoneyVO);
    }
    @GetMapping("luckyMoney/{id}")
    @ApiOperation(value = "根据id查询红包")
    public LuckyMoneyDTO get(@PathVariable Long id){
        LuckyMoney luckyMoney = repository.findById(id).orElse(null);
        return LuckyMoneyDTO.convert(luckyMoney);
    }
    @PutMapping("luckyMoney/{memid}")
    @ApiOperation(value = "收红包",notes = "根据memberid收红包，若红包未指定收取人，则第一个人可收取")
    public LuckyMoneyDTO update(@RequestParam Long luckyMId,@PathVariable Long memid){
      return service.update(luckyMId, memid);
    }
}
