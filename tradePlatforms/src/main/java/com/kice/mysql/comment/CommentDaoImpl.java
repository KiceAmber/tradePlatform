package com.kice.mysql.comment;

import java.sql.Connection;

public class CommentDaoImpl implements CommentDao{

    @Override
    public int postComment(Connection connection) {
        // TODO: 发表评论
        return 1;
    }

    @Override
    public int deleteComment(Connection connection) {
        // TODO: 删除评论
        return 1;
    }
}
