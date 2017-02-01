<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<title>TRMS 정보통신설비 원격제어시스템</title>
<tiles:insertAttribute name="header" />
</head>
<body>
  <input type="hidden" value="${pageContext.request.contextPath}" id="contextPath" />

  <tiles:insertAttribute name="menu" />
  <tiles:insertAttribute name="content" />
  <tiles:insertAttribute name="footer" />
</body>
</html>