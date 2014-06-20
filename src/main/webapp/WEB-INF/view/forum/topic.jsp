<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="sec" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<legend>${topic.title}</legend>

<div class="well" style="background-color: #dff0d8">${topic.content}</div>
<hr/>

<security:authorize access="isAuthenticated()">
    <p>
        <button class="btn btn-primary" data-toggle="modal" data-target="#modalComment">Add comment</button>
    </p>
</security:authorize>
<security:authorize access="!isAuthenticated()">
    <p>
        You must be <a href="/auth/login">logged in</a> to comment.
    </p>
</security:authorize>

<c:forEach items="${topic.comments}" var="comment">
    <div class="well">${comment.content}</div>
</c:forEach>

<div class="modal fade" id="modalComment" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <sf:form method="POST" action="/topic/add-comment" modelAttribute="comment" role="form"
                 cssClass="form-horizontal">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="modalLabel">Add comment</h4>
                </div>
                <div class="modal-body">
                    <sf:hidden path="idTopic"/>
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
