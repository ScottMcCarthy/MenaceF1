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
						<TR><TD align="center" width="694"><U><FONT color="green" size="4">Competition  Rules</FONT></U><BR><small><A
							href="javascript:history.back()">Click here to return</A></small>
						</TD>
					</TR>
					<TR>
						<TD align="left" width="694"><B><U>Rules of Entry</U></B><OL>
							<LI>Anyone may enter this competition provided they argee by the rules of the competition outlined in this section. This competition is free to enter, but there's no prize either! You're in it for the glory.</LI>
							<LI>Entry is limited to a maximum of <B>two</B> entries per e-mail address, however if the webmaster believes a user is submitting multiple entires even with different e-mail addresses, we reserve the right to remove such entries from the league.</LI>
							<LI>Player names and usernames can be real or fictisious, however, usernames of a racist, anti-religious, or otherwise offensive nature will be deleted without warning. It is up to the webmaster to decide what is and is not in the above category. However, if you feel a username in the competition is unacceptable for the above reason, use the contact us form and register your complaint.</LI>
						</OL>
						<BR>
						<B><U>How to Play</U></B>
						<OL>
							<LI>The objective of the game is to predict the correct score for each game in the FA Barclays Premiership.</LI>
							<LI>For each game, you score 3 points for getting the result and score correct, 1 point for predicting the winner or a draw correctly, and 0 points otherwise.</LI>
							<LI>The 38 games each team in the Premiership will play is divided into 38 Matchdays.</LI>
							<LI>A Matchday will start and stop on a certain date. For example, for a weekend where there are 7 games on a Saturday, 2 on Sunday, and 1 on Monday, this matchday will start on the Saturday and finish on the Monday.</LI>
							<LI>You must predict all the games that take place on a particular matchday <I>before</I> the start of that matchday. Using the example in 4 again, you would have to submit your predictions for all 10 games by 23:59:59 on the Friday night. You can make predictions for future matchdays as far in advance as you wish. In fact, you can predict every game for the entire season in one go if you wish!</LI>
							<LI>You can change your predictions as often as you want up to the deadline defined in 5.</LI>
							<LI>Attempting to submit your predictions late will result in either your last successful submission being taken instead, or if there was no previous prediction, you will score no points for that matchday.</LI>
							<LI>Throughout the season, fixtures may change or be postponed for several reasons. (Clashes with the FA Cup, European fixtures, bad weather, etc). If this happens, fixtures may move from one matchday to a later one. Predictions already entered for this fixture will be remembered, but can be changed up to the deadline of the new matchday.</LI>
							<LI>Matchdays themselves can also have their start-dates and end-dates altered. Clearly, if a start-date of a matchday is moved to an earlier date, then the deadline will also be earlier. Therefore, this kind of change will be kept to a minumum, but may be necessary if for example a Saturday fixture is moved to a Friday for whatever reason. In this event, all users will be notified by their registered e-mail of the shorter deadline.</LI>
							<LI>Once the deadline for a matchday has begin, you can see all players predictions.</LI>
							<LI>Once a matchday has finished, the actual results will be uploaded to the site as soon as possible. (It's a manual process, so it's when the webmaster gets around to it!) Once results are uploaded, the league table is updated and you can view the points scored for a particular matchday.</LI>
						</OL><BR>
						<B><U>Site Availability</U></B>
						<OL>
							<LI>Always bookmark www.menacef1.co.uk and not any of it's individual pages. The domain name www.menacef1.co.uk will always work, but the IP address of pages within the site may change.</LI>
							<LI>The Webmaster will make every effort to ensure the site is available as close to 24/7 as possible, however, we cannot be held responsible for any expected downtime or unavailability. Any planned downtime will be notified in the news section, but please don't leave submitting your predictions to the last minute, as if the site isn't there when you want to submit, tough!</LI>
						</OL></TD>
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
