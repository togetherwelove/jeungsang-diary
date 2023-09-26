package com.human.jeungsangdiary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.human.jeungsangdiary.member.MemberDAO;
import com.human.jeungsangdiary.member.MemberRoles;
import com.human.jeungsangdiary.member.MemberVO;

@Component
public class AdminTest implements CommandLineRunner {

    @Autowired
    PasswordEncoder PE;

    @Autowired
    MemberDAO memberDAO;

    @Override
    public void run(String... args) throws Exception {
        MemberVO admin = MemberVO.builder()
                                .email("admin")
                                .password(PE.encode("admin"))
                                .username("admin")
                                .role(MemberRoles.ADMIN)
                                .build();
        try {
            memberDAO.insertMember(admin);
            System.out.println(admin.getUsername() + " 계정 생성 됨");
        } catch (Exception e) {
            // 로그인 처리
            System.out.println(admin.getUsername() + " 계정 이미 생성 됨");
        }
    }
}
