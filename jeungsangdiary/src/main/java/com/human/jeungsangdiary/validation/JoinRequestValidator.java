package com.human.jeungsangdiary.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.human.jeungsangdiary.user.JoinRequest;

@Component
public class JoinRequestValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return JoinRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotBlank.email", "이메일을 입력해주세요.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotBlank.password", "비밀번호를 입력해주세요.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotBlank.username", "닉네임 입력해주세요.");

        JoinRequest joinRequest = (JoinRequest) target;

        if (joinRequest.getEmail() != null && !joinRequest.getEmail().matches("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?")) {
            errors.rejectValue("email", "Pattern.email", "올바른 이메일 형식이 아닙니다.");
        }

        if (joinRequest.getPassword() != null && !joinRequest.getPassword().matches("(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,255}")) {
            errors.rejectValue("password", "Pattern.password", "(a-Z, 0-9) 특수기호 최소 1개 이상");
        }

        if (joinRequest.getUsername() != null && !joinRequest.getUsername().matches("^(?!.*\\.\\.)(?!.*\\.$)[^\\W][\\w.]{4,29}$")) {
            errors.rejectValue("username", "Pattern.username", "(a-Z, 0-9 밑줄 마침표)");
        }
    }
}
