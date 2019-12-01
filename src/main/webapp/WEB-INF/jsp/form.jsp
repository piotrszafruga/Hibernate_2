<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="post" modelAttribute="person">
    Login: <form:input path="login" /> <br />
    Hasło: <form:password path="password"/> <br />
    Email: <form:input path="email" /> <br />
    <input type="submit" value="Wyslij"/>
</form:form>



