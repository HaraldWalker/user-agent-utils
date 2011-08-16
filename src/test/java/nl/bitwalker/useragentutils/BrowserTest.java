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
 * @author harald
 *
 */
public class BrowserTest {

	String[] ie6clients = new String[] {
			"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0; T312461)",
			"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 1.1.4322; XMPP Tiscali Communicator v.10.0.2; .NET CLR 2.0.50727)",
			"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; SV1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)"
	};
	
	String[] ie7clients = new String[] {
			"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; SV1; .NET CLR 2.0.50727)",
			"Mozilla/4.0 (compatible; MSIE 7.0b; Windows NT 6.0 ; .NET CLR 2.0.50215; SL Commerce Client v1.0; Tablet PC 2.0",
			"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)",
			"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; SLCC1; .NET CLR 2.0.50727; .NET CLR 3.0.04506)" // Windows Mail on Vista
	};
	
	String[] ie8clients = new String[] {
			"Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0; WOW64; SLCC1; .NET CLR 2.0.50727; .NET CLR 3.0.04506; Media Center PC 5.0; .NET CLR 1.1.4322)",
			"Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0; Win64; x64; .NET CLR 2.0.50727; SLCC1; Media Center PC 5.0; .NET CLR 3.0.04506)"
	};
	
	String[] ie9clients = new String[] {
			"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; Zune 4.0; InfoPath.3; MS-RTC LM 8; .NET4.0C; .NET4.0E)",
			"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0"
	};
	
	String[] ie10clients = new String[] {
			"Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; Trident/6.0)"
	};	
	
	String[] ie55clients = new String[] {
			"Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0; .NET CLR 1.1.4322)",
			"Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0)",
			"Mozilla/4.0 (compatible; MSIE 5.5; Windows 95)"
	};
	
	String[] ieTooOld = new String[] {
			"Mozilla/4.0 (compatible; MSIE 4.01; Windows 95)",
			"Mozilla/4.0 (compatible; MSIE 4.0; Windows 95; .NET CLR 1.1.4322; .NET CLR 2.0.50727)",
			"Mozilla/2.0 (compatible; MSIE 3.03; Windows 3.1)"
	};
	
	String[] outlook2007 = new String[] {
			"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; SLCC1; .NET CLR 2.0.50727; .NET CLR 3.0.04506; .NET CLR 1.1.4322; MSOffice 12)"
	};
	
	String[] outlook2010 = new String[] {
			"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; Trident/4.0; GTB6.4; Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1) ; SLCC1; .NET CLR 2.0.50727; Media Center PC 5.0; .NET CLR 1.1.4322; .NET CLR 3.5.30729; .NET CLR 3.0.30729; OfficeLiveConnector.1.3; OfficeLivePatch.0.0; MSOffice 14)",
			"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.1; Trident/4.0; .NET CLR 2.0.50727; .NET CLR 3.0.30729; .NET CLR 3.5.30729; Media Center PC 6.0; SLCC2; ms-office; MSOffice 14)"
	};
	
	
	String[] outookExpress = new String[] {
			"Outlook-Express/7.0 (MSIE 6.0; Windows NT 5.1; SV1; SIMBAR={xxx}; .NET CLR 2.0.50727; .NET CLR 1.1.4322; TmstmpExt)",
			"Outlook-Express/7.0 (MSIE 7.0; Windows NT 5.1; InfoPath.2; .NET CLR 1.1.4322; .NET CLR 2.0.50727; TmstmpExt)"
	};
		
	String[] ieMobile6 = new String[] {
			"HTC_TyTN Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 6.12)",
			"Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 6.12) Vodafone/1.0/HTC_s710/1.22.172.3",
			"Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 6.8) PPC; 240x320; HTC_TyTN/1.0 Profile/MIDP-2.0 Configuration/CLDC-1.1"
	};

	String[] ieMobile7 = new String[] {
		 "HTC_TouchDual Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 7.6)",
		 "PPC; 240x320; HTC_P3450/1.0 Profile/MIDP-2.0 Configuration/CLDC-1.1 Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 7.6)",
	     "Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 7.6) PPC; MDA Vario/3.0 Profile/MIDP-2.0 Configuration/CLDC-1.1",
	     "Palm750/v0005 Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 7.6) UP.Link/6.3.0.0.0"
	};
	
	String[] ieMobile9 = new String[] {
			"Mozilla/5.0 (compatible; MSIE 9.0; Windows Phone OS 7.5; Trident/5.0; IEMobile/9.0)"
	};
		
	String[] lotusNotes = new String[] {
		"Mozilla/4.0 (compatible; Lotus-Notes/5.0; Windows-NT)",
		"Mozilla/4.0 (compatible; Lotus-Notes/6.0; Windows-NT)"
	};
	
	String[] lynxClient = new String[] {
			"Lynx/2.8.5rel.1 libwww-FM/2.14 SSL-MM/1.4.1 OpenSSL/0.9.7d",
			"Lynx/2.7.1ac-0.102+intl+csuite libwww-FM/2.14"
	};
	
	String[] konqueror = new String[] {
			"Mozilla/5.0 (compatible; konqueror/3.3; linux 2.4.21-243-smp4G) (KHTML, like Geko)",
			"Mozilla/6.0 (compatible; Konqueror/4.2; i686 FreeBSD 6.4; 20060308)",
			"Mozilla/5.0 (compatible; Konqueror/3.1; Linux 2.4.21-20.0.1.ELsmp; X11; i686; , en_US, en, de)"
	};
	
	String[] chrome = new String[] {
			"Mozilla/5.0 (Windows; U; Windows NT 5.2; en-US) AppleWebKit/532.9 (KHTML, like Gecko) Chrome/5.0.310.0 Safari/532.9",
			"Mozilla/5.0 (X11; U; Linux x86_64; en-US) AppleWebKit/532.9 (KHTML, like Gecko) Chrome/5.0.309.0 Safari/532.9"
	};

	String[] chrome8 = new String[] {
			"Mozilla/5.0 (Windows; U; Windows NT 5.2; en-US) AppleWebKit/534.10 (KHTML, like Gecko) Chrome/8.0.558.0 Safari/534.10",
			"Mozilla/5.0 (X11; U; Linux x86_64; en-US) AppleWebKit/540.0 (KHTML, like Gecko) Ubuntu/10.10 Chrome/8.1.0.0 Safari/540.0"
	};
	
	String[] chrome9 = new String[] {
			"Mozilla/5.0 (X11; U; Linux x86_64; en-US) AppleWebKit/540.0 (KHTML,like Gecko) Chrome/9.1.0.0 Safari/540.0",
			"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) AppleWebKit/534.14 (KHTML, like Gecko) Chrome/9.0.600.0 Safari/534.14"
	};
	
	String[] chrome10 = new String[] {
			"Mozilla/5.0 (X11; U; Linux i686; en-US) AppleWebKit/534.15 (KHTML, like Gecko) Ubuntu/10.10 Chromium/10.0.613.0 Chrome/10.0.613.0 Safari/534.15"
	};
	
	String[] chrome11 = new String[] {
			"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/11.0.697.0 Safari/534.24"
	};
	
	String[] chrome12 = new String[] {
			"Mozilla/5.0 (X11; CrOS i686 12.0.742.91) AppleWebKit/534.30 (KHTML, like Gecko) Chrome/12.0.742.93 Safari/534.30"
	};
	
	String[] chrome13 = new String[] {
			"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_6_7) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.41 Safari/535.1"
	};
	
	String[] chrome14 = new String[] {
			"Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/14.0.815.0 Safari/535.1"
	};
	
	String[] firefox3 = new String[] {
			"Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.14) Gecko/2009090216 Ubuntu/9.04 (jaunty) Firefox/3.0.14"
	};
	
	String[] firefox4 = new String[] {
			"Mozilla/5.0 (X11; Linux x86_64; rv:2.0b4) Gecko/20100818 Firefox/4.0b4",
			"Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:2.0b9pre) Gecko/20101228 Firefox/4.0b9pre"
	};
	
	String[] firefox5 = new String[] {
			"Mozilla/5.0 (Windows NT 6.1; U; ru; rv:5.0.1.6) Gecko/20110501 Firefox/5.0.1 Firefox/5.0.1",
			"Mozilla/5.0 (X11; U; Linux i586; de; rv:5.0) Gecko/20100101 Firefox/5.0"
	};

	String[] firefox6 = new String[] {
	"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:6.0a2) Gecko/20110612 Firefox/6.0a2"
	};

	
	String[] firefox3mobile = {
			"Mozilla/5.0 (X11; U; Linux armv7l; en-US; rv:1.9.2a1pre) Gecko/20091127 Firefox/3.5 Maemo Browser 1.5.6 RX-51 N900"
	};
	
	String[] safari = {
			"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_5_7; en-us) AppleWebKit/525.28.3 (KHTML, like Gecko) Version/3.2.3 Safari/525.28.3",
			"Mozilla/5.0 (Macintosh; U; Intel Mac OS X; en-gb) AppleWebKit/523.10.6 (KHTML, like Gecko) Version/3.0.4 Safari/523.10.6"
	};
	
	String[] safari5 = {
			"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_4; en-us) AppleWebKit/533.16 (KHTML, like Gecko) Version/5.0 Safari/533.16",
			"Mozilla/5.0 (Windows; U; Windows NT 6.1; ja-JP) AppleWebKit/533.16 (KHTML, like Gecko) Version/5.0 Safari/533.16",
			"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_5; en-us) AppleWebKit/533.19.4 (KHTML, like Gecko) Version/5.0.3 Safari/533.19.4",
			"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_7; da-dk) AppleWebKit/533.21.1 (KHTML, like Gecko) Version/5.0.5 Safari/533.21.1"
	};
	
	String[] safari4 = {
			"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_2; en-us) AppleWebKit/531.21.8 (KHTML, like Gecko) Version/4.0.4 Safari/531.21.10",
			"Mozilla/5.0 (Windows; U; Windows NT 6.1; es-ES) AppleWebKit/531.22.7 (KHTML, like Gecko) Version/4.0.5 Safari/531.22.7",
			"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_5_7; en-us) AppleWebKit/531.2+ (KHTML, like Gecko) Version/4.0.1 Safari/530.18"
	};
	
	String[] mobileSafari = {			
			"Mozilla/5.0 (Linux; U; Android 2.1; en-us; Nexus One Build/ERD62) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Mobile Safari/530.17",
			"Mozilla/5.0 (iPod; U; CPU iPhone OS 2_0 like Mac OS X; de-de) AppleWebKit/525.18.1 (KHTML, like Gecko) Version/3.1.1 Mobile/5A347 Safari/525.20", // Mobile Safari 3.1.1
			"Mozilla/5.0 (iPod; U; CPU like Mac OS X; en) AppleWebKit/420.1 (KHTML, like Gecko) Version/3.0 Mobile/3A101a Safari/419.3", // Mobile Safari 3.0
			"Mozilla/5.0 (iPad; U; CPU OS 3_2 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Version/4.0.4 Mobile/7B367 Safari/531.21.10",
			"Mozilla/5.0 (iPod; U; CPU iPhone OS 4_1 like Mac OS X; en-us) AppleWebKit/532.9 (KHTML, like Gecko) Version/4.0.5 Mobile/8B117 Safari/6531.22.7"
	};
	
	String[] dolfin = {
			"Mozilla/5.0 (SAMSUNG; SAMSUNG-GT-S8500/S8500NEJE5; U; Bada/1.0; fr-fr) AppleWebKit/533.1 (KHTML, like Gecko) Dolfin/2.0 Mobile WVGA SMM-MMS/1.2.0 NexPlayer/3.0 profile/MIDP-2.1 configuration/CLDC-1.1 OPN-B"
	};
	
	// similar to Safari, but doesn't mention Safari in the user-agent string
	String[] appleMail = {
			"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_4; en-us) AppleWebKit/533.18.1 (KHTML, like Gecko)"
	};
	
	String[] omniWeb = {
			"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_5_8; en-US) AppleWebKit/531.9+(KHTML, like Gecko, Safari/528.16) OmniWeb/v622.10.0",
			"Mozilla/5.0 (Macintosh; U; Intel Mac OS X; en-US) AppleWebKit/525.18 (KHTML, like Gecko, Safari/525.20) OmniWeb/v622.3.0.105198"
	};
	
	String[] opera = {
			"Opera/8.0 (Macintosh; PPC Mac OS X; U; en)",
		};
	
	String[] opera9 = {
			"Opera/9.52 (Windows NT 5.1; U; en)",
			"Opera/9.20 (Macintosh; Intel Mac OS X; U; en)"
		};
	
	String[] opera10 = {
			"Opera/9.80 (Windows NT 5.2; U; en) Presto/2.2.15 Version/10.10",
			"Opera/9.80 (Macintosh; Intel Mac OS X; U; en) Presto/2.6.30 Version/10.61"
		};
	
	String[] operaMini = {
		"Opera/9.60 (J2ME/MIDP; Opera Mini/4.2.13337/458; U; en) Presto/2.2.0",
		"Opera/9.80 (J2ME/MIDP; Opera Mini/5.0.16823/1428; U; en) Presto/2.2.0"
	};
	
	String[] camino2 = {
			"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.6; en; rv:1.9.0.19) Gecko/2010111021 Camino/2.0.6 (MultiLang) (like Firefox/3.0.19)",
			"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.6; en; rv:1.9.0.18) Gecko/2010021619 Camino/2.0.2 (like Firefox/3.0.18)"
	};
	
	String[] camino = {
			"Mozilla/5.0 (Macintosh; U; PPC Mac OS X Mach-O; it; rv:1.8.1.21) Gecko/20090327 Camino/1.6.7 (MultiLang) (like Firefox/2.0.0.21pre)",
			"Mozilla/5.0 (Macintosh; U; PPC Mac OS X Mach-O; en-US; rv:1.8.0.4) Gecko/20060613 Camino/1.0.2"
	};
	
	String[] flock = {
			"Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.3) Gecko/2008100716 Firefox/3.0.3 Flock/2.0"
	};
	
	String[] seaMonkey = {
			"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.1.13) Gecko/20100914 Mnenhy/0.8.3 SeaMonkey/2.0.8"
	};
		
	String[] bots = {
			"Mozilla/5.0 (compatible; Googlebot/2.1; http://www.google.com/bot.html)",
			"Mozilla/5.0 (compatible; Yahoo! Slurp; http://help.yahoo.com/help/us/ysearch/slurp)",
			"Googlebot-Image/1.0"
	};
	
	String[] tools = {
			"curl/7.19.5 (i586-pc-mingw32msvc) libcurl/7.19.5 OpenSSL/0.9.8l zlib/1.2.3",
			"Wget/1.8.1"
	};
	
	String[] thunderbird3 = {
			"Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.2.12) Gecko/20101027 Thunderbird/3.1.6",
			"Mozilla/5.0 (Windows; U; Windows NT 6.1; sv-SE; rv:1.9.2.8) Gecko/20100802 Thunderbird/3.1.2 ThunderBrowse/3.3.2"
	};
	
	String[] thunderbird2 = {
			"Mozilla/5.0 (Windows; U; Windows NT 6.0; en-GB; rv:1.8.1.14) Gecko/20080421 Thunderbird/2.0.0.14",
			"Mozilla/5.0 (Macintosh; U; Intel Mac OS X; en-US; rv:1.8.1.17) Gecko/20080914 Thunderbird/2.0.0.17"
	};
	
	
	/**
	 * Test method for {@link nl.bitwalker.useragentutils.Browser#isInUserAgentString(java.lang.String)}.
	 */
	@Test
	public void testIsBrowser() {
		assertTrue(Browser.SAFARI.isInUserAgentString("Mozilla/5.0 (iPhone; U; CPU like Mac OS X; en) AppleWebKit/420+ (KHTML, like Gecko) Version/3.0 Mobile/1A543a Safari/419.3"));
	}
	
	/**
	 * 
	 */
	@Test
	public void testVersionDetection() {
		testVersions("Lynx/2.8.5rel.1 libwww-FM/2.14 SSL-MM/1.4.1 OpenSSL/0.9.7d", new Version("2.8.5rel.1","2","8"));
		testVersions("Mozilla/6.0 (compatible; Konqueror/4.2; i686 FreeBSD 6.4; 20060308)", new Version("4.2", "4","2"));
		testVersions("Mozilla/5.0 (compatible; Konqueror/3.1-rc5; i686 Linux; 20021219)", new Version("3.1-rc5","3","1"));
		testVersions("Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.14) Gecko/2009090216 Ubuntu/9.04 (jaunty) Firefox/3.0.14", new Version("3.0.14","3","0"));
		testVersions("Mozilla/4.0 (compatible; MSIE 7.0b; Windows NT 6.0 ; .NET CLR 2.0.50215; SL Commerce Client v1.0; Tablet PC 2.0", new Version("7.0b","7","0b")); // is minor here b or 0b?
		testVersions("Opera/9.80 (Windows NT 5.2; U; en) Presto/2.2.15 Version/10.10", new Version("10.10", "10", "10"));
		testVersions("Opera/8.0 (Macintosh; PPC Mac OS X; U; en)", new Version("8.0","8","0"));
		testVersions("Mozilla/5.0 (Windows; U; Windows NT 5.2; en-US) AppleWebKit/534.10 (KHTML, like Gecko) Chrome/8.0.558.0 Safari/534.10",new Version("8.0.558.0","8","0"));
		testVersions("Mozilla/5.0 (X11; U; Linux x86_64; en-US) AppleWebKit/540.0 (KHTML,like Gecko) Chrome/9.1.0.0 Safari/540.0", new Version("9.1.0.0","9","1"));
		testVersions("Mozilla/5.0 (Macintosh; U; Intel Mac OS X; en-gb) AppleWebKit/523.10.6 (KHTML, like Gecko) Version/3.0.4 Safari/523.10.6", new Version("3.0.4","3","0"));
		testVersions("Mozilla/5.0 (Linux; U; Android 2.1; en-us; Nexus One Build/ERD62) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Mobile Safari/530.17", new Version("4.0","4","0"));
		testVersions("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; Trident/4.0; GTB6.4; Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1) ; SLCC1; .NET CLR 2.0.50727; Media Center PC 5.0; .NET CLR 1.1.4322; .NET CLR 3.5.30729; .NET CLR 3.0.30729; OfficeLiveConnector.1.3; OfficeLivePatch.0.0; MSOffice 14)", new Version("14","14","0"));
		testVersions("Mozilla/5.0 (Macintosh; U; PPC Mac OS X Mach-O; it; rv:1.8.1.21) Gecko/20090327 Camino/1.6.7 (MultiLang) (like Firefox/2.0.0.21pre)", new Version("1.6.7","1","6"));
		testVersions("Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.3) Gecko/2008100716 Firefox/3.0.3 Flock/2.0", new Version("2.0","2","0"));
		testVersions("Mozilla/5.0 (Macintosh; U; Intel Mac OS X; en-US; rv:1.8.1.17) Gecko/20080914 Thunderbird/2.0.0.17", new Version("2.0.0.17","2","0"));
		testVersions("Mozilla/4.0 (compatible; Lotus-Notes/5.0; Windows-NT)", new Version("5.0","5","0"));
		testVersions("Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.1.13) Gecko/20100914 Mnenhy/0.8.3 SeaMonkey/2.0.8", new Version("2.0.8", "2", "0"));
		testVersions("Mozilla/5.0 (SymbianOS/9.2; U; Series60/3.1 NokiaE90-1/07.24.0.3; Profile/MIDP-2.0 Configuration/CLDC-1.1 ) AppleWebKit/413 (KHTML, like Gecko) Safari/413 UP.Link/6.2.3.18.0",null);
		testVersions("Mozilla/5.0 (compatible; Googlebot/2.1; http://www.google.com/bot.html)", null); // no version information for some browsers
	}

	private void testVersions(String ua, Version expectedVersion) {
		Version version = Browser.parseUserAgentString(ua).getVersion(ua);
		assertEquals(expectedVersion, version);
	}
	
	/**
	 * Test method for {@link nl.bitwalker.useragentutils.Browser#parseUserAgentString(java.lang.String)}.
	 */
	@Test
	public void testParseUserAgentString() {
		testAgents(ie55clients, Browser.IE5_5);
		testAgents(ie6clients, Browser.IE6);
		testAgents(ie7clients, Browser.IE7);
		testAgents(ie8clients, Browser.IE8);
		testAgents(ie9clients, Browser.IE9);
		testAgents(ie10clients, Browser.IE10);
		testAgents(ieTooOld, Browser.IE);
		testAgents(outlook2007, Browser.OUTLOOK2007);
		testAgents(outlook2010, Browser.OUTLOOK2010);
		testAgents(outookExpress, Browser.OUTLOOK_EXPRESS7);
		testAgents(ieMobile6, Browser.IEMOBILE6);
		testAgents(ieMobile7, Browser.IEMOBILE7);
		testAgents(ieMobile9, Browser.IEMOBILE9);
		testAgents(lotusNotes, Browser.LOTUS_NOTES);
		testAgents(lynxClient, Browser.LYNX);
		testAgents(konqueror, Browser.KONQUEROR);
		testAgents(chrome, Browser.CHROME);
		testAgents(chrome8, Browser.CHROME8);
		testAgents(chrome9, Browser.CHROME9);
		testAgents(chrome10, Browser.CHROME10);
		testAgents(chrome11, Browser.CHROME11);
		testAgents(chrome12, Browser.CHROME12);
		testAgents(chrome13, Browser.CHROME13);
		testAgents(chrome14, Browser.CHROME14);
		testAgents(firefox3, Browser.FIREFOX3);
		testAgents(firefox4, Browser.FIREFOX4);
		testAgents(firefox5, Browser.FIREFOX5);
		testAgents(firefox6, Browser.FIREFOX6);
		testAgents(firefox3mobile, Browser.FIREFOX3MOBILE);
		testAgents(safari, Browser.SAFARI);
		testAgents(dolfin, Browser.DOLFIN2);
		testAgents(safari5, Browser.SAFARI5);
		testAgents(safari4, Browser.SAFARI4);
		testAgents(mobileSafari, Browser.MOBILE_SAFARI);
		testAgents(appleMail, Browser.APPLE_MAIL);
		testAgents(omniWeb, Browser.OMNIWEB);
		testAgents(operaMini, Browser.OPERA_MINI);
		testAgents(opera9, Browser.OPERA9);
		testAgents(opera, Browser.OPERA);
		testAgents(opera10, Browser.OPERA10);
		testAgents(camino2, Browser.CAMINO2);
		testAgents(flock, Browser.FLOCK);
		testAgents(seaMonkey, Browser.SEAMONKEY);
		testAgents(bots, Browser.BOT);
		testAgents(tools, Browser.DOWNLOAD);
		testAgents(thunderbird3, Browser.THUNDERBIRD3);
		testAgents(thunderbird2, Browser.THUNDERBIRD2);
	}
	
	private void testAgents(String[] agentStrings, Browser expectedBrowser) {
		for (String agentString : agentStrings) {
			assertEquals(expectedBrowser, Browser.parseUserAgentString(agentString));
		}		
	}
	
	@Test
	public void testIncompleteUAString() {
		try {
			Browser browser = Browser.parseUserAgentString("Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_3; en-us) AppleWebKit/531.21.11 (KHTML, like");	
			browser.getVersion("Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_3; en-us) AppleWebKit/531.21.11 (KHTML, like");
			Browser browser2 = Browser.parseUserAgentString("Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.5; en-US; rv:1.9.0.8) Gecko/2009032608 Firefox");	
			browser2.getVersion("Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.5; en-US; rv:1.9.0.8) Gecko/2009032608 Firefox");
			Browser browser3 = Browser.parseUserAgentString("Mozilla/4.0 (compatible; MSIE 8");	
			browser3.getVersion("Mozilla/4.0 (compatible; MSIE 8");			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	/**
	 * Test if generated id values are unique.
	 */
	@Test
	public void testUniqueIdValues() {
		
		List<Short> retrievedIdValues = new ArrayList<Short>();
		
		for (Browser browser : Browser.values()) {
			assertTrue(browser.toString(),!retrievedIdValues.contains(browser.getId()));
			retrievedIdValues.add(browser.getId());
		}
	}

}
