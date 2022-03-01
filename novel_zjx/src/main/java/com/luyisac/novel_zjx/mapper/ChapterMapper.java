package com.luyisac.novel_zjx.mapper;

import com.luyisac.novel_zjx.entity.Chapter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChapterMapper {
    List<Chapter> getAllChapters(Integer bookId);

    int updateChapter(Chapter chapter);

    int deleteChapter(Integer chapterId, Integer bookId);

    Chapter getContentByCId(Integer chapterId, Integer bookId);

    List<Chapter> getContent(Integer bookId);
}
