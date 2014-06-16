<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE>MenaceF1.co.uk</TITLE>
<%@ page 
language="java" import="menaceF1.*"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
%>

	<jsp:useBean id="preds" class="menaceF1.Preds" scope="session"/>
	<jsp:setProperty name="preds" property="*"/> 

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
							href="index.jsp">Click here to return to front page</A></small>
						</TD>
					</TR>
					<tr>
						<td align="left" width="694"></td></tr>
					<% if(preds.postFeedback().equals("0")) { %>
					<tr>
						<td width="621"><b><br />Feedback submitted succesfully
						</b><br />Return to <a href="index.jsp">front page</a><br />
						</td>
					</tr>
						<%} else { %>
							<tr>
							<td width="621"><b><br />There was an error while submitting your feedback.
							</b></td>
							</tr>	
						<%}%>
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
