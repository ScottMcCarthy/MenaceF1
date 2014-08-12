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
					<% if (guest.isFullGuest()){ %>
					<tr>
						<td align="center"><a href="/MenaceF1/menu.do">Wedding Breakfast</a></td>
					</tr>
					<% } %>					
					<tr>
						<td align="center"><a href="/MenaceF1/rsvp.do">R.S.V.P.</a></td>
					</tr>	
					<tr>
						<td align="center" bgcolor="#515b5d"><font color="white">Wedding Gift List</font></td>
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
				<b><u><font size="+3">Wedding Gift List</font></u></b><br>
			<p align="left"><font size="+1">Dear Family &amp; Friends,<br>
			<br />
We know it's traditional to write a gift list, but in truth, we're in need of very little, and in fact have duplicates of most things.  If it is still your desire to present us with a wedding gift, we would be extremely grateful for a donation towards our dream honeymoon please. 
<br /><br />
With this in mind, and taking inspiration from the Chinese, you will find a blank envelope with your invitation.  Should you wish to anonymously donate towards our first holiday as a married couple, you'll find a wedding post box in the hall at the reception where you can also leave any wedding cards and write in our wedding book. Obviously, if you would like us to know who the donation is from, please leave a little note in the envelope for us.
<br /><br />
The biggest gift of all is to be able to share our special day with you and we look forward to seeing you there on the day.
<br /><br />
Much love<br />
Richard &amp; Sharon
			</font></p>
			</td>
		</tr>
</tbody>
</table>
</body>
</html>
