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
						<td align="center"bgcolor="#515b5d" ><font color="white">Order of the Day</font></td>
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
				<b><u><font size="+3">Order of the Day</font></u></b><br>
			<font size="+1"><br>
			<% if (guest.isFullGuest()){ %>
			12:30 - Guests arrive at St. John the Evangelist Church, Waterbeach<br>
			13:00 - Marriage ceremony<br>
			13:45 - Photos and afternoon tea in the Church hall<br>
			<br>
			15:30 - Drinks reception at Downing College, Cambridge<br>
			17:00 - Wedding breakfast in the college hall<br>
			<br>
			
			19:30 - Evening guests arrive &amp; disco <%if (!guest.isFullGuest()) {%>at Downing College, Cambridge<%} %><br>
			Midnight - Bride &amp; Groom leave<br>
			<% } %>
			<% if (!guest.isFullGuest() ){ %>
			19:30 - Evening guests arrive &amp; disco <%if (!guest.isFullGuest()) {%>at Downing College, Cambridge<%} %><br>
			20:00 - First dance and disco <br />
			21:30 - Coffee and wedding cake<br />
			Midnight - Bride &amp; Groom leave<br>
			<% } %>
			
			
			</font>
			</td>
		</tr>
	</tbody>
</table>





</body>
</html>
