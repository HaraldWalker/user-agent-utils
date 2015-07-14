using System;
using NUnit.Framework;

namespace  eu.bitwalker.useragentutils.browser {


public class OperaParameterizedTest : AbstractUserAgentParameterizedTest {
				// opera
				[TestCase( "Opera/8.0 (Macintosh; PPC Mac OS X; U; en)", 
						"OPERA", "8.0", "MAC_OS_X" )]
				// opera9
				[TestCase( "Opera/9.52 (Windows NT 5.1; U; en)", 
						"OPERA9", "9.52", "WINDOWS_XP" )]
				[TestCase( "Opera/9.20 (Macintosh; Intel Mac OS X; U; en)",
						"OPERA9", "9.20", "MAC_OS_X" )]
				// opera10
				[TestCase(
						"Opera/9.80 (Windows NT 5.2; U; en) Presto/2.2.15 Version/10.10",
						"OPERA10", "10.10", "WINDOWS_XP" )]
				[TestCase(
						"Opera/9.80 (Macintosh; Intel Mac OS X; U; en) Presto/2.6.30 Version/10.61",
						"OPERA10", "10.61", "MAC_OS_X" )]
				// opera11
				[TestCase(
						"Opera/9.80 (Windows NT 6.1; WOW64; U; pt) Presto/2.10.229 Version/11.62",
						"OPERA11", "11.62", "WINDOWS_7" )]
				[TestCase(
						"Opera/9.80 (Windows NT 6.0; U; pl) Presto/2.10.229 Version/11.62",
						"OPERA11", "11.62", "WINDOWS_VISTA" )]
				// opera12
				[TestCase(
						"Opera/9.80 (Windows NT 6.1; U; es-ES) Presto/2.9.181 Version/12.00",
						"OPERA12", "12.00", "WINDOWS_7" )]
				[TestCase(
						"Opera/12.0(Windows NT 5.1;U;en)Presto/22.9.168 Version/12.00",
						"OPERA12", "12.00", "WINDOWS_XP" )]
				// opera15
				[TestCase(
						"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.52 Safari/537.36 OPR/15.0.1147.100",
						"OPERA15", "15.0.1147.100", "WINDOWS_7" )]
				// opera16
				[TestCase(
						"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.57 Safari/537.36 OPR/16.0.1196.73",
						"OPERA16", "16.0.1196.73", "MAC_OS_X" )]
				// operaMini
				[TestCase(
						"Opera/9.60 (J2ME/MIDP; Opera Mini/4.2.13337/458; U; en) Presto/2.2.0",
						"OPERA_MINI", "9.60", "UNKNOWN" )]
				[TestCase(
						"Opera/9.80 (J2ME/MIDP; Opera Mini/5.0.16823/1428; U; en) Presto/2.2.0",
						"OPERA_MINI", "9.80", "UNKNOWN" )]
				[TestCase(
						"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.115 Safari/537.36 OPR/27.0.1689.76",
						"OPERA27", "27.0.1689.76", "WINDOWS_7" )]
				// Issue #86
				[TestCase(
						"Mozilla/5.0 (Linux; Android 4.1.2; HTC One SV Build/JZO54K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.81 Mobile Safari/537.36 OPR/28.0.1764.90386",
						"OPERA_MOBILE", "28.0.1764.90386", "ANDROID4" )]

    [Test]
    public void testData(String userAgentValue,
            string expectedBrowserStr, String expectedBrowserVersion,
            string expectedOSStr)
    {
        shouldParseUserAgent(userAgentValue, Browser.valueOf(expectedBrowserStr), expectedBrowserVersion, OperatingSystem.valueOf(expectedOSStr));
    }
}
}
