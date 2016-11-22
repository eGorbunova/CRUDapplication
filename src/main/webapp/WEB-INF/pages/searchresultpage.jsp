<%--
  Created by IntelliJ IDEA.
  User: Work
  Date: 22.11.2016
  Time: 8:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Search results</title>
  <style type="text/css">
    .tg {
      border-collapse: collapse;
      border-spacing: 0;
      border-color: #ccc;
    }

    .tg td {
      font-family: Arial, sans-serif;
      font-size: 14px;
      padding: 10px 5px;
      border-style: solid;
      border-width: 1px;
      overflow: hidden;
      word-break: normal;
      border-color: #ccc;
      color: #333;
      background-color: #fff;
    }

    .tg th {
      font-family: Arial, sans-serif;
      font-size: 14px;
      font-weight: normal;
      padding: 10px 5px;
      border-style: solid;
      border-width: 1px;
      overflow: hidden;
      word-break: normal;
      border-color: #ccc;
      color: #333;
      background-color: #f0f0f0;
    }

    .tg .tg-4eph {
      background-color: #f9f9f9
    }
  </style>
</head>

<body>
<a href="../../index.jsp">Back to start page </a>
<br/>
<h1>Search results</h1>


<c:if test="${!empty users}">
  <table class="tg">
    <tr>
      <th width="80">ID</th>
      <th width="120">Name</th>
      <th width="120">Age</th>
      <th width="120">Admin</th>
      <th width="120">Created date</th>
    </tr>
    <c:forEach items="${users}" var="user">
    <tr>
      <td><c:out value="${user.id}" /></td>
      <td><c:out value="${user.name}" /></td>
      <td><c:out value="${user.age}" /></td>
      <td><c:out value="${user.isAdmin? \"yes\" : \"no\"}" /></td>
      <td><c:out value="${user.createdDate}" /></td>
    </tr>
    </c:forEach>
  </table>
</c:if>

<c:if test="${empty users}">
  No matching users found.
</c:if>
</body>
</html>
