package com.zxy.controller.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class R {
  private Boolean flag;
  private Object data;
  private String msg;

  public R(Boolean flag, String msg) {
    this.flag = flag;
    this.msg = msg;
  }

  public R(Boolean flag, Object data) {
    this.flag = flag;
    this.data = data;
  }

  public R(String msg) {
    this.flag = true;
    this.msg = msg;
  }
}
