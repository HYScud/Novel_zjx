package com.luyisac.novel_zjx.service;

import com.luyisac.novel_zjx.entity.DTO.NovelPage;
import com.luyisac.novel_zjx.entity.Novel;

import java.util.List;

public interface INovelService {

    List<Novel> getMyNovel(Integer userId);

    List<Novel> searchNovel(String searchText);

    List<Novel> getNovelByCategory(String category);

    List<Novel> getNovelByTag(String tags);

    List<Novel> getNovelByword(Integer word);

    List<Novel> getNovelByHitsNum();

    List<Novel> getNovelByUpdateTime();

    List<Novel> getNovelByStatus(Integer status);

    List<Novel> getNovelByMultiple(NovelPage novelPage);

    int addRecommend(Integer novelId, Integer recommend);

    List<Novel> getAllNovel();

    List<Novel> getNovelByRating();
}
