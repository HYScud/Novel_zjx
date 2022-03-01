package com.luyisac.novel_zjx.controller;

import com.luyisac.novel_zjx.common.Result;
import com.luyisac.novel_zjx.entity.Comment;
import com.luyisac.novel_zjx.entity.User;
import com.luyisac.novel_zjx.enums.ResultEnums;
import com.luyisac.novel_zjx.service.Impl.CommentService;
import com.luyisac.novel_zjx.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/getComments")
    public Object getComments(Integer bookId){
        List<Comment> commentList = commentService.getComments(bookId);
        if(commentList.isEmpty()){
            return new Result<Comment>(ResultEnums.ERROR.getCode(), "服务器异常");
        }
        return new Result<Comment>(ResultEnums.SUCCESS.getCode(), "获取图书评论成功",commentList);
    }

    @GetMapping("/addComment")
    public Object addComment(HttpServletRequest httpServletRequest, @RequestBody Comment comment){
        int userId= Integer.parseInt(JwtUtil.getUserId(httpServletRequest.getHeader("token")));
        comment.setUserId(userId);
        int count =commentService.addComment(comment);
        if(count>0){
            return new Result(ResultEnums.SUCCESS.getCode(), "评论成功");
        }
        return new Result(ResultEnums.ERROR.getCode(), "服务器异常");
    }

    @GetMapping("/deleteComments")
    public Object deleteComments(HttpServletRequest httpServletRequest){
//        int count =commentService.deleteComments();
        return new Result<User>(ResultEnums.ERROR.getCode(), "服务器异常");
    }

    @GetMapping("/upComment")
    public Object upComments(Integer bookId, Integer userId){
        int count =commentService.upComment(bookId, userId);
        if(count>0){
            return new Result<User>(ResultEnums.SUCCESS.getCode(), "点赞成功");
    }
        return new Result<User>(ResultEnums.ERROR.getCode(), "服务器异常");
    }
    @GetMapping("/downComments")
    public Object downComments(HttpServletRequest httpServletRequest){
        return new Result<User>(ResultEnums.ERROR.getCode(), "服务器异常");
    }
}
