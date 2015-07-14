using System;
using NUnit.Framework;

namespace  eu.bitwalker.useragentutils.browser {


public class ThunderbirdParameterizedTest :
		AbstractUserAgentParameterizedTest {
				// thunderbird3
				[TestCase(
						"Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.2.12) Gecko/20101027 Thunderbird/3.1.6",
						"THUNDERBIRD3", "3.1.6", "LINUX" )]
				[TestCase(
						"Mozilla/5.0 (Windows; U; Windows NT 6.1; sv-SE; rv:1.9.2.8) Gecko/20100802 Thunderbird/3.1.2 ThunderBrowse/3.3.2",
						"THUNDERBIRD3", "3.1.2", "WINDOWS_7" )]
				// thunderbird2
				[TestCase(
						"Mozilla/5.0 (Windows; U; Windows NT 6.0; en-GB; rv:1.8.1.14) Gecko/20080421 Thunderbird/2.0.0.14",
						"THUNDERBIRD2", "2.0.0.14", "WINDOWS_VISTA" )]
				[TestCase(
						"Mozilla/5.0 (Macintosh; U; Intel Mac OS X; en-US; rv:1.8.1.17) Gecko/20080914 Thunderbird/2.0.0.17",
						"THUNDERBIRD2", "2.0.0.17", "MAC_OS_X" )]
            [Test]
            public void testData(String userAgentValue,
                    string expectedBrowserStr, String expectedBrowserVersion,
                    string expectedOSStr)
            {
                shouldParseUserAgent(userAgentValue, Browser.valueOf(expectedBrowserStr), expectedBrowserVersion, OperatingSystem.valueOf(expectedOSStr));
            }
        }
}
