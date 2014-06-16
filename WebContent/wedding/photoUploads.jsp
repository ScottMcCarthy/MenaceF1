<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>claireandscottwedding.co.uk</title>
<%@ page language="java" import="menaceF1.wedding.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<% response.addHeader("P3P", "CP=\"CAO DSP COR CURa ADMa DEVa OUR IND PHY ONL UNI COM NAV INT DEM PRE\""); %>

</head>

<body bgcolor="#e2e2e0">
<jsp:include page="/wedding/header.jsp" />
<p></p>

<%
	WeddingGuest guest = (WeddingGuest)session.getAttribute("WEDDINGGUEST");
 %>

<table border="0" width="100%" bgcolor="#d9dee4">
	<tbody>
		<tr>
			<td width="20%" valign="top" align="center">
			<table border="0" cellpadding="0" cellspacing="15" bgcolor="#cbccda">
				<tbody>
					<tr>
						<td align="center" ><a href="/MenaceF1/home.do">Home</a></td>
					</tr>
					<tr>
						<td align="center"><a href="/MenaceF1/orderOfDay.do">Order of the
						Day</a></td>
					</tr>
					<% if (guest.isFullGuest()){ %>
					<tr>
						<td align="center"><a href="/MenaceF1/church.do">The Church</a></td>
					</tr>
					<% } %>
					<tr>
						<td align="center"><a href="/MenaceF1/reception.do">The Reception</a></td>
					</tr>
					<% if (guest.isFullGuest()){ %>
					<tr>
						<td align="center"><a href="/MenaceF1/menu.do">Wedding Breakfast</a></td>
					</tr>
					<% } %>					
					<tr>
						<td align="center"><a href="/MenaceF1/rsvp.do">R.S.V.P.</a></td>
					</tr>	
					<tr>
						<td align="center"><a href="/MenaceF1/giftList.do">Wedding Gift List</a></td>
					</tr>									
					<tr>
						<td align="center"><a href="/MenaceF1/accomodation.do">Accommodation</a></td>
					</tr>
					<tr>
						<td align="center"><a href="/MenaceF1/directions.do">Maps &amp; Directions</a></td>
					</tr>
					<tr>
						<td align="center"><a href="/MenaceF1/photos.do">Your Photos</a></td>
					</tr>					
					<tr>
						<td align="center"bgcolor="#515b5d" ><font color="white">Your Photos</font></td>
					</tr>
					<tr>
						<td align="center"><a href="/MenaceF1/music.do">Music Requests</a></td>
					</tr>
					<% if (guest.isAdmin()){ %>
					<tr>
						<td align="center"><a href="/MenaceF1/admin.do">Admin Page</a></td>
					</tr>
					<% } %>																									
				</tbody>
			</table>
			</td>

			<td valign="top" align="center">
<b><u><font size="+3">Upload your photos</font></u></b><br />
				<br />Thank you <%=request.getSession().getAttribute("photoName") %><br/>Please use the tool below to upload your photos.
<br />
<applet
		title="JUpload"
		name="JUpload"
		code="com.smartwerkz.jupload.classic.JUpload"
		codebase="wedding/jupload/"
		archive="dist/jupload.jar,
				dist/commons-codec-1.3.jar,
				dist/commons-httpclient-3.0-rc4.jar,
				dist/commons-logging.jar,
				dist/skinlf/skinlf-6.2.jar"
		width="640"
		height="480"
		mayscript="mayscript"
		alt="JUpload by www.jupload.biz">

	<param name="Config" value="cfg/jupload.default.config">

	Your browser does not support Java Applets or you disabled Java Applets in your browser-options.
	To use this applet, please install the newest version of Sun's Java Runtime Environment (JRE).
	You can get it from <a href="http://www.java.com/">java.com</a>

</applet>	
<br />
Once your photos have been uploaded, they will be checked by one of the site moderators, and can then be viewed on the <a href="/MenaceF1/photos.do">photos page</a>.	
			</td>
		</tr>
	</tbody>
</table>





</body>
</html>
