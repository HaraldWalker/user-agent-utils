using System;
using NUnit.Framework;

namespace  eu.bitwalker.useragentutils.browser {


public class ChromeMobileParameterizedTest :
		AbstractUserAgentParameterizedTest {

    // chromeMobile
				[TestCase(
						"Mozilla/5.0 (Linux; U; Android-4.0.3; en-us; Xoom Build/IML77) AppleWebKit/535.7 (KHTML, like Gecko) CrMo/16.0.912.75 Safari/535.7",
						"CHROME_MOBILE", "16.0.912.75", "ANDROID4_TABLET" )]
				[TestCase(
						"Mozilla/5.0 (Linux; U; Android-4.0.3; en-us; Galaxy Nexus Build/IML74K) AppleWebKit/535.7 (KHTML, like Gecko) CrMo/16.0.912.75 Mobile Safari/535.7",
						"CHROME_MOBILE", "16.0.912.75", "ANDROID4" )]
				[TestCase(
						"Mozilla/5.0 (iPhone; U; CPU iPhone OS 5_1_1 like Mac OS X; en) AppleWebKit/534.46.0 (KHTML, like Gecko) CriOS/19.0.1084.60 Mobile/9B206 Safari/7534.48.3",
						"CHROME_MOBILE", "19.0.1084.60", "iOS5_IPHONE" )]
            [Test]
            public void testData(String userAgentValue,
                    string expectedBrowserStr, String expectedBrowserVersion,
                    string expectedOSStr)
            {
                shouldParseUserAgent(userAgentValue, Browser.valueOf(expectedBrowserStr), expectedBrowserVersion, OperatingSystem.valueOf(expectedOSStr));
            }
        }
}
