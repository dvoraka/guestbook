<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guestbook</title>
    </head>

    <body>
        <p>Guestbook</p>
        <h1>List of all users</h1>
        <ul>
            <c:forEach var="user" items="${users}">
                <li>${user.id} - ${user.username}</li>
            </c:forEach>
        </ul>
        <p>Users: ${counter}</p>
    </body>
</html>
