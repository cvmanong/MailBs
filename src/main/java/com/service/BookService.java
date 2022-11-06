package com.service;

import com.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {

    /**
     * 增加书
     */

    Integer addBook(Books books);

    /**
     * 删除一本书
     */

    Integer deleteBook(Integer id);
    /**
     * 更新一本书
     */
    Integer updateBook(Books books);

    /**
     * 查询一本书
     */
    Books queryBookById(Integer id);

    /**
     * 查询所有的书
     */

    List<Books> queryAllBook();

    /**
     * 根据书名查询一本书
     */
    Books queryBookByBookName(String bookName);
}
