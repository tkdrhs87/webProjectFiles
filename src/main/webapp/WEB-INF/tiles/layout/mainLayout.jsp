<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maxium-scale=1.0, minimum-scale=1.0, user-scalable=no">
<!--화면 너비, 초기확대 비율, 사용자 화면확대가능 여부, 최소축소치, 최대확대치-->
<title>TRMS 정보통신설비 원격제어시스템</title>
<tiles:insertAttribute name="header" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/customDashboard.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/c-table.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/c-groupbox.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/c-notify.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/c-paging.css" />
</head>
<body>
    <input type="hidden" value="${pageContext.request.contextPath}" id="contextPath" />

    <tiles:insertAttribute name="menu" />
    <div class="container">
        <tiles:insertAttribute name="left" />
        <tiles:insertAttribute name="content" />
    </div>
    <tiles:insertAttribute name="footer" />
</body>
</html>