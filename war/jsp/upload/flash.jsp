<script type="text/javascript">
    var swfu;
    window.onload = function () {
        swfu = new SWFUpload({
            // Backend Settings
            upload_url: "/photoUpload",

            // File Upload Settings
            file_size_limit : "10 MB",
            file_types : "*.jpg;*.png",
            file_types_description : "JPG Images; PNG Image",
            file_upload_limit : 0,

            // Event Handler Settings - these functions as defined in Handlers.js
            // The handlers are not part of SWFUpload but are part of my website and control how
            // my website reacts to the SWFUpload events.
            swfupload_preload_handler : preLoad,
            swfupload_load_failed_handler : loadFailed,
            file_queue_error_handler : fileQueueError,
            file_dialog_complete_handler : fileDialogComplete,
            upload_progress_handler : uploadProgress,
            upload_error_handler : uploadError,
            upload_success_handler : uploadSuccess,
            upload_complete_handler : uploadComplete,

            // Button Settings
            button_image_url : "/swf/images/SmallSpyGlassWithTransperancy_17x18.png",
            button_placeholder_id : "spanButtonPlaceholder",
            button_width: 180,
            button_height: 18,
            button_text : '<span class="button">Select Images <span class="buttonSmall">(2 MB Max)</span></span>',
            button_text_style : '.button { font-family: Helvetica, Arial, sans-serif; font-size: 12pt; } .buttonSmall { font-size: 10pt; }',
            button_text_top_padding: 0,
            button_text_left_padding: 18,
            button_window_mode: SWFUpload.WINDOW_MODE.TRANSPARENT,
            button_cursor: SWFUpload.CURSOR.HAND,

            // Flash Settings
            flash_url : "/swf/swfupload.swf",

            custom_settings : {
                upload_target : "divFileProgressContainer",
                thumbnail_height: 400,
                thumbnail_width: 400,
                thumbnail_quality: 100
            },

            // Debug Settings
            debug: false
        });
    };
</script>
<h2>Flash Multi File upload</h2>


<form>
    <div style="width: 180px; height: 18px; border: solid 1px #7FAAFF; background-color: #C5D9FF; padding: 2px;">
        <span id="spanButtonPlaceholder"></span>
    </div>
</form>

<div id="divFileProgressContainer" style="height: 75px;"></div>
<div id="thumbnails"></div>
