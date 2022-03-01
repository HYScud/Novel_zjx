package com.luyisac.novel_zjx.service.Impl;

import com.luyisac.novel_zjx.entity.Chapter;
import com.luyisac.novel_zjx.mapper.ChapterMapper;
import com.luyisac.novel_zjx.service.IChapterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterService implements IChapterService {
    @Autowired
    private ChapterMapper chapterMapper;
    @Override
    public List<Chapter> getAllChapters(Integer bookId) {
        return chapterMapper.getAllChapters(bookId);
    }

    @Override
    public int updateChapter(Chapter chapter) {
        return chapterMapper.updateChapter(chapter);
    }

    @Override
    public int deleteChapter(Integer chapterId, Integer bookId) {
        return chapterMapper.deleteChapter(chapterId,bookId);
    }

    @Override
    public Chapter getContentByCId(Integer chapterId, Integer bookId) {
        return chapterMapper.getContentByCId(chapterId,bookId);
    }

    @Override
    public List<Chapter> getContent(Integer bookId) {
        return chapterMapper.getContent(bookId);
    }
}
