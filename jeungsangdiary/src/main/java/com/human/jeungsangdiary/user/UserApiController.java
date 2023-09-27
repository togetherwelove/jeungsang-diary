package com.human.jeungsangdiary.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@RestController
@RequestMapping("/user")
public class UserApiController {
    @Autowired
    UserService userService;

    @GetMapping("/detail/info")
    public List<Map<String, String>> detail(@SessionAttribute("userId") Long userId) {
        List<Map<String, String>> userInfo = userService.getUserInfo(userId);
        return userInfo;
    }

    @PostMapping("/detail/confirm")
    public ResponseEntity<?> confirm(@SessionAttribute("userId") Long userId, LoginRequest req) {
        boolean isCheckedPassword = userService.isCheckedPassword(userId, req);

        if (isCheckedPassword) {
            return ResponseEntity.ok().body("비밀번호 확인 성공");
        } else {
            return ResponseEntity.badRequest().body("서버 에러 발생");
        }
    }

    @PutMapping("/detail/update")
    public ResponseEntity<?> update(@SessionAttribute("userId") Long userId, ResidenceVO resRes, DetailVO detRes) {
        try {
            userService.update(userId, resRes, detRes);
            return ResponseEntity.ok().body("회원정보 수정 성공");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("서버 에러 발생");
        }
    }

}
