<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet"></link>
	
<script type="text/javascript" src="${pageContext.request.contextPath}/static/script/jquery-3.2.1.min.js"></script>

<script type="text/javascript">

function onLoad(){
	$("#password").keyup(checkPasswordMatch);
	$("#confirmpass").keyup(checkPasswordMatch);
	
	$("#details").submit(canSubmit);
}

function checkPasswordMatch(){
	var password = $("#password").val();
	var confirmpass = $("#confirmpass").val();
	
	if(password.lenght < 3 || confirmpass.length < 3){
		return;
	}
	
	if(password == confirmpass){
		$("#matchpass").text("Password match")
	}else{
		$("#matchpass").text("Password do not match")
	}
	
	alert(password + "-" + confirmpass );
}

function canSubmit(){
	var password = $("#password").val();
	var confirmpass = $("#confirmpass").val();
	
	if(password == confirmpass){
		return true;
	}else{
		return false;
	}
}
$(document).ready(onLoad);

</script>

<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Create New Account</title>
</head>
<body>



	<sf:form id="details" method="post"
		action="${pageContext.request.contextPath}/createaccount"
		commandName="user">

		<table class="formtable">
			<tr>
				<td class="label">Username:</td>
				<td><sf:input class="control" name="username" type="text"
						path="username" /><br/><sf:errors path="username" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Password:</td>
				<td><sf:input id="password" class="control" name="password" type="text"
						path="password" /><br/><sf:errors path="password" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Email:</td>
				<td><sf:input class="control" name="email" type="text"
						path="email" /><br/><sf:errors path="email" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Confirm Password:</td>
				<td><input id="confirmpass" class="control" name="confirmpass" type="text"
						/><br/><div id="matchpass"></div></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input class="control" value="Create advert" type="submit"/></td>
			</tr>
		</table>

	</sf:form>

</body>
</html>