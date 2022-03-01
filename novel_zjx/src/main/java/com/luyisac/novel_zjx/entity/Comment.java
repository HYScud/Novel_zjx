package com.luyisac.novel_zjx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {
    private Integer id;
    private Integer userId;
    private String content;
    private Integer bookId;
    private Integer createTime;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime create_time;
    private Integer status;
    private Integer up;/*支持数*/
    private Integer type;/*评论类型（优质等）*/
}
