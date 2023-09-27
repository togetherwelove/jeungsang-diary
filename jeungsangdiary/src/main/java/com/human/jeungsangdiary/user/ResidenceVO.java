package com.human.jeungsangdiary.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResidenceVO {
    private String postcode;
    private String address;
    private String detailAddress;
    private String extraAddress;
}
