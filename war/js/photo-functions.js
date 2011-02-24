/** Shows the overlay while doing any time consuming action */
function showOverlay() {
    $('#dvoverlay, #dvmodal').show();
}
function hideOverlay() {
    $('#dvoverlay, #dvmodal').hide();
}

function warningMessage(message) {
    $("#message").text(message).show().fadeOut(5000);
}

function infoMessage(message) {
    $("#message").text(message).show().fadeOut(5000);
}

function bindConfirmationMessages() {
    $('a.confirmMessage').click(function(e) {
        e.preventDefault();
        var a = $(this);
        var question = a.attr('question') ? a.attr('question') : 'Do you want to delete?';
        var dialog = $('<div>').attr('id', 'formDialog').html("<table><tr><td style='vertical-align=middle'><img src='/images/alert_icon.png'></img></td><td style='vertical-align:middle'>" + question + "</td></tr></table>");
        $('body').append(dialog);
        var wWidth = a.attr('w') ? a.attr('w') : 300;
        var wHeight = a.attr('h') ? a.attr('h') : 200;
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
        return false;
    });
}
function openHelp(id) {
    var width = 800;
    var height = 600;
    var left = (screen.width / 2) - (width / 2);
    var top = (screen.height / 2) - (height / 2);
    window.open(
            '/help.html#' + id,
            'Help',
            'resizable=1,scrollbars=1' + ', width = ' + width + ', height=' + height + ', top=' + top + ', left=' + left);
}
function openBuzz(message) {
    window.open(
            "http://www.google.com/buzz/post?" + "message=" + message + "&url=http://www.google.com/buzz",
            "_blank",
            "resizable=0,scrollbars=0,width=690,height=415"
            );
}

function openFacebook(message) {
    window.open(
            "http://www.facebook.com/sharer.php?u=" + message + "&t=PhotoCollection",
            "_blank",
            "resizable=0,scrollbars=0,width=690,height=415"
            );
}

function openNewWindow(url) {
    window.open(
            url,
            "_blank",
            "resizable=0,scrollbars=1,width=1124,height=768"
            );
}

function updateTips(t) {
    var tips = $(".validateTips");
    tips.text(t).addClass('ui-state-highlight');
    setTimeout(function() {
        tips.removeClass('ui-state-highlight', 1500);
    }, 500);
}

function validateForNull(field, value) {
    if (value.val().length == 0) {
        value.addClass('ui-state-error');
        updateTips(field + " can't be empty");
        return false;
    } else {
        return true;
    }
}
function isNull(value) {
    if (value.val().trim().length == 0) {
        return false;
    } else {
        return true;
    }
}

function checkRegexp(o, regexp, n) {
    if (!( regexp.test(o.val()) )) {
        o.addClass('ui-state-error');
        updateTips(n);
        return false;
    } else {
        return true;
    }
}

function makeFavorite(id) {
    var image = $("#FI" + id);
    var value = 0;
    if (image.attr("src") == "/images/unfav.png") value = 1;
    if (value == 1) {
        image.attr({
            src: "/images/fav.png",
            title: "Make UnFavorite"
        });
    } else {
        image.attr({
            src: "/images/unfav.png",
            title: "Make Favorite"
        });
    }
    $.ajax({
        type: "GET",
        url: "/photo/favorite/" + id,
        data: "flag=" + value,
        dataType: "text/html"
    });
}

function unFavoriteAndRemove(id) {
    $("#PD" + id).hide("slow", function() {
        $(this).remove();
    });
    $.ajax({
        type: "GET",
        url: "/photo/favorite/" + id,
        data: "flag=0"
    });
}
function makePrivate(id) {
    var image = $("#PI" + id);
    var value = 0;
    if (image.attr("src") == "/images/public.png") value = 1;
    if (value == 1) {
        image.attr({
            src: "/images/private.png",
            title: "Make Public"
        });
    } else {
        image.attr({
            src: "/images/public.png",
            title: "Make Private"
        });
    }
    $.ajax({
        type: "GET",
        url: "/photo/makePrivate/" + id,
        data: "flag=" + value,
        dataType: "text/html"
    });
}
function getID(itemID) {
    return itemID.substr(2, itemID.length);
}

function photoControls(id) {
    var favorite;
    var priv;
    var workarea;
    var unfavorite;

    if (id) {
        favorite = $("#" + id + " a.photo-favorite");
        priv = $("#" + id + " a.photo-private");
        workarea = $("#" + id + " a.photo-workarea");
        unfavorite = $("#" + id + " a.photo-unfavorite");
    } else {
        favorite = $("a.photo-favorite");
        priv = $("a.photo-private");
        workarea = $("a.photo-workarea");
        unfavorite = $("a.photo-unfavorite");
    }
    favorite.click(function(event) {
        var id = getID($(this).attr("id"));
        makeFavorite(id);
        return false;
    });
    priv.click(function(event) {
        var id = getID($(this).attr("id"));
        makePrivate(id);
        return false;
    });
    workarea.click(function(event) {
        var id = getID($(this).attr("id"));
        toWorkArea(id);
        return false;
    });
    unfavorite.click(function(event) {
        var id = getID($(this).attr("id"));
        unFavoriteAndRemove(id);
        return false;
    });
}
function toDelete(id) {
    $("#PD" + id).hide("slow", function() {
        $(this).remove();
    });
    $.ajax({
        type: "GET",
        url: "/photo/delete/" + id
    });
}
function toWorkArea(id) {
    $("#PD" + id).hide("slow", function() {
        $(this).remove();
    });
    $.ajax({
        type: "GET",
        url: "/photo/toWorkArea/" + id
    });
}
// Add a photo from photo collection to workarea
function addToWorkArea(id) {
    $("#A" + id).text("Copying to Work Area...");
    $.ajax({
        type: "GET",
        url: "/photo/addToWorkArea/" + id,
        success: function(msg) {
            $("#A" + id).text("Copied to Work Area");
        }
    });
}
function importPicasaAlbums() {
    $('#import-picasa-albums').click(function() {
        showOverlay();
        var a = $(this);
        $.get(a.attr('href'), function(resp) {
            hideOverlay();
            var dialog = $('<div>').attr('id', 'formDialog').html($(resp).html());
            $('body').append(dialog);
            dialog.find(':submit').hide();
            dialog.dialog({
                title: a.attr('title') ? a.attr('title') : '',
                modal: true,
                buttons: {
                    'Import': function() {
                        form = $('#importPicasaAlbumForm');
                        $.ajax({
                            url: form.attr('action'),
                            data: form.serialize(),
                            type: (form.attr('method')),
                            dataType: "script"
                        });
                        var selectedRadio = $("input:radio[name=albumIDs]:checked", "#importPicasaAlbumForm");
                        $(this).dialog('close');
                        infoMessage("Import started for Album " + selectedRadio.attr("rel") + " .The photos will appear in work area shortly.");
                        return false;
                    },
                    'Cancel': function() {
                        $(this).remove();
                    }
                },
                close: function() {
                    $(this).remove();
                },
                width: 500
            });
        }, 'html');
        return false;
    });
}
function createMetaDialog() {
    $("#edit-meta-dialog").show();
    $("#edit-meta-dialog").dialog({
        autoOpen: false,
        width: 450,
        modal: true,
        buttons: {
            'Save': function() {
                form = $(this).find('form');
                if ($("#multiple").val() == '0') {
                    submitSingleEdit(form);
                } else {
                    submitMultipleEdits(form);
                }
                $(this).dialog('close');
                return false;
            },
            Cancel: function() {
                $(this).dialog('close');
            }
        },
        close: function() {
        }
    });
}


function submitSingleEdit(form) {
    $.ajax({
        url: form.attr('action'),
        data: form.serialize() + "&photoIDs=" + $('#photoID').val(),
        type: (form.attr('method')),
        dataType: "script"
    });
    changePhotoMetaFlag($('#photoID').val())

}
function submitMultipleEdits(form) {
    form = $(form);
    var selCheckBoxes = getSelectedCheckBoxes().join(",");
    $.ajax({
        url: form.attr('action'),
        data: form.serialize() + "&photoIDs=" + selCheckBoxes,
        type: (form.attr('method')),
        dataType: 'script'
    });
    changeMultiplePhotoMetaFlag();
}
function editSingleMetaDialog() {
    $('.edit-meta-link').click(function() {
        var id = $(this).attr('pid');
        $('#photoID').val(id);
        $("#multiple").val(0);
        $("#caption").val($("#CD" + id).text().trim());
        $("#who").val($("#WD" + id).text().trim());
        $("#when").val($("#WN" + id).text().trim());
        $('#edit-meta-dialog').dialog('open');
        $("#caption").focus();
        return false;
    });
}
function editMultipleMetaDialog() {
    $('#edit-multiple-meta-form').click(function() {
        $("#multiple").val(1);
        $("#caption").val("");
        $("#who").val("");
        $("#when").text("");
        var selCheckBoxes = getSelectedCheckBoxes();
        if (selCheckBoxes == "") {
            alert("Must select at least one photo to add photo data");
        } else {
            $('#edit-meta-dialog').dialog('open');
            $("#caption").focus();
        }
    });
}
/* Function that changes the metadata flag based on the data in the photo meta */
function changePhotoMetaFlag(id) {
    var caption = $("#caption").val();
    var who = $("#who").val();
    var when = $("#when").val();

    if (caption != '' || who != '') { // If any of caption or who has some value
        $("#MI" + id).attr("src", "/images/metadata.png");
    } else {
        $("#MI" + id).attr("src", "/images/nometadata.png");
    }
    if (caption == '' || caption == '&nbsp;') caption = "&#160;";
    $("#CD" + id).html(caption);
    $("#WD" + id).text(who);
    $("#WN" + id).text(when);
}
function changeMultiplePhotoMetaFlag() {
    var selCheckBoxes = getSelectedCheckBoxes();
    for (i = 0; i < selCheckBoxes.length; i++) {
        changePhotoMetaFlag(selCheckBoxes[i]);
    }
}
function prepareAlbumView() {
    //Examples of how to assign the ColorBox event to elements
    var bHeight = $(window).height() - 100;
    var bWidth = Math.round(bHeight * 1.3);

    $("a[rel='album-view']").each(function(index) {
        var item = $(this);
        var hrefValue = item.attr("puri") + "s" + bWidth + "/" + item.attr("pfile");
        item.attr("href", hrefValue);
    });
    $("a[rel='album-view']").colorbox({photo:true, transition:"elastic", slideshow:true});
}
function storePhotosDialog() {
    $("#store-photos-dialog").show();
    $("#store-photos-dialog").dialog({
        autoOpen: false,
        width: 600,
        height:600,
        modal: true,
        buttons: {
            'Save': function() {
                submitFormWithAjax($(this).find('#store-photos-form'));
                changeStoreFlag();
                $(this).dialog('close');
                infoMessage("Photos saved successfully !");
                return false;
            },
            Cancel: function() {
                $(this).dialog('close');
            }
        },
        close: function() {
        }
    });
    $("#store-photos-link").click(function() {
        var selCheckBoxes = getSelectedCheckBoxes();
        if (selCheckBoxes == "") {
            alert("Must select at least one photo to store");
        } else {
            $('#store-photos-dialog').dialog('open');
        }
    });
}
function createCollectionDialog() {
    $("#create-collection-dialog").show();
    $("#create-collection-dialog").dialog({
        autoOpen: false,
        width: 450,
        modal: true,
        buttons: {
            'Save': function() {
                form = $(this).find('form');
                submitShareForm(form);
                $(this).dialog('close');
                infoMessage($("#collectionName").val() + " - Collection created successfully");
                return false;
            },
            Cancel: function() {
                $(this).dialog('close');
            }
        },
        close: function() {
        }
    });
    $("#create-collection-link").click(function() {
        var checkBoxes = getSelectedCheckBoxes();
        if (checkBoxes == "") {
            checkBoxes = getAllCheckBoxes();
        }
        $('#photoCount').text("Total of " + checkBoxes.length + " photos");
        $('#create-collection-dialog').dialog('open');
        $('#collectionName').focus();
    });
}
function addToCollectionDialog() {
    $('#addto-collection-link').click(function() {
        showOverlay();
        var a = $(this);
        $.get(a.attr('href'), function(resp) {
            hideOverlay();
            var dialog = $('<div>').attr('id', 'formDialog').html($(resp).html());
            $('body').append(dialog);
            dialog.find(':submit').hide();
            dialog.dialog({
                title: a.attr('title') ? a.attr('title') : '',
                modal: true,
                buttons: {
                    'Save': function() {
                        form = $("#addto-collection-form")
                        submitFormWithAjax(form)
                        $(this).dialog('close');
                        infoMessage("Added to collection successfully");
                        return false;
                    },
                    'Cancel': function() {
                        $(this).remove();
                    }
                },
                close: function() {
                    $(this).remove();
                },
                width: 500
            });
        }, 'html');
        return false;
    });
}


function changeStoreFlag() {
    var selCheckBoxes = getSelectedCheckBoxes();
    for (i = 0; i < selCheckBoxes.length; i++) {
        $("#" + "PD" + selCheckBoxes[i]).hide("slow", function() {
            $(this).remove();
        })
    }
}
function getSelectedCheckBoxes() {
    var checkValues = [];
    $('input[name=photos]:checked').each(function() {
        checkValues.push($(this).val());
    });
    return checkValues;
}
function getAllCheckBoxes() {
    var checkValues = [];
    $('input[name=photos]').each(function() {
        checkValues.push($(this).val());
    });
    return checkValues;
}
function submitShareForm(form) {
    form = $(form);
    var selCheckBoxes = getSelectedCheckBoxes().join(",");
    if (selCheckBoxes == "") selCheckBoxes = getAllCheckBoxes().join(",");
    $.ajax({
        url: form.attr('action'),
        data: form.serialize() + "&photoIDs=" + selCheckBoxes,
        type: (form.attr('method')),
        dataType: 'script'
    });
    return false;

}
function submitFormWithAjax(form) {
    form = $(form);
    var selCheckBoxes = getSelectedCheckBoxes().join(",");
    $.ajax({
        url: form.attr('action'),
        data: form.serialize() + "&photoIDs=" + selCheckBoxes,
        type: (form.attr('method')),
        dataType: 'script'
    });
    return false;

}
function createJournalDialog() {
    $("#search-journal-dialog").show();
    $("#search-journal-dialog").dialog({
        autoOpen: false,
        width: 450,
        modal: true,
        buttons: {
            'Search': function() {
                $(this).find('form').submit();
                $(this).dialog('close');
                return false;
            },
            Cancel: function() {
                $(this).dialog('close');
            }
        },
        close: function() {
        }
    });
    $("#search-journal-link").click(function() {
        $('#search-journal-dialog').dialog('open');
        $("#journalDetail").focus();
    });
}
function maintainAspectRatio(img) {
    // retrieve a new copy of the image that is not sized
    var newImg = new Image();
    newImg.src = img.src;
    var ratio = newImg.width / newImg.height;
    if (newImg.width != 160) {
        img.width = 160 * ratio;
        img.border = 20;
        img.height = 120;
    }
}

function handleImageCheckboxes(id) {
    var checkBoxSelect;
    var photoFrameSelect;
    if (id) {
        checkBoxSelect = $("#" + id + " .checkbox-select");
        photoFrameSelect = $("#" + id + " .photo-frame");
    } else {
        checkBoxSelect = $(".checkbox-select");
        photoFrameSelect = $(".photo-frame");
    }
    checkBoxSelect.click(function(event) {
        event.preventDefault();
        var checkImg = $(this);
        var imgID = getID(checkImg.attr("id"));
        toggleSelection(imgID);
        return false;
    });
    photoFrameSelect.click(function(event) {
        event.preventDefault();
        var checkImg = $(this);
        var imgID = getID(checkImg.attr("id"));
        toggleSelection(imgID)
    });

}

function toggleSelection(imgID) {
    if ($("#SI" + imgID).attr("src") == "/images/unselect.png") {
        $("#SP" + imgID).attr("checked", "checked");
        $("#SI" + imgID).attr("src", "/images/select.png").attr("title", "Unselect");
        $("#PD" + imgID).addClass("ui-state-hover")
    } else {
        $("#SP" + imgID).attr("checked", "");
        $("#SI" + imgID).attr("src", "/images/unselect.png").attr("title", "Select");
        $("#PD" + imgID).removeClass("ui-state-hover")
    }
}

function handleCheckAllCheckbox() {
    $("#checkAll").click(function(event) {
        if ($(this).attr("checked")) {
            $('input[name=photos]').each(function() {
                var id = getID($(this).attr('id'));
                $("#SI" + id).attr("src", "/images/select.png");
                $("#SP" + id).attr("checked", "checked");
                $("#PD" + id).addClass("ui-state-hover")
            });
        } else {
            $('input[name=photos]').each(function() {
                var id = getID($(this).attr('id'));
                $("#SI" + id).attr("src", "/images/unselect.png");
                $("#SP" + id).attr("checked", "");
                $("#PD" + id).removeClass("ui-state-hover")
            });
        }
    });
}
function loadMorePhotos() {
    $('#load-more-photos').click(function() {
        showOverlay();
        $.ajax({
            type: "GET",
            url: "/search/next/" + $("#load-more-photos").attr("beanID") + "?startPos=" + $("#load-more-photos").attr("startPos"),
            dataType: "text/html",
            success: function(response) {
                hideOverlay();
                $("#photoResultsContainer").append(response);
            }
        });
    });
}

function isValidMemberForm(fullName) {
    var bValid = true;
    var allFields = $([]).add(fullName);
    allFields.removeClass('ui-state-error');
    bValid = bValid && validateForNull('Full Name', fullName);
    return bValid;

}
function isValidUserForm(fullName, state, zip) {
    var bValid = true;
    var allFields = $([]).add(fullName, state, zip);
    allFields.removeClass('ui-state-error');
    bValid = bValid && validateForNull('Full Name', fullName);
    bValid = bValid && validateForNull('State', state);
    bValid = bValid && validateForNull('Zip', zip);
    return bValid;

}
function handleMemberDialogs() {
    $("#create-member-dialog").dialog({
        autoOpen: false,
        width: 500,
        modal: true,
        buttons: {
            'Create': function() {
                if (isValidMemberForm($("#fullName-create"))) {
                    $("#create-edit-member-form").submit();
                    $(this).dialog('close');
                    return false;
                }
            },
            'Cancel': function() {
                $(this).dialog('close');
            }
        },
        close: function() {

        }
    });
    $('#create-member-link').click(function() {
        var dlg = $('#create-member-dialog');
        dlg.html("<div style='height:400px;text-align:center'><img src='../images/ajax-loader.gif' /></div>");
        dlg.show();
        dlg.dialog('open');
        var a = $(this);
        $.get(a.attr('href'), function(resp) {
            dlg.html(resp);
            $("#fullName-create").focus();
        }, 'html');
        return false;
    });
    $("#edit-member-dialog").dialog({
        autoOpen: false,
        width: 500,
        modal: true,
        buttons: {
            'Update': function() {
                if (isValidMemberForm($("#fullName-edit"))) {
                    $("#create-edit-member-form").submit();
                    $(this).dialog('close');
                    return false;
                }
            },
            'Cancel': function() {
                $(this).dialog('close');
            }
        },
        close: function() {

        }
    });
    $('.edit-member-link').click(function() {
        var dlg = $('#edit-member-dialog');
        dlg.html("<div style='height:400px;text-align:center'><img src='../images/ajax-loader.gif' /></div>");
        dlg.show();
        dlg.dialog('open');
        var a = $(this);
        $.get(a.attr('href'), function(resp) {
            dlg.html(resp);
            $("#fullName-edit").focus();
        }, 'html');
        return false;
    });

    $("#search-member-photo-dialog").dialog({
        autoOpen: false,
        width: 650,
        modal: true,
        close: function() {
        }
    });
    $('.search-member-photo-link').click(function() {
        var dlg = $('#search-member-photo-dialog');
        dlg.html("<div style='height:400px;text-align:center'><img src='../images/ajax-loader.gif' /></div>");
        dlg.show();
        var a = $(this);
        $.get(a.attr('href'), function(resp) {
            dlg.html(resp);
        }, 'html');
        dlg.dialog('open');
        return false;
    });


}
function mslshare() {
    $("#mslshare-collection-dialog").show();
    $("#mslshare-collection-dialog").dialog({
        autoOpen: false,
        width: 500,
        height: 400,
        modal: true,
        buttons: {
            'Share': function() {
                form = $("#mslshare-collection-form");
                $.ajax({
                    url: form.attr('action'),
                    data: form.serialize(),
                    type: (form.attr('method')),
                    dataType: "script"
                });
                $(this).dialog('close');
                return false;
            },
            Cancel: function() {
                $(this).dialog('close');
            }
        },
        close: function() {
        }
    });
    $('.mslshare-collection-link').click(function() {
        $('#mslshare-collection-dialog').dialog('open');
        var id = $(this).attr('rel');
        $("#collectionID").val(id);
        $("#userIDs").focus();
    });
}
function editCollection() {
    $("#edit-collection-dialog").show();
    $("#edit-collection-dialog").dialog({
        autoOpen: false,
        width: 500,
        height: 600,
        modal: true,
        buttons: {
            'Update': function() {
                form = $("#edit-collection-form");
                $.ajax({
                    url: form.attr('action'),
                    data: form.serialize(),
                    type: (form.attr('method')),
                    dataType: "script"
                });
                $(this).dialog('close');
                location.reload(true);
                return false;
            },
            Cancel: function() {
                $(this).dialog('close');
            }
        },
        close: function() {
        }
    });
    $('.edit-collection-link').click(function() {
        var dlg = $('#edit-collection-dialog');
        dlg.html("<div style='height:400px;text-align:center'><img src='../images/ajax-loader.gif' /></div>");
        dlg.dialog('open');
        var a = $(this);
        $.get(a.attr('href'), function(resp) {
            dlg.html(resp);
        }, 'html');
        return false;
    });
}
/* All Event Tree Related Functions */
function unCheckOtherEventTreeBoxes(id) {
    var otherSelectedCheckBoxes = getEventTreeCheckBoxes(id);
    if (otherSelectedCheckBoxes != "") { // Uncheck all checkboxes
        $.each(otherSelectedCheckBoxes, function(intIndex, objValue) {
            $("#" + objValue).attr('checked', false);
        });
    }
}
function getEventTreeCheckBoxes(id) {
    var checkValues = [];
    $('input[name=eventIDs][pid=' + id + ']:checked').each(function() {
        checkValues.push($(this).attr("value"));
    });
    return checkValues;
}
function clearAllEventTree() {
    $("input:checkbox[name=eventIDs]:checked").each(function() {
        $(this).attr('checked', false);
    });
}
function eventTreeAccordion() {
    var eventAccordion = $("#eventAccordion");
    eventAccordion.show();
    eventAccordion.accordion({
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
    eventAccordion.accordion('activate', "-1");
    return eventAccordion;
}
function handleEventTreeFunctions() {
    var eventAccordion = eventTreeAccordion();
    eventAccordion.find('h2 > input').click(function (e) {
        e.stopPropagation();
        var checkBox = $(this);
        var isChecked = checkBox.is(':checked');
        var headerIDTag = "#HD" + checkBox.attr('id');
        if (isChecked) {
            checkBox.attr('checked', true);
            var active = $("#eventAccordion").accordion("option", "active");
            if (checkBox.attr('rel') != active) {
                $("#eventAccordion").accordion('activate', headerIDTag);
            }
        } else {
            unCheckOtherEventTreeBoxes(checkBox.attr('id'));
            checkBox.attr('checked', false);
            $("#eventAccordion").accordion('activate', headerIDTag);
        }

    });
    eventAccordion.find('div > span > input').click(function (e) {
        var checkBox = $(this);
        var isChecked = checkBox.is(':checked');
        var headerChkIDTag = "#" + checkBox.attr('pid');
        if (isChecked) {
            checkBox.attr('checked', true);
        }
        else {
            checkBox.attr('checked', false);
        }
        e.stopPropagation();
    });
    return eventAccordion;
}

function handleStoreEventTreeFunctions() {
    var eventAccordion = eventTreeAccordion();
    eventAccordion.find('h2 > input').click(function (e) {
        e.stopPropagation();
        var checkBox = $(this);
        var isChecked = checkBox.is(':checked');
        var headerIDTag = "#HD" + checkBox.attr('id');
        if (isChecked) {
            checkBox.attr('checked', true);
            var active = $("#eventAccordion").accordion("option", "active");
            if (checkBox.attr('rel') != active) {
                $("#eventAccordion").accordion('activate', headerIDTag);
            }
        }
        else {
            clearAllEventTree();
            checkBox.attr('checked', false);
            $("#eventAccordion").accordion('activate', headerIDTag);
        }
    });

    eventAccordion.find('div > span > input').click(function (e) {
        var checkBox = $(this);
        var isChecked = checkBox.is(':checked');
        var headerChkIDTag = "#" + checkBox.attr('pid');
        if (isChecked) {
            clearAllEventTree();
            checkBox.attr('checked', true);
            $(headerChkIDTag).attr('checked', true);
        }
        else {
            checkBox.attr('checked', false);
        }
        e.stopPropagation();
    });
}
function getKey() {
    var checkBoxes = getSelectedCheckBoxes();
    if (checkBoxes == "") {
        checkBoxes = getAllCheckBoxes();
    }
    var key = checkBoxes.join(",");
    return key;
}
function openFacebookOnthefly(websiteName) {
    var fbShareUrl = "http://www.facebook.com/sharer.php?u=" + encodeURIComponent(websiteName + "/public/view?key=" + Base64.encode(getKey()) + "&t=myStoredLife&src=sp");
    window.open(
            fbShareUrl,
            "_blank",
            "resizable=0,scrollbars=0,width=690,height=415"
            );
}
function openBuzzOnthefly(websiteName) {
    window.open(
            "http://www.google.com/buzz/post?" + "message=" + encodeURIComponent(websiteName + "/public/view?key=" + Base64.encode(getKey())),
            "_blank",
            "resizable=0,scrollbars=0,width=690,height=415"
            );
}
function openGmailOnthefly(websiteName) {
    window.open(
            "https://mail.google.com/mail/?view=cm&tf=1&source=mailto&fs=1&body=" + websiteName + "/public/view?key=" + encodeURIComponent(Base64.encode(getKey())),
            "_blank",
            "resizable=0,scrollbars=0,width=1124,height=768"
            );
}