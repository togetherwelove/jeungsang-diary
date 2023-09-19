package com.human.jeungsangdiary.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.human.jeungsangdiary.board.vo.BoardVO;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="boards")
public class BoardEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column
    private int hit;

    public static BoardEntity toSaveEntity(BoardVO boardVO) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setUserId(boardVO.getUserId());
        boardEntity.setTitle(boardVO.getTitle());
        boardEntity.setContent(boardVO.getContent());
        boardEntity.setHit(0);

        return boardEntity;
    }

}
