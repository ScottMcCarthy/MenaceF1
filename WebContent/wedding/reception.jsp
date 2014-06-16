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
	Accomodation accomodation = (Accomodation)session.getAttribute("ACCOMODATION");
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
						<td align="center" ><a href="/MenaceF1/church.do">The Church</a></td>
					</tr>
					<% } %>
					<tr>
						<td align="center" bgcolor="#515b5d" ><font color="white">The Reception</font></td>
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
				<b><u><font size="+3">Downing College Cambridge</font></u></b><br>
			<strong><br>
			</strong><font size="+1">Downing College has a unique and
			magnificent setting amid 20 acres of lawns and trees, yet is in the
			very centre of Cambridge. The buildings, which are predominantly
			neo-classical in style, convey a sense of elegance and spaciousness,
			enhanced by harmonious proportions, graceful columned porticos, and
			delicate pink and yellow stone.<b><br>
			<br>
			<% if (!accomodation.soldOut) { %>
			Accommodation is available at the College (single and twin rooms
			only), and there are many hotels nearby.<br><% } %>
			Please see the <% if (!accomodation.soldOut) { %><a href="/MenaceF1/accomodation.do">accommodation page</a> for more details, and the <%} %><a
				href="/MenaceF1/directions.do">Map &amp; Directions</a> page for details of
			how to get here. </b></font><br>
			<br>
			<img border="0"
				src="/MenaceF1/wedding/images/downing_accommodation.jpg" width="500"
				height="375">			
			<br>
			<table>
			<tr>
			<td>
			</td><td>
			<p align="left"><font size="+1">The College was founded in
					1800 under the will of Sir George Downing, Baronet (1685-1749), and
					the Royal Charter was issued on 22 September of that year.&nbsp;
					Sir George's grandfather gave his name to Downing Street in London
					and parts of the house which he built still survive in the present
					number 10.&nbsp; The highly respected Georgian architect, William
					Wilkins, designed the College around a great quadrangle of 300 feet
					square.</font></p>
			<p align="left"><font size="+1">To plan the College on a
					spacious campus layout was innovatory, and Downing was the first
					example of this type of collegiate architecture.&nbsp; The building
					of the College made a complete break with the very enclosed,
					traditional monastic courts of the older foundations. The whole
					feeling of Wilkins' College was to be one of space with buildings
					set in a landscape.&nbsp; However, only part of Wilkins' scheme was
					executed, comprising the West range and majority of the East range,
					built 1807-21. In 1876 the northern two staircases of the East
					range were completed to Wilkins' design by the architect E. M.
					Barry.&nbsp; Much building activity took place during the last
					century.&nbsp; Between 1929-32 the north corners of the quadrangle
					were built by Sir Herbert Baker; the north side was completed by
					A.R. Scott with the construction of the Chapel and two adjacent
					accommodation blocks in the early 1950s.</font></p>
			<p align="left"><font size="+1">Kenny Court, named after
					Courtney Stanhope Kenny, Downing Professor of Law (1907-18), was
					completed in 1963 (also by Scott), and the award-winning Senior
					Combination Room followed in 1969 (by Professor W.G Howell), at
					which time the Hall was also enlarged.&nbsp; More recently, the
					Howard Building (a gift of the Howard Foundation) was opened in
					1987, and the Junior Combination Room (JCR), named the Butterfield
					Bar and Café after Lord Butterfield a former Master was opened in
					1989.&nbsp; In 1993 the award-winning Maitland Robinson Library was
					opened, and subsequently Howard Court comprising 32 high quality
					student rooms was completed in 1996, all designed by Quinlan Terry.</font></p>
			</td></tr></table>
			<br />
			<img border="0" src="/MenaceF1/images/pdf.gif" /><a href="/MenaceF1/wedding/images/Downingcollegemap.pdf">Download map as a PDF</a>
			<img border="0" src="/MenaceF1/images/downingCollegeMap.jpg"
				width="898" height="632"><br />
			</td>
		</tr>
	</tbody>
</table>





</body>
</html>
