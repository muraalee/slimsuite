<%@include file="jsp/common/_include-tags.jsp" %>
<c:if test="${not empty email}">
    <% response.sendRedirect("/home"); %>
</c:if>
<c:if test="${empty email}">
    <% response.sendRedirect("/public"); %>
</c:if>
