package com.luyisac.novel_zjx.controller;

import com.luyisac.novel_zjx.common.Result;
import com.luyisac.novel_zjx.entity.Bookshelf;
import com.luyisac.novel_zjx.entity.Novel;
import com.luyisac.novel_zjx.entity.User;
import com.luyisac.novel_zjx.enums.ResultEnums;
import com.luyisac.novel_zjx.service.Impl.BookShelfService;
import com.luyisac.novel_zjx.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/bookShelf")
public class BookShelfController {
    @Autowired
    private BookShelfService bookShelfService;

    /**
     * 获取我的书架的小说
     * @return Bookshelf
     * @throws Exception
     */
    @GetMapping("/getBookShelf")
    public Result<Bookshelf> getBookShelf(Integer userId) throws Exception {
//        int userId =Integer.parseInt(JwtUtil.getUserId(httpServletRequest.getHeader("token")));
        List<Bookshelf> bookShelf = bookShelfService.getBookShelf(userId);
        System.out.println(bookShelf);
        if(bookShelf.isEmpty()) {
            return new Result<Bookshelf>(ResultEnums.ERROR.getCode(), "服务器异常");
        }
        return new Result<Bookshelf>(ResultEnums.SUCCESS.getCode(),"操作成功",bookShelf);
    }

//    /**
//     * 阅读记录成功
//     * @param httpServletRequest
//     * @param bookId
//     * @return
//     * @throws Exception
//     */
//    @PostMapping ("/addReadBook")
//    public Object addReadBook(HttpServletRequest httpServletRequest,Integer bookId) throws Exception {
//        int userId =Integer.parseInt(JwtUtil.getUserId(httpServletRequest.getHeader("token")));
//        int count=bookShelfService.addReadBook(userId,bookId);
//        if (count>0){
//            return new Result<Novel>(ResultEnums.SUCCESS.getCode(), "阅读记录成功");
//        }
//       return new Result<Novel>(ResultEnums.ERROR.getCode(), "服务器异常");
//    }

    /**
     * 书架新增
     * @param httpServletRequest
     * @param bookshelf
     * @return
     * @throws Exception
     */
    @PostMapping ("/addBookToShelf")
    public Object addBookToShelf(HttpServletRequest httpServletRequest,@RequestBody Bookshelf bookshelf) throws Exception {
        int userId =Integer.parseInt(JwtUtil.getUserId(httpServletRequest.getHeader("token")));
        bookshelf.setUserId(userId);
        int count=bookShelfService.addBookToShelf(bookshelf);
        if (count>0){
            return new Result<Novel>(ResultEnums.SUCCESS.getCode(), "添加成功");
        }
        return new Result<Novel>(ResultEnums.ERROR.getCode(), "服务器异常");
    }

    /**
     * 删除书架小说
     * @param httpServletRequest
     * @param bookId
     * @return
     * @throws Exception
     */
    @PostMapping ("/deleteBook")
    public Object deleteBook(HttpServletRequest httpServletRequest,Integer bookId) throws Exception {
        int userId =Integer.parseInt(JwtUtil.getUserId(httpServletRequest.getHeader("token")));
        int count=bookShelfService.deleteBook(userId,bookId);
        if (count>0){
            return new Result<Novel>(ResultEnums.SUCCESS.getCode(), "删除成功");
        }
        return new Result<Novel>(ResultEnums.ERROR.getCode(), "服务器异常");
    }

    /**
     * 更新小说已阅读章节
     * @param httpServletRequest
     * @param bookshelf
     * @return
     * @throws Exception
     */
    @PostMapping ("/updateBookChapter")
    public Object updateBookChapter(HttpServletRequest httpServletRequest,@RequestBody Bookshelf bookshelf) throws Exception {
        int userId =Integer.parseInt(JwtUtil.getUserId(httpServletRequest.getHeader("token")));
        int count=bookShelfService.updateBookChapter(userId,bookshelf.getNovelId(),bookshelf.getChapterId());
        if (count>0){
            return new Result<Novel>(ResultEnums.SUCCESS.getCode(), "更新阅读位置");
        }
        return new Result<Novel>(ResultEnums.ERROR.getCode(), "服务器异常");
    }
}
