package com.luyisac.novel_zjx.service;

import com.luyisac.novel_zjx.entity.Chapter;

import java.util.List;

public interface IChapterService {
    List<Chapter> getAllChapters(Integer bookId);

    int updateChapter(Chapter chapter);

    int deleteChapter(Integer chapterId, Integer bookId);

    Chapter getContentByCId(Integer chapterId, Integer bookId);

    List<Chapter> getContent(Integer bookId);
}
