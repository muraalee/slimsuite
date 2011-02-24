<c:if test="${theme eq null}">
    <link type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.5/themes/start/jquery-ui.css" rel="stylesheet"/>
</c:if>
<c:if test="${theme ne null}">
    <link type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.5/themes/${theme}/jquery-ui.css" rel="stylesheet"/>
</c:if>
<a id='switcher-button' href="#" class="jquery-ui-themeswitcher-trigger" style="display:none">
    <span class="jquery-ui-themeswitcher-icon"></span><span class="jquery-ui-themeswitcher-title">Switch Theme</span>
</a>
<div id='switcher-pane' class="jquery-ui-themeswitcher" style="display:none">
    <div id="themeGallery">
        <ul>
            <!-- <li><a><img src="http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_ui_light.png" alt="UI Lightness"
                        title="UI Lightness"/><span tn="ui-lightness" class="themeName">UI lightness</span></a></li> -->
            <!-- <li><a><img src="http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_ui_dark.png" alt="UI Darkness"
                        title="UI Darkness"/><span tn="ui-darkness" class="themeName">UI darkness</span></a></li> -->
            <li><a><img src="http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_smoothness.png" alt="Smoothness"
                        title="Smoothness"/><span tn="smoothness" class="themeName">Smoothness</span></a></li>
            <li><a><img src="http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_start_menu.png" alt="Start"
                        title="Start"/><span tn="start" class="themeName">Start</span></a></li>
            <!-- <li><a><img src="http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_windoze.png" alt="Redmond"
                        title="Redmond"/><span tn="redmond" class="themeName">Redmond</span></a></li> -->
            <!-- <li><a><img src="http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_sunny.png" alt="Sunny"
                        title="Sunny"/><span tn="sunny" class="themeName">Sunny</span></a></li> -->
            <li><a><img src="http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_overcast.png" alt="Overcast"
                        title="Overcast"/><span tn="overcast" class="themeName">Overcast</span></a></li>
            <!-- <li><a><img src="http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_le_frog.png" alt="Le Frog"
                        title="Le Frog"/><span tn="le-frog" class="themeName">Le Frog</span></a></li> -->
            <!-- <li><a><img src="http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_flick.png" alt="Flick"
                        title="Flick"/><span tn="flick" class="themeName">Flick</span></a></li> -->
            <!-- <li><a><img src="http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_pepper_grinder.png" alt="Pepper Grinder"
                        title="Pepper Grinder"/><span tn="pepper-grinder" class="themeName">Pepper Grinder</span></a></li> -->
            <!-- <li><a><img src="http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_eggplant.png" alt="Eggplant"
                        title="Eggplant"/><span tn="eggplant" class="themeName">Eggplant</span></a></li> -->
            <li><a><img src="http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_dark_hive.png" alt="Dark Hive"
                        title="Dark Hive"/><span tn="dark-hive" class="themeName">Dark Hive</span></a></li>
            <li><a><img src="http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_cupertino.png" alt="Cupertino"
                        title="Cupertino"/><span tn="cupertino" class="themeName">Cupertino</span></a></li>
            <li><a><img src="http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_south_street.png" alt="South St"
                        title="South St"/><span tn="south-street" class="themeName">South Street</span></a></li>
            <!-- <li><a><img src="http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_blitzer.png" alt="Blitzer"
                        title="Blitzer"/><span tn="blitzer" class="themeName">Blitzer</span></a></li> -->
            <!-- <li><a><img src="http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_humanity.png" alt="Humanity"
                        title="Humanity"/><span tn="humanity" class="themeName">Humanity</span></a></li> -->
            <!-- <li><a><img src="http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_hot_sneaks.png" alt="Hot Sneaks"
                        title="Hot Sneaks"/><span tn="hot-sneaks" class="themeName">Hot sneaks</span></a></li> -->
            <!-- <li><a><img src="http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_excite_bike.png" alt="Excite Bike"
                        title="Excite Bike"/><span tn="excite-bike" class="themeName">Excite Bike</span></a></li> -->
            <li><a><img src="http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_black_matte.png" alt="Vader"
                        title="Vader"/><span tn="vader" class="themeName">Vader</span></a></li>
            <li><a><img src="http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_dot_luv.png" alt="Dot Luv"
                        title="Dot Luv"/><span tn="dot-luv" class="themeName">Dot Luv</span></a></li>
            <li><a><img src="http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_mint_choco.png" alt="Mint Choc"
                        title="Mint Choc"/><span tn="mint-choc" class="themeName">Mint Choc</span></a></li>
            <li><a><img src="http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_black_tie.png" alt="Black Tie"
                        title="Black Tie"/><span tn="black-tie" class="themeName">Black Tie</span></a></li>
            <li><a><img src="http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_trontastic.png" alt="Trontastic"
                        title="Trontastic"/><span tn="trontastic" class="themeName">Trontastic</span></a></li>
            <!-- <li><a><img src="http://static.jquery.com/ui/themeroller/images/themeGallery/theme_30_swanky_purse.png" alt="Swanky Purse"
                        title="Swanky Purse"/><span tn="swanky-purse" class="themeName">Swanky Purse</span></a></li> -->
        </ul>
    </div>
</div>
