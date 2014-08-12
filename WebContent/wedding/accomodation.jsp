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

			<td valign="top" align="center" width="780"><b><u><font size="+3">Local
			Accommodation</font></u></b><br>
			<strong><br></strong>
		
			<font size="+1"><a
				href="http://www.theaa.com/travel/basicsearch/preparepoisearchstage1.do?statusstage1=new&amp;page=placesstay">The
			AA website</a> has a list of Hotels, B&amp;Bs and guest-houses in the area.<br>
			<br>
			The following is a list of local hotels and
			guest houses near to the reception venue. Please check with the hotel for parking arrangements. Overnight parking at the College is only available to guests staying at the College.</font><br>
			<br />
			<table border="1">
				<tbody>
					<tr>
						<td><b>Hotel</b></td>
						<td><b>Map</b></td>
					</tr>
					<tr>
						<td valign="top"><font size="+1"><a
							href="https://www.travelodge.co.uk">Travelodge</a><br>
						<br>
						Cambridge Leisure Park<br>
						Clifton Way<br>
						Cambridge<br>
						CB1 7DY<br>
						<br>
						Tel: 0871 984 6101 <br>
						<a href="https://www.travelodge.co.uk">www.travelodge.co.uk</a><br>
						<br>
						<% if (guest.isFullGuest()){ %>Distance to Church: 6.9 Miles<br><%} %>
						Distance to Reception: 1.1 Miles </font><br>
						</td>
						<td><iframe src="http://www.tinymap.net/embedded/t1YBHLJ0rBq?w=600&h=420&clat=52.1931&clng=0.1405&z=15&v=n&c=1&d=1" frameborder="0" scrolling="no" width="600" height="420" marginwidth="0" marginheight="0"></iframe><br />
						<small><a
							href="http://www.google.co.uk/maps?f=q&amp;hl=en&amp;geocode=&amp;q=CB1+7DY&amp;ie=UTF8&amp;ll=52.196192,0.141191&amp;spn=0.015783,0.025749&amp;z=14&amp;iwloc=addr&amp;source=embed"
							style="color:#0000FF;text-align:left">View larger map and
						driving directions</a></small></td>
					</tr>
					<tr>
						<td valign="top"><font size="+1"><a
							href="http://www.devere-hotels.com/our-hotels/university-arms/the-hotel">The
						University Arms</a><br>
						<br>
						<span id="ctl00_ContentPlaceHolder1_HotelContact1_lblFullName"></span><span
							id="ctl00_ContentPlaceHolder1_HotelContact1_lblAddress">Regent
						Street<br>
						Cambridge<br>
						Cambridgeshire<br>
						CB2 1DB</span> <br>
						<br>
						Tel: <span
							id="ctl00_ContentPlaceHolder1_HotelContact1_lblTelephone">01223
						273000</span><br>
						<a
							href="http://www.devere-hotels.com/our-hotels/university-arms/the-hotel">www.devere-hotels.com</a><br>
						<br>
						<% if (guest.isFullGuest()){ %>Distance to Church: 6.4 Miles<br><%} %>
						Distance to Reception: 0.2 Miles</font></td>
						<td><iframe src="http://www.tinymap.net/embedded/aRcqqgZrDGM?w=600&h=420&clat=52.2018&clng=0.1259&z=16&v=n&c=1&d=1"
frameborder="0" scrolling="no" width="600" height="420" marginwidth="0" marginheight="0"></iframe><br />
						<small><a
							href="http://www.google.co.uk/maps?f=q&amp;hl=en&amp;geocode=&amp;q=CB2+1DB&amp;ie=UTF8&amp;ll=52.207764,0.129089&amp;spn=0.007654,0.014398&amp;z=14&amp;iwloc=addr&amp;source=embed"
							style="color:#0000FF;text-align:left">View larger Map and
						driving directions</a></small></td>
					</tr>
					<tr>
						<td valign="top"><font size="+1"><a href="http://www.cambridgegardenhouse.com/">Doubletree
						by Hilton<br>
						Cambridge Garden House</a><br>
						<br>Granta Place<br>Mill Lane<br>Cambridge<br>CB2 1RT<br>
						<br>Tel: 01223 259 988<br>
						<a href="http://www.cambridgegardenhouse.com/">www.cambridgegardenhouse.com</a><br>
						<br>
						<% if (guest.isFullGuest()){ %>Distance to Church: 7.0 Miles<br><%} %>
						Distance to Reception: 0.6 Miles</font></td>
						<td><iframe src="http://www.tinymap.net/embedded/CTiycLU28K3?w=600&h=420&clat=52.2005&clng=0.1196&z=16&v=n&c=0&d=0"
frameborder="0" scrolling="no" width="600" height="420" marginwidth="0" marginheight="0"></iframe>						<small><a
							href="http://www.google.co.uk/maps?f=q&hl=en&geocode=&q=CB2+1RT&ie=UTF8&ll=52.201321,0.116429&spn=0.017412,0.045104&t=h&z=15&iwloc=addr"
							style="color:#0000FF;text-align:left">View larger Map and
						driving directions</a></small></td>
					</tr>
					<tr>
						<td valign="top"><font size="+1"><a href="http://www.gonvillehotel.co.uk">Best Western
						Gonville Hotel</a><br>
						<br>Gonville Place<br>Cambridge<br>CB1 1LY<br>
						<br>Tel: 01223 366611
						<br>
						<a href="http://www.gonvillehotel.co.uk">www.gonvillehotel.co.uk</a><br>
						<br>
						<% if (guest.isFullGuest()){ %>Distance to Church: 6.1 Miles<br><%} %>
						Distance to Reception: 0.2 Miles</font>
						</td>
						<td><iframe src="http://www.tinymap.net/embedded/YK4R5rIMtSa?w=600&h=420&clat=52.2007&clng=0.1252&z=16&v=n&c=0&d=0"
frameborder="0" scrolling="no" width="600" height="420" marginwidth="0" marginheight="0"></iframe>						<small><a
							href="http://www.google.co.uk/maps?f=q&hl=en&geocode=&q=CB1+1LY&ie=UTF8&ll=52.200769,0.128767&spn=0.008706,0.022552&t=h&z=16&iwloc=addr"
							style="color:#0000FF;text-align:left">View larger Map and
						driving directions</a></small></td>
					</tr>
					<tr>
						<td valign="top"><font size="+1"><a
							href="http://www.regenthotel.co.uk/">Regency  Hotel</a><br>
						<br>
						41 Regent Street<br>
						Cambridge<br>
						CB2 1AB<br>
						<br>
						Tel: 01223 351470&nbsp; <br>
						<a href="http://www.regenthotel.co.uk/">www.regenthotel.co.uk</a><br>
						<br>
						<% if (guest.isFullGuest()){ %>Distance to Church: 6.6 Miles<br>
						<%} %> Distance to Reception: 0.1 Miles</font>
						</td>
						<td><iframe src="http://www.tinymap.net/embedded/I8UKOFQnT3L?w=600&h=420&clat=52.2008&clng=0.1274&z=16&v=n&c=1&d=1"
frameborder="0" scrolling="no" width="600" height="420" marginwidth="0" marginheight="0"></iframe>						<small><a
							href="http://www.google.co.uk/maps?f=q&amp;hl=en&amp;geocode=&amp;q=CB2+1AB&amp;ie=UTF8&amp;ll=52.200769,0.128767&amp;spn=0.008706,0.022552&amp;t=h&amp;z=16&amp;iwloc=addr"
							style="color:#0000FF;text-align:left">View larger Map and
						driving directions</a></small></td>
					</tr>
					<tr>
						<td valign="top"><font size="+1"><a
							href="http://www.ichotelsgroup.com/h/d/cp/925/en/hd/cbguk?sicreative=450913631&amp;sitrackingid=31870643&amp;sicontent=0&amp;siclientid=1931&amp;cm_mmc=Google-PS-CrownePlaza_UK-_-G%20BN-EMEA-_-GBR-Cambridge-_-cambridge%20hotel">Crowne Plaza</a><br>
						<br>
						Downing Street<br>
						Cambridge<br>
						CB2 3DT<br>
						<br>
						Tel: 01223 351470&nbsp; <br>
						<a href="http://www.ichotelsgroup.com/h/d/cp/925/en/hd/cbguk?sicreative=450913631&amp;sitrackingid=31870643&amp;sicontent=0&amp;siclientid=1931&amp;cm_mmc=Google-PS-CrownePlaza_UK-_-G%20BN-EMEA-_-GBR-Cambridge-_-cambridge%20hotel">www.crowneplaza.co.uk</a><br>
						<br>
						<% if (guest.isFullGuest()){ %>Distance to Church: 6.9 Miles<br>
						<%} %> Distance to Reception: 0.3 Miles</font>
						</td>
						<td><iframe src="http://www.tinymap.net/embedded/U1yiN9sNOA5?w=600&h=420&clat=52.2015&clng=0.1229&z=15&v=n&c=1&d=1"
frameborder="0" scrolling="no" width="600" height="420" marginwidth="0" marginheight="0"></iframe>						<small><a
							href="http://www.google.co.uk/maps?f=q&amp;hl=en&amp;geocode=&amp;q=CB2+3DT&amp;ie=UTF8&amp;ll=52.200769,0.128767&amp;spn=0.008706,0.022552&amp;t=h&amp;z=16&amp;iwloc=addr"
							style="color:#0000FF;text-align:left">View larger Map and
						driving directions</a></small></td>
					</tr>
				</tbody>
			</table>
			</td>
		</tr>
	</tbody>
</table>


  


</body>
</html>
