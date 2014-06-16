<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<TITLE>MenaceF1.co.uk</TITLE>
<%@ page 
language="java" import="menaceF1.*"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="GENERATOR" content="IBM WebSphere Studio" />

<script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/prototype/1.6.0.3/prototype.js'></script>
<script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/scriptaculous/1.8.2/scriptaculous.js'></script>
<script type='text/javascript' src='lightview2.5/js/lightview.js'></script>
<link rel="stylesheet" type="text/css" href="lightview2.5/css/lightview.css" />
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

	<jsp:useBean id="gal" class="menaceF1.Menweb" scope="session"/>
	<jsp:setProperty name="gal" property="*"/> 

<%
	String userPassword = request.getParameter("password");
	if (gal.isPasswordProtected(gal.getGallery())) {
		if (!gal.securityCheck(gal.getGallery(),userPassword)) {
	
%>
<form name="paswordForm" action="gallery.jsp" method="post">
<input type="hidden" name="gallery" value="<%=request.getParameter("gallery")%>" />

<table border="1" width="100%" bgcolor="#ffffff">

	<tbody>
<% if (userPassword !=null) { %>
		<tr>
			<td align="center"><font size="4" color="#ff0000">Sorry, you have entered an incorrect password, please try again.</font></td>
		</tr>
<% } %>
		<tr>
			<td align="center"><font size="4">This gallery is password protected, you must enter the password below to view this gallery</font></td>
		</tr>
		<tr>
			<td align="center"><input type="password" name="password" maxlength="15" size="16" /><br />
			<input type="submit" value="submit" name="enterPassword" />
			</td>
		</tr>
	</tbody>
</table>	
</form>
<%
	}}
	if ((!gal.isPasswordProtected(gal.getGallery())) || gal.securityCheck(gal.getGallery(),userPassword)){
%>

<table border="1" width="100%" bgcolor="#ffffff">

	<tbody>
		<tr>
			<td><font size="4"><i>Click on a thumbnail to view a larger image</i></font></td>
		</tr>
	</tbody>
</table>

<%gal.slideshowHTML(gal.getGallery(), gal.getGalleryName(), out,request.getParameter("gallery"),"midsize.jsp"); %>


<%
			gal.thumbsHTML(gal.getGallery(), gal.getGalleryName(), out,request.getParameter("gallery"),"midsize.jsp");
	}
%>


<p></p></body>
</html>
