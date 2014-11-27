<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />
<title>The Wedding of Richard and Sharon</title>
<%@ page language="java" import="menaceF1.wedding.*,menaceF1.*"
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

<script language="JavaScript">
	 <!-- hide

function confirmPayment(booking) {
	return confirm("Are you sure you wish to mark this booking as paid?");
 	 }
function expandSection(id)
{
	document.getElementById(id+'Show').style.display= 'block';
	document.getElementById(id+'Hide').style.display= 'none';
}

function colapseSection(id)
{
	document.getElementById(id+'Show').style.display= 'none';
	document.getElementById(id+'Hide').style.display= 'block';	
}

 	 
  	  // -->
  </script>



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
						<td align="center" bgcolor="#515b5d"><font color="white">Admin Page</font></td>
					</tr>
					<% } %>																									
				</tbody>
			</table>
			</td>

			<td valign="top" align="center">
				<b><u><font size="+4">Admin Page</font></u></b><br />

			<%
				Admin admin = new Admin();
			 %>
			
			<p align="left"><b><u>Summary of activity</u></b><br />
			There are <b><%=admin.getOnlineRSVPNeedingChecking() %></b> on-line RSVP requests that need checking.<br/>
			There are <b><%=admin.getDayGuestsNotConfirmed() %></b> day guests that have not yet confirmed their attendance.<br />
			There are <b><%=admin.getEveningGuestsNotConfirmed() %></b> evening guests that have not yet confirmed their attendance.<br />
			You can invite another <b><%=admin.getGuestsLeftToInvite() %></b> day guests to the wedding.<br /></p>

			<div id="rsvpShow" style="display:block">
			<p align="left"><a href="javascript:colapseSection('rsvp')"><img alt="Click to expand section" border="0" src="/MenaceF1/wedding/images/collapse.gif" width="17" height="14"></a><b><u>RSVPs</u></b>
			<br />
			The following RSVPs require confirmation:
			<%=admin.getRsvpEntriesHTML() %>

			<br />
			The following RSVPs have been received via the website:
			<%=admin.getRsvpEntriesCompleteHTML() %>

			</div>
			<div id="rsvpHide" style="display:none">
			<p align="left"><a href="javascript:expandSection('rsvp')"><img alt="Click to expand section" border="0" src="/MenaceF1/wedding/images/expan.gif" width="17" height="14"></a><b><u>RSVPs</u></b>
			</p>
			</div>

			<div id="dayGuestsShow" style="display:block">
			<p align="left"><a href="javascript:colapseSection('dayGuests')"><img alt="Click to expand section" border="0" src="/MenaceF1/wedding/images/collapse.gif" width="17" height="14"></a><b><u>Day-Guest List</u></b>
			<br />
			The following table shows the status of day guests:
				<%=admin.dayGuestTableHTML() %>		
			</p>
			</div>
			<div id="dayGuestsHide" style="display:none">
			<p align="left"><a href="javascript:expandSection('dayGuests')"><img alt="Click to expand section" border="0" src="/MenaceF1/wedding/images/expan.gif" width="17" height="14"></a><b><u>Day-Guest List</u></b>
			</p>
			</div>

			<div id="eveningGuestsShow" style="display:block">
			<p align="left"><a href="javascript:colapseSection('eveningGuests')"><img alt="Click to expand section" border="0" src="/MenaceF1/wedding/images/collapse.gif" width="17" height="14"></a><b><u>Evening-Guest List</u></b>
			<br />
			The following table shows the status of evening guests:
			<%=admin.eveningGuestTableHTML() %>
			</p>
			</div>
			<div id="eveningGuestsHide" style="display:none">
			<p align="left"><a href="javascript:expandSection('eveningGuests')"><img alt="Click to expand section" border="0" src="/MenaceF1/wedding/images/expan.gif" width="17" height="14"></a><b><u>Evening-Guest List</u></b>
			</p>
			</div>

			<div id="newGuestShow" style="display:block">
			<p align="left"><a href="javascript:colapseSection('newGuest')"><img alt="Click to expand section" border="0" src="/MenaceF1/wedding/images/collapse.gif" width="17" height="14"></a><b><u>Add a new guest</u></b>
			<br />
			Please enter the details of the guest below:<br />
			<html:errors />
			<html:form action="addGuest"  >
			<html:hidden property="actionType" value="NEWGUEST" />
			<table border="1" cellpadding="0" cellspacing="0">
				<tbody>
					<tr>
						<td>Guest Name:</td>
						<td><html:text size="50" property="name" /></td>
					</tr>
					<tr>
						<td>Invite Partner?:</td>
						<td><html:checkbox property="plusOne" /></td>
					</tr>
					<tr>
						<td>Partner Name:</td>
						<td><html:text size="50" property="partner" /></td>
					</tr>

					<tr>
						<td>Address 1:</td>
						<td><html:text size="50" property="address1" /></td>
					</tr>
					<tr>
						<td>Address 2:</td>
						<td><html:text size="50" property="address2" /></td>
					</tr>
					<tr>
						<td>County:</td>
						<td><html:text size="50" property="county" /></td>
					</tr>
					<tr>
						<td>Postcode:</td>
						<td><html:text size="10" property="postcode" /></td>
					</tr>
					<tr>
						<td>Country:</td>
						<td>
<html:select property="country">
<html:option value ="United Kingdom">United Kingdom</html:option>
<html:option value ="Afghanistan">Afghanistan</html:option>
<html:option value ="Albania">Albania</html:option>
<html:option value ="Algeria">Algeria</html:option>
<html:option value ="American Samoa">American Samoa</html:option>
<html:option value ="Andorra">Andorra</html:option>
<html:option value ="Angola">Angola</html:option>
<html:option value ="Anguilla">Anguilla</html:option>
<html:option value ="Antarctica">Antarctica</html:option>
<html:option value ="Antigua and Barbuda">Antigua and Barbuda</html:option>
<html:option value ="Argentina">Argentina</html:option>
<html:option value ="Armenia">Armenia</html:option>
<html:option value ="Aruba">Aruba</html:option>
<html:option value ="Australia">Australia</html:option>
<html:option value ="Austria">Austria</html:option>
<html:option value ="Azerbaijan">Azerbaijan</html:option>
<html:option value ="Bahamas">Bahamas</html:option>
<html:option value ="Bahrain">Bahrain</html:option>
<html:option value ="Bangladesh">Bangladesh</html:option>
<html:option value ="Barbados">Barbados</html:option>
<html:option value ="Belarus">Belarus</html:option>
<html:option value ="Belgium">Belgium</html:option>
<html:option value ="Belize">Belize</html:option>
<html:option value ="Benin">Benin</html:option>
<html:option value ="Bermuda">Bermuda</html:option>
<html:option value ="Bhutan">Bhutan</html:option>
<html:option value ="Bolivia">Bolivia</html:option>
<html:option value ="Bosnia and Herzegovina">Bosnia and Herzegovina</html:option>
<html:option value ="Botswana">Botswana</html:option>
<html:option value ="Bouvet Island">Bouvet Island</html:option>
<html:option value ="Brazil">Brazil</html:option>
<html:option value ="British Indian Ocean Territory">British Indian Ocean Territory</html:option>
<html:option value ="Brunei Darussalam">Brunei Darussalam</html:option>
<html:option value ="Bulgaria">Bulgaria</html:option>
<html:option value ="Burkina Faso">Burkina Faso</html:option>
<html:option value ="Burundi">Burundi</html:option>
<html:option value ="Cambodia">Cambodia</html:option>
<html:option value ="Cameroon">Cameroon</html:option>
<html:option value ="Canada">Canada</html:option>
<html:option value ="Cape Verde">Cape Verde</html:option>
<html:option value ="Cayman Islands">Cayman Islands</html:option>
<html:option value ="Central African Republic">Central African Republic</html:option>
<html:option value ="Chad">Chad</html:option>
<html:option value ="Chile">Chile</html:option>
<html:option value ="China">China</html:option>
<html:option value ="Christmas Island">Christmas Island</html:option>
<html:option value ="Cocos Islands">Cocos Islands</html:option>
<html:option value ="Colombia">Colombia</html:option>
<html:option value ="Comoros">Comoros</html:option>
<html:option value ="Congo">Congo</html:option>
<html:option value ="Congo, Democratic Republic of the">Congo, Democratic Republic of the</html:option>
<html:option value ="Cook Islands">Cook Islands</html:option>
<html:option value ="Costa Rica">Costa Rica</html:option>
<html:option value ="Cote d'Ivoire">Cote d'Ivoire</html:option>
<html:option value ="Croatia">Croatia</html:option>
<html:option value ="Cuba">Cuba</html:option>
<html:option value ="Cyprus">Cyprus</html:option>
<html:option value ="Czech Republic">Czech Republic</html:option>
<html:option value ="Denmark">Denmark</html:option>
<html:option value ="Djibouti">Djibouti</html:option>
<html:option value ="Dominica">Dominica</html:option>
<html:option value ="Dominican Republic">Dominican Republic</html:option>
<html:option value ="Ecuador">Ecuador</html:option>
<html:option value ="Egypt">Egypt</html:option>
<html:option value ="El Salvador">El Salvador</html:option>
<html:option value ="Equatorial Guinea">Equatorial Guinea</html:option>
<html:option value ="Eritrea">Eritrea</html:option>
<html:option value ="Estonia">Estonia</html:option>
<html:option value ="Ethiopia">Ethiopia</html:option>
<html:option value ="Falkland Islands">Falkland Islands</html:option>
<html:option value ="Faroe Islands">Faroe Islands</html:option>
<html:option value ="Fiji">Fiji</html:option>
<html:option value ="Finland">Finland</html:option>
<html:option value ="France">France</html:option>
<html:option value ="French Guiana">French Guiana</html:option>
<html:option value ="French Polynesia">French Polynesia</html:option>
<html:option value ="Gabon">Gabon</html:option>
<html:option value ="Gambia">Gambia</html:option>
<html:option value ="Georgia">Georgia</html:option>
<html:option value ="Germany">Germany</html:option>
<html:option value ="Ghana">Ghana</html:option>
<html:option value ="Gibraltar">Gibraltar</html:option>
<html:option value ="Greece">Greece</html:option>
<html:option value ="Greenland">Greenland</html:option>
<html:option value ="Grenada">Grenada</html:option>
<html:option value ="Guadeloupe">Guadeloupe</html:option>
<html:option value ="Guam">Guam</html:option>
<html:option value ="Guatemala">Guatemala</html:option>
<html:option value ="Guinea">Guinea</html:option>
<html:option value ="Guinea-Bissau">Guinea-Bissau</html:option>
<html:option value ="Guyana">Guyana</html:option>
<html:option value ="Haiti">Haiti</html:option>
<html:option value ="Heard Island and McDonald Islands">Heard Island and McDonald Islands</html:option>
<html:option value ="Honduras">Honduras</html:option>
<html:option value ="Hong Kong">Hong Kong</html:option>
<html:option value ="Hungary">Hungary</html:option>
<html:option value ="Iceland">Iceland</html:option>
<html:option value ="India">India</html:option>
<html:option value ="Indonesia">Indonesia</html:option>
<html:option value ="Iran">Iran</html:option>
<html:option value ="Iraq">Iraq</html:option>
<html:option value ="Ireland">Ireland</html:option>
<html:option value ="Israel">Israel</html:option>
<html:option value ="Italy">Italy</html:option>
<html:option value ="Jamaica">Jamaica</html:option>
<html:option value ="Japan">Japan</html:option>
<html:option value ="Jordan">Jordan</html:option>
<html:option value ="Kazakhstan">Kazakhstan</html:option>
<html:option value ="Kenya">Kenya</html:option>
<html:option value ="Kiribati">Kiribati</html:option>
<html:option value ="Kuwait">Kuwait</html:option>
<html:option value ="Kyrgyzstan">Kyrgyzstan</html:option>
<html:option value ="Laos">Laos</html:option>
<html:option value ="Latvia">Latvia</html:option>
<html:option value ="Lebanon">Lebanon</html:option>
<html:option value ="Lesotho">Lesotho</html:option>
<html:option value ="Liberia">Liberia</html:option>
<html:option value ="Libya">Libya</html:option>
<html:option value ="Liechtenstein">Liechtenstein</html:option>
<html:option value ="Lithuania">Lithuania</html:option>
<html:option value ="Luxembourg">Luxembourg</html:option>
<html:option value ="Macao">Macao</html:option>
<html:option value ="Macedonia">Macedonia</html:option>
<html:option value ="Madagascar">Madagascar</html:option>
<html:option value ="Malawi">Malawi</html:option>
<html:option value ="Malaysia">Malaysia</html:option>
<html:option value ="Maldives">Maldives</html:option>
<html:option value ="Mali">Mali</html:option>
<html:option value ="Malta">Malta</html:option>
<html:option value ="Marshall Islands">Marshall Islands</html:option>
<html:option value ="Martinique">Martinique</html:option>
<html:option value ="Mauritania">Mauritania</html:option>
<html:option value ="Mauritius">Mauritius</html:option>
<html:option value ="Mayotte">Mayotte</html:option>
<html:option value ="Mexico">Mexico</html:option>
<html:option value ="Micronesia">Micronesia</html:option>
<html:option value ="Moldova">Moldova</html:option>
<html:option value ="Monaco">Monaco</html:option>
<html:option value ="Mongolia">Mongolia</html:option>
<html:option value ="Montserrat">Montserrat</html:option>
<html:option value ="Morocco">Morocco</html:option>
<html:option value ="Mozambique">Mozambique</html:option>
<html:option value ="Myanmar">Myanmar</html:option>
<html:option value ="Namibia">Namibia</html:option>
<html:option value ="Nauru">Nauru</html:option>
<html:option value ="Nepal">Nepal</html:option>
<html:option value ="Netherlands">Netherlands</html:option>
<html:option value ="Netherlands Antilles">Netherlands Antilles</html:option>
<html:option value ="New Caledonia">New Caledonia</html:option>
<html:option value ="New Zealand">New Zealand</html:option>
<html:option value ="Nicaragua">Nicaragua</html:option>
<html:option value ="Niger">Niger</html:option>
<html:option value ="Nigeria">Nigeria</html:option>
<html:option value ="Norfolk Island">Norfolk Island</html:option>
<html:option value ="North Korea">North Korea</html:option>
<html:option value ="Norway">Norway</html:option>
<html:option value ="Oman">Oman</html:option>
<html:option value ="Pakistan">Pakistan</html:option>
<html:option value ="Palau">Palau</html:option>
<html:option value ="Palestinian Territory">Palestinian Territory</html:option>
<html:option value ="Panama">Panama</html:option>
<html:option value ="Papua New Guinea">Papua New Guinea</html:option>
<html:option value ="Paraguay">Paraguay</html:option>
<html:option value ="Peru">Peru</html:option>
<html:option value ="Philippines">Philippines</html:option>
<html:option value ="Pitcairn">Pitcairn</html:option>
<html:option value ="Poland">Poland</html:option>
<html:option value ="Portugal">Portugal</html:option>
<html:option value ="Puerto Rico">Puerto Rico</html:option>
<html:option value ="Qatar">Qatar</html:option>
<html:option value ="Romania">Romania</html:option>
<html:option value ="Russian Federation">Russian Federation</html:option>
<html:option value ="Rwanda">Rwanda</html:option>
<html:option value ="Saint Helena">Saint Helena</html:option>
<html:option value ="Saint Kitts and Nevis">Saint Kitts and Nevis</html:option>
<html:option value ="Saint Lucia">Saint Lucia</html:option>
<html:option value ="Saint Pierre and Miquelon">Saint Pierre and Miquelon</html:option>
<html:option value ="Saint Vincent and the Grenadines">Saint Vincent and the Grenadines</html:option>
<html:option value ="Samoa">Samoa</html:option>
<html:option value ="San Marino">San Marino</html:option>
<html:option value ="Sao Tome and Principe">Sao Tome and Principe</html:option>
<html:option value ="Saudi Arabia">Saudi Arabia</html:option>
<html:option value ="Senegal">Senegal</html:option>
<html:option value ="Serbia and Montenegro">Serbia and Montenegro</html:option>
<html:option value ="Seychelles">Seychelles</html:option>
<html:option value ="Sierra Leone">Sierra Leone</html:option>
<html:option value ="Singapore">Singapore</html:option>
<html:option value ="Slovakia">Slovakia</html:option>
<html:option value ="Slovenia">Slovenia</html:option>
<html:option value ="Solomon Islands">Solomon Islands</html:option>
<html:option value ="Somalia">Somalia</html:option>
<html:option value ="South Africa">South Africa</html:option>
<html:option value ="South Georgia">South Georgia</html:option>
<html:option value ="South Korea">South Korea</html:option>
<html:option value ="Spain">Spain</html:option>
<html:option value ="Sri Lanka">Sri Lanka</html:option>
<html:option value ="Sudan">Sudan</html:option>
<html:option value ="Suriname">Suriname</html:option>
<html:option value ="Svalbard and Jan Mayen">Svalbard and Jan Mayen</html:option>
<html:option value ="Swaziland">Swaziland</html:option>
<html:option value ="Sweden">Sweden</html:option>
<html:option value ="Switzerland">Switzerland</html:option>
<html:option value ="Syrian Arab Republic">Syrian Arab Republic</html:option>
<html:option value ="Taiwan">Taiwan</html:option>
<html:option value ="Tajikistan">Tajikistan</html:option>
<html:option value ="Tanzania">Tanzania</html:option>
<html:option value ="Thailand">Thailand</html:option>
<html:option value ="Timor-Leste">Timor-Leste</html:option>
<html:option value ="Togo">Togo</html:option>
<html:option value ="Tokelau">Tokelau</html:option>
<html:option value ="Tonga">Tonga</html:option>
<html:option value ="Trinidad and Tobago">Trinidad and Tobago</html:option>
<html:option value ="Tunisia">Tunisia</html:option>
<html:option value ="Turkey">Turkey</html:option>
<html:option value ="Turkmenistan">Turkmenistan</html:option>
<html:option value ="Tuvalu">Tuvalu</html:option>
<html:option value ="Uganda">Uganda</html:option>
<html:option value ="Ukraine">Ukraine</html:option>
<html:option value ="United Arab Emirates">United Arab Emirates</html:option>
<html:option value ="United Kingdom">United Kingdom</html:option>
<html:option value ="United States">United States</html:option>
<html:option value ="United States Minor Outlying Islands">United States Minor Outlying Islands</html:option>
<html:option value ="Uruguay">Uruguay</html:option>
<html:option value ="Uzbekistan">Uzbekistan</html:option>
<html:option value ="Vanuatu">Vanuatu</html:option>
<html:option value ="Vatican City">Vatican City</html:option>
<html:option value ="Venezuela">Venezuela</html:option>
<html:option value ="Vietnam">Vietnam</html:option>
<html:option value ="Virgin Islands, British">Virgin Islands, British</html:option>
<html:option value ="Virgin Islands, U.S.">Virgin Islands, U.S.</html:option>
<html:option value ="Wallis and Futuna">Wallis and Futuna</html:option>
<html:option value ="Western Sahara">Western Sahara</html:option>
<html:option value ="Yemen">Yemen</html:option>
<html:option value ="Zambia">Zambia</html:option>
<html:option value ="Zimbabwe">Zimbabwe</html:option>
</html:select>							
						</td>
					</tr>
					<tr>
						<td>Guest Type:</td>
						<td>
<html:select property="guestType">
<% if (admin.placeLeft()) { %>	
<html:option value ="DAY">Day Guest</html:option>
<%} %>
<html:option value ="EVENING">Evening Guest</html:option>
</html:select>							
						</td>
					</tr>
					</tbody>
				</table>
			<html:submit value="Submit new Guest" />
			</html:form>
			</p>
			</div>
			<div id="newGuestHide" style="display:none">
			<p align="left"><a href="javascript:expandSection('newGuest')"><img alt="Click to expand section" border="0" src="/MenaceF1/wedding/images/expan.gif" width="17" height="14"></a><b><u>Add a new guest</u></b>
			</p>
			</div>

			<div id="photoShow" style="display:block">
			<p align="left"><a href="javascript:colapseSection('photo')"><img alt="Click to expand section" border="0" src="/MenaceF1/wedding/images/collapse.gif" width="17" height="14"></a><b><u>Uploaded photos to moderate</u></b>
			<br />
			The following photo galleries have been uploaded to the website:<br />
			To confirm a gallery as acceptable for publication, click on the gallery, view the photos, and you can then confirm that are suitable.
<%
			Menweb menJava = new Menweb();
			menJava.setShowLogo(false);
			menJava.directoryTrawler("/var/www/wedding/");
			menJava.restrictedGalleryFront("/var/www/wedding/",out,"restrictedWeddingGallery.jsp");
%>	
			</p>
			</div>
			<div id="photoHide" style="display:none">
			<p align="left"><a href="javascript:expandSection('photo')"><img alt="Click to expand section" border="0" src="/MenaceF1/wedding/images/expan.gif" width="17" height="14"></a><b><u>Uploaded photos to moderate</u></b>
			</p>
			</div>		
			
			
			</td>
		</tr>
	</tbody>
</table>





</body>
</html>
