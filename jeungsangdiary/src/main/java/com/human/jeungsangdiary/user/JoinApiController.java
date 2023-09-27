package com.human.jeungsangdiary.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.human.jeungsangdiary.validation.JoinRequestValidator;

@RestController
@RequestMapping("/user")
public class JoinApiController {

    @Autowired
    UserService userService;

    @Autowired
    JoinRequestValidator joinRequestValidator;

    @InitBinder
    public void InitBinder(WebDataBinder binder) {
        binder.setValidator(joinRequestValidator);
    }

    public Map<String, String> returnErrorMap(String field, String message) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("field", field);
        errorMap.put("message", message);
        return errorMap;
    }
    
    @PostMapping("/join")
    public ResponseEntity<?> joinUs(@Valid JoinRequest req, BindingResult bindingResult) {

        List<Map<String, String>> errorList = new ArrayList<>();
        
        // 비밀번호 확인 불일치 처리
        boolean isCheckPassword = req.getPassword().equals(req.getPasswordCheck());
        if (!isCheckPassword) {
            String field = "passwordCheck";
            String message = "비밀번호가 일치하지 않습니다.";
            errorList.add(returnErrorMap(field, message));
        }
        
        // 이메일 또는 사용자 이름이 중복되었을 때의 처리
        boolean isEmailExists = userService.isEmailExists(req.getEmail());
        if (isEmailExists) {
            String field = "email";
            String message = "누군가 이미 사용 중인 이메일입니다.";
            errorList.add(returnErrorMap(field, message));
        }
        
        boolean isUsernameExists = userService.isUsernameExists(req.getUsername());
        if (isUsernameExists) {
            String field = "username";
            String message = "누군가 이미 사용 중인 닉네임입니다.";
            errorList.add(returnErrorMap(field, message));
        }
        
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if (bindingResult.hasErrors()) {
            for (FieldError error : fieldErrors) {
                String field = error.getField();
                String message = error.getDefaultMessage();
                errorList.add(returnErrorMap(field, message));
            }
        }

        if (!errorList.isEmpty()) {
            return ResponseEntity.badRequest().body(errorList);
        }

        // 회원가입 로직
        userService.join(req);

        return ResponseEntity.ok("");
    }

}
