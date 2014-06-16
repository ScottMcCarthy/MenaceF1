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
<body bgcolor="#eef8e9">

	<jsp:useBean id="player" class="menaceF1.PredPlayer" scope="session"/>
	<jsp:setProperty name="player" property="*"/> 
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
player.getUserDetails(player.getUsername());
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
<P></P><form action="login.jsp" name="loginForm" method="post">
<TABLE border="1" width="100%" bgcolor="#ffffff">
	<TBODY>
		<TR>
			<%if (player.getFullName()!= null && player.passwordValid()) { %>
			<TD width="20%" valign="top" align="center"><small>Welcome back<BR><B><font color="maroon"><%out.print(player.getFullName());%></font></b></small>
				<%if (player.isAdministrator()) { %>
				<br>
			<BR>
			<A href="admin.jsp"><IMG border="1" src="../images/admin.gif"
				width="134" height="97"></A> <%}%><BR>
			<A href="rules.jsp"><IMG border="1" src="../images/rules.gif"
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
			<TD width="524" valign="top"><FONT size="4"><I></I><I></I></FONT>


			<%if (player.getFullName()!= null) { %>
			<%if (player.passwordValid()) { %>
			<TABLE border="0">
				<TBODY>
						<%if (preds.matchInProgress()) {%>
						<TR><TD width="523" align="center"><U><FONT color="green" size="4">Matchday <%out.println(preds.currentMatch());%></FONT></U></TD></TR>
						<TR><TD align="center"><A href="currentPreds.jsp">Click here to See what
						everyone predicted</A></td></tr>
						
						<% } else {%>
						<TR><TD width="523" align="center"><U><FONT color="green" size="4">Next Matchday is <%out.print(preds.getNextMatchday());%></FONT></U></TD>
						<%}%>
					</TR>
					<TR>
						<TD width="523">
						<BR>
						<TABLE border="1" width="100%">
							<TBODY>
								<TR>
									<TD><B>Completed Matchdays </B></TD>
									<TD><B>Future Matchdays</B></TD>
								</TR>
								<TR>
									<TD valign="top"><small>Click to see Results<BR>
									<BR>
									<%preds.getCompletedMatchdays(out,request);%>
									</small></TD>
									<TD valign="top"><small>Click to make or change a prediction<BR>
									<BR><%preds.getFutureMatchdays(out,request,""+player.getId());%></small>
									</TD>
								</TR>
							</TBODY>
						</TABLE></TD>
					</TR>
				</TBODY>
			</TABLE>

			<% } else {%>
			<TABLE border="0">
				<TBODY>
					<TR>
						<TD width="523" align="center"><FONT color="green" size="4">Error - Invalid Password</FONT></TD>
					</TR>
					<TR>
						<TD width="523">Sorry, but you have entered an invalid password. <BR>Please try again.<BR>
						If you cannot remember your password, plesae use the &quot;Contact us&quot; button on the left.</TD>
					</TR>
				</TBODY>
			</TABLE>
			
		
		
			<% }} else {%>

			<TABLE border="0">
				<TBODY>
					<TR>
						<TD width="523" align="center"><FONT color="green" size="4">Error - Invalid Username</FONT></TD>
					</TR>
					<TR>
						<TD width="523">Sorry, but you have entered an invalid username of <b><%out.print(player.getUsername());%>.</b><BR>Please try again. If you are a new user, you can <A
							href="register.jsp">register here</A>.
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			<% } %>			
			</TD>
			<TD width="20%" align="center" valign="top"><FONT color="green" size="4">League Table<BR>
			</FONT><%preds.getLeagueTable(out,request);%></TD>
		</TR>
	</TBODY>
</TABLE>

</form>

<P></P></BODY>
</HTML>
