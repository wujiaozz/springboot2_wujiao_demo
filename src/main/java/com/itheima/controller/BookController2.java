package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.controller.utils.R;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController2 {

    @Autowired
    private IBookService iBookService ;
    @Autowired
    private BookService bookService;

    @GetMapping
    public R selectAll(){
        return new R(true , iBookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book){
        return new R(iBookService.save(book)) ;
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(iBookService.updateById(book)) ;
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id){
        return new R(iBookService.removeById(id)) ;
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id){
        return new R(true , iBookService.getById(id)) ;
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable Integer currentPage ,@PathVariable Integer pageSize, Book book){

        IPage<Book> page = iBookService.getPage(currentPage, pageSize , book);
        // 如果前页码纸大于总页码纸, 那么重新执行查询操作, 使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = bookService.getPage((int)page.getPages(), pageSize , book) ;
        }

        return new R(true , page) ;
    }

}
