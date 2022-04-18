<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

Name:${employee.name}
<br>
Surname:${employee.surname}
<br>
Salary:${employee.salary}
<br>
Department:${employee.department}
<br>
Car brand:${employee.carBrand}
<br>
Language(s):
<ul>
    <c:forEach var="lang" items="${employee.languages}">
        <li>${lang}</li>
    </c:forEach>
</ul>

Phone number:${employee.phoneNumber}

</body>
</html>