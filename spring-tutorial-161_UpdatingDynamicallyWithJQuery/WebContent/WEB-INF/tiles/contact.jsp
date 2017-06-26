<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h2>Send Message</h2>

User: ${fromUser}

<sf:form method="post" commandName="message">

	<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
	<input type="hidden" name="_eventId" value="send" />
	<input type="hidden" name="username" value="jesulito" />

	<table class="formtable">
		<tr>
			<td class="label">Your name:</td>
			<td><sf:input class="control" path="name" type="text" value="${fromName}" /><br />
				<div class="error">
					<sf:errors path="name"></sf:errors>
				</div></td>
		</tr>
		<tr>
			<td class="label">Your email:</td>
			<td><sf:input class="control" path="email" type="text" value="${fromEmail}"/><br />
				<div class="error">
					<sf:errors path="email"></sf:errors>
				</div></td>
		</tr>
		<tr>
			<td class="label">Subject:</td>
			<td><sf:input class="control" path="subject" type="text" /><br />
				<div class="error">
					<sf:errors path="subject"></sf:errors>
				</div></td>
		</tr>
		<tr>
			<td class="label">Your Message:</td>
			<td><sf:textarea class="control" path="content" name="name"
					type="text" /><br />
				<div class="error">
					<sf:errors path="content"></sf:errors>
				</div></td>
		</tr>
		<tr>
			<td class="label"></td>
			<td><input class="control" value="Send message" type="submit" /></td>
		</tr>
	</table>

</sf:form>
