<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title><tiles:insertAttribute name="title"/></title>
    <link rel="stylesheet" href="<s:url value="/resources" />/css/bootstrap.css" type="text/css"/>
    <script src="<s:url value="/resources" />/js/jquery.min.js"></script>
    <script src="<s:url value="/resources" />/js/bootstrap.js"></script>
</head>

<body>
<div id="container">
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