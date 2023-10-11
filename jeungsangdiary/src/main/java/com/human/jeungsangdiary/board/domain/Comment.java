package com.human.jeungsangdiary.board.domain;

public class Comment {

    private int board_id;
    private int user_id;
    private String content;
    private String WRITE_DATE;
    private int unq_id;

    public int getBoard_id() {
        return this.board_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWRITE_DATE() {
        return this.WRITE_DATE;
    }

    public void setWRITE_DATE(String WRITE_DATE) {
        this.WRITE_DATE = WRITE_DATE;
    }

    public int getUnq_id() {
        return this.unq_id;
    }

    public void setUnq_id(int unq_id) {
        this.unq_id = unq_id;
    }

}
