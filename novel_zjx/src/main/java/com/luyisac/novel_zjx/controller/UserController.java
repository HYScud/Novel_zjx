package com.luyisac.novel_zjx.controller;

import com.alibaba.fastjson.JSONObject;
import com.luyisac.novel_zjx.common.Result;
import com.luyisac.novel_zjx.entity.User;
import com.luyisac.novel_zjx.enums.ResultEnums;
import com.luyisac.novel_zjx.service.Impl.UserService;
import com.luyisac.novel_zjx.utils.FastDFSClient;
import com.luyisac.novel_zjx.utils.JwtUtil;
import com.luyisac.novel_zjx.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.util.StringUtil;


import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FastDFSClient fastDFSClient;

    @Value("${image.location}")
    private String location;

    /**
     * 登录
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    public Object Login(@RequestBody User user) throws Exception {
        System.out.println(user);
        JSONObject jsonObject = new JSONObject();
        Result<User> userResult;
        if (StringUtil.isEmpty(user.getUserName()) || StringUtil.isEmpty(user.getPassword())) {
            userResult = new Result<User>(ResultEnums.LOGIN_EMPTY.getCode(), ResultEnums.LOGIN_EMPTY.getMsg());
            jsonObject.put("user", userResult);
            return jsonObject;
        }
        if (userService.login(user.getUserName(),MD5Utils.getMD5Str(user.getPassword())) == null) {
            System.out.println(MD5Utils.getMD5Str(user.getPassword()));
            userResult = new Result<User>(ResultEnums.LOGIN_FAIL.getCode(), ResultEnums.LOGIN_FAIL.getMsg());
            jsonObject.put("user", userResult);
            return jsonObject;
        }
        //生成token
        user.setId(userService.getIdByName(user.getUserName()));
        String token = JwtUtil.sign(user.getId().toString());
        System.out.println(token);
        user = userService.getUserById(user.getId());
        user.setPassword(null);
        userResult = new Result<User>(ResultEnums.SUCCESS.getCode(), ResultEnums.SUCCESS.getMsg(), user);
        jsonObject.put("token", token);
        jsonObject.put("user", userResult);
        return jsonObject;
    }

    /**
     * 注册
     * @param user
     * @return user
     * @throws Exception
     */
    @PostMapping("/register")
    public Result register(@RequestBody User user) throws Exception {
        System.out.println(user);
        User findUser = userService.getUser(user.getUserName());
        System.out.println(findUser);
        if (findUser != null)
            return new Result(ResultEnums.ERROR.getCode(), "用户已注册");
        if (user != null) {
            user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
            System.out.println(user);
            int count = userService.register(user);
            if (count > 0) {
                return new Result(ResultEnums.SUCCESS.getCode(), "注册成功");
            }
            return new Result(ResultEnums.ERROR.getCode(), "服务器异常");
        }
        return new Result(ResultEnums.ERROR.getCode(), "服务器异常");
    }

    /**
     * 检测缓存登录
     * @param httpServletRequest
     * @return
     * @throws Exception
     */
    @GetMapping("/checkLogin")
    public Object checkLogin(HttpServletRequest httpServletRequest) throws Exception {
        return new Result<User>(ResultEnums.ERROR.getCode(), "服务器异常");
    }

    /**
     * 获取用户信息
     * @param httpServletRequest
     * @return user
     */
    @GetMapping("/getUserInfo")
    public Result<User> getUserInfo(HttpServletRequest httpServletRequest){
        int userId= Integer.parseInt(JwtUtil.getUserId(httpServletRequest.getHeader("token")));
        User user = userService.getUserById(userId);
        if(user!=null){
            return new Result<User>(ResultEnums.SUCCESS.getCode(), "获取信息成功",user);
        }
        return new Result<User>(ResultEnums.ERROR.getCode(), "服务器异常");
    }
    /**
     * 编辑用户信息
     * @param user
     * @param httpServletRequest
     * @return
     */
    @PostMapping("/editUserInfo")
    public Result<User> editUserInfo(@RequestBody User user, HttpServletRequest httpServletRequest) {
        int userId= Integer.parseInt(JwtUtil.getUserId(httpServletRequest.getHeader("token")));
        int count = userService.editUserInfo(user);
        if(count>0){
            return new Result<User>(ResultEnums.SUCCESS.getCode(), "修改信息成功");
        }
        return new Result<User>(ResultEnums.ERROR.getCode(), "服务器异常");
    }

    /**
     * 获取月票
     * @param httpServletRequest
     * @return RecNum(int)
     */
    @GetMapping("/getUserRecommend")
    public Result getUserRecommend(HttpServletRequest httpServletRequest){
        int userId= Integer.parseInt(JwtUtil.getUserId(httpServletRequest.getHeader("token")));
        int RecNum = userService.getUserRecommend(userId);
        return new Result(ResultEnums.SUCCESS.getCode(), "获取月票数量成功",RecNum);
    }

    /**
     * 充值月票
     * @param httpServletRequest
     * @return RecNum(int)
     */
    @GetMapping("/addUserRecommend")
    public Result addUserRecommend(HttpServletRequest httpServletRequest,Integer recNum){
        int userId= Integer.parseInt(JwtUtil.getUserId(httpServletRequest.getHeader("token")));
        int count = userService.addUserRecommend(userId,recNum);
        if(count>0){
            return new Result(ResultEnums.SUCCESS.getCode(), "获取月票数量成功",recNum);
        }
        return new Result(ResultEnums.ERROR.getCode(), "充值月票数量成功");
    }

    @PostMapping("/uploadUserAvatarBase64")
    public Result uploadUserAvatar(MultipartFile file) throws Exception {//        获取前端传过来的base的字符串,
        System.out.println("上传文件开始");
        //上传文件到fastdfs
        String url = fastDFSClient.uploadFile(file);
        url = location + url;
        System.out.println(url);
        // 获取缩略图
        String thump = "_80x80.";
        String arr[] = url.split("\\.");
        String thumpurl = arr[0] + thump + arr[1];

        System.out.println("上传文件文件完毕");
        return new Result(ResultEnums.SUCCESS.getCode(), "操作操作成功", thumpurl);
    }
}
