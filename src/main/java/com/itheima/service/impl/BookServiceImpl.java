package com.itheima.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao ;

    @Override
    public Boolean save(Book book) {
        return bookDao.insert(book) > 0  ;
    }

    @Override
    public Boolean updata(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Book book) {
        return bookDao.deleteById(book) > 0 ;
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id) ;
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int PageSize, Book book) {
        IPage<Book> page = new Page<>(currentPage , PageSize) ;
        return bookDao.selectPage(page , null) ;
    }
}
