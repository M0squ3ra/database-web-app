<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="/css/style.css" rel="stylesheet">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>Logs</h2>
        </div>
    </div>
    <div id="container">
        <div id="content">
            <table>
                <tr>
                    <th>Id</th>
                    <th>Id Mod</th>
                    <th>Action</th>
                    <th>Timestamp</th>
                </tr>

                <c:forEach var="tempLog" items="${logs}">
                    <tr>
                        <td>${tempLog.id}</td>
                        <td>${tempLog.idMod}</td>
                        <td>${tempLog.action}</td>
                        <td>${tempLog.timestamp}</td>
                </c:forEach>

            </table>
        </div>
    </div>
    <br>
    <p>
        <a href="/customer/list">Back to List</a>
    </p>
    <form:form action="/logout" method="POST">
        <input type="submit" value="Logout">
    </form:form>
</body>
</html>