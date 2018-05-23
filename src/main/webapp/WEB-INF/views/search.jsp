<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Auto Suggest Using ArrayList</title>
</head>
<body>
	<center>
		<h2>Auto Suggest Using ArrayList</h2>
		<c:if test="${not empty suggestedList}">
			<c:forEach items="${suggestedList}" var="suggestions">
					${suggestions}<br>
			</c:forEach>
		</c:if>

	</center>
</body>
</html>