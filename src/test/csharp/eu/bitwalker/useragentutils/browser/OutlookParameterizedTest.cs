using System;
using NUnit.Framework;

namespace  eu.bitwalker.useragentutils.browser {


public class OutlookParameterizedTest :
		AbstractUserAgentParameterizedTest {
				// outlook2007
				[TestCase(
						"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; SLCC1; .NET CLR 2.0.50727; .NET CLR 3.0.04506; .NET CLR 1.1.4322; MSOffice 12)",
						"OUTLOOK2007", "12", "WINDOWS_VISTA" )]
				// outlook2010
				[TestCase(
						"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; Trident/4.0; GTB6.4; Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1) ; SLCC1; .NET CLR 2.0.50727; Media Center PC 5.0; .NET CLR 1.1.4322; .NET CLR 3.5.30729; .NET CLR 3.0.30729; OfficeLiveConnector.1.3; OfficeLivePatch.0.0; MSOffice 14)",
						"OUTLOOK2010", "14", "WINDOWS_VISTA" )]
				[TestCase(
						"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.1; Trident/4.0; .NET CLR 2.0.50727; .NET CLR 3.0.30729; .NET CLR 3.5.30729; Media Center PC 6.0; SLCC2; ms-office; MSOffice 14)",
						"OUTLOOK2010", "14", "WINDOWS_7" )]
				[TestCase(
						"Outlook-Express/7.0 (MSIE 6.0; Windows NT 5.1; SV1; SIMBAR={xxx}; .NET CLR 2.0.50727; .NET CLR 1.1.4322; TmstmpExt)",
						"OUTLOOK_EXPRESS7", "6.0", "WINDOWS_XP" )]
				[TestCase(
						"Outlook-Express/7.0 (MSIE 7.0; Windows NT 5.1; InfoPath.2; .NET CLR 1.1.4322; .NET CLR 2.0.50727; TmstmpExt)",
						"OUTLOOK_EXPRESS7", "7.0", "WINDOWS_XP" )]
            [Test]
            public void testData(String userAgentValue,
                    string expectedBrowserStr, String expectedBrowserVersion,
                    string expectedOSStr)
            {
                shouldParseUserAgent(userAgentValue, Browser.valueOf(expectedBrowserStr), expectedBrowserVersion, OperatingSystem.valueOf(expectedOSStr));
            }
        }
}
