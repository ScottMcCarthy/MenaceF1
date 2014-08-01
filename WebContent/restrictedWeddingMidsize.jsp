<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>The Wedding of Sharon and Richard</title>
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
						<td align="center"><a href="/MenaceF1/home.do">Home</a></td>
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
						<td align="center"><a href="/MenaceF1/music.do">Music Requests</a></td>
					</tr>
					<% if (guest.isAdmin()){ %>
					<tr>
						<td align="center" bgcolor="#515b5d"><font color="white">Admin Page</font></td>
					</tr>
					<% } %>																									
				</tbody>
			</table>
			</td>

			<td valign="top" align="left">
<a href="/MenaceF1/photos.do">Return to list of galleries</a>
	<jsp:useBean id="gal" class="menaceF1.Menweb" scope="session"/>
	<jsp:setProperty name="gal" property="*"/> 


<TABLE border="1" width="100%" bgcolor="#ffffff">

	<TBODY>
		<TR>
			<TD><FONT size="4"><I>Click on the image to view the original full size version (May take some time to download)</I></FONT></TD>
		</TR>
	</TBODY>
</TABLE>
<table>
<tbody>
<tr>
<td>
<%
			gal.imageHTML(gal.getGallery(), gal.getGalleryName(),request.getParameter("filename") , out);
%>
</td>
</tr>
</tbody>
</table>





</td>
</tr>
</tbody>
</table>


</body>
</html>
