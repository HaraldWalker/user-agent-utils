/*
* Copyright (c) 2008, Harald Walker (bitwalker.nl) 
* All rights reserved.
* 
* Redistribution and use in source and binary forms, with or
* without modification, are permitted provided that the
* following conditions are met:
* 
* * Redistributions of source code must retain the above
* copyright notice, this list of conditions and the following
* disclaimer.
* 
* * Redistributions in binary form must reproduce the above
* copyright notice, this list of conditions and the following
* disclaimer in the documentation and/or other materials
* provided with the distribution.
* 
* * Neither the name of bitwalker nor the names of its
* contributors may be used to endorse or promote products
* derived from this software without specific prior written
* permission.
* 
* THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND
* CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
* INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
* MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
* DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
* CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
* SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
* NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
* LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
* HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
* CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
* OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
* SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package nl.bitwalker.useragentutils;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Test class for application detection.
 * @author harald
 * 
 */
public class ApplicationTest {
	
	String[] emptyOrNull = new String[] {
			null,
			"",
			"-"
	};

	String[] hotmail = new String[] {
			"http://by105w.bay105.mail.live.com/mail/ReadMessageLight.aspx?Action=DeleteMessage&FolderID=00000000-0000-0000-0000-000000000001&InboxSortAscending=False&InboxSortBy=Date&ReadMessageId=12345-abcdedf-1345-abcdef&n=12345",
			"http://by119fd.bay119.hotmail.msn.com/cgi-bin/getmsg?msg=12345-abcdedf-1345-abcdef&start=0&len=6715&msgread=1&imgsafe=y&curmbox=00000000%2d0000%2d0000%2d0000%2d000000000001&a=12345678"
	};
	
	String[] gmail = new String[] {
			"http://mail.google.com/mail/?ui=2&view=bsp&ver=abcd",
			"http://mail.google.com/mail/?ui=1&ik=abcd&view=cv&search=inbox&th=123456&ww=123&cvap=11&qt=&zx=123456"
	};
	
	String[] yahooMail = new String[] {
			"http://us.f506.mail.yahoo.com/ym/ShowLetter?Search=&Idx=0&YY=12345&y5beta=yes&y5beta=yes&order=down&sort=date&pos=0",
			"http://aa.mg1.mail.yahoo.com/dc/blank.html?bn=123.48&.intl=aa",
			"http://de.mg40.mail.yahoo.com/dc/blank.html?bn=123.40&.intl=de"
	};
	
	String[] compuserve = new String[] {
			"http://csmail.compuserve.com/msgview.adp?folder=SU5CT1g=&seq=1&cmd=deletemsgs&msguid=12345&cmdnum=12345"
	};
	
	String[] aol = new String[] {
			"http://webmail.aol.com/12345/aol/en-us/Suite.aspx",
			"http://9c.webmail.aol.com/123456/neuf/fr-fr/Suite.aspx",
			"http://webmail.aol.com/38159/aim/en-us/Lite/MsgRead.aspx?folder=Inbox&uid=1.23456&seq=8&searchIn=none&searchQuery=&start=0"
	};
	
	String[] mailDotCom = new String[] {
			"http://mail01.mail.com/scripts/mail/read.mail",
			"http://mail01.mail.com/scripts/mail/read.mail?folder=INBOX&order=Newest&mview=a&mstart=1&pbox=0&msg_uid=12345&mprev=12345&mnext=12345&referer=mailbox"
	};
	
	String[] horde = new String[] {
			"http://webmail.dds.nl/horde/imp/message.php?index=123456",
			"http://webmail.versatel.nl/horde/imp/message.php?index=1234&start=8&actionID=delete_message"
	};
	
	String[] mobileMe = new String[] {
			"http://www.me.com/mail/",
			"http://www.me.com/wo/WebObjects/Webmail2.woa/wa/DirectAction/emptyPage?&action=view&mids=12345"
	};
	
	String[] unknownWebMailer = new String[] {
			"http://sg2001.webmail.hinet.net/mailService/mail/M_mail_1_iframe.jsp?msg=123456",
			"http://webmail.luxmail.com/email/scripts/view.pl?EV1=123456",
			// 12move included an email address in the referrer
			"http://webmail.12move.nl/mail/MessageRead?sid=123456&userid=abcdefg%4012move.nl&seq=C&auth=abcdef&srcfolder=INBOX&uid=12345&srch=0&style=default",
			"http://webmail.skynet.be/page.html?action=viewmessage&message_id=12345&thisfolder=INBOX",
			"http://webmail.atl.earthlink.net/wam/msg.jsp?msgid=12345&folder=INBOX&isSeen=false&x=-12345",
			"http://email2.online.nl/webmail/nl_NL/read.html",
			"http://webmail.luxmail.com/email/scripts/view.pl?EV1=123456",
			"http://webemail.telenet.be/cgi-bin/inbox.exe?id=@ID@&fld=12345,U;&open=22",
			"http://webmail.att.net/wmc/en-US/v/wm/12345?cmd=Next&a=2&no=70&sid=c0",
			// also telfort includes an email address in the referrer
			"http://webmail.telfort.nl/mail/MessageRead?sid=12345&userid=abcdefg%40telfort.nl&seq=C&auth=abcdefg&srcfolder=INBOX&uid=12345&srch=0&style=default",
			"http://webmail.casema.nl/webmail/popup.html?nopop",
			"http://email4.orange.nl/webmail/nl_NL/read.html?IDMSG=1234&FOLDER=SF_INBOX&SHOW_JUNK_TYPE=JUNK&ORIGIN=SYSTEM_FOLDER&MESSAGE=CONFIRM_MOVETOQUARANTAINE&REDIRECT_NO_NEXT_PREV=inbox.html&PARAM1=1&uids=12345&GOTO_ANOTHER_MSG=1&URL_VALID=read.html&FOLDER=SF_INBOX&REDIRECT_SUCCESS_LAST_MESSAGE=inbox.html&ORIGIN=SYSTEM_FOLDER&FOLDER_DEST=SF_JUNK&NEXT_MSG=12345&PREV_MSG=&REDIRECT_SUCCESS=read.html?IDMSG=__IDMSG____MD5_CHECK__&FOLDER=SF_INBOX&SHOW_JUNK_TYPE=JUNK&ORIGIN=SYSTEM_FOLDER&&CURRENT_FOLDER=SF_INBOX&REDIRECT_REFRESH=inbox.html&SHOW_JUNK=?SHOW_JUNK_TYPE=JUNK&",			
	};
	
	// other referrers which are not handled yet:
	// "http://mail50.paran.com/read/view.php?brd=INBOX&msgid=123456.nrmail2&p_eye=mail^lst^btl^mai^vw"
	// "http://wm30.inbox.com/Lib/123456/mod_email.html",
	// "http://apennootje.mail.everyone.net/email/scripts/view.pl?EV1=123456",
	// "http://mail.azon1.com/iclient/PreviewMsg.aspx?SeqNum=123456",
	// "http://mail.bollywoodmail.com/email/scripts/view.pl?EV1=123456",
	// "http://f006.mail.lycos.nl/app/msg/mail/read/body.jsp?id=12345",
	// "http://bareed11.maktoob.com/mail2/message272.php?mm=12345&uid=12345&folder=Inbox&rfc=0",
	// "http://g1a83.mail.126.com/a/s?func=mbox:readMessageHTML&sid=abcdefg&mid=11:123456",

	/**
	 * Test method for {@link nl.bitwalker.useragentutils.Application#isInReferrerString(java.lang.String)}.
	 */
	@Test
	public void testIsBrowser() {
		assertTrue(Application.GMAIL.isInReferrerString("http://mail.google.com/mail/?ui=1&ik=xx&view=cv&search=inbox&th=xx&ww=xx&cvap=5&qt=&zx=xx"));
	}

	/**
	 * Test method for {@link nl.bitwalker.useragentutils.Application#parseReferrerString(java.lang.String)}.
	 */
	@Test
	public void testParseUserAgentString() {
		testReferrers(emptyOrNull, Application.UNKNOWN);
		testReferrers(hotmail, Application.HOTMAIL);
		testReferrers(gmail, Application.GMAIL);
		testReferrers(yahooMail, Application.YAHOO_MAIL);
		testReferrers(horde, Application.HORDE);
		testReferrers(compuserve, Application.COMPUSERVE);
		testReferrers(aol, Application.AOL_WEBMAIL);
		testReferrers(mailDotCom, Application.MAIL_COM);
		testReferrers(mobileMe, Application.MOBILEME);
		testReferrers(unknownWebMailer, Application.OTHER_WEBMAIL);
	}
	
	private void testReferrers(String[] referrerStrings, Application expectedApplication) {
		for (String agentString : referrerStrings) {
			assertEquals(expectedApplication, Application.parseReferrerString(agentString));
		}		
	}
	
	/**
	 * Test if generated id values are unique.
	 */
	@Test
	public void testUniqueIdValues() {
		
		List<Short> retrievedIdValues = new ArrayList<Short>();
		
		for (Application application : Application.values()) {
			assertTrue(!retrievedIdValues.contains(application.getId()));
			retrievedIdValues.add(application.getId());
		}
	}

}
