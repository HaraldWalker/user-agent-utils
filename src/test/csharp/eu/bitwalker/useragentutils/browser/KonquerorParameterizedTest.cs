using System;
using NUnit.Framework;

namespace  eu.bitwalker.useragentutils.browser {


public class KonquerorParameterizedTest :
		AbstractUserAgentParameterizedTest {
				// konqueror
				[TestCase(
						"Mozilla/5.0 (compatible; konqueror/3.3; linux 2.4.21-243-smp4G) (KHTML, like Geko)",
						"KONQUEROR", null, "LINUX" )]
				[TestCase(
						"Mozilla/6.0 (compatible; Konqueror/4.2; i686 FreeBSD 6.4; 20060308)",
						"KONQUEROR", "4.2", "UNKNOWN" )]
				[TestCase(
						"Mozilla/5.0 (compatible; Konqueror/3.1; Linux 2.4.21-20.0.1.ELsmp; X11; i686; , en_US, en, de)",
						"KONQUEROR", "3.1", "LINUX" )]
            [Test]
            public void testData(String userAgentValue,
                    string expectedBrowserStr, String expectedBrowserVersion,
                    string expectedOSStr)
            {
                shouldParseUserAgent(userAgentValue, Browser.valueOf(expectedBrowserStr), expectedBrowserVersion, OperatingSystem.valueOf(expectedOSStr));
            }
        }
}
