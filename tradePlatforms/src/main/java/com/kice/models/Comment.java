package com.kice.models;

import java.util.Date;

public class Comment {
    private int commentID; // 评论ID
    private User user; // 发表评论用户
    private Product product; // 评论所属商品
    private int commentContent; // 评论内容
    private int commentParentID; // 评论父ID
    private int commentLikeCount; // 评论点赞数量
    private Date commentDate; // 评论日期

    public Comment() {
    }

    public Comment(int commentID, User user, Product product, int commentContent, int commentParentID, int commentLikeCount, Date commentDate) {
        this.commentID = commentID;
        this.user = user;
        this.product = product;
        this.commentContent = commentContent;
        this.commentParentID = commentParentID;
        this.commentLikeCount = commentLikeCount;
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

    public int getCommentParentID() {
        return commentParentID;
    }

    public void setCommentParentID(int commentParentID) {
        this.commentParentID = commentParentID;
    }

    public int getCommentLikeCount() {
        return commentLikeCount;
    }

    public void setCommentLikeCount(int commentLikeCount) {
        this.commentLikeCount = commentLikeCount;
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
                ", commentParentID=" + commentParentID +
                ", commentLikeCount=" + commentLikeCount +
                ", commentDate=" + commentDate +
                '}';
    }
}
