package com.human.jeungsangdiary.board.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor  // 기본생성자
@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자
public class BoardVO {
    
    private int userId;
    private String title;
    private String content;
    private int hit;
    private LocalDateTime writeDate;
    private LocalDateTime updateDate;

}
