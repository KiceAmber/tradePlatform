package com.kice.models;

public class Sort {
    private int sortID; // 分类ID
    private String sortName; // 分类名称

    public Sort() {
    }

    public Sort(int sortID) {
        this.sortID = sortID;
    }

    public Sort(int sortID, String sortName) {
        this.sortID = sortID;
        this.sortName = sortName;
    }

    public int getSortID() {
        return sortID;
    }

    public void setSortID(int sortID) {
        this.sortID = sortID;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }


}
