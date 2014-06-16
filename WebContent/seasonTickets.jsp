<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<TITLE>MenaceF1.co.uk</TITLE>
<%@ page 
language="java" import="menaceF1.*"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="GENERATOR" content="IBM WebSphere Studio" />

<script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/prototype/1.6.0.3/prototype.js'></script>
<script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/scriptaculous/1.8.2/scriptaculous.js'></script>
<script type='text/javascript' src='lightview2.5/js/lightview.js'></script>
<link rel="stylesheet" type="text/css" href="lightview2.5/css/lightview.css" />
</head>
<body bgcolor="#eef8e9">
<table border="0" bgcolor="#80ff00" width="100%">
	<tbody>
		<tr>
			<td width="119"><img border="0" src="images/Little_Menace_Logo.gif" width="93" height="125" /></td>
			<td width="654" align="left">
			<table border="0">
				<tbody>
					<tr>
						<td><font size="7" color="#0000ff" face="Times New Roman"><b><i><a href="http://www.menacef1.co.uk">MenaceF1.co.uk</a></i></b></font></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td><i>Now running on a Raspberry Pi!</i></td>
					</tr>
					<tr>
						<td><% 
						Menweb menJava = new Menweb();
						out.println (menJava.printDate()) ;
						%></td>
					</tr>
				</tbody>
			</table>
			
		</td>
		<td width="119"><img border="0" src="images/Little_Menace_Logo.gif" width="93" height="125" /></td>						
								
		</tr>
	</tbody>
</table>

	<jsp:useBean id="st" class="menaceF1.SeasonTicket" scope="request"/>
	<% st.actionUpdates(request); %>

<table border="1" width="100%" bgcolor="#ffffff">

	<tbody>
		<tr>
			<td align="center" ><font size="4"><b><i><u>Arsenal season ticket tracker</u></i></b></font></td>
		</tr>
	</tbody>
</table>

<table border="1" width="100%" bgcolor="#ffffff">

	<tbody>
		<tr>
			<td><font size="4"><i>The following matches require payment:</i></font><br /><br />
				<table border="0" width="100%" bgcolor="#ccff33">
					<tr>
						<% st.getPaymentsPending(out,request); %>
					</tr>			
				</table>
			<br />
			</td>
		</tr>
	</tbody>
</table>

<table border="0" width="100%" bgcolor="#ffffff">

	<tbody>
		<tr>
			<td valign="top">
				<table border="1" width="100%" bgcolor="#ffffff">
				
					<tbody>
						<tr>
							<td><font size="4"><u>Fixtures List:</u></font><br />
							<table border="0" width="100%">
								<tr>
									<td align="center"></td>
									<td align="center"></td>
									<td align="center"></td>
									<td align="center">Matt's ticket</td>
									<td align="center">James's ticket</td>
									<td align="center">Scott's ticket</td>
									<td></td>
								</tr>							
							<% st.getFixtures(out,request); %>
							</table>
							</td>
						</tr>
					</tbody>
				</table>			
			</td>
			<td valign="top">
				<table border="1" width="100%" bgcolor="#ffffff">
				
					<tbody>
						<tr>
							<td><font size="4"><u>Payment History:</u></font><br />
								<table border="0" width="100%" bgcolor="#ffffff">
									<tr>
										<% st.getPaymentHistory(out,request); %>
									</tr>			
								</table>
							
							</td>
						</tr>
					</tbody>
				</table>			
			</td>
		</tr>
	</tbody>
</table>



<p></p></body>
</html>
