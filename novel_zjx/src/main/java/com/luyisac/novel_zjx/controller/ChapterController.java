package com.luyisac.novel_zjx.controller;

import com.luyisac.novel_zjx.common.Result;
import com.luyisac.novel_zjx.entity.Chapter;
import com.luyisac.novel_zjx.entity.User;
import com.luyisac.novel_zjx.enums.ResultEnums;
import com.luyisac.novel_zjx.service.Impl.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    /**
     * 获取小说目录
     * @param bookId
     * @return List<Chapter>
     * @throws Exception
     */
    @GetMapping("/getAllChapters")
    public Result<Chapter> getAllChapters(Integer bookId) throws Exception {
        List<Chapter> chapterList =chapterService.getAllChapters(bookId);
        if(chapterList.isEmpty()){
            return new Result<>(ResultEnums.ERROR.getCode(), "服务器异常");
        }
        return new Result<>(ResultEnums.SUCCESS.getCode(), "获取小说目录成功",chapterList);
    }

    /**
     * 更新小说
     * @param chapter
     * @return
     * @throws Exception
     */
    @PostMapping("/updateChapter")
    public Result updateChapter(@RequestBody Chapter chapter) throws Exception {
        int count = chapterService.updateChapter(chapter);
        if (count>0){
            return new Result(ResultEnums.SUCCESS.getCode(), "更新小说成功");
        }
        return new Result(ResultEnums.ERROR.getCode(), "服务器异常更新小说失败");
    }

    /**
     * 删除小说章节
     * @param chapterId
     * @param bookId
     * @return
     * @throws Exception
     */
    @GetMapping("/deleteChapter")
    public Object deleteChapter(Integer chapterId,Integer bookId) throws Exception {
        int count = chapterService.deleteChapter(chapterId,bookId);
        if (count>0){
            return new Result(ResultEnums.SUCCESS.getCode(), "删除小说成功");
        }
        return new Result(ResultEnums.ERROR.getCode(), "服务器异常删除小说失败");
    }

    /**
     * 获取某一章小说内容
     * @param chapterId
     * @param bookId
     * @return
     * @throws Exception
     */
    @GetMapping("/getContentByCId")
    public Result getContentByCId(Integer chapterId,Integer bookId) throws Exception {
        Chapter chapter = chapterService.getContentByCId(chapterId,bookId);
        if (chapter!=null){
            return new Result(ResultEnums.SUCCESS.getCode(), "获取章节内容成功",chapter);
        }
        return new Result(ResultEnums.ERROR.getCode(), "服务器异常");
    }

    /**
     * 获取一本小说的所有内容
     * @param bookId
     * @return
     * @throws Exception
     */
    @GetMapping("/getContent")
    public Result getContent(Integer bookId) throws Exception {
        List<Chapter> chapterList= chapterService.getContent(bookId);
        if (!chapterList.isEmpty()){
            return new Result(ResultEnums.SUCCESS.getCode(), "获取小说所有章节内容成功");
        }
        return new Result(ResultEnums.ERROR.getCode(), "服务器异常获取内容小说失败");
    }
}
