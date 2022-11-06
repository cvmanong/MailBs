package com.controller;

import com.pojo.Books;
import com.service.BookService;
import com.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    //controller调用service层
    @Autowired
    private BookService bookService;

    /**
     * 查询所有的的书籍
     */
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }

    /**
     *
     * 添加书籍
     */
    @RequestMapping("/toAddBook")
    public String toAddBook(){
        return "addBook";
    }

    /**
     * 接收添加的书籍
     */
    @RequestMapping("/addBook")
    public String addBook(Books books){
        bookService.addBook(books);
        return "redirect:/allBook";
    }

    /**
     * 修改书籍
     */
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, int id) {
        Books books = bookService.queryBookById(id);
        System.out.println(books);
        model.addAttribute("book",books );
        return "updateBook";
    }
    @RequestMapping("/updateBook")
    public String updateBook(Model model, Books book) {
        System.out.println(book);
        bookService.updateBook(book);
        Books books = bookService.queryBookById(book.getBookID());
        model.addAttribute("books", books);
        return "redirect:/allBook";
    }

    @RequestMapping("/del/{bookId}")
    public String del(@PathVariable("bookId") int id){
        bookService.deleteBook(id);
        return "redirect:/allBook";
    }

    /**
     * 查询一本书籍
     */
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        Books books = bookService.queryBookByBookName(queryBookName);
        List<Books> list=new ArrayList<Books>();
        list.add(books);
        model.addAttribute("list", list);
        return "allBook";
    }

}
