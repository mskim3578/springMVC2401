<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html><html><head>
<title>회원 목록</title></head><body>
<ul>
	<c:forEach var="mi" items="${members}">
	<li><a href="<%=request.getContextPath() %>/members/${mi.id}">${mi.name}</a></li>
	</c:forEach>
</ul></body></html>