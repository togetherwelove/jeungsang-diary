package com.human.jeungsangdiary.member;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberVO {
    private Long unqId;
    
    private String email;
    private String password;
    private String username;
    
    private MemberRoles role;
    
    @Builder
    public MemberVO(String email, String password, String username, MemberRoles role) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.role = role;
    }

}
