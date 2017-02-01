package com.minifit.stock.common;

import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.minifit.stock.util.SessionUtil;
import com.minifit.stock.vo.common.Result;

public class ControllerAop {
  private static Logger log = LoggerFactory.getLogger(ControllerAop.class);

  @Pointcut("execution(public * com.minifit.stock.controller.*.*(..))")
  public void controllerMethod() {}

  @Around("controllerMethod()")
  public Object controllerAround(ProceedingJoinPoint joinPoint) throws Throwable {
    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
    String className = joinPoint.getTarget().getClass().getSimpleName();
    String methodName = joinPoint.getSignature().getName();
    Object[] parameters = joinPoint.getArgs();

    String scheme = request.getScheme();
    String addr = request.getRemoteAddr();
    String path = request.getServletPath();

    log.info("-------------------------------CALL S-------------------------------");
    log.info("// Request = {} : //{}, Action = {}", scheme, addr, path);
    if (parameters != null) {

    }

    // Cache 관련 설정
    response.setHeader("cache-control", "no-store, no-cache, must-revalidate");
    response.setHeader("expires", "0");
    response.setHeader("pragma", "no-cache");

    SessionUtil sessionUtil = new SessionUtil();

    // Session 제외 페이지에 대한 처리
    List<String> sessionBanList = Arrays.asList("/login/main.do", "/login/ajaxLogin.do");
    if (!sessionBanList.contains(path)) {
      if (!sessionUtil.isLoggedIn(request)) {
        log.info("// Session False");
        log.info("-------------------------------CALL E-------------------------------");

        if (path.indexOf("ajax") != -1) {
          return "{\"session\":false}";
        }

        String url = request.getRequestURI();
        if (!StringUtils.isEmpty(request.getQueryString())) {
          url = url + "?" + request.getQueryString();
        }
        String returnUrl = "redirect:/login/main.do?returnUrl=" + URLEncoder.encode(url, "UTF-8");

        return new ModelAndView(returnUrl);
      }
    }

    // Session이 있는 상태에서의 로그인 페이지
    if (sessionUtil.isLoggedIn(request) && "/login/main.do".equals(path)) {
      log.info("// Session True Login Page");
      log.info("-------------------------------CALL E-------------------------------");
      return new ModelAndView("redirect:/dashboard/main.do");
    }

    // 걸린 시간을 측정하기 위해서 추가
    long startTime = System.nanoTime();

    Object returnVal = null;
    try {
      returnVal = joinPoint.proceed();
    } catch (Exception e) {
      Result result = new Result(false, e.getMessage());
      returnVal = result;
    }

    long durationTime = System.nanoTime() - startTime;

    log.info("// ClassName : {}, MethodName : {}, TimeOut : {}ms", className, methodName, (durationTime / 1000000.0));
    log.info("-------------------------------CALL E-------------------------------");
    return returnVal;
  }

  @Around("excelControllerMethod()")
  public Object excelControllerAround(ProceedingJoinPoint joinPoint) throws Throwable {
    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();

    String fileName = request.getParameter("fileName");

    response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".xls");
    response.setHeader("Content-Description", "JSP Generated Data");

    log.info("-------------------------------EXCEL S-------------------------------");
    log.info("// fileName = {} :", fileName);

    Object returnVal = null;
    returnVal = joinPoint.proceed();

    log.info("-------------------------------EXCEL E-------------------------------");

    return returnVal;
  }
}
