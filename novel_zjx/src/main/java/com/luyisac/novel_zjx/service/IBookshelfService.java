package com.luyisac.novel_zjx.service;

import com.luyisac.novel_zjx.entity.Bookshelf;
import com.luyisac.novel_zjx.entity.Novel;

import java.util.List;

public interface IBookshelfService {
    List<Bookshelf> getBookShelf(int userId);

    int addBookToShelf(Bookshelf bookshelf);

    int addReadBook(int userId, int bookId);

    int deleteBook(int userId, int bookId);

    int updateBookChapter(int userId, int novel_id, int chapter_id);
}
