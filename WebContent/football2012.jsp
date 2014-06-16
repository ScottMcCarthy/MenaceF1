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
			menJava.directoryTrawler("/var/www/extras/FootballPhotos2012/");
%>


<BR>
<CENTER>
<TABLE border="1" width="100%" bgcolor="#ffffff">
	<TBODY>
		<TR>
			<TD width="121"><img border="0" src="images/season.jpg"
				width="289" height="178"></TD>
			<TD align="center" width="431"><FONT size="6">Football Photos<BR>2011/2012 Season

			</FONT></TD>
			<TD align="center"><IMG border="0" src="images/arsenalCrest.gif"
				width="137" height="160"></TD>
		</TR>
	</TBODY>
</TABLE>
</CENTER>


<BR>
<%
			menJava.galleryFront("/var/www/extras/FootballPhotos2012/",out,"gallery.jsp");
%>


<P></P></BODY>
</HTML>
