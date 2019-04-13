package com.fq.luckymoney.exceptions.controller;

import com.fq.luckymoney.exceptions.MemberNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:fngqng github
 * @Description:fngqng1211@gmail.com
 * @Created:2019/4/12 17:15
 **/
@ControllerAdvice
public class CommonExceptionHandler {
    /** 捕获到MemberNotExistException 异常后，将map的信息写到ResponseBody中去
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(MemberNotExistException.class)
    public Map<String,Object> handleException(RuntimeException e){
        Map<String,Object> map=new HashMap<>();
        map.put("code","USER_NOTEXIST");
        map.put("message",e.getMessage());
        return map;
    }

}
