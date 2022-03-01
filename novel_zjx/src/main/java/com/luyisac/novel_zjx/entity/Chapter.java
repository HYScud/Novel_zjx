package com.luyisac.novel_zjx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chapter implements Serializable {
    private Integer id;
    private Integer novelId;
    private Integer chapterId;
    private String chapterName;
    private String content;
    private Integer contentNum;
    private Integer createTime;
}
