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
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
				<b><u><font size="+3">Order of the Day</font></u></b><br />
			<font size="+1"><br />
			<% if (guest.isFullGuest()){ %>
			<table>
				<tr><td>1:15pm</td><td width="5"></td><td>Arrive at All Saints Church Fleet</td></tr>
				<tr><td>1:30pm</td><td width="5"></td><td>Wedding Ceremony</td></tr>
				<tr><td>2.15pm</td><td width="5"></td><td>Photo's at the Church</td></tr>
				<tr><td>2.45pm</td><td width="5"></td><td>Make your way to Farnham Castle</td></tr>
				<tr><td>3pm</td><td width="5"></td><td>Reception drinks, canapés and photos at the Castle</td></tr>
				<tr><td>4.30pm</td><td width="5"></td><td>Wedding Breakfast and speeches</td></tr>
				<tr><td>8pm</td><td width="5"></td><td>Evening guests arrive</td></tr>
				<tr><td>8:30pm</td><td width="5"></td><td>First Dance</td></tr>
				<tr><td>9:30pm</td><td width="5"></td><td>Wedding Cake, Welsh Cakes, tea &amp; coffee</td></tr>
				<tr><td>11:15pm</td><td width="5"></td><td>Last orders at the bar</td></tr>
				<tr><td>11.30pm</td><td width="5"></td><td>Bar closes and music finishes</td></tr>
				<tr><td>midnight</td><td width="5"></td><td>The venue requests that guests have departed by midnight please</td></tr>
			</table>	
			<p align="left">
				Please note, there is another wedding at All Saints Church before ours.  Their service should be finished by 12.15 and the church has allowed an hour for their guests to depart.
			</p>					
			<% } %>
			<% if (!guest.isFullGuest() ){ %>
			<table>
				<tr><td>8pm</td><td width="5"></td><td>Arrive at the castle</td></tr>
				<tr><td>8:30pm</td><td width="5"></td><td>First Dance</td></tr>
				<tr><td>9:30pm</td><td width="5"></td><td>Wedding Cake, Welsh Cakes, tea &amp; coffee</td></tr>
				<tr><td>11:15pm</td><td width="5"></td><td>Last orders at the bar</td></tr>
				<tr><td>11.30pm</td><td width="5"></td><td>Bar closes and music finishes</td></tr>
				<tr><td>midnight</td><td width="5"></td><td>The venue requests that guests have departed by midnight please</td></tr>
			</table>			
			<% } %>
			</font>
			</td>
		</tr>
	</tbody>
</table>





</body>
</html>