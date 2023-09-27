package com.human.jeungsangdiary.user;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    boolean countByEmail(String email);
    boolean countByUsername(String username);
    ResidenceVO selectUserResidence(Long userId);
    DetailVO selectUserDetail(Long userId);
    void insertUser(UserVO user);
    void insertUserRole(UserVO user);
    void insertUserResidence(UserVO user);
    void updateUserResidence(@Param("userId") Long userId, @Param("req") ResidenceVO req);
    void insertUserDetail(UserVO user);
    void updateUserDetail(@Param("userId") Long userId, @Param("req") DetailVO req);
    Optional<UserVO> selectByEmail(String email);
    Optional<UserVO> selectByUnqId(Long unqId);
}
