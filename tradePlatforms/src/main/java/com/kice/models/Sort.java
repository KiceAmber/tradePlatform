package com.kice.models;

public class Sort {
    private int sortID; // 分类ID
    private String sortName; // 分类名称
    private int sortParentID; // 分类父ID

    public Sort() {
    }

    public Sort(int sortID) {
        this.sortID = sortID;
    }

    public Sort(int sortID, String sortName, int sortParentID) {
        this.sortID = sortID;
        this.sortName = sortName;
        this.sortParentID = sortParentID;
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

    public int getSortParentID() {
        return sortParentID;
    }

    public void setSortParentID(int sortParentID) {
        this.sortParentID = sortParentID;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "sortID=" + sortID +
                ", sortName='" + sortName + '\'' +
                ", sortParentID=" + sortParentID +
                '}';
    }
}
