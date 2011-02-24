<%@include file="_include-tags.jsp" %>
<title>${title}</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8"/>
<link type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.6/themes/base/jquery-ui.css" rel="stylesheet"/>
<c:if test="${theme eq null}">
    <link type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.5/themes/start/jquery-ui.css" rel="stylesheet"/>
</c:if>
<c:if test="${theme ne null}">
    <link type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.5/themes/${theme}/jquery-ui.css"
          rel="stylesheet"/>
</c:if>
<link href="../../css/site.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.6/jquery-ui.min.js"></script>
<script type="text/javascript" src="../../js/jquery.allplugins.js"></script>
<script type="text/javascript" src="../../js/base64.js"></script>
<script type="text/javascript" src="../../js/photo-functions.js"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $('a.huge-button, a.big-button, a.small-button').hover(function() {
            $(this).addClass('ui-state-hover');
        }, function() {
            $(this).removeClass('ui-state-hover');
        });
        bindConfirmationMessages();
    });
</script>


