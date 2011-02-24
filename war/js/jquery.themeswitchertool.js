/* jQuery plugin themeswitcher
 ---------------------------------------------------------------------*/
$.fn.themeswitcher = function(settings) {
    var options = jQuery.extend({
        loadTheme: null,
        initialText: 'Switch Theme',
        width: 175,
        height: 200,
        buttonPreText: 'Theme: ',
        closeOnSelect: true,
        buttonHeight: 20,
        onOpen: function() {
        },
        onClose: function() {
        },
        onSelect: function() {
        }
    }, settings);

    //markup 
    var button = $('#switcher-button').show();
    var switcherpane = $('#switcher-pane').find('div').removeAttr('id');
    var button_default = 'img-dropdown-button-default';
    var button_hover = 'img-dropdown-button-hover';
    var button_active = 'img-dropdown-button-active';

    //button events
    button.click(
            function() {
                if (switcherpane.is(':visible')) {
                    switcherpane.spHide();
                }
                else {
                    switcherpane.spShow();
                }
                return false;
            });

    //menu events (mouseout didn't work...)
    switcherpane.hover(
            function() {
            },
            function() {
                if (switcherpane.is(':visible')) {
                    $(this).spHide();
                }
            });

    //show/hide panel functions
    $.fn.spShow = function() {
        $(this).css({top: button.offset().top + options.buttonHeight + 6, left: button.offset().left}).slideDown(50);
        button.addClass(button_active);
        options.onOpen();
    }
    $.fn.spHide = function() {
        $(this).slideUp(50, function() {
            options.onClose();
        });
        button.addClass(button_default);
        button.removeClass(button_active);
    }

    /* Theme Loading
     ---------------------------------------------------------------------*/
    switcherpane.find('a').click(function() {
        var themeName = $(this).find('span').attr("tn");
        window.location.href = "/home/theme/" + themeName;
        if (options.closeOnSelect && switcherpane.is(':visible')) {
            switcherpane.spHide();
        }
        return false;
    });

    /* Inline CSS
     ---------------------------------------------------------------------*/
    //button css
    button.addClass(button_default);
    button.hover(
            function() {
                $(this).addClass(button_hover);
            },
            function() {
                if (!switcherpane.is(':animated') && switcherpane.is(':hidden')) {
                   $(this).addClass(button_default);
                }
            }).find('.jquery-ui-themeswitcher-icon').css({
        float: 'right',
        width: '16px',
        height: '16px',
        background: 'url(http://jqueryui.com/themeroller/themeswitchertool/images/icon_color_arrow.gif) 50% 50% no-repeat'
    });
    //pane css
    switcherpane.addClass('img-dropdown');
    switcherpane.find('ul').css({
        listStyle: 'none',
        margin: '0',
        padding: '0',
        overflow: 'auto',
        height: options.height
    }).end().find('li').hover(
            function() {
                $(this).css({
                    'borderColor':'#555',
                    'background': 'url(http://jqueryui.com/themeroller/themeswitchertool/images/menuhoverbg.png) 50% 50% repeat-x',
                    cursor: 'pointer'
                });
            },
            function() {
                $(this).css({
                    'borderColor':'#111',
                    'background': '#000',
                    cursor: 'auto'
                });
            }
            ).css({
        width: options.width - 30,
        height: '',
        padding: '2px',
        margin: '1px',
        border: '1px solid #111',
        '-moz-border-radius': '4px',
        clear: 'left',
        float: 'left'
    }).end().find('a').css({
        color: '#aaa',
        textDecoration: 'none',
        float: 'left',
        width: '100%',
        outline: '0'
    }).end().find('img').css({
        float: 'left',
        border: '1px solid #333',
        margin: '0 2px'
    }).end().find('.themeName').css({
        float: 'left',
        margin: '3px 0'
    }).end();

    $(this).append(button);
    $('body').append(switcherpane);
    switcherpane.hide();
    return this;
};


