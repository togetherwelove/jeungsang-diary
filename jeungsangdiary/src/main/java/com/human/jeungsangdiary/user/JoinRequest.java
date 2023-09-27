package com.human.jeungsangdiary.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JoinRequest {
    private String email;
    private String password;
    private String passwordCheck;
    
    private String username;

    public UserVO toEntity(String encodedPassword) {
        return UserVO.builder()
        .email(this.email)
        .password(encodedPassword)
        .username(this.username)
        .role(UserRoles.USER)
        .build();
    }
}
