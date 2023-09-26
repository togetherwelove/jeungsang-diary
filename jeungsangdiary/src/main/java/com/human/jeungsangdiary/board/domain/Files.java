package com.human.jeungsangdiary.board.domain;

public class Files {
    private int BOARD_ID;
    private String ORIGINAL_NAME;
    private String STORED_NAME;
    private int FILE_SIZE;
    private String UPLOAD_DATE;

    public int getBOARD_ID() {
        return this.BOARD_ID;
    }

    public void setBOARD_ID(int boardId) {
        this.BOARD_ID = boardId;
    }

    public String getORIGINAL_NAME() {
        return this.ORIGINAL_NAME;
    }

    public void setORIGINAL_NAME(String originalName) {
        this.ORIGINAL_NAME = originalName;
    }

    public String getSTORED_NAME() {
        return this.STORED_NAME;
    }

    public void setSTORED_NAME(String storedName) {
        this.STORED_NAME = storedName;
    }

    public int getFILE_SIZE() {
        return this.FILE_SIZE;
    }

    public void setFILE_SIZE(int fileSize) {
        this.FILE_SIZE = fileSize;
    }

    public String getUPLOAD_DATE() {
        return this.UPLOAD_DATE;
    }

    public void setUPLOAD_DATE(String writeDate) {
        this.UPLOAD_DATE = writeDate;
    }

}
