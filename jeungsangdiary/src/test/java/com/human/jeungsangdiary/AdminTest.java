package com.human.jeungsangdiary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.human.jeungsangdiary.user.UserDAO;
import com.human.jeungsangdiary.user.UserRoles;
import com.human.jeungsangdiary.user.UserVO;

@Component
public class AdminTest implements CommandLineRunner {

    @Autowired
    PasswordEncoder PE;

    @Autowired
    UserDAO userDAO;

    @Override
    public void run(String... args) throws Exception {
        UserVO admin = UserVO.builder()
                                .email("admin")
                                .password(PE.encode("admin"))
                                .username("admin")
                                .role(UserRoles.ADMIN)
                                .build();
        try {
            userDAO.saveUser(admin);
            System.out.println(admin.getUsername() + " 계정 생성 됨");
        } catch (Exception e) {
            // 로그인 처리
            System.out.println(admin.getUsername() + " 계정 이미 생성 됨");
        }
    }
}
