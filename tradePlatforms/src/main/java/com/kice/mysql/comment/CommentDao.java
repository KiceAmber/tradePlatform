package com.kice.mysql.comment;

import java.sql.Connection;

public interface CommentDao {
    /**
     * 发表评论
     */
    int postComment(Connection connection);

    /**
     * 删除评论
     */
    int deleteComment(Connection connection);
}
