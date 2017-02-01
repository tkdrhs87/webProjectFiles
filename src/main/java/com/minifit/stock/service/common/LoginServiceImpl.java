package com.minifit.stock.service.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minifit.stock.dao.base.MntUserMapper;
import com.minifit.stock.vo.common.Result;
import com.minifit.stock.vo.extend.MntUserExtends;

@Service
public class LoginServiceImpl {

  @Autowired
  MntUserMapper mntUserMapper;

  public Result getLogin(HttpServletRequest request, MntUserExtends mntUserExtends) {
    Result result = new Result(false);

    // 서비스 로직 추가

    return result;
  }
}
