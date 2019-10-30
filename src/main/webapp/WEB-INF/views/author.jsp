<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="author">
    <div>
        <label for="firstNameId">First name:</label>
        <form:input type="text" path="firstName" id="firstNameId"/>
        <form:errors path="firstName" element="div"/>
    </div>

    <div>
        <label for="lastNameId">Last name:</label>
        <form:input type="text" path="lastName" id="lastNameId"/>
        <form:errors path="lastName" element="div"/>
    </div>

    <div>
        <label for="peselId">Pesel:</label>
        <form:input type="text" path="pesel" id="peselId"/>
        <form:errors path="pesel" element="div"/>
    </div>

    <div>
        <label for="emailId">Email:</label>
        <form:input type="text" path="email" id="emailId"/>
        <form:errors path="email" element="div"/>
    </div>

    <input type="submit" value="Save">
</form:form>
</body>
</html>
