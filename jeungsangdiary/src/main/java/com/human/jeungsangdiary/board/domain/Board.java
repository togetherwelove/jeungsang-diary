package com.human.jeungsangdiary.board.domain;

import org.springframework.web.multipart.MultipartFile;

public class Board {
    
    private int UNQ_ID;
    private int USER_ID;
    private String title;
    private String content;
    private int hit;
    private String WRITE_DATE;
    private String updateDate;

    private MultipartFile[] files;

    public int getUNQ_ID() {
        return this.UNQ_ID;
    }

    public void setUNQ_ID(int UNQ_ID) {
        this.UNQ_ID = UNQ_ID;
    }

    public int getUSER_ID() {
        return this.USER_ID;
    }

    public void setUSER_ID(int USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getWRITE_DATE() {
        return this.WRITE_DATE;
    }

    public void setWRITE_DATE(String WRITE_DATE) {
        this.WRITE_DATE = WRITE_DATE;
    }

    public int getUnqId() {
        return this.UNQ_ID;
    }
    
    public void setUnqId(int unqId) {
        this.UNQ_ID = unqId;
    }

    public int getUserId() {
        return this.USER_ID;
    }

    public void setUserId(int userId) {
        this.USER_ID = userId;
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
        return this.WRITE_DATE;
    }
    
    public void setWriteDate(String writeDate) {
        this.WRITE_DATE = writeDate;
    }
    
    public String getUpdateDate() {
        return this.updateDate;
    }
    
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
    
    public MultipartFile[] getFiles() {
        return this.files;
    }
    
    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }
    
    
}