package com.luyisac.novel_zjx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    /*；
    * id,用戶名，用戶，邮箱，密码，性别，
    *省份，城市，国家
    * 头像，介绍，用户状态
    * 登录时间
    * 经验，积分，创建时间，推荐票
    * */
    private Integer id;
    private String userName;
    private String password;
    private Integer sex;
    private String province;
    private String city;
    private String country;

    private String headImgUrl;
    private String introduce;
    private Integer status;
    private Integer loginIp;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Integer loginTime;
    private Long exp;
    private Integer integral;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Integer createTime;
    private Integer recommend;


}
