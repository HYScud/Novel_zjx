package com.luyisac.novel_zjx.mapper;

import com.luyisac.novel_zjx.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {
    List<Comment> getComments(Integer bookId);

    int addComment(Comment comment);
    int upComment(Integer bookId, Integer userId);
}
