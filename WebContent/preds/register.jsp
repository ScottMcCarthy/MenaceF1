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

<script language="JavaScript">
	 <!-- hide
 	 function validate(user) {

 	 if (user.firstname.value.length == 0) {
 	 	alert("You must enter your first name");
 	 	return false;
 	 	}
 	 if (user.surname.value.length == 0) {
 	 	alert("You must enter your last name");
 	 	return false;
 	 	}
 	 if (user.username.value.length == 0) {
 	 	alert("You must enter a username");
 	 	return false;
 	 	}
 	 if (user.password.value.length == 0) {
 	 	alert("You must enter a password");
 	 	return false;
 	 	}
 	 if (user.email.value.length == 0) {
 	 	alert("You must enter your email address");
 	 	return false;
 	 	}
 	 if (user.password.value != user.password2.value) {
 	 	alert("The two passwords you have entered do not match");
 	 	return false;
 	 	}  	 	 	 	 	 	 	 	 	 	 	 	 	 	

	 if (user.rules.checked == false) {
 	 	alert("You must agree to the rules");
 	 	return false;
 	 	}  

	
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
<form method="post" action="register2.jsp" name="newUser" onSubmit="return validate(this)">
<P></P><TABLE border="1" width="100%" bgcolor="#ffffff">
	<TBODY>
		<TR>
			<TD width="20%" valign="top">Please enter all your details in the form on the right.
			</TD>
			<TD width="602" valign="top"><FONT size="4"><I></I><I></I></FONT>
			<TABLE border="0">
				<TBODY>
					<TR>
						<TD align="center" width="621" valign="top"><FONT color="green" size="4">Thank you for your interested in joining the Pred League.<BR>Please fill out all details in the form below, and click &quot;submit&quot;.
						</FONT></TD>
					</TR>
					<TR>
						<TD width="621" valign="top">
						<TABLE border="0">
							<TBODY>
								<TR>
									<TD>First Name</TD>
									<TD><input type="text" name="firstname" size="50" maxlength="50"></TD>
								</TR>
								<TR>
									<TD>Last Name</TD>
									<TD><input type="text" name="surname" size="50" maxlength="50"></TD>
								</TR>
								<TR>
									<TD>Username</TD>
									<TD><input type="text" name="username" size="20" maxlength="20"></TD>
								</TR>
								<TR>
									<TD>Password</TD>
									<TD><input type="password" name="password" size="20" maxlength="20"></TD>
								</TR>
								<TR>
									<TD>retype password</TD>
									<TD><input type="password" name="password2" size="20" maxlength="20"></TD>
								</TR>
								<TR>
									<TD>Team</TD>
									<TD>
										<select name="teamIDString">
										<%preds.getTeamSelect(out,request);%>
									</select>
									</TD>
								</TR>
								<TR>
									<TD>e-mail</TD>
									<TD><input type="text" name="email" size="50" maxlength="100"></TD>
								</TR>
								<tr><td colspan='2'>I have read and agree to abide by the <A
										href="rules.jsp">rules</A> of the competition
								<INPUT type="checkbox" name="rules">
								
								</td></tr>
								<TR>
									<TD></TD>
									<TD><input type="submit" value="Submit" name="addUser"></TD>
								</TR>
							</TBODY>
						</TABLE>
						</TD>
					</TR>
				</TBODY>
			</TABLE></TD>
			<TD width="20%" align="center"><FONT color="green" size="4">League Table<BR>
			</FONT><%preds.getLeagueTable(out,request);%></TD>
		</TR>
	</TBODY>
</TABLE>
</form>

<P></P></BODY>
</HTML>
