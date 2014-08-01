<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>The Wedding of Sharon and Richard</title>
<%@ page language="java" 
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<% response.addHeader("P3P", "CP=\"CAO DSP COR CURa ADMa DEVa OUR IND PHY ONL UNI COM NAV INT DEM PRE\""); %>
</head>

<body bgcolor="#e2e2e0">
<jsp:include page="/wedding/header.jsp" />
<p></p>

<table border="1" width="100%" bgcolor="#ffffff">
	<tbody>
		<tr>
			<td align="center">
			
			<img border="1" src="/MenaceF1/wedding/images/sharonAndRich.jpg" >
						
			<html:errors /><br />
			<br /><font size="4"><i>Welcome to our wedding website<br>
			To enter our site,
			please enter your password you were given in your invitation.
			</i></font><html:form action="password.do"  >
			<html:password size="20" property="password" /><br />
			<html:submit value="Enter our wedding website" />
			</html:form>
			</td>
		</tr>
	</tbody>
</table>





</body>
</html>
