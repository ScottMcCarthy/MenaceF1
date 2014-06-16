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
<P></P><TABLE border="1" width="100%" bgcolor="#ffffff">
	<TBODY>
		<TR>
			<%if (player.getFullName()!= null && player.passwordValid()) { %>
			<TD width="20%" valign="top"><small>Welcome back<BR><B><font color="maroon"><%out.print(player.getFullName());%></font></b></small>
				<%if (player.isAdministrator()) { %>
				<br>
			<BR> <%}%><BR>
			<BR>			<A href="rules.jsp"><IMG border="1" src="../images/rules.gif"
				width="132" height="48"></A>
			<BR>
			<A href="contact.jsp"><IMG border="1" src="../images/contactus.gif"
				width="132" height="48"></A>	
			</TD>
			<% } else {%>
			<TD width="20%" valign="top"><small><U>Login</U><BR>
			<BR>Username<BR>
			<form action="login.jsp" name="loginForm" method="post">
			<input type="text" size = 15 name='username'>
			<BR>
			Password<BR>
			<input type="password" size = 15 name='userPassword'>
			<BR><input type = 'submit' name='submit' value="Login">
			</form>
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
						<% if (player.isAdministrator()) { %>
						
						<TD align="center" width="621"><FONT color="green" size="4">Add Fixtures</FONT></TD>
					</TR>
					<TR>
						<TD width="621"><B><BR>
						<form method="post" name="fixtures" action="addFixtures2.jsp">
						Choose teams and matchdays below, then click Submit:<BR>
						<TABLE border="1">
							<TBODY>
								<TR>
									<TD><FONT color="green" size="4">Matchday</FONT></TD>
									<TD><FONT color="green" size="4">Home Team</FONT></TD>
									<TD><FONT color="green" size="4">Away Team</FONT></TD>
								</TR>
								<TR>
									<TD><select name="match1">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD>
										<select name="hometeam1">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam1">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD><select name="match2">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD><select name="hometeam2">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam2">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD><select name="match3">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD><select name="hometeam3">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam3">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD><select name="match4">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD><select name="hometeam4">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam4">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD><select name="match5">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD><select name="hometeam5">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam5">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD><select name="match6">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD><select name="hometeam6">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam6">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD><select name="match7">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD><select name="hometeam7">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam7">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD><select name="match8">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD><select name="hometeam8">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam8">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD><select name="match9">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD><select name="hometeam9">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam9">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD><select name="match10">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD><select name="hometeam10">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam10">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD><select name="match11">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD><select name="hometeam11">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam11">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD><select name="match12">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD><select name="hometeam12">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam12">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD><select name="match13">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD><select name="hometeam13">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam13">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD><select name="match14">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD><select name="hometeam14">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam14">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD><select name="match15">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD><select name="hometeam15">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam15">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD><select name="match16">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD><select name="hometeam16">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam16">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD><select name="match17">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD><select name="hometeam17">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam17">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD><select name="match18">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD><select name="hometeam18">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam18">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD><select name="match19">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD><select name="hometeam19">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam19">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD><select name="match20">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD><select name="hometeam20">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam20">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD><select name="match21">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD><select name="hometeam21">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam21">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD><select name="match22">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD><select name="hometeam22">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam22">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD><select name="match23">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD><select name="hometeam23">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam23">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD><select name="match24">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD><select name="hometeam24">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam24">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD><select name="match25">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD><select name="hometeam25">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam25">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD><select name="match26">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD><select name="hometeam26">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam26">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD><select name="match27">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD><select name="hometeam27">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam27">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD><select name="match28">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD><select name="hometeam28">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam28">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD><select name="match29">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD><select name="hometeam29">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam29">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD><select name="match30">
										<%preds.getMatchdaySelect(out,request);%>
									</select>
									</TD>
									<TD><select name="hometeam30">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
									<TD><select name="awayteam30">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
							</TBODY>
						</TABLE>
						<input type="submit" name="goFixtures" value="Submit Fixtures"></form>
						<BR>
						</B></TD>
				<%} else { %>
					<TR>
						<TD align="center" width="621"><FONT color="green" size="4">Sorry, but you are not an Adminstrator.</FONT></TD>
				<%}%>
				
					</TR>
					
				</TBODY>
			</TABLE></TD>
			<TD width="20%" align="center" valign="top"><FONT color="green" size="4">League Table<BR>
			</FONT><%preds.getLeagueTable(out,request);%></TD>
			
		</TR>
	</TBODY>
</TABLE>

<P></P></BODY>
</HTML>
