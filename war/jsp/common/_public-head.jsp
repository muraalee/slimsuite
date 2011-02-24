<%@include file="_include-tags.jsp" %>
<title>My Stored Life</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8"/>
<link href="../../css/site.css" rel="stylesheet" type="text/css"/>
<link type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.5/themes/base/jquery-ui.css" rel="stylesheet"/>
<link type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.5/themes/cupertino/jquery-ui.css" rel="stylesheet"/>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.5/jquery-ui.min.js"></script>
<script type="text/javascript" src="../../js/jquery.allplugins.js"></script>
<script type="text/javascript" src="../../js/photo-functions.js"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $('a.big-button,a.small-button').hover(function() {
            $(this).addClass('ui-state-hover');
        }, function() {
            $(this).removeClass('ui-state-hover');
        });
    });
</script>


