<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jstl/core" %>
<div>
    <legend>Sign up</legend>
    <form method="post" class="form-horizontal" action="<c:url value="/auth/login" />">
        <div class="form-group">
            <label for="user-login" class="col-sm-2 control-label">Login</label>
            <div class="col-sm-10">
                <input type="text" name="username" id="user-login" class="form-control" placeholder="User name" style="width: 33%" />
            </div>
        </div>
        <div class="form-group">
            <label for="user-password" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
                <input type="password" name="password" id="user-password" class="form-control" placeholder="Password" style="width: 33%" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" name="remember"> Remember me
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
