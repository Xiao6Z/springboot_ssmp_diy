package com.zxy;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 分页操作所用到的拦截器
 */
@Configuration
public class MPConfig {

  @Bean
  public MybatisPlusInterceptor mybatisPlusInterceptor(){
    //定义拦截器
    MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
    //添加具体的拦截器
    interceptor.addInnerInterceptor(new PaginationInnerInterceptor());

    return interceptor;

  }
}
