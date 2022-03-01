package com.luyisac.novel_zjx.mapper;

import com.luyisac.novel_zjx.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User login(String userName,String password);

    User getUser(String userName);

    int register(User user);


    int editUserInfo(User user);

    int getUserRecommend(int userId);

    Integer getIdByName(String userName);

    User getUserById(Integer id);

    int addUserRecommend(int userId, Integer recNum);
}
