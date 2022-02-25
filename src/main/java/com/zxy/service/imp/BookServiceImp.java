package com.zxy.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxy.Dao.BookDao;
import com.zxy.domain.Book;
import com.zxy.service.IBookservice;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImp extends ServiceImpl<BookDao, Book> implements IBookservice {

  @Autowired
  private BookDao bookDao;

  @Override
  public IPage<Book> getPage(int currentPage, int pageSize) {
    IPage page = new Page(currentPage,pageSize);
    return bookDao.selectPage(page,null);

  }

  @Override
  public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
    LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();

    lqw.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
    lqw.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
    lqw.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());

    IPage page = new Page(currentPage,pageSize);
    return bookDao.selectPage(page,lqw);
  }
}
