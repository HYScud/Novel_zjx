package com.luyisac.novel_zjx.service.Impl;

import com.luyisac.novel_zjx.entity.DTO.NovelPage;
import com.luyisac.novel_zjx.entity.Novel;
import com.luyisac.novel_zjx.mapper.NovelMapper;
import com.luyisac.novel_zjx.service.INovelService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Novelservice implements INovelService {
    @Autowired
    private NovelMapper novelMapper;

    @Override
    public List<Novel> getMyNovel(Integer userId) {
        return novelMapper.getMyNovel(userId);
    }

    @Override
    public List<Novel> searchNovel(String searchText) {
        return novelMapper.searchNovel(searchText);
    }

    @Override
    public List<Novel> getNovelByCategory(String category) {
        return novelMapper.getNovelByCategory(category);
    }

    @Override
    public List<Novel> getNovelByTag(String tags) {
        return novelMapper.getNovelByTag(tags);
    }

    @Override
    public List<Novel> getNovelByword(@Param("word") Integer word) {
        return novelMapper.getNovelByword(word);
    }

    @Override
    public List<Novel> getNovelByHitsNum() {
        return novelMapper.getNovelByHitsNum();
    }

    @Override
    public List<Novel> getNovelByUpdateTime() {
        return novelMapper.getNovelByUpdateTime();
    }

    @Override
    public List<Novel> getNovelByStatus(@Param("status") Integer status) {
        return novelMapper.getNovelByStatus(status);
    }

    @Override
    public List<Novel> getNovelByMultiple(NovelPage novelPage) {
        return novelMapper.getNovelByMultiple(novelPage);
    }

    @Override
    public int addRecommend(Integer novelId, Integer recommend) {
        return novelMapper.addRecommend(novelId,recommend);
    }

    @Override
    public List<Novel> getAllNovel() {
        return novelMapper.getAllNovel();
    }

    @Override
    public List<Novel> getNovelByRating() {
        return novelMapper.getNovelByRating();
    }
}
