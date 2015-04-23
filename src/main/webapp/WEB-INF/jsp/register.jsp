<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Guestbook</title>
</head>

<body>
  <h2>Register</h2>
  <form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/reg/">
    <table>
      <tr>
        <td><form:label path="username">Name</form:label></td>
        <td><form:input path="username" /></td>
      </tr>
      <tr>
        <td><form:label path="password">Password</form:label></td>
        <td><form:input path="password" /></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="Submit" /></td>
      </tr>
    </table>
  </form:form>

</body>
</html>
