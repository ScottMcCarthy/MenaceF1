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
			<br>
			We do not expect a gift and do not have a list as we already have everything we 
need for our home.&nbsp;&nbsp; We understand that many of you will have the expense of 
traveling and accommodation.&nbsp; Having our family and friends here to celebrate 
with us is the best present we could ask for.&nbsp; <br>
			<br>
			We feel that happy memories are 
far more precious than toasters and towels, so if you would really like to get 
us something then vouchers towards our dream honeymoon in Mauritius would really 
be appreciated and a gift never forgotten. <br>
			<br>Vouchers can be purchased via the <a
				href="http://www.kuoni.co.uk/vouchers/" target="_blank">Kuoni vouchers website</a>.<br>Please quote our booking reference number: <b>8712009</b><br>
			<br>
			Thank you so much for any contribution you make and we look forward to seeing you on our big day!<br>
			<br>
			Best wishes<br>
			<br>
			Scott &amp; Claire</font></p>
			</td>
		</tr>
</tbody>
</table>
</body>
</html>
