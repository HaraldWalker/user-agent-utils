/**
 * 
 */

using System;
using NUnit.Framework;

namespace  eu.bitwalker.useragentutils {


/**
 * 
 * @author pcollaog
 */
public class ApplicationParameterizedTest {


	public void testName(String referrerString,
			Application expectedApplication) {
		Application application = Application
				.parseReferrerString(referrerString);

		Assert.AreEqual(expectedApplication, application);
	}

	
				// Unknow webapp
				[TestCase( null, "UNKNOWN" )]
				[TestCase( "", "UNKNOWN" )]
				[TestCase( "-", "UNKNOWN" )]
				// Hotmail
				[TestCase(
						"http://by105w.bay105.mail.live.com/mail/ReadMessageLight.aspx?Action=DeleteMessage&FolderID=00000000-0000-0000-0000-000000000001&InboxSortAscending=False&InboxSortBy=Date&ReadMessageId=12345-abcdedf-1345-abcdef&n=12345",
						"HOTMAIL" )]
				[TestCase(
						"http://by119fd.bay119.hotmail.msn.com/cgi-bin/getmsg?msg=12345-abcdedf-1345-abcdef&start=0&len=6715&msgread=1&imgsafe=y&curmbox=00000000%2d0000%2d0000%2d0000%2d000000000001&a=12345678",
						"HOTMAIL" )]
				// Gmail
				[TestCase( "http://mail.google.com/mail/?ui=2&view=bsp&ver=abcd",
						"GMAIL" )]
				[TestCase(
						"http://mail.google.com/mail/?ui=1&ik=abcd&view=cv&search=inbox&th=123456&ww=123&cvap=11&qt=&zx=123456",
						"GMAIL" )]
				// Yahoo mail
				[TestCase(
						"http://us.f506.mail.yahoo.com/ym/ShowLetter?Search=&Idx=0&YY=12345&y5beta=yes&y5beta=yes&order=down&sort=date&pos=0",
						"YAHOO_MAIL" )]
				[TestCase(
						"http://aa.mg1.mail.yahoo.com/dc/blank.html?bn=123.48&.intl=aa",
						"YAHOO_MAIL" )]
				[TestCase(
						"http://de.mg40.mail.yahoo.com/dc/blank.html?bn=123.40&.intl=de",
						"YAHOO_MAIL" )]
				// Compuserve
				[TestCase(
						"http://csmail.compuserve.com/msgview.adp?folder=SU5CT1g=&seq=1&cmd=deletemsgs&msguid=12345&cmdnum=12345",
						"COMPUSERVE" )]
				// AOL
				[TestCase( "http://webmail.aol.com/12345/aol/en-us/Suite.aspx",
						"AOL_WEBMAIL" )]
				[TestCase( "http://9c.webmail.aol.com/123456/neuf/fr-fr/Suite.aspx",
						"AOL_WEBMAIL" )]
				[TestCase(
						"http://webmail.aol.com/38159/aim/en-us/Lite/MsgRead.aspx?folder=Inbox&uid=1.23456&seq=8&searchIn=none&searchQuery=&start=0",
						"AOL_WEBMAIL" )]
				// MailDotCom
				[TestCase( "http://mail01.mail.com/scripts/mail/read.mail",
						"MAIL_COM" )]
				[TestCase(
						"http://mail01.mail.com/scripts/mail/read.mail?folder=INBOX&order=Newest&mview=a&mstart=1&pbox=0&msg_uid=12345&mprev=12345&mnext=12345&referer=mailbox",
						"MAIL_COM" )]
				// Horde
				[TestCase( "http://webmail.dds.nl/horde/imp/message.php?index=123456",
						"HORDE" )]
				[TestCase(
						"http://webmail.versatel.nl/horde/imp/message.php?index=1234&start=8&actionID=delete_message",
						"HORDE" )]
				// MobileMe
				[TestCase( "http://www.me.com/mail/", "MOBILEME" )]
				[TestCase(
						"http://www.me.com/wo/WebObjects/Webmail2.woa/wa/DirectAction/emptyPage?&action=view&mids=12345",
						"MOBILEME" )]
				// Other webmailer
				[TestCase(
						"http://sg2001.webmail.hinet.net/mailService/mail/M_mail_1_iframe.jsp?msg=123456",
						"OTHER_WEBMAIL" )]
				[TestCase(
						"http://webmail.luxmail.com/email/scripts/view.pl?EV1=123456",
						"OTHER_WEBMAIL" )]
				[TestCase(
						"http://webmail.12move.nl/mail/MessageRead?sid=123456&userid=abcdefg%4012move.nl&seq=C&auth=abcdef&srcfolder=INBOX&uid=12345&srch=0&style=default",
						"OTHER_WEBMAIL" )]
				[TestCase(
						"http://webmail.skynet.be/page.html?action=viewmessage&message_id=12345&thisfolder=INBOX",
						"OTHER_WEBMAIL" )]
				[TestCase(
						"http://webmail.atl.earthlink.net/wam/msg.jsp?msgid=12345&folder=INBOX&isSeen=false&x=-12345",
						"OTHER_WEBMAIL" )]
				[TestCase( "http://email2.online.nl/webmail/nl_NL/read.html",
						"OTHER_WEBMAIL" )]
				[TestCase(
						"http://webmail.luxmail.com/email/scripts/view.pl?EV1=123456",
						"OTHER_WEBMAIL" )]
				[TestCase(
						"http://webemail.telenet.be/cgi-bin/inbox.exe?id=@ID@&fld=12345,U;&open=22",
						"OTHER_WEBMAIL" )]
				[TestCase(
						"http://webmail.att.net/wmc/en-US/v/wm/12345?cmd=Next&a=2&no=70&sid=c0",
						"OTHER_WEBMAIL" )]
				[TestCase(
						"http://webmail.telfort.nl/mail/MessageRead?sid=12345&userid=abcdefg%40telfort.nl&seq=C&auth=abcdefg&srcfolder=INBOX&uid=12345&srch=0&style=default",
						"OTHER_WEBMAIL" )]
				[TestCase( "http://webmail.casema.nl/webmail/popup.html?nopop",
						"OTHER_WEBMAIL" )]
				[TestCase(
						"http://email4.orange.nl/webmail/nl_NL/read.html?IDMSG=1234&FOLDER=SF_INBOX&SHOW_JUNK_TYPE=JUNK&ORIGIN=SYSTEM_FOLDER&MESSAGE=CONFIRM_MOVETOQUARANTAINE&REDIRECT_NO_NEXT_PREV=inbox.html&PARAM1=1&uids=12345&GOTO_ANOTHER_MSG=1&URL_VALID=read.html&FOLDER=SF_INBOX&REDIRECT_SUCCESS_LAST_MESSAGE=inbox.html&ORIGIN=SYSTEM_FOLDER&FOLDER_DEST=SF_JUNK&NEXT_MSG=12345&PREV_MSG=&REDIRECT_SUCCESS=read.html?IDMSG=__IDMSG____MD5_CHECK__&FOLDER=SF_INBOX&SHOW_JUNK_TYPE=JUNK&ORIGIN=SYSTEM_FOLDER&&CURRENT_FOLDER=SF_INBOX&REDIRECT_REFRESH=inbox.html&SHOW_JUNK=?SHOW_JUNK_TYPE=JUNK&",
						"OTHER_WEBMAIL" )]
				// other referrers which are not handled yet
				[TestCase(
						"http://mail50.paran.com/read/view.php?brd=INBOX&msgid=123456.nrmail2&p_eye=mail^lst^btl^mai^vw",
						"UNKNOWN" )]
				[TestCase( "http://wm30.inbox.com/Lib/123456/mod_email.html",
						"UNKNOWN" )]
				[TestCase(
						"http://apennootje.mail.everyone.net/email/scripts/view.pl?EV1=123456",
						"UNKNOWN" )]
				[TestCase(
						"http://mail.azon1.com/iclient/PreviewMsg.aspx?SeqNum=123456",
						"UNKNOWN" )]
				[TestCase(
						"http://mail.bollywoodmail.com/email/scripts/view.pl?EV1=123456",
						"UNKNOWN" )]
				[TestCase(
						"http://f006.mail.lycos.nl/app/msg/mail/read/body.jsp?id=12345",
						"UNKNOWN" )]
				[TestCase(
						"http://bareed11.maktoob.com/mail2/message272.php?mm=12345&uid=12345&folder=Inbox&rfc=0",
						"UNKNOWN" )]
				[TestCase(
						"http://g1a83.mail.126.com/a/s?func=mbox:readMessageHTML&sid=abcdefg&mid=11:123456",
						"UNKNOWN" )]
        [Test]
        public void TestApplication(String referrerString,
			String expectedApplication)
    { 
        testName(referrerString, Application.valueOf(expectedApplication));
    }
                }

}
