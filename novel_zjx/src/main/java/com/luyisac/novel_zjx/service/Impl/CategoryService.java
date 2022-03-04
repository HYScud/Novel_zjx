package com.luyisac.novel_zjx.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luyisac.novel_zjx.common.Result;
import com.luyisac.novel_zjx.entity.Category;
import com.luyisac.novel_zjx.enums.ResultEnums;
import com.luyisac.novel_zjx.mapper.CategoryMapper;
import com.luyisac.novel_zjx.service.ICategoryService;
import com.luyisac.novel_zjx.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Result getCategory(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        String key = "category_" + pageNum.toString() + "_" + pageSize.toString();
        List<Category> categoryList;
        if(redisUtil.hasKey(key)){
            PageInfo pageInfo= (PageInfo) redisUtil.get(key);
            return new Result<>(ResultEnums.SUCCESS.getCode(),"从缓存获取分类成功",pageInfo);
        }else {
            categoryList =categoryMapper.getCategory(pageSize,pageNum);
            if(!categoryList.isEmpty()){
                PageInfo pageInfo=new PageInfo<>(categoryList);
                redisUtil.set(key,pageInfo);
                return new Result<>(ResultEnums.SUCCESS.getCode(),"获取分类成功",pageInfo);
            }
            return new Result<>(ResultEnums.ERROR.getCode(),"获取失败");
        }

    }
}
