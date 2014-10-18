<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />
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
						<td align="center" ><a href="/MenaceF1/home.do">Home</a></td>
					</tr>
					<tr>
												<td align="center"><a href="/MenaceF1/orderOfDay.do">Order of the
						Day</a></td>
					</tr>
					<% if (guest.isFullGuest()){ %>
					<tr>
						<td align="center" bgcolor="#515b5d" ><font color="white">The Church</font></td>
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
				<b><u><font size="+3">All Saints Church </font></u></b><br>
			<strong><br>
			<b><font size="+1">All Saints Church is located in the centre of Fleet.
			
			<br>
			<br>
			It is easily accessible by both train and car. <br>
			Please see the <a
				href="/MenaceF1/directions.do">Map &amp; Directions</a> page for details of
			how to get here. </font></b></strong>
			<br /> <br />
<font size="5">The church requests that confetti may only be thrown outside the church, provided it is natural petals.<br /><br /></font>
			<table CELLSPACING = "2" cellpadding="10">
			<tr>
			<td valign="top">
			<p align="left"><img border="0"
				src="/MenaceF1/wedding/images/fleet13.JPG"></p>
				</td><td valign="top">
			<p align="left"><font size="+1"></font></p>
					<p align="left"><font size="+1">In 1860 Charles Edward Lefroy, Secretary to the Speaker of the House of Commons, commissioned All Saints Church, Fleet - in memory of his wife, Janet Walker, who had died in 1857. The architect was William Burges, among the greatest of the Victorian art-architects.
The ecclesiastical parish of Ewshot and Crookham was split into two in 1862 with the northern section based on the All Saints church, becoming the new parish of Fleet.

Lefroy did not live to complete the design. It was completed by James Walker, Janet's father.

lefroy

A memorial to Charles Lefroy, probably by Thomas Nicholls, is now in the north west of the church beside his wife, and with their dogs at their feet.
</font></p>

					</td></tr></table>
			<p align="left"></p><br><br />
			</td>
		</tr>
	</tbody>
</table>





</body>
</html>
