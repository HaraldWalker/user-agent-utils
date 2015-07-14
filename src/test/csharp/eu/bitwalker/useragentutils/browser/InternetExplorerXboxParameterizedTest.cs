using System;
using NUnit.Framework;

namespace  eu.bitwalker.useragentutils.browser {


public class InternetExplorerXboxParameterizedTest : AbstractUserAgentParameterizedTest {

				[TestCase(
						"Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Trident/6.0; Xbox; Xbox One)",
						"IE_XBOX", "10.0", "XBOX_OS" )]
				[TestCase(
						"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; Xbox)",
						"IE_XBOX", "9.0", "XBOX_OS" )]
    [Test]
    public void testData(String userAgentValue,
            string expectedBrowserStr, String expectedBrowserVersion,
            string expectedOSStr)
    {
        shouldParseUserAgent(userAgentValue, Browser.valueOf(expectedBrowserStr), expectedBrowserVersion, OperatingSystem.valueOf(expectedOSStr));
    }
}
}
