package com.fq.luckymoney;

import com.fq.luckymoney.entity.Mail;
import com.fq.luckymoney.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LuckymoneyApplicationTests {
    @Resource
    MailService mailService;

    @Test
    public void testmy(){
        Mail mail=new Mail("fngqng1211@163.com","hellofngqng","hahahaha");
        mailService.sendSimpleMail(mail);
    }
    @Test
    public void testmy2() throws MessagingException {
        Mail mail=new Mail("fngqng1211@163.com","htmltest","<html>\n<body>\n<h1>\nwelcom fngqng</h1>\n</body>\n</html>");
        mailService.sendHtmlMail(mail);
    }
    @Test
    public void testmy3() throws MessagingException {
        String filePath="C:\\Users\\Administrator\\Desktop\\软件20153班方晴-开题报告及任务书.zip";
        Mail mail=new Mail("fngqng1211@163.com","attachtest","<html>\n<body>\n<h1>\nwelcom fngqng</h1>\n</body>\n</html>");
        mailService.sendAttachmentMail(mail,filePath);
    }
    @Test
    public void testmy4() throws MessagingException {
        String imgPath="E:\\swire-mis-demo\\static\\bg.jpg";
        String imgId="mybg";
        Mail mail=new Mail("fngqng1211@163.com","img.test","<html>\n<body>\n<h1>\nwelcom fngqng" +
                "<img src=\'cid:"+imgId+"\'\\>"+
                "</h1>\n</body>\n</html>");
        mailService.sendPicMail(mail,imgPath,imgId);
    }
    /**
     * 解析模板引擎
     */
    @Resource
    TemplateEngine engine;
    @Test
    public void testmy5() throws MessagingException {
        Context context=new Context();
        context.setVariable("id",1);
        //模板引擎解析内容 第一个参数为模板名称 获取html格式的文本
        String emailContent=engine.process("emailTemplate",context);
        Mail mail=new Mail("fngqng1211@163.com","tmplatetest",emailContent);

        mailService.sendHtmlMail(mail);
    }
    @Test
    public void contextLoads() {
    }

}
