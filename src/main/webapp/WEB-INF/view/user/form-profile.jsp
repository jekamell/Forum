<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div>
    <legend>Change profile</legend>
    <s:form method="post" cssClass="form-horizontal" modelAttribute="user">
        <fieldset disabled>
        <div class="form-group">
            <label class="col-sm-2 control-label">Login</label>
            <div class="col-sm-10">
                <span class="form-control text-muted">${user.login}</span>
            </div>
        </div>
        </fieldset>

        <div class="form-group">
            <label for="user-name-first" class="col-sm-2 control-label">First name</label>
            <div class="col-sm-10">
                <sf:input path="nameFirst" id="user-name-first" class="form-control" placeholder="First name"/>
                <sf:errors path="nameFirst" cssClass="text-danger"/>
            </div>
        </div>

        <div class="form-group">
            <label for="user-name-last" class="col-sm-2 control-label">Last name</label>
            <div class="col-sm-10">
                <sf:input path="nameLast" id="user-name-last" class="form-control" placeholder="Last name"/>
                <sf:errors path="nameLast" cssClass="text-danger"/>
            </div>
        </div>

        <div class="form-group">
            <label for="user-email" class="col-sm-2 control-label">E-mail</label>
            <div class="col-sm-10">
                <sf:input path="email" id="user-email" cssClass="form-control"/>
                <sf:errors path="email" cssClass="text-danger"/>
            </div>
        </div>
        <div class="form-group">
            <label for="user-skype" class="col-sm-2 control-label">Skype</label>
            <div class="col-sm-10">
                <sf:input path="skype" id="user-skype" cssClass="form-control"/>
                <sf:errors path="skype" cssClass="text-danger"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" value="Update" class="btn btn-primary "/>
            </div>
        </div>
    </s:form>
    </form>
</div>
