package com.human.jeungsangdiary.member;

import java.util.ArrayList;
import java.util.Collections;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberApiController {

    @Autowired
    MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<?> joinUs(@Valid JoinRequest req
                                    , BindingResult bindingResult) {

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        List<Map<String, String>> errorMessages = new ArrayList<>();
        
        // 비밀번호 확인 불일치 처리
        if (!req.getPassword().equals(req.getPasswordCheck())) {
            // 비밀번호와 비밀번호 확인이 일치하지 않는 경우 에러 처리
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("field", "passwordCheck");
            errorMessage.put("message", "비밀번호가 일치하지 않습니다.");
            errorMessages.add(errorMessage);
        }
        
        // 이메일 또는 사용자 이름이 중복되었을 때의 처리
        boolean isEmailExists = memberService.isEmailDuplicate(req.getEmail());
        if (isEmailExists) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("field", "email");
            errorMessage.put("message", "누군가 이미 사용 중인 이메일입니다.");
            errorMessages.add(errorMessage);
        }

        boolean isUsernameExists = memberService.isUsernameDuplicate(req.getUsername());
        if (isUsernameExists) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("field", "username");
            errorMessage.put("message", "누군가 이미 사용 중인 닉네임입니다.");
            errorMessages.add(errorMessage);
        }

        if (bindingResult.hasErrors()) {
            for (FieldError error : fieldErrors) {
                Map<String, String> errorMap = new HashMap<>();
                errorMap.put("field", error.getField());
                errorMap.put("message", error.getDefaultMessage());
                errorMessages.add(errorMap);
            }
        }
        
        if (!errorMessages.isEmpty()) {
            return ResponseEntity.badRequest().body(errorMessages);
        }

        // 회원가입 로직
        memberService.join(req);

        return ResponseEntity.ok("join success");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid LoginRequest req, BindingResult bindingResult, HttpServletRequest httpServletRequest) {
            
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        List<Map<String, String>> errorMessages = new ArrayList<>();

        if (bindingResult.hasErrors()) {
            for (FieldError error : fieldErrors) {
                Map<String, String> errorMap = new HashMap<>();
                errorMap.put("field", error.getField());
                errorMap.put("message", error.getDefaultMessage());
                errorMessages.add(errorMap);
            }
            return ResponseEntity.badRequest().body(errorMessages);
        }

        // 로그인 로직
        MemberVO member = memberService.login(req);

        if (member == null) {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("field", "notmatched");
            errorMap.put("message", "아이디 또는 비밀번호가 맞지 않습니다.");
            errorMessages.add(errorMap);
            return ResponseEntity.badRequest().body(Collections.singletonList(errorMap));
        }
        
        // 기존의 세션 파기
        httpServletRequest.getSession().invalidate();
        // 세션이 없으면 생성
        HttpSession session = httpServletRequest.getSession(true);
        // 세션에 고유 인덱스 추가
        session.setAttribute("memberId", member.getUnqId());
        // 세션 10분동안 유지
        session.setMaxInactiveInterval(1800);
        
        // TODO 룰 할당 로직

        return ResponseEntity.ok(member.getUsername());
    }

}
