<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />
<title>The Wedding of Richard and Sharon</title>
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
			<td align="center"><html:errors />Your session has timed-out after a period of inactivity.  Please log-in again.<br />
			<br /><font size="4"><i>Welcome to our wedding website<br>
			To enter our site,
			please enter your password you were given in your invitation or save-the-date card.</i></font><html:form action="password.do"  >
			<html:password size="20" property="password" /><br />
			<html:submit value="Enter our wedding website" />
			</html:form>
			</td>
		</tr>
	</tbody>
</table>





</body>
</html>
