<%@include file="../common/_include-tags.jsp" %>
<script type="text/javascript">
    $(document).ready(function() {
        var homePageAccordion = $("#homePageAccordion");
        homePageAccordion.show();
        homePageAccordion.accordion({
            collapsible:true,
            header: "h2",
            clearStyle: true,
            autoHeight: true,
            animated: 'bounceslide',
            icons: {
                header: "normal_arrow",
                headerSelected: "circle_arrow_down"
            }
        });
        homePageAccordion.accordion('activate', "-1");
    });
</script>

<div class="contentWrap">
    <div style="clear:both;"></div>
    
    <c:if test="${not empty error}">Oops something went wrong. Please retry it later.</c:if>
    
    <small>${error}</small>

    <div id="homePageAccordion" style="width:600px">
        <h2>
            <table>
                <tr>
                    <td style="vertical-align:middle"><img src="/images/home/upload.png"/></td>
                    <td style="vertical-align:middle"> Upload</td>
                </tr>
            </table>
        </h2>
        <div><a href="/upload" class='link'>File Uploader Example</a></div>
    </div>

</div>
