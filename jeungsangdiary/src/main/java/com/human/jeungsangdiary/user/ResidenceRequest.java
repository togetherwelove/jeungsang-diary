package com.human.jeungsangdiary.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResidenceRequest {
    private Long userId;
    private int postcode;
    private String address;
    private String detailAddress;
    private String extraAddress;
}
