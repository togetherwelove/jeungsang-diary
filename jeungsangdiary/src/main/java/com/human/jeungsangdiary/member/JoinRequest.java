package com.human.jeungsangdiary.member;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JoinRequest {
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?"
            , message = "올바른 이메일 형식이 아닙니다.")
    @NotBlank(message = "이메일을 입력해주세요.")
    private String email;

    @Pattern (regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,255}"
            , message = "영문과 숫자, 특수기호가 최소 1개 이상 포함, 최소 8자 이상이여야 합니다.")
    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;
    private String passwordCheck;

    @NotBlank(message = "닉네임을 입력해주세요.")
    private String username;

    public MemberVO toEntity(String encodedPassword) {
        return MemberVO.builder()
        .email(this.email)
        .password(encodedPassword)
        .username(this.username)
        .role(MemberRoles.USER)
        .build();
    }
}
