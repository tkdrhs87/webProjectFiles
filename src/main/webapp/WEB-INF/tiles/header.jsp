<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jstl/jstl.jsp"%>

<!-- CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/lib/jquery-ui.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/lib/jstree/style.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/lib/dropit.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/lib/jquery.contextMenu.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/lib/notify-metro.css" />

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link href='http://fonts.googleapis.com/css?family=Exo:700' rel='stylesheet' type='text/css'>
<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<!-- JS -->
<!-- Lib -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery-3.1.0.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery.cookie.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jstree.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/dropit.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery.mousewheel.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/d3.v4.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery.contextMenu.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery.form.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/notify.js"></script>

<!-- Custom -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/lib/eventMgmt.js?ver=<fmt:formatDate value="${now}" type="both" pattern="yyyyMMddHHmmss"/>"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/lib/properties.js?ver=<fmt:formatDate value="${now}" type="both" pattern="yyyyMMddHHmmss"/>"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/lib/common.js?ver=<fmt:formatDate value="${now}" type="both" pattern="yyyyMMddHHmmss"/>"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/lib/ajaxCall.js?ver=<fmt:formatDate value="${now}" type="both" pattern="yyyyMMddHHmmss"/>"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/lib/validation.js?ver=<fmt:formatDate value="${now}" type="both" pattern="yyyyMMddHHmmss"/>"></script>