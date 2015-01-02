<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<TITLE>MenaceF1.co.uk</TITLE>
<%@ page 
language="java" import="menaceF1.*"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="GENERATOR" content="IBM WebSphere Studio">
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
						<td><font size="7" color="#0000ff" face="Times New Roman"><b><i><a href="http://www.menacef1.co.uk">MenaceF1.co.uk</a></i></b></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="https://twitter.com/MenaceF1" class="twitter-follow-button" data-show-count="false" data-size="large">Follow @MenaceF1</a>
<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script>						
						
						</td>
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
			menJava.directoryTrawler("/var/www");
%>
<TABLE border="1" width="100%" bgcolor="#ffffff">
	<TBODY>
		<TR>
			<TD width="155"><IMG border="0" src="images/senna_williams_renault.jpg"
				></TD>
			<TD width="736">
				<h1><a href="senna.jsp"> 1994 San Marino Grand Prix</a></h1>
				<h2>The full original BBC broadcast of the 1994 San Marino Grand Prix, where Ayrton Senna was killed, plus additonal news footage and tributes.</h2>
			</TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE border="1" width="100%" bgcolor="#ffffff">
	<TBODY>
		<TR>
			<TD width="155"><IMG border="0" src="images/arsenalCrest.gif"
				width="137" height="160"></TD>
			<TD width="736"><font size="3">
			<a href="football2012.jsp">Football Photos 2011 / 2012 Season - Final season before the arrival of Ellie</a><br />
			<a href="football2011.jsp">Football Photos 2010 / 2011 Season - The quest for silverwear continues...</a><br />
			<a href="football2010.jsp">Football Photos 2009 / 2010 Season - My first as a season ticket holder</a><br />
			<a href="football2009.jsp">Football Photos 2008 / 2009 Season - Rebuilding</a><br />
			<a href="football2008.jsp">Football Photos 2007 / 2008 Season - Life without Thierry</a><br />
			<a href="football2007.jsp">Football Photos 2006 / 2007 Season - Welcome to the Emirates Stadium</a><br />
			<a href="football2006.jsp">Football Photos 2005 / 2006 Season - UEFA Champions league Finalists</a><br />
			<a href="football2005.jsp"> Football Photos 2004 / 2005 Season - FA Cup Winners!</a><br /><a href="football2004.jsp">Football Photos 2003 / 2004 Season - Undefeated Premiership Champions!</a></font>
			</TD>
		</TR>
	</TBODY>
</TABLE>

<%
			menJava.galleryFront("/var/www",out,"gallery.jsp");
%>


<P></P></BODY>
</HTML>
