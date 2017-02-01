<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jstl/jstl.jsp"%>

<header>
    <nav class="topmenu">
        <h1>
            <img src="${pageContext.request.contextPath}/images/s_images/sub_logo.png">
        </h1>
        <ul class="menu">
            <li>
                <span>|</span>
            </li>
            <li>
                <a href="#">파일</a>
                <ul class="dpn">
                    <li id="menu_file_map">
                        <a>맵 열기</a>
                    </li>
                </ul>
            </li>
            <li>
                <span>|</span>
            </li>
            <li>
                <a href="#">환경 설정</a>
                <ul class="dpn">
                    <li id="menu_envsetting_object_identify">
                        <a>객체 식별자 관리</a>
                    </li>
                    <li id="menu_envsetting_organization">
                        <a>조직도 관리</a>
                    </li>
                    <li id="menu_envsetting_user">
                        <a>사용자 관리</a>
                    </li>
                    <li id="menu_envsetting_eventhistory">
                        <a>이벤트 이력 정보</a>
                    </li>
                    <li id="menu_envsetting_aipointhistory">
                        <a>AI 감시이력 정보</a>
                    </li>
                </ul>
            </li>
            <li>
                <span>|</span>
            </li>
            <li>
                <a href="#">도움말</a>
            </li>
            <li>
                <span>|</span>
            </li>
        </ul>
        <input type="hidden" id="userId" value="${ADMIN_SESSION.userId}" />
        <ul class="until">
            <li>
                <p>${ADMIN_SESSION.userName}님</p>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/login/logout.do"><p class="log">로그아웃</p></a>
            </li>
        </ul>
    </nav>
    <nav class="icon">
        <ul>
            <li>
                <p id="icon_map_open">
                    <img src="${pageContext.request.contextPath}/images/s_images/navico02.png">
                </p>
            </li>
            <li>
                <p id="icon_map_refresh">
                    <img src="${pageContext.request.contextPath}/images/s_images/navico03.png">
                </p>
            </li>
            <li>
                <span></span>
            </li>
            <li>
                <select id="icon_node_view_type">
                    <option value="LINK">기본 배치</option>
                    <option value="BUS">버스형</option>
                    <option value="RING">링형</option>
                    <option value="STAR">스타형</option>
                </select>
            </li>
            <li>
                <span></span>
            </li>
            <li>
                <p>
                    <img src="${pageContext.request.contextPath}/images/s_images/navico06.png">
                </p>
            </li>
            <li>
                <p>
                    <img src="${pageContext.request.contextPath}/images/s_images/navico07.png">
                </p>
            </li>
        </ul>
    </nav>
</header>

<script>
    $(function() {
        $('.menu').dropit();
    });
</script>