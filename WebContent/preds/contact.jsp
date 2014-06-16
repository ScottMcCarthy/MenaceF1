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

<script language="JavaScript">
	 <!-- 
 	 function validate(feedback) {

 	 if (feedback.name.value.length == 0) {
 	 	alert("You must enter your name");
 	 	return false;
 	 	}
 	 if (feedback.email.value.length == 0) {
 	 	alert("You must enter your email address");
 	 	return false;
 	 	}
 	 if (feedback.subject.value.length == 0) {
 	 	alert("You must enter a subject");
 	 	return false;
 	 	}
	
 	 return true;
 	 }
  	 
  	  // -->
  </script>


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
<P></P>
<TABLE border="1" width="100%" bgcolor="#ffffff">
	<TBODY>
		<TR>
			<TD width="524" valign="top"><FONT size="4"><I></I><I></I></FONT>
			<TABLE border="0">
				<TBODY>
						<TR><TD align="center" width="694"><U><FONT color="green" size="4">Feedback Form</FONT></U><BR><small><A
							href="javascript:history.back()">Click here to return</A></small>
						</TD>
					</TR>
					<TR>
						<TD align="left" width="694"><B><U></U></B>Please fill out all the fields to submit your feedback. If you want a reply, be sure to enter a valid e-mail address:<BR>
						<form action="contact2.jsp" method="post" onSubmit="return validate(this)">
						<TABLE>
							<TBODY>
								<TR>
									<TD>Name</TD>
									<TD><input type='text' name='name' size='50' maxlength='50'></TD>
								</TR>
								<TR>
									<TD>e-mail</TD>
									<TD><input type='text' name='email' size='50' maxlength='50'></TD>
								</TR>
								<TR>
									<TD>Subject</TD>
									<TD><input type='text' name='subject' size='50' maxlength='50'></TD>
								</TR>
							</TBODY>
						</TABLE><TEXTAREA rows="10" cols="50" name="news">Enter your message here</TEXTAREA><br>
						<input type='submit' name="submit" value="Post Message">
						</form>
						
						</TD>
					</TR>
				</TBODY>
			</TABLE>
						
			</TD>
			<TD width="20%" align="center" valign="top"><FONT color="green" size="4">League Table<BR>
			</FONT><%preds.getLeagueTable(out,request);%></TD>
		</TR>
	</TBODY>
</TABLE>


<P></P></BODY>
</HTML>
