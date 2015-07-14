using System;
using NUnit.Framework;

namespace  eu.bitwalker.useragentutils.browser {


public class CFNetworkParameterizedTest :
		AbstractUserAgentParameterizedTest {
	
				// CFNetworks
                [TestCase(
                    "MobileSafari/9537.53 CFNetwork/672.0.8 Darwin/14.0.0",
						"CFNETWORK", "672.0.8", "MAC_OS_X" )]
				[TestCase(
                    "MobileSafari/9537.53 CFNetwork/128 Darwin/14.0.0",
						"CFNETWORK", "128", "MAC_OS_X" )]
				[TestCase(
                    "MobileSafari/9537.53 CFNetwork/129.9 Darwin/14.0.0",
						"CFNETWORK", "129.9", "MAC_OS_X" )]
            [Test]
            public void testData(String userAgentValue,
                    string expectedBrowserStr, String expectedBrowserVersion,
                    string expectedOSStr)
            {
                shouldParseUserAgent(userAgentValue, Browser.valueOf(expectedBrowserStr), expectedBrowserVersion, OperatingSystem.valueOf(expectedOSStr));
            }
        }
}
