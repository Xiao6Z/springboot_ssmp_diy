package com.zxy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxy.controller.utils.R;
import com.zxy.domain.Book;
import com.zxy.service.IBookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/books")
public class BookController {

  @Autowired
  private IBookservice bookservice;

  @GetMapping
  public R getAll(){
    return new R(true,bookservice.list());
  }

  @GetMapping("/{id}")
  public R getById(@PathVariable Integer id){
    return new R(true,bookservice.getById(id));
  }

  @PostMapping
  public R add(@RequestBody Book book){
    return new R(true,bookservice.save(book));
  }

  @PutMapping
  public R update(@RequestBody Book book){
    return new R(true,bookservice.updateById(book));
  }

  @DeleteMapping("/{id}")
  public R delete(@PathVariable Integer id){
    return new R(true,bookservice.removeById(id));
  }

  @GetMapping("/{currentPage}/{pageSize}")
  public R getPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize,Book book){

    IPage<Book> page = bookservice.getPage(currentPage,pageSize,book);
    if (currentPage > page.getPages()){
      page = bookservice.getPage((int)page.getPages(),pageSize);
    }
    return new R(true,page);
  }

}
