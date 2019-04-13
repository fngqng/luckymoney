package com.fq.luckymoney.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author:fngqng github
 * @Description:fngqng1211@gmail.com
 * @Created:2019/4/12 13:22
 * 邮件
 **/

public class Mail {
    /**
     * 邮件发送方
     */
   private String from="fngqng1211@163.com";
    /**
     * 邮件接受方
     */
    private String to;
    /**
     * 邮件主题
     */
    private String subject;
    /**
     * 邮件内容
     */
    private String content;

    public Mail(String to, String subject, String content) {
        this.to = to;
        this.subject = subject;
        this.content = content;
    }

    public Mail() {
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
