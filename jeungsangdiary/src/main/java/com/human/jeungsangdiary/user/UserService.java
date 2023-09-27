package com.human.jeungsangdiary.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    UserDAO userDAO;

    @Autowired
    PasswordEncoder PE;

    public boolean isEmailExists(String email) {
        return userDAO.isEmailExists(email);
    }

    public boolean isUsernameExists(String username) {
        return userDAO.isUsernameExists(username);
    }

    public void join(JoinRequest req) {
        userDAO.saveUser(req.toEntity(PE.encode(req.getPassword())));
    }

    /**
     *  로그인 기능
     *  화면에서 LoginRequest(email, password)을 입력
     */
    public UserVO login(LoginRequest req) {
        Optional<UserVO> optionalUser = userDAO.findByEmail(req.getEmail());

        // email과 일치하는 user가 없으면
        if (optionalUser.isEmpty()) {
            return null;
        }

        UserVO user = optionalUser.get();

        // user의 password와 입력된 password가 일치하지 않으면
        if (!PE.matches(req.getPassword(), user.getPassword())) {
            return null;
        }

        return user;
    }

    /**
     * userId(Long)를 입력
     * 인증, 인가 시 사용
     */
    public UserVO getLoggedinUser(Long userId) {
        if(userId == null) return null;

        Optional<UserVO> optionalUser = userDAO.findByUnqId(userId);

        if (optionalUser.isEmpty()) return null;

        return optionalUser.get();
    }

    /**
     * email(String)를 입력
     * 인증, 인가 시 사용
     */
    public UserVO findByLoginEmail(String email) {
        if(email == null) return null;

        Optional<UserVO> optionalUser = userDAO.findByEmail(email);

        if (optionalUser.isEmpty()) return null;

        return optionalUser.get();
    }
}
