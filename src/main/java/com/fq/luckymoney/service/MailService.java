package com.fq.luckymoney.service;

import com.fq.luckymoney.entity.Mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;


/**
 * @Author:fngqng github
 * @Description:fngqng1211@gmail.com
 * @Created:2019/4/12 13:21
 **/
@Service
public class MailService {

    /**
     * 使用JavaMailSender对象发送简单邮件
     */
    @Autowired
    private JavaMailSender sender;
    public void sendSimpleMail(Mail mail){
        //SimpleMailMessage 简单文本邮件对象
        SimpleMailMessage message=new SimpleMailMessage();
        message.setTo(mail.getTo());
        message.setSubject(mail.getSubject());
        message.setText(mail.getContent());
        message.setFrom(mail.getFrom());
        sender.send(message);
    }

    /**发送html邮件
     * @param mail
     * @throws MessagingException
     */
    public void sendHtmlMail(Mail mail) throws MessagingException {
        //MimeMessage 多类型邮件对象
        MimeMessage message=sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(mail.getTo());
        helper.setSubject(mail.getSubject());
        //转换成html内容
        helper.setText(mail.getContent(),true);
        helper.setFrom(mail.getFrom());
        sender.send(message);
    }

    /**  发送附件邮件
     * @param mail
     * @param filePath
     * @throws MessagingException
     */
    public void sendAttachmentMail(Mail mail,String filePath) throws MessagingException {
        MimeMessage message=sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(mail.getTo());
        helper.setSubject(mail.getSubject());
        //转换成html内容
        helper.setText(mail.getContent(),true);
        helper.setFrom(mail.getFrom());
        //需要添加文件地址filePath  "c:\\a.txt"
        FileSystemResource source=new FileSystemResource(new File(filePath));
        String fileName=source.getFilename();
        helper.addAttachment(fileName,source);
        sender.send(message);
    }


    /**图片邮件
     * @param mail
     * @param imgPath
     * @param imgId
     * @throws MessagingException
     */
    public void sendPicMail(Mail mail,String imgPath,String imgId) throws MessagingException {
        MimeMessage message=sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(mail.getTo());
        helper.setSubject(mail.getSubject());
        //转换成html内容
        helper.setText(mail.getContent(),true);
        helper.setFrom(mail.getFrom());
        //需要添加imgId
        FileSystemResource source=new FileSystemResource(new File(imgPath));
        helper.addInline(imgId,source);
        sender.send(message);
    }
}
