package com.human.jeungsangdiary.board.domain;

public class Board {
    
    private int unqId;
    private int userId;
    private String title;
    private String content;
    private int hit;
    private String writeDate;
    private String updateDate;

    public int getUnqId() {
        return this.unqId;
    }

    public void setUnqId(int unqId) {
        this.unqId = unqId;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getHit() {
        return this.hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public String getWriteDate() {
        return this.writeDate;
    }

    public void setWriteDate(String writeDate) {
        this.writeDate = writeDate;
    }

    public String getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }


}
