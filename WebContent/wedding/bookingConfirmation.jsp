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
	String bookingRef = (String)session.getAttribute("BOOKINGREF");
	String paymentType = (String)session.getAttribute("PAYMENTTYPE");
	String paymentCost = (String)session.getAttribute("PAYMENTCOST");
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

			<td valign="top" align="center" width="780"><b><u><font size="+3">Booking
			Request Confirmed</font></u></b><br><strong><br>
			</strong><font size="+1">Your booking request has been
			confirmed and your booking reference number is: <b><%=bookingRef %></b><br>
			<br>
			<b>IMPORTANT</b> - You must now complete payment as outlined below.
			If we do not recieve payment within 14 days you may loose your
			booking, although we will always contact you before cancelling a
			booking.<b><u></u></b> <br>
			<br>
			<b><u>Steps to complete payment</u></b><br>
			<% if (paymentType.equalsIgnoreCase("paypal")) { %> You have chosen to
			pay via Paypal. <br>
			Please use the button below to open Paypal in a new window, and pay
			using your credit or debit card. <br>
			The paypal account name you will see will be <b>paypal@menacef1.co.uk</b>,
			which is the correct account. </font><br />
				
<form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="paypalWindow">
   <input type="hidden" name="cmd" value="_xclick">
   <input type="hidden" name="business" value="paypal@menacef1.co.uk">
   <input type="hidden" name="item_name" 
   value="Hotel booking for Scott and Claire's wedding on 29th August 2009">
   <input type="hidden" name="item_number" 
   value="<%=bookingRef %>">
   <input type="hidden" name="amount" value="<%=paymentCost%>">
   <input type="hidden" name="no_shipping" value="2">
   <input type="hidden" name="no_note" value="1">
   <input type="hidden" name="currency_code" value="GBP">
   <input type="hidden" name="bn" value="IC_Sample">
   <input type="image" src="https://www.paypal.com/en_US/i/btn/x-click-but23.gif" 
   name="submit" alt="Make payments with payPal - it's fast, free and secure!">
</form>		
			
				<br />
				<font size="+1">Once you have completed your payment via
			Paypal, you can return to the <a href="/MenaceF1/home.do">homepage</a>.
			<br>
			<% } %> <% if (paymentType.equalsIgnoreCase("cheque")) { %> You have
			chosen to pay via Cheque. <br>
			Please send a cheque for <b>£<%=Accomodation.webNumber(Float.parseFloat(paymentCost))%></b>
			payable to <b>Scott McCarthy </b> to : <br>
			<br>
			<br>
			Scott McCarthy &amp; Claire Helliwell<br>
			14 Pieces Lane<br>
			Waterbaech<br>
			Cambridgeshire<br>
			CB25 9NF<br>
			<br>
			<br>
			Once you have made a note of our address you can return to the <a
				href="/MenaceF1/home.do">homepage</a>. <br>
			<% } %> <% if (paymentType.equalsIgnoreCase("banking")) { %> You have
			chosen to pay via internet Banking. <br>
			Please can you arrange to transfer <b>£<%=Accomodation.webNumber(Float.parseFloat(paymentCost))%></b>
			to the account details below: <br>
			<br>
			<b> Account Name: </b> Scott McCarthy &amp; Claire Helliwell<br>
			<b> Account Number: </b> 22047815<br>
			<b> Account Sort Code: </b> 11- 18- 11<br>

			Once you have transfered the money, you can return to the <a
				href="/MenaceF1/home.do">homepage</a>. </font><br />		
			<% } %>
			</td>
		</tr>
	</tbody>
</table>


  


</body>
</html>
