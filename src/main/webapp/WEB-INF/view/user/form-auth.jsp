<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jstl/core" %>
<div>
    <legend>Sign up</legend>
    <spring:url var="authUrl" value="/auth/login"/>
    <form method="post" class="form-horizontal" action="${authUrl}">
        <div class="form-group">
            <label for="user-login" class="col-sm-2 control-label">Login</label>
            <div class="col-sm-10">
                <input type="text" id="user-login" name="username" class="form-control" placeholder="User name"/>
            </div>
        </div>
        <div class="form-group">
            <label for="user-password" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
                <input type="password" name="password" id="user-password" class="form-control" placeholder="Password"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" name="_spring_security_remember_me"> Remember me
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" value="Authenticate" class="btn btn-primary "/>
            </div>
        </div>
    </form>
</div>
