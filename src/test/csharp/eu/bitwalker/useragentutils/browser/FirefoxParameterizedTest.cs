using System;
using NUnit.Framework;

namespace  eu.bitwalker.useragentutils.browser {


public class FirefoxParameterizedTest :
		AbstractUserAgentParameterizedTest {
				// firefox3
				[TestCase(
						"Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.14) Gecko/2009090216 Ubuntu/9.04 (jaunty) Firefox/3.0.14",
						"FIREFOX3", "3.0.14", "LINUX" )]
				// firefox4
				[TestCase(
						"Mozilla/5.0 (X11; Linux x86_64; rv:2.0b4) Gecko/20100818 Firefox/4.0b4",
						"FIREFOX4", "4.0b4", "LINUX" )]
				[TestCase(
						"Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:2.0b9pre) Gecko/20101228 Firefox/4.0b9pre",
						"FIREFOX4", "4.0b9pre", "WINDOWS_7" )]
				// firefox5
				[TestCase(
						"Mozilla/5.0 (Windows NT 6.1; U; ru; rv:5.0.1.6) Gecko/20110501 Firefox/5.0.1 Firefox/5.0.1",
						"FIREFOX5", "5.0.1", "WINDOWS_7" )]
				[TestCase(
						"Mozilla/5.0 (X11; U; Linux i586; de; rv:5.0) Gecko/20100101 Firefox/5.0",
						"FIREFOX5", "5.0", "LINUX" )]
				// firefox6
				[TestCase(
						"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:6.0a2) Gecko/20110612 Firefox/6.0a2",
						"FIREFOX6", "6.0a2", "WINDOWS_7" )]
				// firefox19
				[TestCase(
						"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:19.0) Gecko/20100101 Firefox/19.0",
						"FIREFOX19", "19.0", "MAC_OS_X" )]
				// firefox20
				[TestCase(
						"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:20.0) Gecko/20100101 Firefox/20.0",
						"FIREFOX20", "20.0", "MAC_OS_X" )]
				// firefox25
				[TestCase(
						"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.6; rv:25.0) Gecko/20100101 Firefox/25.0",
						"FIREFOX25", "25.0", "MAC_OS_X" )]
				// firefox3mobile
				[TestCase(
						"Mozilla/5.0 (X11; U; Linux armv7l; en-US; rv:1.9.2a1pre) Gecko/20091127 Firefox/3.5 Maemo Browser 1.5.6 RX-51 N900",
						"FIREFOX3MOBILE", "3.5", "MAEMO" )]
				// firefoxMobile
				[TestCase(
						"Mozilla/5.0 (Android; Mobile; rv:13.0) Gecko/13.0 Firefox/13.0",
						"FIREFOX_MOBILE", "13.0", "ANDROID_MOBILE" )]
				// firefoxMobile23
				[TestCase(
						"Mozilla/5.0 (Android; Mobile; rv:23.0) Gecko/23.0 Firefox/23.0",
						"FIREFOX_MOBILE23", "23.0", "ANDROID_MOBILE" )]
            [Test]
            public void testData(String userAgentValue,
                    string expectedBrowserStr, String expectedBrowserVersion,
                    string expectedOSStr)
            {
                shouldParseUserAgent(userAgentValue, Browser.valueOf(expectedBrowserStr), expectedBrowserVersion, OperatingSystem.valueOf(expectedOSStr));
            }
        }
}
