package com.luyisac.novel_zjx.service;

import com.luyisac.novel_zjx.entity.Comment;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICommentService {
    List<Comment> getComments(Integer bookId);

    int addComment(Comment comment);

    int upComment(Integer bookId,Integer userId);
}
