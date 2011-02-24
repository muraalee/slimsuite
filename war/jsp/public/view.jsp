<%@include file="../common/_include-tags.jsp" %>
<script type="text/javascript">
    $(function() {
        prepareAlbumView();
    });
</script>
<div class="contentWrap">
    <div style="clear:both;"></div>
    <div>
        <c:forEach var="photo" items="${photos}">
            <c:if test="${not photo.photoPrivate}">
                <div id="P${photo.key.id}" class="photo-frame">
                    <%@include file="../common/photo/_photo-meta.jsp" %>
                    <div id="A${photo.key.id}" class="photo-controls">
                        <c:if test="${(not empty email)}">
                            <a href="javascript:addToWorkArea(${photo.key.id})">
                                <img id="F${photo.key.id}" src="/images/add.png" alt="Add to my Workarea"/>
                            </a>
                        </c:if>
                    </div>
                </div>
            </c:if>
        </c:forEach>
    </div>
</div>
