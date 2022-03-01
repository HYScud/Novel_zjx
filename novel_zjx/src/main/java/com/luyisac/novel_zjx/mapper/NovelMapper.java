package com.luyisac.novel_zjx.mapper;

import com.luyisac.novel_zjx.entity.DTO.NovelPage;
import com.luyisac.novel_zjx.entity.Novel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NovelMapper {

    List<Novel> getMyNovels();

    List<Novel> searchNovel(String searchText);

    List<Novel> getNovelByCategory(String category);

    List<Novel> getNovelByword(@Param("word") Integer word);

    List<Novel> getNovelByTag(String tag);

    List<Novel> getNovelByHitsNum();

    List<Novel> getNovelByUpdateTime();

    List<Novel> getNovelByStatus(@Param("status") Integer status);

    List<Novel> getNovelByMultiple(NovelPage novelPage);

    int addRecommend(Integer novelId, Integer recommend);

    List<Novel> getAllNovel();

    List<Novel> getNovelByRating();
}
