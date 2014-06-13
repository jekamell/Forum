<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title><tiles:insertAttribute name="title" /></title>
    <link rel="stylesheet" href="<s:url value="/resources" />" type="text/css"/>
</head>

<body>
<div id="container">
    <a href="<s:url value="/home" />">Home</a>

    <div id="header">
        <t:insertAttribute name="header"/>
    </div>

    <div id="content">
        <t:insertAttribute name="content"/>
    </div>

    <div id="footer">
        <t:insertAttribute name="footer"/>
    </div>
</div>
</body>
</html>