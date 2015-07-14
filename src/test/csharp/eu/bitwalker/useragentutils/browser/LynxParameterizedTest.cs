using System;
using NUnit.Framework;

namespace  eu.bitwalker.useragentutils.browser {


public class LynxParameterizedTest : AbstractUserAgentParameterizedTest {
				// lynxClient
				[TestCase( "Lynx/2.8.5rel.1 libwww-FM/2.14 SSL-MM/1.4.1 OpenSSL/0.9.7d",
						"LYNX", "2.8.5rel.1", "UNKNOWN" )]
				[TestCase( "Lynx/2.7.1ac-0.102+intl+csuite libwww-FM/2.14",
						"LYNX", "2.7.1ac-0.102+intl+csuite", "UNKNOWN" )]
    [Test]
    public void testData(String userAgentValue,
            string expectedBrowserStr, String expectedBrowserVersion,
            string expectedOSStr)
    {
        shouldParseUserAgent(userAgentValue, Browser.valueOf(expectedBrowserStr), expectedBrowserVersion, OperatingSystem.valueOf(expectedOSStr));
    }
}
}
