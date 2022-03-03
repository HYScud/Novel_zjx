package com.luyisac.novel_zjx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Novel implements Serializable {
    private Integer id;
    private Integer category;
    private String novelName;
    private String author;
    private String pic;
    private String synopsis;
    private String tags;
    private Integer hitsNum;
    private Double rating;
    private Integer rating_count;
    private Integer status;
    private Integer favorites;
    private Integer position;
    /*@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")*/
    private Integer create_time;
    private Integer update_time;
    private Integer hits_day;
    private Integer hits_week;
    private Integer hits_month;
    private Integer words;
    private Integer recommend;
    private Category categorys;
}
