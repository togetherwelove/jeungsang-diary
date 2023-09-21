package com.human.jeungsangdiary.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.human.jeungsangdiary.board.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {


}
