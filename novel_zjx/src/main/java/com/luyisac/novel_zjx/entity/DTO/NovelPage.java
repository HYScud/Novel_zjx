package com.luyisac.novel_zjx.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NovelPage implements Serializable {
    private String tags;
    private Integer category;
    private Integer hitsNum;
    private Integer words;
    private Double rating;
    private Integer status;
    private Integer pageNum;
    private Integer pageSize;
}
