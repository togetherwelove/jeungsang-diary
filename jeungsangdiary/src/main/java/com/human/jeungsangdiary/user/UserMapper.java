package com.human.jeungsangdiary.user;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    boolean countByEmail(String email);
    boolean countByUsername(String username);
    void insertUser(UserVO user);
    void insertUserRole(UserVO user);
    void insertUserResidence(UserVO user);
    Optional<UserVO> selectByEmail(String email);
    Optional<UserVO> selectByUnqId(Long unqId);
}
