<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<legend>${topic.title}</legend>
<div class="well wMain">
    <div class="wImageName">
        <strong>${topic.author.login}</strong>
        <img src="${topic.author.avatar}" alt="${topic.author.login}" class="img-thumbnail"/>
    </div>
    <div class="wContent">
        <em class="wDate"><fmt:formatDate value="${topic.dateAdd}" pattern="dd.MM.yyyy HH:mm" /></em>
        <h2>${topic.title}</h2>
        <p>${topic.content}</p>
    </div>
</div>
<hr/>
<p>
    <security:authorize access="isAuthenticated()">
        <button class="btn btn-info" data-toggle="modal" data-target="#modalComment">Add comment</button>
    </security:authorize>
    <security:authorize access="!isAuthenticated()">
        You must be <a href="/auth/login">logged in</a> to post a comment.
    </security:authorize>
</p>

<c:forEach items="${topic.comments}" var="comment">
    <div class="well">
        <div class="wImageName">
            <strong>${comment.author.login}</strong>
            <img src="${comment.author.avatar}" alt="${comment.author.login}" class="img-thumbnail"/>
        </div>
        <div class="wContent">
            <em class="wDate"><fmt:formatDate value="${comment.dateAdd}" pattern="dd.MM.yyyy HH:mm" /> </em>
            <h2>${topic.title}</h2>
            <p>${comment.content}</p>
        </div>
    </div>
</c:forEach>
<div class="modal fade" id="modalComment" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <sf:form method="POST" action="/topic/add-comment" modelAttribute="comment" role="form" cssClass="form-horizontal">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="modalLabel">Add comment</h4>
                </div>
                <div class="modal-body">
                    <sf:hidden path="topic.id"/>
                    <sf:textarea path="content" cssClass="form-control" rows="5"/>
                    <sf:errors path="content" cssClass="text-danger"/>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <input type="submit" class="btn btn-primary"/>
                </div>
            </div>
        </sf:form>
    </div>
</div>

<c:if test="${showModal==true}">
    <script>
        $('#modalComment').modal();
    </script>
</c:if>
