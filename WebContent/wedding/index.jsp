<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>claireandscottwedding.co.uk</title>
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
			
			<object width="560" height="340"><param name="movie" value="http://www.youtube.com/v/pZRBrB6dlPs&hl=en_GB&fs=1&"></param><param name="allowFullScreen" value="true"></param><param name="allowscriptaccess" value="always"></param><embed src="http://www.youtube.com/v/pZRBrB6dlPs&hl=en_GB&fs=1&" type="application/x-shockwave-flash" allowscriptaccess="always" allowfullscreen="true" width="560" height="340"></embed></object>
			
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
