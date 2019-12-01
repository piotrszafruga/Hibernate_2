<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Validation</title>
</head>
<body>
<h2>Validation</h2>
<br/>
<c:forEach items="${validations}" var="var">
    <p> ---- </p>
    ${var}

</c:forEach>
</body>
</html>