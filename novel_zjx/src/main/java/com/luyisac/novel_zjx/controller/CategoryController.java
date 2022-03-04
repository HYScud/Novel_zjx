package com.luyisac.novel_zjx.controller;

import com.luyisac.novel_zjx.common.Result;
import com.luyisac.novel_zjx.service.Impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getCategory")
    public Result getCategory(Integer pageSize,Integer pageNum){
        return categoryService.getCategory(pageSize,pageNum);
    }
}
