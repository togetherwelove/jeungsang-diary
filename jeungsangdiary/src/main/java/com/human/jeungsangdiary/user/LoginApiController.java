package com.human.jeungsangdiary.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

import com.human.jeungsangdiary.validation.LoginRequestValidator;

@RestController
@RequestMapping("/user")
public class LoginApiController {

    @Autowired
    UserService userService;

    @Autowired
    LoginRequestValidator loginRequestValidator;

    @InitBinder
    public void InitBinder(WebDataBinder binder) {
        binder.setValidator(loginRequestValidator);
    }

    public Map<String, String> returnErrorMap(String field, String message) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("field", field);
        errorMap.put("message", message);
        return errorMap;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid LoginRequest req, BindingResult bindingResult, HttpServletRequest httpServletRequest) {
        
        List<Map<String, String>> errorList = new ArrayList<>();

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        if (bindingResult.hasErrors()) {
            for (FieldError error : fieldErrors) {
                String field = error.getField();
                String message = error.getDefaultMessage();
                errorList.add(returnErrorMap(field, message));
            }
            return ResponseEntity.badRequest().body(errorList);
        }
        
        // 로그인 로직
        UserVO user = userService.login(req);
        
        if (user == null) {
            String field = "notmatched";
            String message = "아이디 또는 비밀번호가 맞지 않습니다.";
            errorList.add(returnErrorMap(field, message));
            return ResponseEntity.badRequest().body(errorList);
        }
        
        // 기존의 세션 파기
        httpServletRequest.getSession().invalidate();
        // 세션이 없으면 생성
        HttpSession session = httpServletRequest.getSession(true);
        // 세션에 고유 인덱스 추가
        session.setAttribute("userId", user.getUnqId());
        // 세션 10분동안 유지
        session.setMaxInactiveInterval(1800);
        
        // TODO 룰 할당 로직

        return ResponseEntity.ok(user.getUsername());
    }
}
