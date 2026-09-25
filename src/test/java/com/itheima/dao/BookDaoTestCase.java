package com.itheima.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookDaoTestCase {
    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById(){
        Book byID = bookDao.getByID(3);
        System.out.println(byID);
    }

    @Test
    void test1(){
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");

        bookDao.insert(book) ;
    }

    @Test
    void test2(){
        Book book = new Book();
        book.setId(14);
        book.setType("测试数据abc");
        book.setName("测试数据abc");
        book.setDescription("测试数据abc");

        bookDao.updateById(book);
    }

    @Test
    void test3(){
        bookDao.deleteById(14) ;
    }


    @Test
    void test4(){
        List<Book> books = bookDao.selectList(null);
        System.out.println(books);
    }

    @Test
    void testGetPage(){
        IPage page = new Page(1,5) ;
        bookDao.selectPage(page , null) ;
    }

    @Test
    void testGetBy(){
      /*  select * from tbl_book where name like %Spring%      */

        QueryWrapper<Book> qw = new QueryWrapper<>() ;
        qw.like("name" , "spring") ;
        bookDao.selectList(qw) ;

    }

    @Test
    void testGetBy2(){
        String name = "Spring" ;

        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>() ;
        /*   if(name != null)   lqw.like(Book::getName , name) ;   */
        lqw.like(name!=null , Book::getName , name) ;

        bookDao.selectList(lqw) ;

    }

    @Autowired
    private IBookService iBookService ;

    @Test
    void testService1(){
        iBookService.getById(4) ;
    }

    @Test
    void testService2(){
        IPage<Book> page = new Page<>(2,5) ;
        iBookService.page(page) ;
    }

    @Test
    void testService3(){

    }

    @Test
    void testService4(){

    }
}
