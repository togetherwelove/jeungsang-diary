package com.human.jeungsangdiary.board.vo;

import com.human.jeungsangdiary.board.entity.BoardEntity;

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
public class Board {
    
    private int unqId;
    private int userId;
    private String title;
    private String content;
    private int hit;
    private String writeDate;
    private String updateDate;

    public static Board toBoard(BoardEntity boardEntity) {
        Board board = new Board();
        board.setUserId(boardEntity.getUserId());
        board.setTitle(boardEntity.getTitle());
        board.setContent(boardEntity.getContent());
        board.setHit(boardEntity.getHit());

        return board;
    }

}
