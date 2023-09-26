package com.human.jeungsangdiary.member;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    void insertMember(MemberVO member);
    void insertMemberRole(MemberVO member);
    Long getNextId();
    Optional<MemberVO> findByEmail(String email);
    Optional<MemberVO> findById(Long memberId);
}
