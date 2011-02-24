<%@ page isErrorPage="true" %>
<%@include file="common/_include-tags.jsp" %>

<html>
<head><title>My Error Page</title></head>
<body>
<h2>Exception Information</h2>
<table>
    <tr>
        <td>Cause</td>
        <td>${exception}</td>
    </tr>
</table>
</body>
</html>