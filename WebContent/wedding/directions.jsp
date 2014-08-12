<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
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
			<p align="center"><b><font size="+2">All Saints Church</font></b><br /><b><font size="+1"><span
				class="street-address">Church Road</span>, Fleet, Hampshire,
			<span class="postal-code">GU51 4NB</span></font></b></p>
			<p align="left"><font size="+1"></font></p>
<p><iframe src="https://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=All+Saints+Church,+Fleet,+Church+Road,+Fleet,+Fleet,+UK&amp;aq=1&amp;oq=all+&amp;sll=37.0625,-95.677068&amp;sspn=39.371738,86.572266&amp;t=m&amp;ie=UTF8&amp;hq=All+Saints+Church,+Fleet,+Church+Road,+Fleet,+Fleet,+UK&amp;ll=51.283854,-0.842905&amp;spn=0.013958,0.032015&amp;output=embed" height="350" width="100%" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe><br>
<small><a style="color: #0000ff; text-align: left;" href="https://maps.google.com/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=All+Saints+Church,+Fleet,+Church+Road,+Fleet,+Fleet,+UK&amp;aq=1&amp;oq=all+&amp;sll=37.0625,-95.677068&amp;sspn=39.371738,86.572266&amp;t=h&amp;ie=UTF8&amp;hq=All+Saints+Church,+Fleet,+Church+Road,+Fleet,+Fleet,+UK&amp;ll=51.283854,-0.842905&amp;spn=0.013958,0.032015">View Larger Map</a></small></p>

			<p align="left"><font size="+1"><b><u>By Car</u></b> <br />
			From the M3 exit 4a, follow signs to Fleet. You'll pass the Heron on the Lake pub on your left before getting to a roundabout where you'll turn left.  Go over the railway bridge passing the railway station on your left hand side. Continue straight on through the roundabout and up the high street on Fleet Road, signposted Aldershot and Town Centre A3013. <br />
<br />
Turn right just after the 3rd set of traffic lights, between Waterfords and McCarthy Holden Estate Agents, onto Church Road. Signposted All Saints Church, Fleet Hospital and Lismoyne Hotel. The Church will be on the right hand side. Park in the pay and display Sainsbury's car park opposite Sunrise Senior Living homes. The cost of the car park is £0.80 for up to1 hour and £1.60 for up to 2 hours. The church will be visible from the entrance to the car park. The service should last around 45 minutes and we've allowed up to 30 minutes for photos before leaving for the Castle. <br />
<br />
Directions from the Church to the castle:<br />
<br />
From leaving Sainsbury's car park, turn right back onto Church Road. At the T junction turn right back onto Fleet Road heading into Central Fleet. Go through the Town and at the crossroads with The Oat Sheaf pub, turn left onto Reading Road South (A323). At the traffic lights go straight on towards Church Crookham. <br />
<br />
Continue straight through the roundabout near Tesco Express. Up Beacon Hill Road (B3013) and straight through the next two roundabouts. At the top of Beacon Hill Road, take the first exit at the Roundabout onto Odiham Road, signposted Farnham A287.  <br />
<br />
At the traffic lights just after the Shell Garage, turn right onto Folly Hill. You'll see a brown sign for Farnham Castle. <br />
<br />
As you go down the hill, Folly Hill will become Castle Street. The castle is on the left a little way down the hill, after Farnham Park Golf Course. Just after the Cricket Club look out for the brown Farnham Castle sign on the left, the next left is the Castle Entrance. The Car Park is at the top of the hill. <br />
<br />
This should take less than 15 mins from the Church. <br />
<br />
We'll see you there for drinks and canapés. 
			
			</font></p>
			
			<p align="left"><font size="+1"><b><u>By Train</u></b> <br />
			All Saints church is just under a mile from Fleet railway station.
			Train times are usually published three months in advance, and can be
			found on the <a href="http://www.nationalrail.co.uk/">National
			Rail website</a>.<br>
			Trains to Fleet go from Basingstoke to London Waterloo and are operated by <a
				href="http://www.southwesttrains.co.uk">South West Trains</a>.</font></p>
			<p align="left"></p>
			<p align="center"><b><font size="+2"></font></b></p>
			<br />	
			<p align="center"><b><font size="+2">Getting from the Church to Farnham Castle</font></b></p>
			<p align="left"><font size="+1">
			<b>Directions to go here</b></ul>		
			
				
<%} if (guest.isEveningGuest()){ %>
			<p align="center"><b><font size="+2">Farnham Castle</font><br>
			<font size="+1">Castle Street, Farnham, Surrey, GU9 0AG </font></b></p>
			
			<iframe width="100%" height="300" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.co.uk/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Farnham+Castle,+Castle+Street,+Farnham&amp;aq=0&amp;oq=Farnham+Castle,&amp;sll=52.8382,-2.327815&amp;sspn=14.413765,22.346191&amp;ie=UTF8&amp;hq=Farnham+Castle,+Castle+Street,+Farnham&amp;t=m&amp;ll=51.217314,-0.799856&amp;spn=0.018817,0.036478&amp;z=14&amp;iwloc=A&amp;output=embed"></iframe>
			
			
			<p align="left"><font size="+1"><b><u>By Car</u></b> <br />
			Approaching from Guildford (A31) arriving at the ‘Shepherd & Flock’ roundabout follow directions to Central Farnham. At traffic lights (next to Fire Station), follow road and enter one way system to left past Leisure Centre and left again. At traffic lights turn left into South Street & then first available right into Union Road. Follow one-way system straight on (past Police Station on left hand side) and turn right into Downing Street. At T-junction turn right into The Borough (main street in town centre) and first left into Castle Street (which becomes Castle Hill). The entrance to the Castle is 400 metres up on the right hand side.
			<p align="left"><font size="+1"><b><u>By Train</u></b> <br>
			Farnham station is about a mile from Farnham Castle.
			<br>
			Trains to Farnham go from Basingstoke to London Waterloo and are operated by <a
				href="http://www.southwesttrains.co.uk">South West Trains</a>.</font></p>
			<p align="left"></p>
			<p align="center"><b><font size="+2"></font></font></p>
		
			<%} %>	
			</td>
		</tr>
	</tbody>
</table>





</body>
</html>
