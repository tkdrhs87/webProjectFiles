package com.minifit.stock.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.minifit.stock.vo.common.UserSession;


@Component
public class SessionUtil {

  public static final String ADMIN_SESSION = "ADMIN_SESSION";

  public void setUserSession(Object object, HttpServletRequest request) {
    int sessionTimeOut = 0;
    String sessionName = "";
    if (object instanceof UserSession) {
      sessionTimeOut = 60 * 30; // 세션 타임아웃 30분으로 설정
      sessionName = ADMIN_SESSION;
    }

    HttpSession httpSession = request.getSession(false);
    if (httpSession != null) {
      httpSession.invalidate();
    }

    httpSession = request.getSession(true);
    httpSession.setAttribute(sessionName, object);
    httpSession.setMaxInactiveInterval(sessionTimeOut);
  }

  public UserSession getAdminSession(HttpServletRequest request) {
    HttpSession httpSession = request.getSession(false);
    if (httpSession == null) {
      return null;
    }

    UserSession userSession = (UserSession) httpSession.getAttribute(ADMIN_SESSION);
    if (userSession == null) {
      return null;
    }

    return userSession;
  }

  public HttpSession getSession(HttpServletRequest request) {
    HttpSession httpSession = request.getSession(false);
    if (httpSession == null) {
      return null;
    }

    return httpSession;
  }

  public boolean isLoggedIn(HttpServletRequest request) {
    HttpSession httpSession = request.getSession(false);
    if (httpSession == null)
      return false;

    UserSession userSession = (UserSession) httpSession.getAttribute(ADMIN_SESSION);
    if (userSession != null)
      return true;

    return false;
  }

  public void removeUserSession(HttpServletRequest request) {
    HttpSession httpSession = request.getSession(false);
    if (httpSession != null)
      httpSession.invalidate();
  }
}
