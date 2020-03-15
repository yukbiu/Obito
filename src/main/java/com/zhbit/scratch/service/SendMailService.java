package com.zhbit.scratch.service;

import com.zhbit.scratch.domain.result.GetCodeResult;

import javax.mail.MessagingException;

public interface SendMailService {

    GetCodeResult sendMail(String email, String emailMsg) throws MessagingException;
}
