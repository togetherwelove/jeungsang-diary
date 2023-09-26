package com.human.jeungsangdiary.member;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    
    @Autowired
    MemberDAO memberDAO;

    @Autowired
    PasswordEncoder PE;

    public boolean isEmailDuplicate(String email) {
        return memberDAO.existsByEmail(email);
    }

    public boolean isUsernameDuplicate(String username) {
        return memberDAO.existsByUsername(username);
    }

    public void join(JoinRequest req) {
        memberDAO.insertMember(req.toEntity(PE.encode(req.getPassword())));
    }

    /**
     *  로그인 기능
     *  화면에서 LoginRequest(email, password)을 입력
     */
    public MemberVO login(LoginRequest req) {
        Optional<MemberVO> optionalMember = memberDAO.findByEmail(req.getEmail());

        // email과 일치하는 member가 없으면
        if (optionalMember.isEmpty()) {
            return null;
        }

        MemberVO member = optionalMember.get();

        // member의 password와 입력된 password가 일치하지 않으면
        if (!PE.matches(req.getPassword(), member.getPassword())) {
            return null;
        }

        return member;
    }

    /**
     * memberId(Long)를 입력
     * 인증, 인가 시 사용
     */
    public MemberVO getLoggedinMember(Long memberId) {
        if(memberId == null) return null;

        Optional<MemberVO> optionalMember = memberDAO.findById(memberId);

        if (optionalMember.isEmpty()) return null;

        return optionalMember.get();
    }

    /**
     * email(String)를 입력
     * 인증, 인가 시 사용
     */
    public MemberVO findByLoginEmail(String email) {
        if(email == null) return null;

        Optional<MemberVO> optionalMember = memberDAO.findByEmail(email);

        if (optionalMember.isEmpty()) return null;

        return optionalMember.get();
    }
}
