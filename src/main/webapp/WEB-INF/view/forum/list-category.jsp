<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
    <dl>
    <c:forEach items="${categoryList}" var="category">
        <h3><a href="<s:url value="/category/${category.id}" />"><dt>${category.title}</dt></a></h3>
        <dd>${category.description}</dd>
        <br />
    </c:forEach>
    </dl>
</div>