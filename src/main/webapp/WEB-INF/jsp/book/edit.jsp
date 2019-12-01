<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<p>Edit book:</p>

<form:form method="post" modelAttribute="book">

    Title: <form:input path="title" /> <br />
    Rating: <form:input path="rating"/> <br />
    Description: <form:textarea path="description" rows = "5" cols="20"/> <br />
    Publisher: <form:select path="publisher.id" items="${publishers}"
                            itemLabel="name" itemValue="id"/> <br/>

    <input type="submit" value="Add"/>

</form:form>