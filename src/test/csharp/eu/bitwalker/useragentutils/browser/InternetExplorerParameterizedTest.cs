using System;
using NUnit.Framework;

namespace  eu.bitwalker.useragentutils.browser {


public class InternetExplorerParameterizedTest :
		AbstractUserAgentParameterizedTest {
				// Internet explorer 6.0
				[TestCase(
						"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; SV1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)",
						"IE6", "6.0", "WINDOWS_XP" )]
				[TestCase(
						"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0; T312461)",
						"IE6", "6.0", "WINDOWS_2000" )]
				[TestCase(
						"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 1.1.4322; XMPP Tiscali Communicator v.10.0.2; .NET CLR 2.0.50727)",
						"IE6", "6.0", "WINDOWS_XP" )]
				[TestCase(
						"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; SV1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)",
						"IE6", "6.0", "WINDOWS_XP" )]
				// Internet explorer 7
				[TestCase(
						"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; SV1; .NET CLR 2.0.50727)",
						"IE7", "7.0", "WINDOWS_XP" )]
				[TestCase(
						"Mozilla/4.0 (compatible; MSIE 7.0b; Windows NT 6.0 ; .NET CLR 2.0.50215; SL Commerce Client v1.0; Tablet PC 2.0",
						"IE7", "7.0b", "WINDOWS_VISTA" )]
				[TestCase(
						"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)",
						"IE7", "7.0", "WINDOWS_XP" )]
				[TestCase(
						"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; SLCC1; .NET CLR 2.0.50727; .NET CLR 3.0.04506)",
						"IE7", "7.0", "WINDOWS_VISTA" )]
				// Internet Explorer 8
				[TestCase(
						"Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0; WOW64; SLCC1; .NET CLR 2.0.50727; .NET CLR 3.0.04506; Media Center PC 5.0; .NET CLR 1.1.4322)",
						"IE8", "8.0", "WINDOWS_VISTA" )]
				[TestCase(
						"Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0; Win64; x64; .NET CLR 2.0.50727; SLCC1; Media Center PC 5.0; .NET CLR 3.0.04506)",
						"IE8", "8.0", "WINDOWS_VISTA" )]
				// Internet Explorer 9
				[TestCase(
						"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; Zune 4.0; InfoPath.3; MS-RTC LM 8; .NET4.0C; .NET4.0E)",
						"IE9", "9.0", "WINDOWS_7" )]
				[TestCase(
						"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0",
						"IE9", "9.0", "WINDOWS_7" )]
				// Internet Explorer 10
				[TestCase(
						"Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; Trident/6.0)",
						"IE10", "10.0", "WINDOWS_7" )]
				[TestCase(
						"Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Trident/6.0)",
						"IE10", "10.0", "WINDOWS_8" )]
				// Internet Explorer 11
				[TestCase(
						"Mozilla/5.0 (Windows NT 6.3; WOW64; Trident/7.0; rv:11.0) like Gecko",
						"IE11", "11.0", "WINDOWS_81" )]
				// Internet Explorer 5
				[TestCase(
						"Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0; .NET CLR 1.1.4322)",
						"IE5_5", "5.5", "WINDOWS_2000" )]
				[TestCase( "Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0)",
						"IE5_5", "5.5", "WINDOWS_2000" )]
				[TestCase( "Mozilla/4.0 (compatible; MSIE 5.5; Windows 95)",
						"IE5_5", "5.5", "WINDOWS" )]
				// IE old
				[TestCase( "Mozilla/4.0 (compatible; MSIE 4.01; Windows 95)",
						"IE", "4.01", "WINDOWS" )]
				[TestCase(
						"Mozilla/4.0 (compatible; MSIE 4.0; Windows 95; .NET CLR 1.1.4322; .NET CLR 2.0.50727)",
						"IE", "4.0", "WINDOWS" )]
				[TestCase( "Mozilla/2.0 (compatible; MSIE 3.03; Windows 3.1)",
						"IE", "3.03", "WINDOWS" )]
            [Test]
            public void testData(String userAgentValue,
                    string expectedBrowserStr, String expectedBrowserVersion,
                    string expectedOSStr)
            {
                shouldParseUserAgent(userAgentValue, Browser.valueOf(expectedBrowserStr), expectedBrowserVersion, OperatingSystem.valueOf(expectedOSStr));
            }
        }

}
