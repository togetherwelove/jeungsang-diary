package com.human.jeungsangdiary.user;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserVO {
    private Long unqId;
    
    private String email;
    private String password;
    private String username;
    private UserRoles role;
    
    @Builder
    public UserVO(String email, String password, String username, UserRoles role) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.role = role;
    }
}
