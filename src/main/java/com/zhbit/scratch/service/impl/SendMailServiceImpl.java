package com.zhbit.scratch.service.impl;

import com.zhbit.scratch.domain.result.GetCodeResult;
import com.zhbit.scratch.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class SendMailServiceImpl implements SendMailService {
    @Autowired
    private JavaMailSender sender;

    @Value("${spring.mail.username}")
    private String from;

    public GetCodeResult sendMail(String email, String emailMsg) throws MessagingException {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(email);
        helper.setSubject("注册验证");
        helper.setText(emailMsg, true);
        sender.send(message);

        GetCodeResult result = new GetCodeResult();
        result.setEmail(email);
        result.setCode(null);
        return result;
    }
}
