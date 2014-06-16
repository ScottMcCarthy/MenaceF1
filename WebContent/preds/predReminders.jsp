<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page 
language="java" import="menaceF1.*"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="GENERATOR" content="IBM WebSphere Studio">
<meta http-equiv="Content-Style-Type" content="text/css">
<link href="../theme/Master.css" rel="stylesheet" type="text/css">
<title>predReminders.jsp</title>
</head>
<body>

<% 

Preds preds = new Preds();
preds.predReminder();
%>

<p>Pred Reminders Completed</p>
</body>
</html>
