<%@include file="../common/_include-tags.jsp" %>

<div class="contentWrap">
    <div style="clear:both;"></div>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#tabs").tabs();
            $("#tabs").show();
        });
    </script>
    <div id="tabs" style="display:none">
        <ul>
            <li><a href="#tabs1">Batch Photo Upload</a></li>
            <li><a href="#tabs2">Simple Photo Upload</a></li>
            <%--<li><a href="#tabs3">Direct Picasa Upload</a></li>--%>
        </ul>
        <div id="tabs1">
            <applet name="jumpLoaderApplet"
                    code="jmaster.jumploader.app.JumpLoaderApplet.class"
                    codebase="jars"
                    archive="mediautil_z.jar,sanselan_z.jar,jumploader_z.jar"
                    width="100%"
                    height="500px"
                    mayscript>
                <param name="uc_sendImageMetadata" value="false">
                <param name="uc_imageEditorEnabled" value="true">
                <param name="uc_useLosslessJpegTransformations" value="true">
                <param name="vc_useNativeFileDialog" value="true"/>
                <param name="vc_xfileDialogFilterString" value="Images|*.bmp;*.gif;*.jpg;*.jpeg;*.png;*.tif;*.tiff"/>
                <param name="vc_disableLocalFileSystem" value="false">

                <param name="vc_mainViewFileTreeViewVisible" value="true"/>
                <param name="vc_mainViewFileListViewVisible" value="true"/>

                <!-- Upload URL, -->
                <param name="uc_uploadUrl" value="/upload/applet/1?email=${email}"/>

                <param name="uc_uploadScaledImages" value="true">
                <param name="uploadScaledImagesNoZip" value="true">

                <!-- name, resolution, quality -->
                <param name="uc_scaledInstanceNames" value="file">
                <param name="uc_scaledInstanceDimensions" value="1600x1200">
                <param name="uc_scaledInstanceQualityFactors" value="900">
                <param name="uc_fileNamePattern" value="^.+\.(?i)((jpg)|(jpe)|(jpeg)|(gif)|(png)|(tif)|(tiff))$">
                <param name="vc_fileNamePattern" value="^.+\.(?i)((jpg)|(jpe)|(jpeg)|(gif)|(png)|(tif)|(tiff))$">

                <!-- this config as true or false does not affected-->
                <param name="uc_imageRotateEnabled" value="false">
                <param name="uc_scaledInstancePreserveMetadata" value="true">
                <param name="uc_deleteTempFilesOnRemove" value="true">
                <!-- Java script events, remove in actual product -->
                <param name="ac_fireUploaderFileStatusChanged" value="true">
            </applet>
        </div>
        <div id="tabs2" style="height:400px">
            <div style="width:90%">
                <form action="/upload/simple" method="post" enctype="multipart/form-data">
                    <b>Simple File Upload:</b> <input type="hidden" name='cmd' value="simpleUpload"/>
                    <input style="display: inline;width:320px" class="text ui-widget-content ui-corner-all" type="file"
                           name="file">
                    <input style="display: inline; width:100px" type="submit" value="Upload"/>
                    <input type="hidden" name="email" value="${email}"/>

                    <div style="color:red">Currently we support only photo size &lt; 1 Mega Bytes (MB)</div>
                </form>
            </div>
        </div>
<%--        <div id="tabs3" style="width:90%;height:90%">
            <iframe src="http://picasaweb.google.com/home" class="iframe" frameborder="0"  width="90%" height="90%" scrolling="yes">
                <p>Your browser does not support iframes.</p>
            </iframe>
        </div>--%>
    </div>

</div>