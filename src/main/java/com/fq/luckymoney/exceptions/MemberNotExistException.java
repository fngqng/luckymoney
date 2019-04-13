package com.fq.luckymoney.exceptions;

/**
 * @Author:fngqng github
 * @Description:fngqng1211@gmail.com
 * @Created:2019/4/12 17:06
 **/
public class MemberNotExistException extends RuntimeException {
    private String message;

    public MemberNotExistException() {
        super();
    }

    public MemberNotExistException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
