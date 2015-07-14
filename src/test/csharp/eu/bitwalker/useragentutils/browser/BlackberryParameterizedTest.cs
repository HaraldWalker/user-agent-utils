using System;
using System.Collections.Generic;
using NUnit.Framework;

namespace  eu.bitwalker.useragentutils.browser {

    public class BlackberryParameterizedTest :
		    AbstractUserAgentParameterizedTest {
	
				        // blackberry10
				        [TestCase(
						        "Mozilla/5.0 (BB10; Touch) AppleWebKit/537.1 (KHTML, like Gecko) Version/10.0.0.1337 Mobile Safari/537.1",
						        "BLACKBERRY10", "10.0.0", "UNKNOWN_MOBILE" )]
				        [TestCase(
						        "Mozilla/5.0 (BB10; Kbd) AppleWebKit/537.10+ (KHTML, like Gecko) Version/10.1.0.1485 Mobile Safari/537.10+",
						        "BLACKBERRY10", "10.1.0", "UNKNOWN_MOBILE" )]
        [Test]
    public void testData(String userAgentValue,
            string expectedBrowserStr, String expectedBrowserVersion,
            string expectedOSStr)
    {
        shouldParseUserAgent(userAgentValue,Browser.valueOf(expectedBrowserStr), expectedBrowserVersion, OperatingSystem.valueOf(expectedOSStr));
	}
	}
}
