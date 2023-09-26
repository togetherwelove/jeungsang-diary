package com.human.jeungsangdiary.member;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MemberDAO {

    @Autowired
    MemberMapper memberMapper;

    public boolean existsByEmail(String email) {
        return memberMapper.existsByEmail(email);
    }

    public boolean existsByUsername(String username) {
        return memberMapper.existsByUsername(username);
    }

    public Optional<MemberVO> findByEmail(String email) {
        return memberMapper.findByEmail(email);
    }

    @Transactional
    public void insertMember(MemberVO member) {
        memberMapper.insertMember(member);
        memberMapper.insertMemberRole(member);
    }

    public Optional<MemberVO> findById(Long memberId) {
        return memberMapper.findById(memberId);
    }

}
