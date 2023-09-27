package com.human.jeungsangdiary.user;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public List<Map<String, String>> getUserInfo(Long userId) {
        DetailVO details = userDAO.getUserDetail(userId);
        ResidenceVO residences = userDAO.getUserResidence(userId);

        List<Object> vos = Arrays.asList(details, residences);
        List<Map<String, String>> result = new ArrayList<>();

        for (Object vo : vos) {
            Map<String, String> map = new HashMap<>();
            if (vo != null) {
                Field[] fields = vo.getClass().getDeclaredFields();

                for (Field field : fields) {
                field.setAccessible(true); // private 필드에 접근 가능하도록 설정
                try {
                    Object value = field.get(vo);
                    if (value != null) { // 값이 null이 아닌 경우만 map에 추가
                        map.put(field.getName(), value.toString());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            result.add(map);
        }
    }
    return result;
    }

    public void join(JoinRequest req) {
        userDAO.saveUser(req.toEntity(PE.encode(req.getPassword())));
    }

    public void update(Long userId, ResidenceVO res, DetailVO det) {
        userDAO.updateUser(userId, res, det);
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

    public boolean isCheckedPassword(Long userId, LoginRequest req) {
        if(userId == null) return false;

        Optional<UserVO> optionalUser = userDAO.findByUnqId(userId);
        UserVO user = optionalUser.get();

        // user의 password와 입력된 password가 일치하지 않으면
        if(!PE.matches(req.getPassword(), user.getPassword())) {
            return false;
        } else {
            return true;
        }
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
