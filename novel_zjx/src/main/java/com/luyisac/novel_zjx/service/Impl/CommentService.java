package com.luyisac.novel_zjx.service.Impl;

import com.luyisac.novel_zjx.entity.Comment;
import com.luyisac.novel_zjx.mapper.CommentMapper;
import com.luyisac.novel_zjx.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getComments(Integer bookId) {
        return commentMapper.getComments(bookId);
    }

    @Override
    public int addComment(Comment comment) {
        return commentMapper.addComment(comment);
    }

    @Override
    public int upComment(Integer bookId, Integer userId) {
        return commentMapper.upComment(bookId,userId);
    }
}
