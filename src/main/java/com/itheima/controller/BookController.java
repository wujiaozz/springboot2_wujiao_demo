package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import com.itheima.service.impl.IBookServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController {


    private IBookService iBookService = new IBookServiceImpl();

    @GetMapping
    public List<Book> selectAll(){
        return iBookService.list() ;
    }

    @PostMapping
    public Boolean save(@RequestBody Book book){
        return iBookService.save(book) ;
    }

    @PutMapping
    public Boolean update(@RequestBody Book book){
        return iBookService.updateById(book) ;
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id){
        return iBookService.removeById(id) ;
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Integer id){
        return iBookService.getById(id) ;
    }

    @GetMapping("/{current}/{pageSize}")
    public IPage<Book> getPage(@PathVariable Integer currentPage ,@PathVariable Integer pageSize, Book book){
        return iBookService.getPage(currentPage , pageSize, book) ;
    }

}
