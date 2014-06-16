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

	<jsp:useBean id="prediction" class="menaceF1.Prediction" scope="session"/>
	<jsp:setProperty name="prediction" property="*"/> 

<body bgcolor="#eef8e9">
<table border="0" bgcolor="#80ff00" width="100%">
	<tbody>
		<tr>
			<td width="119"><img border="0" src="../images/Little_Menace_Logo.gif" width="93" height="125" /></td>
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
		<td width="119"><img border="0" src="../images/Little_Menace_Logo.gif" width="93" height="125" /></td>						
								
		</tr>
	</tbody>
</table>


<% 

Preds preds = new Preds();
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
			<%if (player.getFullName()!= null && player.passwordValid()) { %>
			<TD width="20%" valign="top"><small>Welcome back<BR><B><font color="maroon"><%out.print(player.getFullName());%></font></b></small>
				<%if (player.isAdministrator()) { %>
				<br>
			<BR> <%}%>	
			
			<BR>
			<BR>			<A href="rules.jsp"><IMG border="1" src="../images/rules.gif"
				width="132" height="48"></A>
			<BR>
			<A href="contact.jsp"><IMG border="1" src="../images/contactus.gif"
				width="132" height="48"></A>	
			</TD>
			<% } else {%>
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
			<% } %>
			<TD width="602" valign="top"><FONT size="4"><I></I><I></I></FONT>
			<TABLE border="0">
				<TBODY>
					<TR>
						<% if (player.getFullName()!= null && player.passwordValid()) { %>
						<TD align="center" width="621"><FONT color="green" size="4"></FONT></TD>
					</TR>
					<% 
						prediction.setPlayer(""+player.getId());
						String sqlcode = prediction.submit(); 
					    if(sqlcode.equals("0")) { %>
					<TR>
						<TD align="center" width="621"><FONT color="green" size="4">Predictions entered succesfully!</FONT></TD>
					</tr>
					<tr>
						<TD width="621"><B>Good
						luck!</B><BR>Return to <A href="login.jsp">homepage</A><BR>
						</TD>
						<%} else if (sqlcode.equals("late")){ %>
					<TR>
						<TD align="center" width="621"><FONT color="red" size="4">Submission deadline has passed!</FONT></TD>
					</TR>
					<TR>
						<TD width="621"><B></B>Sorry, but the deadline for submitting predictions for this matchday has passed. If you had previously submitted scores for these fixtures, the original scores will be used, otherwise you will score no points for this matchday.<BR>
						<BR>Return to <A
							href="login.jsp">homepage</A>
						<BR></TD>
					</TR>

						<%} else {%>
					<tr>	
						<TD align="center" width="621"><FONT color="red" size="4">An unknown error occured while submitting your predictions!</FONT></TD>
					</TR>
					<TR>
						<TD width="621"><B></B>Please try again, it is possible the server was too busy at the time you submitted your predictions.<BR>Error code <%out.print(sqlcode);%><BR>
						<BR>Return to <A
							href="login.jsp">homepage</A>
						<BR></TD>
					</TR>	
					<%}%>					
				<%} else { %>
					<TR>
						<TD align="center" width="621"><FONT color="green" size="4">Sorry, but your session has expired, please log-in again.</FONT></TD>
				<%}%>
				
					</TR>
					
				</TBODY>
			</TABLE></TD>
			<TD width="20%" align="center" valign="top"><FONT color="green" size="4">League Table<BR>
			</FONT><%preds.getLeagueTable(out,request);%></TD>
			
		</TR>
	</TBODY>
</TABLE>
</form>

<P></P></BODY>
</HTML>
