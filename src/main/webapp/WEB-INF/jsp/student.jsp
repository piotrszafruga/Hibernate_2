<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="post" modelAttribute="student">
    First name: <form:input path="firstName" /> <br />
    Last name: <form:input path="lastName"/> <br />
    Gender: Male: <form:radiobutton path="gender" value="M"/>
            Female: <form:radiobutton path="gender" value="M"/> <br />
    Country: <form:select path="country" items="${countries}" />
    Notes: <form:textarea path="notes" rows = "5" cols="20"/> <br />
    Mailing list: <form:checkbox path="mailingList"/> <br />
    Programming skills: <form:select path="programmingSkills" items="${skills}" multiple="true" /> <br />
    Hobbies: <form:checkboxes items="${hobbies}" path="hobbies" /> <br />

    <input type="submit" value="Wyslij"/>
</form:form>
