<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE>MenaceF1.co.uk</TITLE>
<%@ page 
language="java" import="menaceF1.*"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">
</HEAD>

	<jsp:useBean id="player" class="menaceF1.PredPlayer" scope="session"/>
	<jsp:setProperty name="player" property="*"/> 


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


<% 

Preds preds = new Preds();
String error = "";
error = player.register();
%>

<P></P><TABLE border="1" width="100%" bgcolor="#ffffff">
	<TBODY>
		<TR>
			<TD width="1"><IMG border="0" src="../images/trophy_black.jpg" width="72"
				height="111"></TD>
			<TD width="656" align="center"><FONT size="7">The Premier League Prediction Competition</FONT></TD>
			<TD width="25"><IMG border="0" src="../images/trophy_black.jpg" width="72"
				height="111"></TD>
		</TR>
	</TBODY>
</TABLE>
<P></P><form action="login.jsp" name="loginForm" method="post"><TABLE border="1" width="100%" bgcolor="#ffffff">
	<TBODY>
		<TR>
			<TD width="20%" valign="top"><small><U>Login</U><BR>
			<BR>Username<BR><input type="text" size = 15 name='username'>
			<BR>
			Password<BR>
			<input type="password" size = 15 name='userPassword'>
			<BR><input type = 'submit' name='submit' value="Login">
			</small><BR>
			<BR>			<A href="rules.jsp"><IMG border="1" src="../images/rules.gif"
				width="132" height="48"></A>
			<BR>
			<A href="contact.jsp"><IMG border="1" src="../images/contactus.gif"
				width="132" height="48"></A>	
			</TD>
			<TD width="602" valign="top"><FONT size="4"><I></I><I></I></FONT>
			<% if (error.equals("0")) { %>
			<TABLE border="0">
				<TBODY>
					<TR>
						<TD align="center" width="621"><FONT color="green" size="4">Registration successful!</FONT></TD>
					</TR>
					<TR>
						<TD width="621"><B></B>Thank you for registering with the Pred league. You may now login with your new username and password in the box on the left. Once logged in you can begin to enter your score predictions for all goals in the season.<B></B></TD>
					</TR>
				</TBODY>
			</TABLE>
			<%} if (error.equals("23505")) { %>
			<TABLE border="0">
				<TBODY>
					<TR>
						<TD align="center" width="621"><FONT color="red" size="4">User Already Registered!</FONT></TD>
					</TR>
					<TR>
						<TD width="621"><B></B>This username has already been used by another player. Please click 'back' on your browser, and choose a different username.</TD>
					</TR>
				</TBODY>
			</TABLE>
			<%} else if (!error.equals("0")) { %>

			<TABLE border="0">
				<TBODY>
					<TR>
						<TD align="center" width="621"><FONT color="green" size="4"></FONT><FONT
							color="red" size="4">An unknown error has occured!</FONT></TD>
					</TR>
					<TR>
						<TD width="621"><B></B>A problem has been detected while attempting to register you as a player. A possible reason for this is that the server is too busy at the moment. Please try again later. Check the homepage for details of any known problems with the site.<B></B></TD>
					</TR>
				</TBODY>
			</TABLE>
			<% } %>



			</TD>



			<TD width="20%" align="center"><FONT color="green" size="4">League Table<BR>
			</FONT><%preds.getLeagueTable(out,request);%></TD>
		</TR>
	</TBODY>
</TABLE>
</form>

<P></P></BODY>
</HTML>