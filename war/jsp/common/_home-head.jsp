<%@include file="_include-tags.jsp" %>
<title>${title}</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8"/>
<link type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.6/themes/base/jquery-ui.css"
      rel="stylesheet"/>
<%@include file="_switchTheme.jsp" %>
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
        $('#switcher').themeswitcher();
        $('#switcher-button').show();
        $('a.confirmMessage').click(function(e) {
            e.preventDefault();
            var a = $(this);
            var question = a.attr('question') ? a.attr('question') : 'Do you want to delete?';
            var dialog = $('<div>').attr('id', 'formDialog').html("<span style='float:left;vertical-align:middle'><img src='/images/alert_icon.png'></img></span><span style='float:right;vertical-align:middle'>"+ question+ "</span>");
            $('body').append(dialog);
            var wWidth = a.attr('w') ? a.attr('w') : 300;
            var wHeight = a.attr('h') ? a.attr('h') : 175;
            dialog.dialog({
                title: a.attr('title') ? a.attr('title') : 'Confirmation',
                modal: true,
                width:wWidth,
                height:wHeight,
                buttons: {
                    'Yes': function() {
                        $(this).remove();
                        var fnCall = a.attr();
                        if (a.attr("pass"))
                            eval(a.attr("pass"));
                        else
                            window.location = a.attr("href");
                        return false;
                    },
                    'No': function() {
                        $(this).remove();
                    }
                },
                close: function() {
                    $(this).remove();
                }
            });
        });
    });
</script>


