using System;
using NUnit.Framework;

namespace  eu.bitwalker.useragentutils.browser {


public class OthersParameterizedTest : AbstractUserAgentParameterizedTest {

				// dolfin
				[TestCase(
						"Mozilla/5.0 (SAMSUNG; SAMSUNG-GT-S8500/S8500NEJE5; U; Bada/1.0; fr-fr) AppleWebKit/533.1 (KHTML, like Gecko) Dolfin/2.0 Mobile WVGA SMM-MMS/1.2.0 NexPlayer/3.0 profile/MIDP-2.1 configuration/CLDC-1.1 OPN-B",
						"DOLFIN2", null, "BADA" )]
				// appleMail
				[TestCase(
						"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_4; en-us) AppleWebKit/533.18.1 (KHTML, like Gecko)",
						"APPLE_WEB_KIT", null, "MAC_OS_X" )]
				// omniWeb
				[TestCase(
						"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_5_8; en-US) AppleWebKit/531.9+(KHTML, like Gecko, Safari/528.16) OmniWeb/v622.10.0",
						"OMNIWEB", null, "MAC_OS_X" )]
				[TestCase(
						"Mozilla/5.0 (Macintosh; U; Intel Mac OS X; en-US) AppleWebKit/525.18 (KHTML, like Gecko, Safari/525.20) OmniWeb/v622.3.0.105198",
						"OMNIWEB", null, "MAC_OS_X" )]

				// flock
				[TestCase(
						"Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.3) Gecko/2008100716 Firefox/3.0.3 Flock/2.0",
						"FLOCK", "2.0", "LINUX" )]
				// seaMonkey
				[TestCase(
						"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.1.13) Gecko/20100914 Mnenhy/0.8.3 SeaMonkey/2.0.8",
						"SEAMONKEY", "2.0.8", "WINDOWS_XP" )]

				// silk
				[TestCase(
						"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_3; en-us; Silk/1.1.0-80) AppleWebKit/533.16 (KHTML, like Gecko) Version/5.0 Safari/533.16 Silk-Accelerated=true",
						"SILK", "1.1.0-80", "MAC_OS_X" )]
				// iTunes
				[TestCase(
						"iTunes/10.2.2 (Windows; Microsoft Windows XP Home Edition Service Pack 3 (Build 2600)) AppleWebKit/533.21.1",
						"APPLE_ITUNES", null, "WINDOWS" )]
				// appStore
				[TestCase(
						"MacAppStore/1.1.2 (Macintosh; U; Intel Mac OS X 10.7.3; en) AppleWebKit/534.53.11 ",
						"APPLE_APPSTORE", null, "MAC_OS_X" )]
				// airApp
				[TestCase(
						"Mozilla/5.0 (Windows; U; cs-CZ) AppleWebKit/526.9+ (KHTML, like Gecko) AdobeAIR/1.5.1",
						"ADOBE_AIR", null, "WINDOWS" )]
				// vivaldi
				[TestCase(
						"Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.89 Vivaldi/1.0.83.38 Safari/537.36",
						"VIVALDI", "1.0.83.38", "WINDOWS_8" )]
				[TestCase(
						"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.114 Safari/537.36 Vivaldi/1.0.111.2",
						"VIVALDI", "1.0.111.2", "MAC_OS_X" )]
				[TestCase(
						"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.114 Safari/537.36 Vivaldi/1.0.111.2",
						"VIVALDI", "1.0.111.2", "WINDOWS_7" )]
    [Test]
    public void testData(String userAgentValue,
            string expectedBrowserStr, String expectedBrowserVersion,
            string expectedOSStr)
    {
        shouldParseUserAgent(userAgentValue, Browser.valueOf(expectedBrowserStr), expectedBrowserVersion, OperatingSystem.valueOf(expectedOSStr));
    }
}
}
