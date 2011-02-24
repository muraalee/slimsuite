<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
    <%@include file="../common/_public-head.jsp" %>
</head>
<body>
<div id="mainContainer">
    <div id="header">
        <c:if test="${empty sessionScope.email}">
            <a href="/public" title="Home"><img src="/images/logo.png" alt="Home"/></a>
        </c:if>
        <c:if test="${not empty sessionScope.email}">
            <a href="/home" title="Home"><img src="/images/logo.png" alt="Home"/></a>
        </c:if>
    </div>
    <div class="outer">
        <div class="inner">
            <div class="float-wrap">
                <div id="content">
                    <jsp:include page="/jsp/${page}.jsp" flush="true"/>
                </div>
                <!-- end centered div -->
                <%@include file="../common/_public-left-nav.jsp" %>
                <!-- end left div -->
                <div class="clear"></div>
            </div>
            <%@include file="../common/_right-nav.jsp" %>
            <!-- end right div -->
            <div class="clear"></div>
        </div>
    </div>
    <div id="footer" class="ui-corner-bottom">
        <a href="/public/aboutUs" class='link'>About Us</a> | <a href="/public/agreement" class='link'>&#169; 2011
        www.innovationem.com All rights reserved</a>
    </div>
</div>
</body>
</html>