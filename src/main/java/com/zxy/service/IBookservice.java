package com.zxy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxy.domain.Book;
import org.springframework.stereotype.Service;

@Service
public interface IBookservice extends IService<Book> {
  IPage<Book> getPage(int currentPage,int pageSize);
  IPage<Book> getPage(int currentPage,int pageSize,Book book);
}
