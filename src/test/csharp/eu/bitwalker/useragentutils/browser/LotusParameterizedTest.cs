using System;
using NUnit.Framework;

namespace  eu.bitwalker.useragentutils.browser {


public class LotusParameterizedTest : AbstractUserAgentParameterizedTest {
				// lotusNotes
				[TestCase( "Mozilla/4.0 (compatible; Lotus-Notes/5.0; Windows-NT)",
						"LOTUS_NOTES", "5.0", "WINDOWS" )]
				[TestCase( "Mozilla/4.0 (compatible; Lotus-Notes/6.0; Windows-NT)",
						"LOTUS_NOTES", "6.0", "WINDOWS" )]
    [Test]
    public void testData(String userAgentValue,
            string expectedBrowserStr, String expectedBrowserVersion,
            string expectedOSStr)
    {
        shouldParseUserAgent(userAgentValue, Browser.valueOf(expectedBrowserStr), expectedBrowserVersion, OperatingSystem.valueOf(expectedOSStr));
    }
}
}
