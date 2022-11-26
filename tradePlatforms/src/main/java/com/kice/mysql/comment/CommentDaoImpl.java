package com.kice.mysql.comment;

import com.kice.models.User;
import com.kice.mysql.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentDaoImpl implements CommentDao{

    @Override
    public int postComment(Connection connection) {
        // TODO: 发表评论
        return 1;
    }

    @Override
    public int deleteComment(Connection connection) {
        //TODO: 删除评论
        return 1;
    }
}
