package com.zhbit.scratch.controller;

import com.zhbit.scratch.base.RestResponse;
import com.zhbit.scratch.base.RestResponseStatus;
import com.zhbit.scratch.domain.result.GetCodeResult;
import com.zhbit.scratch.service.MailRegisterService;
import com.zhbit.scratch.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.Map;

@RestController
@RequestMapping
public class MailRegisterController {

    private static final String MAIL_REGISTER_URL = "/api/register";
    private static final String MAIL_VERIFICATION_CODE_URL = "/api/getCode";

    @Autowired
    MailRegisterService mailRegisterService;
    @Autowired
    SendMailService sendMailService;

    @RequestMapping(value = MAIL_REGISTER_URL, method = RequestMethod.POST)
    public <T> RestResponse<T> register(@RequestBody Map<String, String> map) {
        String email = map.get("email");
        String password = map.get("password");
        String role = map.get("role");
        mailRegisterService.register(email, password, role);

        return new RestResponse<>(RestResponseStatus.SUCCESS);
    }

    @RequestMapping(value = MAIL_VERIFICATION_CODE_URL, method = RequestMethod.POST)
    public RestResponse<GetCodeResult> getCode(@RequestParam String email) throws MessagingException {
        GetCodeResult result = null;
        String emailMsg = "HELLO WORD!";
        if (!email.isEmpty()) {
            result = sendMailService.sendMail(email, emailMsg);
        }
        return new RestResponse<>(RestResponseStatus.SUCCESS ,result);
    }
}