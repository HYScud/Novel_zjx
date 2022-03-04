package com.luyisac.novel_zjx.mapper;

import com.luyisac.novel_zjx.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {
    List<Category> getCategory(Integer pageSize, Integer pageNum);
}
