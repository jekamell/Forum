<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div>
    <legend>Registration</legend>

    <sf:form method="POST" modelAttribute="user" enctype="multipart/form-data" role="form" cssClass="form-horizontal">
        <div class="form-group">
            <label for="user-login" class="col-sm-2 control-label">Login</label>
            <div class="col-sm-10">
                <sf:input path="login" id="user-login" class="form-control" placeholder="User name"/>
                <sf:errors path="login" cssClass="text-danger" />
            </div>
        </div>
        <div class="form-group">
            <label for="user-email" class="col-sm-2 control-label">E-mail</label>
            <div class="col-sm-10">
                <sf:input path="email" id="user-email" class="form-control" placeholder="E-mail"/>
                <sf:errors path="email" cssClass="text-danger" />
            </div>
        </div>
        <div class="form-group">
            <label for="user-password" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
                <sf:password path="password" id="user-password" showPassword="false" class="form-control"
                             placeholder="Password"/>
                <sf:errors path="password" cssClass="text-danger" />
            </div>
        </div>
        <div class="form-group">
            <label for="user-avatar" class="col-sm-2 control-label">Picture</label>
            <div class="col-sm-10">
                <input type="file" name="avatar" id="user-avatar"/>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" value="Register" class="btn btn-primary "/>
            </div>
        </div>
    </sf:form>
</div>