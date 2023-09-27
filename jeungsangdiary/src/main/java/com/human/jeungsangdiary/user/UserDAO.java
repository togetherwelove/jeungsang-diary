package com.human.jeungsangdiary.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAO {

    @Autowired
    UserMapper userMapper;

    public boolean isEmailExists(String email) {
        return userMapper.countByEmail(email);
    }

    public boolean isUsernameExists(String username) {
        return userMapper.countByUsername(username);
    }

    public Optional<UserVO> findByEmail(String email) {
        return userMapper.selectByEmail(email);
    }

    public Optional<UserVO> findByUnqId(Long userId) {
        return userMapper.selectByUnqId(userId);
    }

    public DetailVO getUserDetail(Long userId) {
        return userMapper.selectUserDetail(userId);
    }

    public ResidenceVO getUserResidence(Long userId) {
        return userMapper.selectUserResidence(userId);
    }

    @Transactional
    public void saveUser(UserVO user) {
        userMapper.insertUser(user);
        userMapper.insertUserRole(user);
        userMapper.insertUserDetail(user);
        userMapper.insertUserResidence(user);
    }

    @Transactional
    public void updateUser(Long userId, ResidenceVO res, DetailVO det) {
        userMapper.updateUserResidence(userId, res);
        userMapper.updateUserDetail(userId, det);
    }
}
