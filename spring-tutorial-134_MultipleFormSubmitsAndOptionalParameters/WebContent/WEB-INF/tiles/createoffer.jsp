<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sf:form method="post" action="${pageContext.request.contextPath}/docreate" commandName="offer">
<sf:hidden path="id" />
<table class="formtable">
<tr><td class="label">Your offer: </td><td><sf:textarea class="control"  path="text" name="text" rows="10" cols="10"></sf:textarea><br/><sf:errors path="text" cssClass="error"></sf:errors></td></tr>
<tr><td class="label"> </td><td><input class="control"  value="Save advert" type="submit" /></td></tr>

<c:if test="${offer.id != 0 }">
	<tr><td class="label">&nbsp;</td></tr>
	<tr><td class="label"> </td><td><input class="control" name="delete" value="Delete this offer" type="submit" /></td></tr>
</c:if>

</table>

</sf:form>
