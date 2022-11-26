package com.kice.models;

import java.util.Date;

public class Comment {
    private int commentID; // 评论ID
    private User user; // 发表评论用户
    private Product product; // 评论所属商品
    private int commentContent; // 评论内容
    private Date commentDate; // 评论日期

    public Comment() {
    }

    public Comment(int commentID, User user, Product product, int commentContent, Date commentDate) {
        this.commentID = commentID;
        this.user = user;
        this.product = product;
        this.commentContent = commentContent;
        this.commentDate = commentDate;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(int commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentID=" + commentID +
                ", user=" + user +
                ", product=" + product +
                ", commentContent=" + commentContent +
                ", commentDate=" + commentDate +
                '}';
    }
}
