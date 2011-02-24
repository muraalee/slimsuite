<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
    <%@include file="../common/_plain-head.jsp" %>
</head>
<body>
<div id="mainContainer">
    <div id="header">
        <a href="/home" title="Home"><img src="/images/logo.png" alt="Home"/></a>
    </div>
    <div class="outer">
        <div class="inner">
            <div class="float-wrap">
                <div id="content">
                    <jsp:include page="/jsp/${page}.jsp" flush="true"/>
                </div>
                <!-- end left div -->
                <div class="clear"></div>
            </div>
            <%@include file="../common/_right-nav.jsp" %>
            <!-- end right div -->
            <div class="clear"></div>
        </div>
    </div>
    <%@include file="../common/_footer.jsp" %>
</div>
</body>
</html>