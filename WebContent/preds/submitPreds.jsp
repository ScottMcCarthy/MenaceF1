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
<BODY bgcolor="#eef8e9">

	<jsp:useBean id="player" class="menaceF1.PredPlayer" scope="session"/>
	<jsp:setProperty name="player" property="*"/> 
	<jsp:useBean id="prediction" class="menaceF1.Prediction" scope="session"/>
	<jsp:setProperty name="prediction" property="*"/> 

<script language="JavaScript">
	 <!-- hide
 	 function validate(preds) {
 
if (preds.homeScore1.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore1.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="1") return true;
if (preds.homeScore2.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore2.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="2") return true;
if (preds.homeScore3.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore3.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="3") return true;
if (preds.homeScore4.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore4.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="4") return true;
if (preds.homeScore5.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore5.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="5") return true;
if (preds.homeScore6.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore6.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="6") return true;
if (preds.homeScore7.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore7.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="7") return true;
if (preds.homeScore8.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore8.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="8") return true;
if (preds.homeScore9.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore9.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="9") return true;
if (preds.homeScore10.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore10.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="10") return true;
if (preds.homeScore11.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore11.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="11") return true;
if (preds.homeScore12.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore12.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="12") return true;
if (preds.homeScore13.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore13.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="13") return true;
if (preds.homeScore14.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore14.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="14") return true;
if (preds.homeScore15.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore15.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="15") return true;
if (preds.homeScore16.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore16.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="16") return true;
if (preds.homeScore17.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore17.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="17") return true;
if (preds.homeScore18.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore18.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="18") return true;
if (preds.homeScore19.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore19.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="19") return true;
if (preds.homeScore20.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore20.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="20") return true;
if (preds.homeScore21.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore21.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="21") return true;
if (preds.homeScore22.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore22.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="22") return true;
if (preds.homeScore23.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore23.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="23") return true;
if (preds.homeScore24.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore24.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="24") return true;
if (preds.homeScore25.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore25.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="25") return true;
if (preds.homeScore26.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore26.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="26") return true;
if (preds.homeScore27.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore27.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="27") return true;
if (preds.homeScore28.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore28.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="28") return true;
if (preds.homeScore29.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore29.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="29") return true;
if (preds.homeScore30.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.awayScore30.selectedIndex==0) {alert ("You must enter a score for every fixture"); return false; }
if (preds.totalFixtures.value=="30") return true;
 	 
 	 return true;
 	 }

function randomNumber() {
		return (Math.round(Math.random() * 5)+1);
}

function luckyDip(preds) {
 

	preds.homeScore1.selectedIndex=randomNumber();
	preds.awayScore1.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="1") return true;
	preds.homeScore2.selectedIndex=randomNumber();
	preds.awayScore2.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="2") return true;
	preds.homeScore3.selectedIndex=randomNumber();
	preds.awayScore3.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="3") return true;
	preds.homeScore4.selectedIndex=randomNumber();
	preds.awayScore4.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="4") return true;
	preds.homeScore5.selectedIndex=randomNumber();
	preds.awayScore5.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="5") return true;
	preds.homeScore6.selectedIndex=randomNumber();
	preds.awayScore6.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="6") return true;
	preds.homeScore7.selectedIndex=randomNumber();
	preds.awayScore7.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="7") return true;
	preds.homeScore8.selectedIndex=randomNumber();
	preds.awayScore8.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="8") return true;
	preds.homeScore9.selectedIndex=randomNumber();
	preds.awayScore9.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="9") return true;
	preds.homeScore10.selectedIndex=randomNumber();
	preds.awayScore10.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="10") return true;
	preds.homeScore11.selectedIndex=randomNumber();
	preds.awayScore11.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="11") return true;
	preds.homeScore12.selectedIndex=randomNumber();
	preds.awayScore12.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="12") return true;
	preds.homeScore13.selectedIndex=randomNumber();
	preds.awayScore13.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="13") return true;
	preds.homeScore14.selectedIndex=randomNumber();
	preds.awayScore14.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="14") return true;
	preds.homeScore15.selectedIndex=randomNumber();
	preds.awayScore15.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="15") return true;
	preds.homeScore16.selectedIndex=randomNumber();
	preds.awayScore16.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="16") return true;
	preds.homeScore17.selectedIndex=randomNumber();
	preds.awayScore17.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="17") return true;
	preds.homeScore18.selectedIndex=randomNumber();
	preds.awayScore18.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="18") return true;
	preds.homeScore19.selectedIndex=randomNumber();
	preds.awayScore19.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="19") return true;
	preds.homeScore20.selectedIndex=randomNumber();
	preds.awayScore20.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="20") return true;
	preds.homeScore21.selectedIndex=randomNumber();
	preds.awayScore21.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="21") return true;
	preds.homeScore22.selectedIndex=randomNumber();
	preds.awayScore22.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="22") return true;
	preds.homeScore23.selectedIndex=randomNumber();
	preds.awayScore23.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="23") return true;
	preds.homeScore24.selectedIndex=randomNumber();
	preds.awayScore24.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="24") return true;
	preds.homeScore25.selectedIndex=randomNumber();
	preds.awayScore25.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="25") return true;
	preds.homeScore26.selectedIndex=randomNumber();
	preds.awayScore26.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="26") return true;
	preds.homeScore27.selectedIndex=randomNumber();
	preds.awayScore27.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="27") return true;
	preds.homeScore28.selectedIndex=randomNumber();
	preds.awayScore28.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="28") return true;
	preds.homeScore29.selectedIndex=randomNumber();
	preds.awayScore29.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="29") return true;
	preds.homeScore30.selectedIndex=randomNumber();
	preds.awayScore30.selectedIndex=randomNumber();
if (preds.totalFixtures.value=="30") return true;
 	 
 	 return true;
 	 }

  	 
  	  // -->
  </script>

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
<P></P>
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
			<BR>			<A href="rules.jsp"><IMG border="1" src="../images/rules.gif"
				width="132" height="48"></A>
			<BR>
			<A href="contact.jsp"><IMG border="1" src="../images/contactus.gif"
				width="132" height="48"></A>	
			</TD>
			<% } else {%>
			<form action="login.jsp" name="loginForm" method="post">
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
			</TD></form>
			<% } %>
			<TD width="524" valign="top"><FONT size="4"><I></I><I></I></FONT>


			<%if (player.getFullName()!= null) { %>
			<%if (player.passwordValid()) { %>
			<TABLE border="0">
				<TBODY>
						<TR><TD width="523" align="center"><U><FONT color="green" size="4">Predict Scores for Matchday  <%out.print(prediction.getMatchday());%></FONT></U></TD>
					</TR>
					<TR>
						<TD width="523">
						<form action='submitPreds2.jsp' name="preds" onSubmit='return validate(this)'>
						<br><input type = "button" value="Lucky Dip!" name="random" onClick='luckyDip(form)'>
						<br><br>
						<TABLE border="0">
							<TBODY>
								<TR>
									<TD colspan='3' align = 'center'><FONT color="green" size="4">Home Team</font></TD>
									<TD colspan='3' align = 'center'><FONT color="green" size="4">Away Team</font></TD>
								</TR>
								<%preds.getPreds(out,request,""+player.getId(),prediction.getMatchday());%>
								<TR>
									<TD><input type='submit' name="submitPreds" value="Submit"></TD>
									<TD></TD>
									<TD></TD>
									<TD></TD>
									<TD></TD>
									<TD></TD>
								</TR>
							</TBODY>
						</TABLE>
						<BR>
						</form></TD>
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
						<TD width="523">Sorry, but you have entered an invalid password. <BR>Please try again.
						</TD>
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


<P></P></BODY>
</HTML>
