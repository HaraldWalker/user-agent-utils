/*
* Copyright (c) 2008-2014, Harald Walker (bitwalker.eu) and contributing developers 
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

package eu.bitwalker.useragentutils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
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
			"Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; Trident/6.0)",
			"Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Trident/6.0)",
			"Mozilla/5.0 (compatible; MSIE 10.6; Windows NT 6.1; Trident/5.0; InfoPath.2; SLCC1; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729; .NET CLR 2.0.50727) 3gpp-gba UNTRUSTED/1.0"
	};	
	
	String[] ie11clients = new String[] {
			"Mozilla/5.0 (Windows NT 6.3; WOW64; Trident/7.0; rv:11.0) like Gecko",
			"Mozilla/5.0 (Windows NT 6.3; WOW64; Trident/7.0; ASU2JS; rv:11.0) like Gecko", //64bit Win8
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
	
	String[] outlook2013 = new String[] {
			"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.1; Win64; x64; Trident/6.0; .NET CLR 2.0.50727; SLCC2; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; .NET4.0E; InfoPath.3; Tablet PC 2.0; Microsoft Outlook 15.0.4481; ms-office; MSOffice 15)"
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
	
	String[] ieMobile10 = new String[] {
			"Mozilla/5.0 (compatible; MSIE 10.0; Windows Phone 8.0; Trident/6.0; IEMobile/10.0; ARM; Touch; NOKIA; Lumia 920)"
	};

	
	String[] ieMobile11 = {
			"Mozilla/5.0 (Windows Phone 8.1; ARM; Trident/7.0; Touch; rv:11.0; IEMobile/11.0; HTC; HTC6990LVW) like Gecko"
	};
	
    String[] ie7Rss = new String[] {
            "Windows-RSS-Platform/1.0 (MSIE 7.0; Windows NT 5.1)",
            "Windows-RSS-Platform/1.0 (MSIE 7.0; Windows NT 6.0)",
            "Windows-RSS-Platform/1.0 (MSIE 7.0; Windows NT 6.1)"
    };
    
    String[] ie8Rss = new String[] {
            "Windows-RSS-Platform/2.0 (MSIE 8.0; Windows NT 6.0)",
    };
    
	
	
	String[] ie9Rss = new String[] {
            "Windows-RSS-Platform/2.0 (MSIE 9.0; Windows NT 6.0)"
    };

    String[] ie10Rss = new String[] {
            "Windows-RSS-Platform/2.0 (MSIE 10.0; Windows NT 6.0)"
    };

    String[] ie11Rss = new String[] {
            "Windows-RSS-Platform/2.0 (IE 11.0; Windows NT 6.1)"
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
	
	String[] chromeMobile = new String[] {
			"Mozilla/5.0 (Linux; U; Android-4.0.3; en-us; Xoom Build/IML77) AppleWebKit/535.7 (KHTML, like Gecko) CrMo/16.0.912.75 Safari/535.7",
			"Mozilla/5.0 (Linux; U; Android-4.0.3; en-us; Galaxy Nexus Build/IML74K) AppleWebKit/535.7 (KHTML, like Gecko) CrMo/16.0.912.75 Mobile Safari/535.7",
			"Mozilla/5.0 (iPhone; U; CPU iPhone OS 5_1_1 like Mac OS X; en) AppleWebKit/534.46.0 (KHTML, like Gecko) CriOS/19.0.1084.60 Mobile/9B206 Safari/7534.48.3",
			"Mozilla/5.0 (Linux; Android 4.1.2; LT22i Build/6.2.A.1.100) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.59 Mobile Safari/537.36"
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
	
	String[] chrome29 = new String[] {
			"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.65 Safari/537.36"
	};
	
	String[] chrome32 = new String[] {
			"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1700.77 Safari/537.36",
			"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1700.107 Safari/537.36"
	};

	String[] chrome33 = new String[] {
			"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.117 Safari/537.36"
	};

	String[] chrome31 = new String[] {
			"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36"
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

	String[] firefox19 = new String[] {
			"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:19.0) Gecko/20100101 Firefox/19.0"
	};

	String[] firefox20 = new String[] {
		"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:20.0) Gecko/20100101 Firefox/20.0"
	};
	
	String[] firefox25 = new String[] {
			"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.6; rv:25.0) Gecko/20100101 Firefox/25.0"
	};
	
	String[] firefox28 = new String[] {
			"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:28.0) Gecko/20100101 Firefox/28.0"
	};

	String[] firefox3mobile = {
			"Mozilla/5.0 (X11; U; Linux armv7l; en-US; rv:1.9.2a1pre) Gecko/20091127 Firefox/3.5 Maemo Browser 1.5.6 RX-51 N900"
	};
	
	String[] firefoxMobile = {
		"Mozilla/5.0 (Android; Mobile; rv:13.0) Gecko/13.0 Firefox/13.0"	
	};
	
	String[] firefoxMobile23 = {
			"Mozilla/5.0 (Android; Mobile; rv:23.0) Gecko/23.0 Firefox/23.0"	
	};
	
	String[] safari = {
			"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_5_7; en-us) AppleWebKit/525.28.3 (KHTML, like Gecko) Version/3.2.3 Safari/525.28.3",
			"Mozilla/5.0 (Macintosh; U; Intel Mac OS X; en-gb) AppleWebKit/523.10.6 (KHTML, like Gecko) Version/3.0.4 Safari/523.10.6"
	};
	
	String[] safari6 = {
			"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_3) AppleWebKit/536.28.10 (KHTML, like Gecko) Version/6.0.3 Safari/536.28.10"
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
			"Mozilla/5.0 (iPod; U; CPU iPhone OS 4_1 like Mac OS X; en-us) AppleWebKit/532.9 (KHTML, like Gecko) Version/4.0.5 Mobile/8B117 Safari/6531.22.7",
			"Mozilla/5.0 (iPhone; CPU iPhone OS 5_0 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9A334 Safari/7534.48.3",
			"Mozilla/5.0 (iPhone; CPU iPhone OS 5_1_1 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9B206 Safari/7534.48.3"
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
	
	String[] opera11 = {
			"Opera/9.80 (Windows NT 6.1; WOW64; U; pt) Presto/2.10.229 Version/11.62",
			"Opera/9.80 (Windows NT 6.0; U; pl) Presto/2.10.229 Version/11.62"
		};
	
	String[] opera12 = {
			"Opera/9.80 (Windows NT 6.1; U; es-ES) Presto/2.9.181 Version/12.00",
			"Opera/12.0(Windows NT 5.1;U;en)Presto/22.9.168 Version/12.00"
		};
	
	String[] opera15 = {
			"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.52 Safari/537.36 OPR/15.0.1147.100"
		};
	
	String[] opera16 = {
			"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.57 Safari/537.36 OPR/16.0.1196.73"
		};
	
	String[] opera17 = {
			"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.101 Safari/537.36 OPR/17.0.1241.53"
		};

	String[] opera18 = {
			"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36 OPR/18.0.1284.63",
			"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36 OPR/18.0.1284.68",
			"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36 OPR/18.0.1284.49",

		};

	String[] opera19 = {
			"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1700.76 Safari/537.36 OPR/19.0.1326.39 (Edition Next)",
			"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1700.76 Safari/537.36 OPR/19.0.1326.56",
			"Mozilla/5.0 (Windows NT 6.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1700.102 Safari/537.36 OPR/19.0.1326.59",
			"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1700.107 Safari/537.36 OPR/19.0.1326.63",
			"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1700.107 Safari/537.36 OPR/19.0.1326.63"
		};

	String[] opera20 = {
			"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.91 Safari/537.36 OPR/20.0.1387.37 (Edition Next)",
			"Mozilla/5.0 (Windows NT 6.3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.46 Safari/537.36 OPR/20.0.1387.16 (Edition Developer)"
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
			"Googlebot-Image/1.0",
			"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/536.8 (KHTML, like Gecko; Google Web Preview) Chrome/19.0.1084.36 Safari/536.8"
	};
	
	String[] mobileBot = {
			"Mozilla/5.0 (iPhone; U; CPU iPhone OS 4_1 like Mac OS X; en-us) AppleWebKit/532.9 (KHTML, like Gecko) Version/4.0.5 Mobile/8B117 Safari/6531.22.7 (compatible; Googlebot-Mobile/2.1; +http://www.google.com/bot.html)",
			"DoCoMo/2.0 N905i(c100;TB;W24H16) (compatible; Googlebot-Mobile/2.1; +http://www.google.com/bot.html)"
	};
	
	String[] tools = {
			"curl/7.19.5 (i586-pc-mingw32msvc) libcurl/7.19.5 OpenSSL/0.9.8l zlib/1.2.3",
			"Wget/1.8.1",
			"Apache-HttpClient/release (java 1.5)"
	};
	
	String[] thunderbird3 = {
			"Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.2.12) Gecko/20101027 Thunderbird/3.1.6",
			"Mozilla/5.0 (Windows; U; Windows NT 6.1; sv-SE; rv:1.9.2.8) Gecko/20100802 Thunderbird/3.1.2 ThunderBrowse/3.3.2"
	};
	
	String[] thunderbird2 = {
			"Mozilla/5.0 (Windows; U; Windows NT 6.0; en-GB; rv:1.8.1.14) Gecko/20080421 Thunderbird/2.0.0.14",
			"Mozilla/5.0 (Macintosh; U; Intel Mac OS X; en-US; rv:1.8.1.17) Gecko/20080914 Thunderbird/2.0.0.17"
	};
	
	String[] silk = {
			"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_3; en-us; Silk/1.1.0-80) AppleWebKit/533.16 (KHTML, like Gecko) Version/5.0 Safari/533.16 Silk-Accelerated=true"
	};
	
	String[] iTunes = {
			"iTunes/10.2.2 (Windows; Microsoft Windows XP Home Edition Service Pack 3 (Build 2600)) AppleWebKit/533.21.1"
	};
	
	String[] appStore = {
			"MacAppStore/1.1.2 (Macintosh; U; Intel Mac OS X 10.7.3; en) AppleWebKit/534.53.11 "
	};
	
	String[] airApp = {
			"Mozilla/5.0 (Windows; U; cs-CZ) AppleWebKit/526.9+ (KHTML, like Gecko) AdobeAIR/1.5.1"
	};
	
	String[] blackberry10 = {
			"Mozilla/5.0 (BB10; Touch) AppleWebKit/537.1 (KHTML, like Gecko) Version/10.0.0.1337 Mobile Safari/537.1",
			"Mozilla/5.0 (BB10; Kbd) AppleWebKit/537.10+ (KHTML, like Gecko) Version/10.1.0.1485 Mobile Safari/537.10+"
	};
	
	// proxy server with fake browser reference
	String[] proxy = {
			"Mozilla/5.0 (Windows; U; Windows NT 5.1; de; rv:1.9.0.7) Gecko/2009021910 Firefox/3.0.7 (via ggpht.com)" // Gmail proxy server
	};
	
	/**
	 * Test method for {@link eu.bitwalker.useragentutils.Browser#isInUserAgentString(java.lang.String)}.
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
		testVersions("Mozilla/5.0 (Linux; U; Android-4.0.3; en-us; Xoom Build/IML77) AppleWebKit/535.7 (KHTML, like Gecko) CrMo/16.0.912.75 Safari/535.7", new Version("16.0.912.75", "16", "0"));
		testVersions("Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_3; en-us; Silk/1.1.0-80) AppleWebKit/533.16 (KHTML, like Gecko) Version/5.0 Safari/533.16 Silk-Accelerated=true", new Version("1.1.0-80", "1", "1"));
		testVersions("Mozilla/5.0 (iPhone; U; CPU iPhone OS 5_1_1 like Mac OS X; en) AppleWebKit/534.46.0 (KHTML, like Gecko) CriOS/19.0.1084.60 Mobile/9B206 Safari/7534.48.3", new Version("19.0.1084.60", "19", "0"));
		testVersions("Mozilla/5.0 (Linux; U; Android-4.0.3; en-us; Xoom Build/IML77) AppleWebKit/535.7 (KHTML, like Gecko) CrMo/16.0.912.75 Safari/535.7", new Version("16.0.912.75", "16", "0"));
		testVersions("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.52 Safari/537.36 OPR/15.0.1147.100", new Version("15.0.1147.100", "15", "0"));
		testVersions("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.57 Safari/537.36 OPR/16.0.1196.73", new Version("16.0.1196.73", "16", "0"));
		testVersions("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.65 Safari/537.36", new Version("29.0.1547.65", "29", "0"));
		testVersions("Mozilla/5.0 (Windows NT 6.3; WOW64; Trident/7.0; rv:11.0) like Gecko", new Version("11.0", "11", "0"));
		testVersions("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.1; Trident/7.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C)", new Version("7.0", "7", "0")); // issue #31
		testVersions("Mozilla/5.0 (Linux; Android 4.1.2; LT22i Build/6.2.A.1.100) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.59 Mobile Safari/537.36", new Version("31.0.1650.59", "31", "0"));
        testVersions("Windows-RSS-Platform/2.0 (IE 11.0; Windows NT 6.1)", new Version("11.0", "11", "0"));
	}

	private void testVersions(String ua, Version expectedVersion) {
		Version version = Browser.parseUserAgentString(ua).getVersion(ua);
		assertEquals(expectedVersion, version);
	}
	
	/**
	 * Test method for {@link eu.bitwalker.useragentutils.Browser#parseUserAgentString(java.lang.String)}.
	 */
	@Test
	public void testParseUserAgentString() {
		testAgents(ie55clients, Browser.IE5_5);
		testAgents(ie6clients, Browser.IE6);
		testAgents(ie7clients, Browser.IE7);
		testAgents(ie8clients, Browser.IE8);
		testAgents(ie9clients, Browser.IE9);
		testAgents(ie10clients, Browser.IE10);
		testAgents(ie11clients, Browser.IE11);
		testAgents(ieTooOld, Browser.IE);
		testAgents(outlook2007, Browser.OUTLOOK2007);
		testAgents(outlook2010, Browser.OUTLOOK2010);
		testAgents(outookExpress, Browser.OUTLOOK_EXPRESS7);
		testAgents(ieMobile6, Browser.IEMOBILE6);
		testAgents(ieMobile7, Browser.IEMOBILE7);
		testAgents(ieMobile9, Browser.IEMOBILE9);
		testAgents(ieMobile10, Browser.IEMOBILE10);
		testAgents(ieMobile11, Browser.IEMOBILE11);
        testAgents(ie7Rss, Browser.IE7);
        testAgents(ie8Rss, Browser.IE8);
        testAgents(ie9Rss, Browser.IE9);
        testAgents(ie10Rss, Browser.IE10);
		testAgents(ie11Rss, Browser.IE11);
		testAgents(lotusNotes, Browser.LOTUS_NOTES);
		testAgents(lynxClient, Browser.LYNX);
		testAgents(konqueror, Browser.KONQUEROR);
		testAgents(chromeMobile, Browser.CHROME_MOBILE);
		testAgents(chrome, Browser.CHROME);
		testAgents(chrome8, Browser.CHROME8);
		testAgents(chrome9, Browser.CHROME9);
		testAgents(chrome10, Browser.CHROME10);
		testAgents(chrome11, Browser.CHROME11);
		testAgents(chrome12, Browser.CHROME12);
		testAgents(chrome13, Browser.CHROME13);
		testAgents(chrome14, Browser.CHROME14);
		testAgents(chrome29, Browser.CHROME29);
		testAgents(chrome31, Browser.CHROME31);
		testAgents(chrome32, Browser.CHROME32);
		testAgents(chrome33, Browser.CHROME33);
		testAgents(firefox3, Browser.FIREFOX3);
		testAgents(firefox4, Browser.FIREFOX4);
		testAgents(firefox5, Browser.FIREFOX5);
		testAgents(firefox6, Browser.FIREFOX6);
		testAgents(firefox19, Browser.FIREFOX19);
		testAgents(firefox20, Browser.FIREFOX20);
		testAgents(firefox25, Browser.FIREFOX25);
		testAgents(firefox3mobile, Browser.FIREFOX3MOBILE);
		testAgents(firefoxMobile, Browser.FIREFOX_MOBILE);
		testAgents(firefoxMobile23, Browser.FIREFOX_MOBILE23);
		testAgents(safari, Browser.SAFARI);
		testAgents(dolfin, Browser.DOLFIN2);
		testAgents(safari6, Browser.SAFARI6);
		testAgents(safari5, Browser.SAFARI5);
		testAgents(safari4, Browser.SAFARI4);
		testAgents(mobileSafari, Browser.MOBILE_SAFARI);
		testAgents(appleMail, Browser.APPLE_WEB_KIT);
		testAgents(omniWeb, Browser.OMNIWEB);
		testAgents(operaMini, Browser.OPERA_MINI);
		testAgents(opera9, Browser.OPERA9);
		testAgents(opera, Browser.OPERA);
		testAgents(opera10, Browser.OPERA10);
		testAgents(opera11, Browser.OPERA11);
		testAgents(opera12, Browser.OPERA12);
		testAgents(opera15, Browser.OPERA15);
		testAgents(opera16, Browser.OPERA16);
		testAgents(opera17, Browser.OPERA17);
		testAgents(opera18, Browser.OPERA18);
		testAgents(opera19, Browser.OPERA19);
		testAgents(opera20, Browser.OPERA20);
		testAgents(camino2, Browser.CAMINO2);
		testAgents(camino, Browser.CAMINO);		
		testAgents(flock, Browser.FLOCK);
		testAgents(seaMonkey, Browser.SEAMONKEY);
		testAgents(bots, Browser.BOT);
		testAgents(mobileBot, Browser.BOT_MOBILE);
		testAgents(tools, Browser.DOWNLOAD);
		testAgents(proxy, Browser.DOWNLOAD);
		testAgents(thunderbird3, Browser.THUNDERBIRD3);
		testAgents(thunderbird2, Browser.THUNDERBIRD2);
		testAgents(silk, Browser.SILK);
		testAgents(iTunes, Browser.APPLE_ITUNES);
		testAgents(appStore, Browser.APPLE_APPSTORE);
		testAgents(airApp, Browser.ADOBE_AIR);
		testAgents(blackberry10, Browser.BLACKBERRY10);
	}
	
	@Test
	public void testCustomUserAgentParsing() {
		// Test limited to the big browser families. As Camino can not be detected any longer, the second best match is Firefox3 (a child of Firefox).
		for (String agentString : camino2) {
			assertEquals(Browser.FIREFOX3, Browser.parseUserAgentString(agentString,Arrays.asList(Browser.IE,Browser.CHROME, Browser.APPLE_WEB_KIT, Browser.FIREFOX)));
		}
		// When there is no match in the given set, return UNKNOWN
		for (String agentString : opera9) {
			assertEquals(Browser.UNKNOWN, Browser.parseUserAgentString(agentString,Arrays.asList(Browser.IE,Browser.CHROME, Browser.APPLE_WEB_KIT, Browser.FIREFOX)));
		}
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
