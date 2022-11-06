package com.service;

import com.dao.BookMapper;
import com.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//service调dao层
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public BookMapper getBookMapper() {
        return bookMapper;
    }

    public Integer addBook(Books books) {
        return bookMapper.addBook(books);
    }

    public Integer deleteBook(Integer id) {
        return bookMapper.deleteBook(id);
    }

    public Integer updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    public Books queryBookById(Integer id) {
        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    @Override
    public Books queryBookByBookName(String bookName) {
        return bookMapper.queryBookByBookName(bookName);
    }
}
