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
						<td align="center" bgcolor="#515b5d"><font color="white">Home</font></td>
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

			<td valign="top" align="center"><b><u><font size="+3">The Wedding of Richard John Fuller &amp; Sharon McCarthy</font></u></b>
			<p align="left">
			<font size="+1">Welcome to our wedding website. </font></p>
			<p align="left"><font size="+1">We hope you will be able to
			join us to celebrate our special day on Saturday 9th May 2015.<br />
			<br />
			We have made the decision to only ask children that are in the wedding party or extended family . If your child or children are invited their names will be included on the invitation.
			<br /><br />
			Ladies, hats and fascinators would be welcomed but are by no means required.
			<br /><br />
			This website is designed to help you find all the information you
			need for the day, including accommodation, maps and some fun elements
			to help make the day as memorable for you as I'm sure it will be for
			us.<br />
			<br />
			Please check back from time to time, as we'll try to keep this up to
			date with the latest information you need and new features as the
			date gets closer.</font></p>
			<p align="left"><font size="+1">To explore the site, please
			select an item from the left-hand navigation bar.
			<br />
			<br />
			If you need to contact us for any reason, please e-mail us at <a
				href="mailto:SharonAndRichard@richardandsharonwedding.co.uk?Subject=Wedding">SharonAndRichard@richardandsharonwedding.co.uk</a>
			
			</font></p>
			</td>
		</tr>
	</tbody>
</table>





</body>
</html>
