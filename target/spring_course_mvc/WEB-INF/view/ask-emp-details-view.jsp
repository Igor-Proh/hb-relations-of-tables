<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>

<h2>Please Enter your details.</h2>

<br><br>
<form:form action="showDetails" modelAttribute="employee">

    Name: <form:input path="name"/>
    <form:errors path="name"/>
    <br><br>
    Surname: <form:input path="surname"/>
    <form:errors path="surname"/>
    <br><br>
    Salary: <form:input path="salary"/>
    <form:errors path="salary"/>

    <br><br>
    Department: <form:select path="department">
    <br><br>
    Departments: <form:options items="${employee.departments}"/>
                </form:select>

    <br><br>
    PhoneNumber: <form:input path="phoneNumber"/>
    <form:errors path="phoneNumber"/>
    <br><br>
    Which car do you want?
    <br>
    <%--    <form:radiobutton path="carBrand" value="BMV"/> BMW--%>
    <%--    <br>--%>
    <%--    <form:radiobutton path="carBrand" value="Audi"/> Audi--%>
    <%--    <br>--%>
    <%--    <form:radiobutton path="carBrand" value="Fiat"/> Fiat--%>
    <form:radiobuttons path="carBrand" items="${employee.carBrands}"/>
    <br><br>
    Foreign Language(s):
    <%--    EN<form:checkbox path="languages" value="English"/>--%>
    <%--    DN<form:checkbox path="languages" value="Deutch"/>--%>
    <%--    FR<form:checkbox path="languages" value="French"/>--%>
    <form:checkboxes path="languages" items="${employee.languageList}"/>
    <br><br>
    <input type="submit" value="OK">

</form:form>
</body>
</html>