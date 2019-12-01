<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All books</title>
</head>
<body>
<h2>All books:</h2>
<br/>
<c:forEach items="${allBooks}" var="var">
    <p> ---- </p>
    Title: ${var.title} <br/>
    Publisher: ${var.publisher.name} <br/>

    <a href='<c:url value="/book/edit/${var.id}"/>'>Edit</a> <br/>

    <form method="post" modelAttribute="container">
        <input type="hidden" name="id" value="${var.id}">
        <input type="submit" value="Delete"/>
    </form> <br/>
</c:forEach>
</body>
</html>