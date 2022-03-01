package com.luyisac.novel_zjx.mapper;

import com.luyisac.novel_zjx.entity.Bookshelf;
import com.luyisac.novel_zjx.entity.Novel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookShelfMapper {
    List<Bookshelf> getBookShelf(int userId);

    int addBookToShelf(Bookshelf bookshelf);

    int addReadBook(int userId, int bookId);

    int deleteBook(int userId, int bookId);

    int updateBookChapter(int userId, int novelId, int chapterId);
}
