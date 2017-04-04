<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:out value="${name}"></c:out> <p/>

<sql:query var="rs" dataSource="jdbc/springTutorialsDB">
select id, name, email, text from offers
</sql:query>


<c:forEach var="row" items="${rs.rows}">
    Name: ${row.name}<br/>
    id: ${row.id}<br/>
</c:forEach>

</body>
</html>

