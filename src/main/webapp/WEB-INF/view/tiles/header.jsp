<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="secucity" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-default navbar-static-top navbar-inverse" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<s:url value="/home" />">Home</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="#">Link</a></li>
                <li><a href="#">Link</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                        <li class="divider"></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <form class="navbar-form navbar-left" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>

                <security:authorize access="!isAuthenticated()">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Authorization<b
                                class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="<s:url value="/auth/login" />">Sign up</a></li>
                            <li class="divider"></li>
                            <li><a href="<s:url value="/user/register" />">Register</a></li>
                        </ul>
                    </li>
                </security:authorize>
                <security:authorize access="isAuthenticated()">
                    <security:authentication property="principal.username" var="login"/>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <span class="glyphicon glyphicon-user"></span>&nbsp;<strong>${login}</strong>
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="<s:url value="/profile/edit" />">Edit profile</a></li>
                            <li class="divider"></li>
                            <li><a href="<s:url value="/auth/logout" />">Logout</a></li>
                        </ul>
                    </li>
                </security:authorize>
            </ul>
        </div>
    </div>
</nav>