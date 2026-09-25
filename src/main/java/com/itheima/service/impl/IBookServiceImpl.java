package com.itheima.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IBookServiceImpl extends ServiceImpl<BookDao,Book> implements IBookService {

    @Autowired
    private BookDao bookDao ;

    @Override
    public IPage<Book> getPage(int currentPage, int PageSize, Book book) {
        IPage page = new Page(currentPage , PageSize) ;
        return bookDao.selectPage(page , null) ;
    }
}
