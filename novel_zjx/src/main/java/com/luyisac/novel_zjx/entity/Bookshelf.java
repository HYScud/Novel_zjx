package com.luyisac.novel_zjx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bookshelf implements Serializable {
    private Integer id;//id
    private Integer userId;//用户的id
    private Integer novelId;//小说的id
    private Integer chapterId;//当前已阅读章节的id
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Integer status;//当前书架状态
    private Integer createTime;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Integer updateTime;
}
