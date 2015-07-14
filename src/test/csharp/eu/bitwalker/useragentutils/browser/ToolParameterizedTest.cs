using System;
using NUnit.Framework;

namespace  eu.bitwalker.useragentutils.browser {


public class ToolParameterizedTest : AbstractUserAgentParameterizedTest {
				// tools
				[TestCase(
						"curl/7.19.5 (i586-pc-mingw32msvc) libcurl/7.19.5 OpenSSL/0.9.8l zlib/1.2.3",
						"DOWNLOAD", null, "UNKNOWN" )]
				[TestCase( "Wget/1.8.1", "DOWNLOAD", null, "UNKNOWN" )]
    [Test]
    public void testData(String userAgentValue,
            string expectedBrowserStr, String expectedBrowserVersion,
            string expectedOSStr)
    {
        shouldParseUserAgent(userAgentValue, Browser.valueOf(expectedBrowserStr), expectedBrowserVersion, OperatingSystem.valueOf(expectedOSStr));
    }
}
}
