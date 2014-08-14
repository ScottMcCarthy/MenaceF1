<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />
<title>The Wedding of Richard and Sharon</title>
<%@ page language="java" import="menaceF1.wedding.*,menaceF1.*"
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
			<td>
				
				<br /><b><u><font size="+3">Upload your photos</font></u></b><br />
				<br />We would love you to share any photos you took during our wedding with us and our other guests.<br />
				You can upload multiple photos in one go providing you are using a modern browser / phone.<br />


	<form name="weddingimages" method="post"
                        enctype="multipart/form-data" action="/MenaceF1/photoUpload.do"  >
	<br />Please enter your name:<br /><input type="text" name="guestname" size="50"><br />
	<input type="file" multiple="multiple" name="files" size="50" />
<br />
	<input type="submit" value="Upload photos" />
	<br />
	</form>
			
				<b><u><font size="+3">Photos</font></u></b><br />
				<br />The following photo galleries have been uploaded to our website:
				<br />
<%
			Menweb menJava = new Menweb();
			menJava.setShowLogo(false);
			menJava.directoryTrawler("/var/www/wedding/");
			menJava.galleryFront("/var/www/wedding/",out,"weddingGallery.jsp");
%>				
			</td>
		</tr>
	</tbody>
</table>





</body>
</html>
