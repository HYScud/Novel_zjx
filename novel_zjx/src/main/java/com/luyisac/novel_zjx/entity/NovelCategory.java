package com.luyisac.novel_zjx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NovelCategory implements Serializable {
    private Integer id;
    private Integer NovelId;
    private Integer categoryId;
}
