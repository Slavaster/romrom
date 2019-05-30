<%@ page language="java" contentType="text/html; charset=US-ASCII"
pageEncoding="US-ASCII" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
	<title>Login Success Page</title>
</head>
<body>
	<style type="text/css">
		#send_email_form{
			border-style: inset; 
			position: absolute;
			top:50%;
			left:50%;
			margin-left: -100px;
			margin-top: -100px;
			padding: 10px;
			padding-bottom: 30px;
		}
		#send_email_button{
			position: absolute;
			right: 0;
			margin: 10px;
			margin-top: 5px;
			color: green;
		}
	</style>
	<form action="/send-email" method="POST" id="send_email_form">
		<table>
			<tr>
				<td>Recipient:</td>
				<td><input type="text" name="recipient" size="40"></td>
			</tr>
			<tr>
				<td>Subject:</td>
				<td><input type="text" name="messageSubject" size="40"></td>
			</tr>
			<tr>
				<td>Message text:</td>
				<td><textarea name="messageText" cols="40" rows="5"></textarea></td>
			</tr>
		</table>	
		<button id="send_email_button">Send</button>
	</form>
	
</body>
</html>