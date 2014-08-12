<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>The Wedding of Richard and Sharon</title>
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
	<jsp:useBean id="gal" class="menaceF1.Menweb" scope="session"/>
	<jsp:setProperty name="gal" property="*"/> 
<a href="/MenaceF1/admin.do">Return to the admin page</a>
<%
	String userPassword = request.getParameter("password");
	if (gal.isPasswordProtected(gal.getGallery())) {
		if (!gal.securityCheck(gal.getGallery(),userPassword)) {
	
%>

<form name="paswordForm" action="weddingGallery.jsp" method="post">
<input type="hidden" name="gallery" value="<%=request.getParameter("gallery")%>">

<TABLE border="1" width="100%" bgcolor="#ffffff">

	<TBODY>
<% if (userPassword !=null) { %>
		<TR>
			<TD align="center"><FONT size="4" color="#ff0000">Sorry, you have entered an incorrect password, please try again.</FONT></TD>
		</TR>
<% } %>
		<TR>
			<TD align="center"><FONT size="4">This gallery is password protected, you must enter the password below to view this gallery</FONT></TD>
		</TR>
		<TR>
			<TD align="center"><input type="password" name="password" maxlength="15" size="16"><br>
			<input type="submit" value="submit" name="enterPassword">
			</TD>
		</TR>
	</TBODY>
</TABLE>	
</form>
<%
	}}
	if ((!gal.isPasswordProtected(gal.getGallery())) || gal.securityCheck(gal.getGallery(),userPassword)){
%>
<TABLE border="1" width="100%" bgcolor="#ffffff">

	<TBODY>
		<TR>
			<TD><FONT size="4"><I>Click on a thumbnail to view a larger image
			<br />Once you have checked the images, you can <a href="publishGallery.do?directory=<%=gal.getGalleryName() %>">publish this galery to the website</a> or <a href="deleteGallery.do?directory=<%=gal.getGalleryName() %>">delete these photos</a>
			</I></FONT></TD>
		</TR>
	</TBODY>
</TABLE>
<%
			gal.thumbsHTML(gal.getGallery(), gal.getGalleryName().substring(0,gal.getGalleryName().length()-10), out,request.getParameter("gallery"),"restrictedWeddingMidsize.jsp");
	}
%>			</td>
		</tr>
	</tbody>
</table>





</body>
</html>
