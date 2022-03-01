package com.luyisac.novel_zjx.service.Impl;

import com.luyisac.novel_zjx.entity.Bookshelf;
import com.luyisac.novel_zjx.entity.Novel;
import com.luyisac.novel_zjx.mapper.BookShelfMapper;
import com.luyisac.novel_zjx.service.IBookshelfService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookShelfService implements IBookshelfService {
    @Autowired
    private BookShelfMapper bookShelfMapper;
    @Override
    public List<Bookshelf> getBookShelf(int userId) {
        return bookShelfMapper.getBookShelf(userId);
    }

    @Override
    public int addBookToShelf(Bookshelf bookshelf) {
        return bookShelfMapper.addBookToShelf(bookshelf);
    }

    @Override
    public int addReadBook(int userId, int bookId) {
        return bookShelfMapper.addReadBook(userId,bookId);
    }

    @Override
    public int deleteBook(int userId, int bookId) {
        return bookShelfMapper.deleteBook(userId,bookId);
    }

    @Override
    public int updateBookChapter(int userId, int novelId, int chapterId) {
        return bookShelfMapper.updateBookChapter(userId, novelId, chapterId);
    }
}
