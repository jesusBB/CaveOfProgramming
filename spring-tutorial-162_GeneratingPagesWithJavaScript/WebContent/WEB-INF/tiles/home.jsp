<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<p>
<c:choose>
<c:when test="${hasOffer}">
	<a href="${pageContext.request.contextPath}/createoffer">Edit or delete your current offer</a>
</c:when>
<c:otherwise>

	<a href="${pageContext.request.contextPath}/createoffer">Add a new offer</a>
	
</c:otherwise>

</c:choose>
&nbsp;


<sec:authorize access="hasRole('ROLE_ADMIN')">
	<a href="<c:url value='/admin'/>">Admin</a>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
	<a href="<c:url value='/messages'/>">Messages (<span id="numberMessages">0</span>)</a>
</sec:authorize>

<table class="offers">
<tr><td>Name</td><td>Email</td><td>Offer</td></tr>

<c:forEach var="offer" items="${offers}">
<tr>

<td><c:out value="${offer.user.name}"></c:out></td>

<td><a href="<c:url value='/message?uid=${offer.username}'></c:url>">Contact</a></td>

<td><c:out value="${offer.text}"></c:out></td>
   
</tr>
</c:forEach>
</table>


<script type="text/javascript">
function updateMessageLink(data){
	$("#numberMessages").text(data.number);
}

function onLoad(){
	window.setInterval(updatePage, 5000);
}

function updatePage(){
	$.getJSON("<c:url value="/getmessages"/>",updateMessageLink);
	
}

$( document ).ready(function() {
    onLoad();
});
</script>