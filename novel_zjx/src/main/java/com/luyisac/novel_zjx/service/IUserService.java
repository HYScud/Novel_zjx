package com.luyisac.novel_zjx.service;

import com.luyisac.novel_zjx.entity.User;

public interface IUserService {
    User login(String userName,String password);

    User getUser(String userName);

    int register(User user);


    int editUserInfo(User user);

    int getUserRecommend(int userId);

    Integer getIdByName(String userName);

    User getUserById(Integer id);

    int addUserRecommend(int userId, Integer recNum);
}
