<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Custom Login Page</title>

</head>
<body>
    <h3>My Custom Login Page</h3>
    <form:form action="authenticateTheUser" method="POST">
        <c:if test="${param.error != null}">
            <i>Bad Credentials</i>
        </c:if>
        <p>
            User name: <input type="text" name="username"/>
        </p>
        <p>
            Password: <input type="text" name="password"/>
        </p>
        <input type="submit" value="Login"/>
    </form:form>
</body>
</html>