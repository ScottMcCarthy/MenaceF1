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
				<b><u><font size="+3">Farnham Castle</font></u></b>
				
				<iframe width="905" height="509" frameborder="0" allowfullscreen="" mozallowfullscreen="" webkitallowfullscreen="" src="//player.vimeo.com/video/94992852?title=0&amp;byline=0&amp;portrait=0&amp;color=c8df8d"></iframe>
				
			<strong><br>
			</strong><font size="+1">Farnham Castle overlooks the historic town of Farnham on the western border of Surrey.

From the times of the Norman Conquest until the Tudors, the all-powerful Bishops of Winchester shaped English politics from within the walls of Farnham Castle. For over 900 years the Bishop's Palace has played host to meetings and celebrations and monarchs including King John and Queen Victoria have stayed at or visited the castle during this time.
<br>
			<br>

			Please see the <a
				href="/MenaceF1/directions.do">Map &amp; Directions</a> page for details of
			how to get here. </b></font><br>
			<br>
			<img border="0"
				src="/MenaceF1/wedding/images/Farnham-castle-at-night.jpg" width="992"
				height="660">			
			<br>
			<table>
			<tr>
			<td>
			</td><td>
			<p align="left"><font size="+1"><p>
Playing an important part in the life of the town, the Keep and the Bishop&#8217;s Palace are popular tourist attractions. Historical associations and nearly continuous occupancy make the Castle one of the most important historical buildings in the south of England.</p>
<p>For 800 years, the Bishops of Winchester used the Castle as a home and administrative centre. Powerful men from the Norman Conquest until the Tudors, the bishops often shaped English politics. Nine were Lord Chancellors. Most of the monarchs of England from King John to Queen Victoria visited or stayed at the castle.</p>
<p>The Castle consists of two parts:</p>
<ul>
<li>The Keep, a Scheduled Ancient Monument. Put in the guardianship of the State in 1933, the Keep has been placed under the management of Farnham Castle on behalf of English Heritage.</li>
<li>The Bishop&#8217;s Palace, a complex of Grade I and II listed buildings.</li>
</ul>
<p>Permanently lived in for almost 900 years, the buildings reflect changing architectural styles through the centuries. Though sometimes neglected in the past, the buildings are now well maintained. Recent HLF grants have allowed the undertaking of extensive repairs and restoration work to both the Palace and the Keep.</p></font></p>
<br />
			<img border="0" src="/MenaceF1/images/farnham/chairs.png" /><br /><br />	
			<img border="0" src="/MenaceF1/images/farnham/night.png" /><br /><br />
			<img border="0" src="/MenaceF1/images/farnham/outside.png" /><br /><br />
			<img border="0" src="/MenaceF1/images/farnham/tables.png" /><br /><br />
			<img border="0" src="/MenaceF1/images/farnham/topshot.png" /><br /><br />


			<br />For more details, please go to the <a href="http://www.farnhamcastle.com">Farnham Castle Website</a></td></tr></table>
			<br />
			</td>
		</tr>
	</tbody>
</table>





</body>
</html>
