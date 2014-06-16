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
						<td align="center"><a href="/MenaceF1/giftList.do">Wedding Gift List</a></td>
					</tr>								
					<tr>
						<td align="center"><a href="/MenaceF1/accomodation.do">Accommodation</a></td>
					</tr>
					<tr>
						<td align="center" bgcolor="#515b5d"><font color="white">Maps &amp; Directions</font></td>
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
				<b><u><font size="+3">Maps &amp; Directions</font></u></b><br>
<% if (guest.isFullGuest()){ %>			
			<strong><br />
			</strong>
			<p align="center"><b><font size="+2">St. John 
			Church</font></b><br /><b><font size="+1"><span
				class="street-address">Station Road</span>, Waterbeach, Cambridgeshire,
			<span class="postal-code">CB25 9HT</span></font></b></p>
			<p align="left"><font size="+1">Waterbeach is a village about
			7 miles north of Cambridge off the A10. The church is on the main road from the
			railway station to the village and is a 5 minute walk. The map below shows the location of
			the church and the train station.</font></p>
<iframe src="http://www.tinymap.net/embedded/38AX9Y8Mykq?w=700&h=300&clat=52.2627&clng=0.1862&z=15&v=h&c=1&d=1"
frameborder="0" scrolling="no" width="700" height="300" marginwidth="0" marginheight="0"></iframe>			
			<p align="left"><font size="+1"><b><u>By Car</u></b> <br>
			The easiest way to get to Waterbeach is via the A14 and A10, entering
			the village from the West.<br>
			The church does have a small car-park, although probably not enough
			for all our guests. However, you should be able to park in any of the
			streets in the village</font>.</p>
			<form action="http://maps.google.com/maps" method="get" target="googleMaps" >
			<b>Get driving directions to the church, please enter your postcode:</b>
			<input type="text" name="saddr" id="saddr" value="" />
			

<input type="submit" value="Go" />
<input type="hidden" name="daddr" value="CB25 9HT" />
<input type="hidden" name="hl" value="en" />
</form>
			<p align="left"><font size="+1"><b><u>By Train</u></b> <br />
			Waterbeach has it's own train station, although at weekends trains
			are only once an hour.<br>
			If travelling from the North, you can change at Peterborough and Ely
			to get to Waterbeach.<br>
			From the south, direct trains are available from London Kings Cross,
			or from London Liverpool street, changing at Cambridge.<br>
			<br>
			Train times are usually published three months in advance, and can be
			found on the <a href="http://www.nationalrail.co.uk/">National
			Rail website</a>.<br>
			Trains to Waterbeach are operated by <a
				href="http://www.firstcapitalconnect.co.uk">First Capital
			Connect</a> or <a href="http://www.nationalexpresseastanglia.com/">National
			Express East Anglia</a>.</font></p>
			<p align="left"></p>
			<p align="center"><b><font size="+2"></font></b></p>
			<br />	
			<p align="center"><b><font size="+2">Getting from the Church to Downing College</font></b></p>
			<p align="left"><font size="+1">
			<b>N.B.</b> - We would like to advise our guests who are driving from the Church to the Reception to take the route via the A10 and <b>NOT</b> through Horningsea and Fen Ditton.
			Most sat-navs will attempt to take you via Horningsea.  However,  as Cambridge United are playing on our wedding day at 3pm, you are very likely to get stuck in match-day traffic.
			We would therefore advise guests to travel via the A10 as described below:
			</font></p>
			<ul>
			<li ><p align="left"> On leaving the lane from the car park bear left in to Chapel street</p></li>
<li><p align="left">Follow the road round to the left (passing the village green on the right), it becomes Cambridge road and then Car Dyke road</p></li>
<li><p align="left">Turn left on to the A10 (Ely road), pass through 2 sets of traffic lights</p></li>
<li><p align="left">At the roundabout take the middle lane signposted "city", take the 3rd exit on to the A1304/Milton road towards Cambridge</p></li>
<li><p align="left">Stay in the left lane signposted city (the 2 right-hand lanes are for the science park)</p></li>
<li><p align="left">At the traffic lights on the crossroads (Golden Hind pub on your right) go straight on</p></li>
<li><p align="left">At the roundabout, take the 1st exit onto A1134/Elizabeth Way</p></li>
<li><p align="left">At the roundabout go straight on (2nd exit) staying on the A1134/Elizabeth Way and crossing the river</p></li>
<li><p align="left">At the roundabout, take the 2nd exit onto East Rd (A603), continue forward (the Grafton Centre will be on your right)</p></li>
<li><p align="left">At the traffic lights on the crossroad go straight on (becomes Gonville Place), Queen Anne car park will be on your left and Parker's Piece (green space) on your right</p></li>
<li><p align="left">At the traffic lights turn right in to Regent street, travel 0.2 miles</p></li>
<li><p align="left">Look for the black old fashioned lanterns on the left then turn left in to Downing college (opposite Pizza Hut).  You may need to go in to the porter's lodge (building on the left by the entrance) to get a token to access the car park</p></li>
</ul>		
			
				
<%} if (guest.isEveningGuest()){ %>
			<p align="center"><b><font size="+2">Downing College</font><br>
			<font size="+1">Regent Street, Cambridge, CB2 1DQ </font></b></p>
			<p align="left"><font size="+1">Our reception takes place in
			the main hall at Downing College.<br />Downing College is located
			in the heart of Cambridge, and is shown on the map below.</font></p>
			<iframe src="http://www.tinymap.net/embedded/UJkHFFErsle?w=700&h=400&clat=52.1954&clng=0.1135&z=14&v=h&c=1&d=1"
frameborder="0" scrolling="no" width="700" height="400" marginwidth="0" marginheight="0"></iframe>		
			<p align="left"><font size="+1"><b><u>By Car</u></b> <br>
			<b></b>Cambridge is connected to the North via the A1(M), East and
			West via the A14, and South via the M11.<br>
			The College does have limited parking available, however cars can only be left overnight if you are staying at the College.<br>
			With the College being in the heart of Cambridge, street parking on a
			Saturday is virtually impossible, although there are various car
			parks available.  Full details of car-parks can be found on the <a
				href="http://www.cambridge.gov.uk/parking">Cambridge City
			Council website</a>.</font><b></b></p>
			<form action="http://maps.google.com/maps" method="get"
				target="googleMaps"><b>Get driving directions to Downing College, please enter your postcode:</b> <input type="text" name="saddr"
				id="saddr" value=""> <input type="submit" value="Go">
			<input type="hidden" name="daddr" value="CB2 1DQ"> <input
				type="hidden" name="hl0" value="en"></form>
			<p align="left"><font size="+1"><b><u>By Train</u></b> <br>
			Cambridge station is actaully about a mile outside of the city
			centre, and is roughly a 20 minute walk to the reception, although
			there are always plenty of taxis outside.<br>
			<br>
			Cambridge is well connected, and direct trains are available from
			Peterborough, London Kings Cross, London Liverpool Street, Norwich,
			Stansted Airport, Birmingham, and occasionally Manchester and
			Liverpool.<br>
			<br>
			Train times are usually published three months in advance, and can be
			found on the <a href="http://www.nationalrail.co.uk/">National
			Rail website</a>.<br>
			Trains to Cambridge are operated by <a
				href="http://www.firstcapitalconnect.co.uk">First Capital
			Connect</a> , <a href="http://www.nationalexpresseastanglia.com/">National
			Express East Anglia</a> and <a
				href="http://www.crosscountrytrains.co.uk/">CrossCountry</a>.</font></p>
			<p align="left">
				<font size="+1"><b><u>Map of Downing College grounds</u></b></font>
				<br /><img border="0" src="/MenaceF1/images/pdf.gif" /><a href="/MenaceF1/wedding/images/Downingcollegemap.pdf">Download map as a PDF</a>
				</p>
			<p align="left"><img border="0" src="/MenaceF1/images/downingCollegeMap.jpg"
				width="898" height="632"></p>
			<%} %>	
			</td>
		</tr>
	</tbody>
</table>





</body>
</html>
