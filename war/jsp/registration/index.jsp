<%@include file="../common/_include-tags.jsp" %>

<div class="contentWrap">
    <div class='page-header-text'>User Registration</div>
    <div style="clear:both;"></div>
    <script type="text/javascript">
        $(document).ready(function() {
            $('#register-user-link').click(function() {
                if (isValidUserForm($("#fullName"), $("#state"), $("#zip"))) {
                    $("#register-user-form").submit();
                }
            });
        });
    </script>


    <div style="width:400px;padding:20px;" class="ui-widget ui-widget-header ui-corner-all ui-resizable ui-widget"
         title="Register User">
        <form id="register-user-form" method="post" action="/registration" enctype="multipart/form-data">

            <input type="hidden" name="email" value='${email}'/>

            <p class="validateTips"></p>

            <p>
                <label for="fullName">Full Name*</label>
                <input type="text" name="fullName" id="fullName" class="text ui-widget-content ui-corner-all"/>
            </p>

            <p>
                <label for="gender" style="display:block">Gender</label>
                <select name="gender" id="gender" class="ui-corner-all">
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                </select>
            </p>
            <p>
                <label for="birthYear">Birth Year
                    <small>e.g 2002</small>
                </label><br/>
                <input type="text" name="birthYear" id="birthYear" value="${member.birthYear}"
                       class="text ui-widget-content ui-corner-all"/>
            </p>
            <p>
                <label for="relation" style="display:block">Relation</label>
                <select name="relation" id="relation" class="ui-corner-all">
                    <c:forEach var="rel" items="${relations}">
                        <option value="${rel}">${rel}</option>
                    </c:forEach>
                </select>
            </p>
            <p>
                <label for="state">State*</label>
                <input type="text" name="state" id="state" value="" class="text ui-widget-content ui-corner-all"/>
            </p>

            <p>
                <label for="zip">Zip*</label>
                <input type="text" name="zip" id="zip" value="" class="text ui-widget-content ui-corner-all"/><br/>
            </p>

            <p>
                <label for="country" style="display:block">Country</label>
                <select name="country" id="country">
                    <c:forEach var="country" items="${countries}">
                        <option value="${country}">${country}</option>
                    </c:forEach>
                </select>
            </p>

            <p>By clicking on 'I accept' below you are agreeing to the
                <a href="#" class="link" onclick="openNewWindow('/public/agreement')">Terms of Service</a>
                <br/>
                <a style="float:right" id="register-user-link"
                   class="small-button ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon">
                    <span class="ui-button-icon-primary ui-icon ui-icon-circle-plus"
                          style="display:inline-block"></span>
                    <span class="ui-button-text" style="display:inline-block">I accept. Register</span>
                </a>
            </p>
        </form>
    </div>
</div>