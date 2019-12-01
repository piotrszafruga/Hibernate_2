<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="post" modelAttribute="book">

    Title: <form:input path="title" /> <br />
    <form:errors path="title"/> <br/>
    Rating: <form:input path="rating"/> <br />
    <form:errors path="rating"/> <br/>
    Description: <form:textarea path="description" rows = "5" cols="20"/> <br />
    <form:errors path="description"/> <br/>
    Publisher: <form:select path="publisher.id" items="${publishers}"
                            itemLabel="name" itemValue="id"/> <br/>
    <form:errors path="publisher"/> <br/>
    Author: <form:select path="authorList" items="${authors}"
                         itemLabel="fullName" itemValue="id" multiple="true"/> <br/>
    <form:errors path="authorList"/> <br/>
    Pages: <form:input path="pages"/> <br/>
    Proposition: <form:checkbox path="proposition"/> <br/>

    <input type="submit" value="Add"/>

</form:form>
