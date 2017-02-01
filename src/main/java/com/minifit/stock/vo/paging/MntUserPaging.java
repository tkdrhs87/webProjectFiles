package com.minifit.stock.vo.paging;

import java.util.List;

import com.minifit.stock.vo.common.Paging;
import com.minifit.stock.vo.extend.MntUserExtends;

public class MntUserPaging extends Paging {

  private List<MntUserExtends> list;

  public List<MntUserExtends> getList() {
    return list;
  }

  public void setList(List<MntUserExtends> list) {
    this.list = list;
  }
}
