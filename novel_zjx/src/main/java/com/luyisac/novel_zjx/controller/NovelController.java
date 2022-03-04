package com.luyisac.novel_zjx.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luyisac.novel_zjx.common.Result;
import com.luyisac.novel_zjx.entity.DTO.NovelPage;
import com.luyisac.novel_zjx.entity.Novel;
import com.luyisac.novel_zjx.entity.User;
import com.luyisac.novel_zjx.enums.ResultEnums;
import com.luyisac.novel_zjx.exception.CommonException;
import com.luyisac.novel_zjx.service.Impl.Novelservice;
import com.luyisac.novel_zjx.service.Impl.UserService;
import com.luyisac.novel_zjx.utils.JwtUtil;
import com.luyisac.novel_zjx.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/novel")
public class NovelController {
    @Autowired
    private Novelservice novelservice;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NovelController.class);

    /**
     * 获取所有小说
     * 待开发分页
     *
     * @return List<Novel>
     */
    @GetMapping("/getAllNovel")
    public Result<PageInfo> getAllNovel(Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageSize == null) {
            throw new CommonException("数值为空");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Novel> novelList = novelservice.getAllNovel();
        System.out.println(pageNum + ":" + pageSize);
        if (!novelList.isEmpty()) {
            PageInfo pageInfo = new PageInfo(novelList);
            return new Result<PageInfo>(ResultEnums.SUCCESS.getCode(), "获取所有小说成功", pageInfo);
        }
        return new Result<>(ResultEnums.DATA_NOT_FOUND.getCode(), "获取失败");
    }

    /**
     * 获取我的所有小说
     *
     * @return List<Novel>
     */
    @GetMapping("/getMyNovel")
    public Result getMyNovel(Integer pageNum, Integer pageSize, Integer userId) {
        if (pageNum == null || pageSize == null||userId==null) {
            throw new CommonException("数值为空");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Novel> novelList;
        String key="novel_getMy_"+userId.toString();
        redisUtil.del(userId.toString());
        if (redisUtil.hasKey(key)) {
            PageInfo pageInfo = (PageInfo) redisUtil.get(key);
            log.info("从redis中取");
            return new Result<>(ResultEnums.SUCCESS.getCode(), "获取我的小说成功", pageInfo);
        } else {
            novelList = novelservice.getMyNovel(userId);
            System.out.println(novelList);
            if (!novelList.isEmpty()) {
                PageInfo pageInfo = new PageInfo(novelList);
                redisUtil.set(key,pageInfo);
                return new Result<>(ResultEnums.SUCCESS.getCode(), "获取我的小说成功", pageInfo);
            }
        }

        return new Result<>(ResultEnums.DATA_NOT_FOUND.getCode(), "获取失败");
    }

    /**
     * 获取搜索小说
     *
     * @param searchText
     * @return List<Novel>
     */
    @GetMapping("/searchNovel")
    public Result<PageInfo> searchNovel(String searchText, Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageSize == null) {
            throw new CommonException("数值为空");
        }
        List<Novel> novelList = novelservice.searchNovel(searchText);
        PageHelper.startPage(pageNum, pageSize);
        if (!novelList.isEmpty()) {
            PageInfo pageInfo = new PageInfo(novelList);
            return new Result<PageInfo>(ResultEnums.SUCCESS.getCode(), "搜索获取小说成功", pageInfo);
        }
        return new Result<>(ResultEnums.DATA_NOT_FOUND.getCode(), "获取失败");
    }

    /**
     * 按类型获取小说
     *
     * @param category
     * @return List<Novel>
     */
    @GetMapping("/getNovelByCategory")
    public Result<PageInfo> getNovelByCategory(String category, Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageSize == null || category == null) {
            throw new CommonException("数值为空");
        }
        List<Novel> novelList = novelservice.getNovelByCategory(category);
        PageHelper.startPage(pageNum, pageSize);
        if (!novelList.isEmpty()) {
            PageInfo pageInfo = new PageInfo(novelList);
            return new Result<PageInfo>(ResultEnums.SUCCESS.getCode(), "按类型获取小说成功", pageInfo);
        }
        return new Result<>(ResultEnums.DATA_NOT_FOUND.getCode(), "获取失败");
    }

    /**
     * 按标签获取小说
     *
     * @param tags
     * @return List<Novel>
     */
    @GetMapping("/getNovelByTag")
    public Result<PageInfo> getNovelByTag(String tags, Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageSize == null || tags == null) {
            throw new CommonException("数值为空");
        }
        List<Novel> novelList = novelservice.getNovelByTag(tags);
        PageHelper.startPage(pageNum, pageSize);
        if (!novelList.isEmpty()) {
            PageInfo pageInfo = new PageInfo(novelList);
            return new Result<>(ResultEnums.SUCCESS.getCode(), "按标签获取小说成功", pageInfo);
        }
        return new Result<>(ResultEnums.DATA_NOT_FOUND.getCode(), "获取失败");
    }

    /**
     * 按小说字数查找
     *
     * @param word
     * @return List<Novel>
     */
    @GetMapping("/getNovelByword")
    public Result<PageInfo> getNovelByword(Integer word, Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageSize == null || word == null) {
            throw new CommonException("数值为空");
        }
        List<Novel> novelList = novelservice.getNovelByword(word);
        PageHelper.startPage(pageNum, pageSize);
        if (!novelList.isEmpty()) {
            PageInfo pageInfo = new PageInfo(novelList);
            return new Result<>(ResultEnums.SUCCESS.getCode(), "按小说字数获取小说成功", pageInfo);
        }
        return new Result<>(ResultEnums.DATA_NOT_FOUND.getCode(), "获取失败");

    }

    /**
     * 按热度查找
     *
     * @return List<Novel>
     */
    @GetMapping("/getNovelByHitsNum")
    public Result<PageInfo> getNovelByHitsNum(Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageSize == null) {
            throw new CommonException("数值为空");
        }
        List<Novel> novelList = novelservice.getNovelByHitsNum();
        PageHelper.startPage(pageNum, pageSize);
        System.out.println(novelList);
        if (!novelList.isEmpty()) {
            PageInfo pageInfo = new PageInfo(novelList);
            return new Result<>(ResultEnums.SUCCESS.getCode(), "按热度获取小说成功", pageInfo);
        }
        return new Result<>(ResultEnums.DATA_NOT_FOUND.getCode(), "获取失败");
    }

    /**
     * 按更新时间查找
     *
     * @return List<Novel>
     */
    @GetMapping("/getNovelByUpdateTime")
    public Result<PageInfo> getNovelByUpdateTime(Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageSize == null) {
            throw new CommonException("数值为空");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Novel> novelList = novelservice.getNovelByUpdateTime();
        if (!novelList.isEmpty()) {
            PageInfo pageInfo = new PageInfo(novelList);
            System.out.println(pageInfo);
            return new Result<>(ResultEnums.SUCCESS.getCode(), "按更新时间获取小说成功", pageInfo);

        }
        return new Result<>(ResultEnums.DATA_NOT_FOUND.getCode(), "获取失败");
    }

    /**
     * 按小说完结状态获取
     *
     * @return
     */
    @GetMapping("/getNovelByStatus")
    public Result<PageInfo> getNovelByStatus(Integer status, Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageSize == null || status == null) {
            throw new CommonException("数值为空");
        }
        List<Novel> novelList = novelservice.getNovelByStatus(status);
        PageHelper.startPage(pageNum, pageSize);
        if (!novelList.isEmpty()) {
            PageInfo pageInfo = new PageInfo(novelList);
            System.out.println(pageInfo);
            return new Result<PageInfo>(ResultEnums.SUCCESS.getCode(), "按小说完结状态获取小说成功", pageInfo);

        }
        return new Result<>(ResultEnums.DATA_NOT_FOUND.getCode(), "获取失败");
    }

    /**
     * 按小说评分状态获取
     *
     * @return
     */
    @GetMapping("/getNovelByRating")
    public Result<PageInfo> getNovelByRating(Integer pageNum, Integer pageSize) {
        List<Novel> novelList = novelservice.getNovelByRating();
        PageHelper.startPage(pageNum, pageSize);
        if (!novelList.isEmpty()) {
            PageInfo pageInfo = new PageInfo(novelList);
            return new Result<>(ResultEnums.SUCCESS.getCode(), "按小说评分状态获取小说成功", pageInfo);
        }
        return new Result<PageInfo>(ResultEnums.ERROR.getCode(), "服务器异常");
    }

    /**
     * 多条件查询
     *
     * @param novelPage
     * @return List<Novel>
     */
    @PostMapping("/getNovelByMultiple")
    public Result<PageInfo> getNovelByMultiple(@RequestBody NovelPage novelPage) {
        PageHelper.startPage(novelPage.getPageNum(), novelPage.getPageSize());
        List<Novel> novelList = novelservice.getNovelByMultiple(novelPage);
        System.out.println(novelList);
        if (!novelList.isEmpty()) {
            PageInfo pageInfo = new PageInfo(novelList);
            return new Result<>(ResultEnums.SUCCESS.getCode(), "多条件获取小说成功", pageInfo);
        }
        return new Result<PageInfo>(ResultEnums.ERROR.getCode(), "服务器异常");
    }

    /**
     * 送月票
     *
     * @param recommend
     * @param httpServletRequest
     * @return Result<Novel>
     */
    @GetMapping("/addRecommend")
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Result<Novel> addRecommend(Integer recommend, Integer novelId, HttpServletRequest httpServletRequest) {
        int userId = Integer.parseInt(JwtUtil.getUserId(httpServletRequest.getHeader("token")));
        int curRecommend = userService.getUserRecommend(userId);
        User user = new User();
        user.setId(userId);
        user.setRecommend(curRecommend);
        if (recommend < curRecommend) {
            int count = userService.editUserInfo(user);
            if (count > 0) {
                int op = novelservice.addRecommend(novelId, recommend);
                if (op > 0) {
                    return new Result<Novel>(ResultEnums.SUCCESS.getCode(), "月票打赏成功");
                } else return new Result<Novel>(ResultEnums.ERROR.getCode(), "服务器异常");
            }
            return new Result<Novel>(ResultEnums.ERROR.getCode(), "服务器异常");
        }
        return new Result<Novel>(ResultEnums.ERROR.getCode(), "月票不足请充值");
    }


}
