package com.minifit.stock.controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.minifit.stock.service.common.LoginServiceImpl;
import com.minifit.stock.vo.extend.MntUserExtends;

@Controller
@RequestMapping("/login")
public class LoginController {

  @Autowired
  LoginServiceImpl loginServiceImpl;

  @RequestMapping("/main")
  public ModelAndView main(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mv = new ModelAndView("login/main");

    return mv;
  }

  // AJAX

  @RequestMapping("/ajaxLoging")
  public @ResponseBody Object ajaxLogin(HttpServletRequest request, HttpServletResponse response, MntUserExtends mntUserExtends) {
    return loginServiceImpl.getLogin(request, mntUserExtends);
  }
}
