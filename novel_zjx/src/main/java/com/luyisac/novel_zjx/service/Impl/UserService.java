package com.luyisac.novel_zjx.service.Impl;

import com.luyisac.novel_zjx.entity.User;
import com.luyisac.novel_zjx.mapper.UserMapper;
import com.luyisac.novel_zjx.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String userName, String password) {
        return userMapper.login(userName,password);
    }

    @Override
    public User getUser(String userName) {
        return userMapper.getUser(userName);
    }

    @Override
    public int register(User user) {
        return userMapper.register(user);
    }



    @Override
    public int editUserInfo(User user) {
        return userMapper.editUserInfo(user);
    }

    @Override
    public int getUserRecommend(int userId) {
        return userMapper.getUserRecommend(userId);
    }

    @Override
    public Integer getIdByName(String userName) {
        return userMapper.getIdByName(userName);
    }

    @Override
    public User getUserById(Integer id) {
        return  userMapper.getUserById(id);
    }

    @Override
    public int addUserRecommend(int userId, Integer recNum) {
        return userMapper.addUserRecommend(userId,recNum);
    }
}
