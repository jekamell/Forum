<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<legend>${topic.title}</legend>

<p>
    <button class="btn btn-info" data-toggle="modal" data-target="#modalComment">Add comment</button>
</p>


<div class="well wMain">
    <div class="wImageName">
        <strong>User name</strong>
        <img src="/" alt="username"/>
    </div>
    <div class="wContent">
        <em class="wDate">11.11.11 11:11:11</em>
        <h2>title</h2>
        <p>${topic.content}</p>
    </div>

    <%--<div></div>--%>

</div>
<hr/>

<c:forEach items="${topic.comments}" var="comment">
    <div class="well">${comment.content}</div>
</c:forEach>
<p>
    <button class="btn btn btn-info" data-toggle="modal" data-target="#modalComment">Add comment</button>
</p>
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
