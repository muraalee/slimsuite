<%@include file="../common/_include-tags.jsp" %>
<script type="text/javascript">
    $(function() {
        prepareAlbumView();
    });
</script>
<div class="contentWrap">
    <div class='page-header-text'>${collection.collectionName}</div>
    <div style="clear:both;"></div>
    <div>
        <c:forEach var="photo" items="${photos}">
            <div id="P${photo.key.id}" class="photo-frame">
                <%@include file="../common/photo/_photo-meta.jsp" %>
                <div id="A${photo.key.id}" class="photo-controls">
                    <c:if test="${(not empty email) and (collection.userID ne userID) }">
                        <a href="javascript:addToWorkArea(${photo.key.id})">
                            <img id="F${photo.key.id}" src="/images/add.png" alt="Add to my Workarea"/>
                        </a>
                    </c:if>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
