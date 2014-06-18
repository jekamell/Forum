<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
    <a class="btn btn-info" href="#">add topic</a>
    <dl>
        <c:forEach items="${topicList}" var="topic">
            <h3><a href="<s:url value="/showTopic/${topic.id}" />"><dt>${topic.title}</dt></a></h3>
            <small class="text-muted">${topic.content}</small>
        </c:forEach>
    </dl>
</div>