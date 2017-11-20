<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IAM - RAPPROCHEMENT DES FACTURES</title>
<link rel="shortcut icon" href="images/favicon.ico">
</head>
<body>


	<div id="result">
		<h3>${requestScope["message"]}</h3>
		<br>
	</div>
	File name : ${requestScope["name"]}
	<br> File size : ${requestScope["size"]}
	<br> File type : ${requestScope["type"]}


</body>
</html>