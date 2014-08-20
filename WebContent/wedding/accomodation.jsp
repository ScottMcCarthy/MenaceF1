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

<table border="0" width="106%" bgcolor="#d9dee4">
	<tbody>
		<tr>
			<td width="21%" valign="top" align="center">
			<table border="0" cellpadding="0" cellspacing="15" bgcolor="#cbccda">
				<tbody>
					<tr>
						<td align="center"><a href="/MenaceF1/home.do">Home</a></td>
					</tr>
					<tr>
						<td align="center"><a href="/MenaceF1/orderOfDay.do">Order
						of the Day</a></td>
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
						<td align="center" bgcolor="#515b5d"><font color="white">Accommodation</font></td>
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

			<td valign="top" align="left" width="780"><b><u><font size="+3"><p align="center">Local
			Accommodation</p></font></u></b>

			The following is a list of local hotels near to the reception venue. Please check with the hotel for parking arrangements.</font><br>
			<br />
			<table border="1">
				<tbody>
					<tr>
						<td><b>Hotel</b></td>
						<td><b>Map</b></td>
					</tr>
					<tr>
						<td valign="top"><font size="+1"><a
							href="http://www.mercure.com/gb/hotel-6621-mercure-farnham-bush-hotel/index.shtml">Mercure Farnham Bush Hotel</a><br>
						<br>
						The Borough <br />
						Farnham <br />
						GU9 7NN <br /><br />
						Tel: +44 1252 234800 <br />
						<br />
						Distance from Church : 6.1 miles<br />Distance from Castle : 0.3 miles
						</td>
						<td>
						<iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d4998.413842131014!2d-0.801037463433442!3d51.21526373845667!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x6e9622f851a6732d!2sMercure+Bush+Hotel+Farnham!5e0!3m2!1sen!2suk!4v1408438994387" width="600" height="420" frameborder="0" style="border:0"></iframe>
						</td>
					</tr>
					<tr>
						<td valign="top"><font size="+1"><a
							href="http://www.farnhamhousehotel.com">Farnham House Hotel</a><br>
						<br>
						Alton Road<br />
						Farnham<br />
						Surrey<br />
						GU10 5ER<br />
						<br />
						Tel: +44 1252 716908<br />
						<br />
						Distance from Church : 7.7 miles<br />Distance from Castle : 2.3 miles

						<td><iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d10000.454572180279!2d-0.8375793312103481!3d51.19855761397681!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x48742dac267e6393%3A0x5ae0745b888740bb!2sFarnham+House+Hotel!5e0!3m2!1sen!2suk!4v1408439299391" width="600" height="420" frameborder="0" style="border:0"></iframe>
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
