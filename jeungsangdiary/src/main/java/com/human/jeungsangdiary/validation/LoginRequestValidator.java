package com.human.jeungsangdiary.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.human.jeungsangdiary.user.LoginRequest;

@Component
public class LoginRequestValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return LoginRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotBlank.email", "이메일을 입력해주세요.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotBlank.password", "비밀번호를 입력해주세요.");
    }
    
}
