<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/jstl/jstl.jsp"%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
	<meta charset="utf-8" />
	<title><spring:message code="Common_Title" /></title>
	<tiles:insertAttribute name="header" />
</head>
<body class="content_sub">
	<input type="hidden" value="${pageContext.request.contextPath}" id="contextPath" />
	<video src="${pageContext.request.contextPath}/video/nyamnyam.mp3" controls id="alarm_pop_sound" style="display:none;"></video>

	<tiles:insertAttribute name="content" />
	<div class="popup_wrap"></div>
	
	<c:if test="${fn:indexOf(requestScope['javax.servlet.forward.request_uri'], 'dashboard') ne -1}">
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/common/base.js?ver=<fmt:formatDate value="${now}" type="both" pattern="yyyyMMddHHmmss"/>"></script>
	</c:if>
</body>
</html>