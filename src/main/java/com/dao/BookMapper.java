package com.dao;

import com.pojo.Books;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookMapper {

    /**
     * 增加书
     */

    Integer addBook(Books books);

    /**
     * 删除一本书
     */

    Integer deleteBook(@Param("id") Integer id);
    /**
     * 更新一本书
     */
    Integer updateBook(Books books);

    /**
     * 查询一本书
     */
    Books queryBookById(@Param("id") Integer id);

    /**
     * 查询所有的书
     */

    List<Books> queryAllBook();

    /**
     * 通过书名查询一本书
     */
    Books queryBookByBookName(@Param("bookName") String bookName);

}
