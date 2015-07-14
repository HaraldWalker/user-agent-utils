using System;
using NUnit.Framework;

namespace  eu.bitwalker.useragentutils.browser {


public class SafariParameterizedTest : AbstractUserAgentParameterizedTest {
				// safari
				[TestCase(
						"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_5_7; en-us) AppleWebKit/525.28.3 (KHTML, like Gecko) Version/3.2.3 Safari/525.28.3",
						"SAFARI", "3.2.3", "MAC_OS_X" )]
				[TestCase(
						"Mozilla/5.0 (Macintosh; U; Intel Mac OS X; en-gb) AppleWebKit/523.10.6 (KHTML, like Gecko) Version/3.0.4 Safari/523.10.6",
						"SAFARI", "3.0.4", "MAC_OS_X" )]
				// safari6
				[TestCase(
						"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_3) AppleWebKit/536.28.10 (KHTML, like Gecko) Version/6.0.3 Safari/536.28.10",
						"SAFARI6", "6.0.3", "MAC_OS_X" )]
				// safari5
				[TestCase(
						"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_4; en-us) AppleWebKit/533.16 (KHTML, like Gecko) Version/5.0 Safari/533.16",
						"SAFARI5", "5.0", "MAC_OS_X" )]
				[TestCase(
						"Mozilla/5.0 (Windows; U; Windows NT 6.1; ja-JP) AppleWebKit/533.16 (KHTML, like Gecko) Version/5.0 Safari/533.16",
						"SAFARI5", "5.0", "WINDOWS_7" )]
				[TestCase(
						"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_5; en-us) AppleWebKit/533.19.4 (KHTML, like Gecko) Version/5.0.3 Safari/533.19.4",
						"SAFARI5", "5.0.3", "MAC_OS_X" )]
				[TestCase(
						"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_7; da-dk) AppleWebKit/533.21.1 (KHTML, like Gecko) Version/5.0.5 Safari/533.21.1",
						"SAFARI5", "5.0.5", "MAC_OS_X" )]
				// safari4
				[TestCase(
						"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_2; en-us) AppleWebKit/531.21.8 (KHTML, like Gecko) Version/4.0.4 Safari/531.21.10",
						"SAFARI4", "4.0.4", "MAC_OS_X" )]
				[TestCase(
						"Mozilla/5.0 (Windows; U; Windows NT 6.1; es-ES) AppleWebKit/531.22.7 (KHTML, like Gecko) Version/4.0.5 Safari/531.22.7",
						"SAFARI4", "4.0.5", "WINDOWS_7" )]
				[TestCase(
						"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_5_7; en-us) AppleWebKit/531.2+ (KHTML, like Gecko) Version/4.0.1 Safari/530.18",
						"SAFARI4", "4.0.1", "MAC_OS_X" )]
				// mobileSafari
				[TestCase(
						"Mozilla/5.0 (Linux; U; Android 2.1; en-us; Nexus One Build/ERD62) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Mobile Safari/530.17",
						"MOBILE_SAFARI", "4.0", "ANDROID2" )]
				[TestCase(
						"Mozilla/5.0 (iPod; U; CPU iPhone OS 2_0 like Mac OS X; de-de) AppleWebKit/525.18.1 (KHTML, like Gecko) Version/3.1.1 Mobile/5A347 Safari/525.20",
						"MOBILE_SAFARI", "3.1.1", "MAC_OS_X_IPHONE" )]
				[TestCase(
						"Mozilla/5.0 (iPod; U; CPU like Mac OS X; en) AppleWebKit/420.1 (KHTML, like Gecko) Version/3.0 Mobile/3A101a Safari/419.3",
						"MOBILE_SAFARI", "3.0", "MAC_OS_X_IPOD" )]
				[TestCase(
						"Mozilla/5.0 (iPad; U; CPU OS 3_2 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Version/4.0.4 Mobile/7B367 Safari/531.21.10",
						"MOBILE_SAFARI", "4.0.4", "MAC_OS_X_IPAD" )]
				[TestCase(
						"Mozilla/5.0 (iPod; U; CPU iPhone OS 4_1 like Mac OS X; en-us) AppleWebKit/532.9 (KHTML, like Gecko) Version/4.0.5 Mobile/8B117 Safari/6531.22.7",
						"MOBILE_SAFARI", "4.0.5", "iOS4_IPHONE" )]
				[TestCase(
						"Mozilla/5.0 (iPhone; CPU iPhone OS 5_0 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9A334 Safari/7534.48.3",
						"MOBILE_SAFARI", "5.1", "iOS5_IPHONE" )]
				[TestCase(
						"Mozilla/5.0 (iPhone; CPU iPhone OS 5_1_1 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9B206 Safari/7534.48.3",
						"MOBILE_SAFARI", "5.1", "iOS5_IPHONE" )]
    [Test]
    public void testData(String userAgentValue,
            string expectedBrowserStr, String expectedBrowserVersion,
            string expectedOSStr)
    {
        shouldParseUserAgent(userAgentValue, Browser.valueOf(expectedBrowserStr), expectedBrowserVersion, OperatingSystem.valueOf(expectedOSStr));
    }
}
}
