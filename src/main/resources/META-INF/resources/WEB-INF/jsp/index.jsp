<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Guestbook</title>
</head>
<body>
  <h1>Guestbook</h1>
  <p>
    <a href="${pageContext.request.contextPath}/add-rand-user/">Generate new user</a>
  </p>
  <p>
    <a href="${pageContext.request.contextPath}/reg/">Register new user</a>
  </p>
  <h2>Comments</h2>
  <ul>
    <c:forEach var="comment" items="${comments}">
                ${comment} | ${comment.text}<br>
    </c:forEach>
  </ul>
  <p>Comments: ${commentCounter}</p>
  <h2>List of all users</h2>
  <ul>
    <c:forEach var="user" items="${users}">
      <li>${user.id}-${user.username} (created: ${user.created}) <a
        href="${pageContext.request.contextPath}/delete-user/${user.id}">delete</a></li>
    </c:forEach>
  </ul>
  <p>Users: ${counter}</p>
  <p>Found users: ${foundUsers}</p>
</body>
</html>
