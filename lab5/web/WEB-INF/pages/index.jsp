<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Countries</title>
  <style><%@include file="/WEB-INF/static/css/style.css"%></style>
</head>
<body>
<jsp:useBean id="countries" class="java.util.ArrayList" scope="request"/>
<c:choose>
  <c:when test="${not empty countries}">
    <table class="blueTable">
      <tr>
        <th>Name</th>
        <th>Population</th>
        <th>Capital</th>
        <th>Polity</th>
        <th>Founding Date</th>
        <th>Area</th>
        <th>Area Units</th>
      </tr>
      <c:forEach var="country" items="${countries}">
        <tr>
          <td>${country.name}</td>
          <td>${country.population}</td>
          <td>${country.capital}</td>
          <td>${country.policy}</td>
          <td>${country.foundingDate}</td>
          <td>${country.area.areaSize}</td>
          <td>${country.area.areaUnits}</td>
        </tr>
      </c:forEach>
    </table>
  </c:when>
  <c:otherwise>
    <h2>No countries</h2>
  </c:otherwise>
</c:choose>
</body>
</html>