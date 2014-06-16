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
				<b><u><font size="+3">The Church of St. John </font></u></b><br>
			<strong><br>
			<b><font size="+1">The church of St. John  is in
			the village of Waterbeach, <br>
			which is approx. 7 miles north of
			Cambridge.<br>
			<br>
			It is easily accessible by both train and car. <br>
			Please see the <a
				href="/MenaceF1/directions.do">Map &amp; Directions</a> page for details of
			how to get here. </font></b></strong><br>
			<table CELLSPACING = "2" cellpadding="10">
			<tr>
			<td>
			<p align="left"><img border="0"
				src="/MenaceF1/wedding/images/church1.jpg" width="373" height="497"></p>
				</td><td valign="top">
			<p align="left"><font size="+1"></font></p>
					<p align="left"><font size="+1">The church of St. John
					the Evangelist is an edifice of the 13th century, in the early
					English style with perpendicular insertions, and consists of
					chancel, clerestoried nave, aisles, south porch and an embattled
					western tower containing a clock and bells. The windows of the
					clerestory and aisles are perpendicular, and the chancel is
					enriched with an alabaster and mosaic reredos. The beautiful font
					of marble and Caen stone and a very elaborate brass lectern were
					presented by friends of the late vicar. </font></p>
					<p align="left"><font size="+1">The chancel, nave and
					aisles have been restored, and the church enlarged and reseated
					with carved oak benches, and in 1878 a stained window was placed in
					the belfry. In the nave floor is a stone inscribed to William Stane
					M.D. a Fellow of the Royal College of Physicians in London, d. 11
					Feb. 1679. The pulpit was erected in 1879, as a memorial to the
					Rev. William Keatinge Clay B.D. vicar here 1854-67, it is of Caen
					stone and alabaster, inlaid with representations in mosaic of the
					Sermon on the Mount and the preaching of St. Paul, and is further
					adorned with statuettes of St. John the Baptist and the Prophet
					Elijah. </font></p>
					<p align="left"><font size="+1">The Church was restored
					in 1878, at a cost of £3,500, and affords 450 sittings. The
					register dates from the year 1653.</font></p>
					</td></tr></table>
			<p align="left"></p><br><br />
			</td>
		</tr>
	</tbody>
</table>





</body>
</html>
