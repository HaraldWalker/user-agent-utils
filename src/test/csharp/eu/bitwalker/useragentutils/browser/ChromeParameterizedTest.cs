using System;
using NUnit.Framework;

namespace  eu.bitwalker.useragentutils.browser {


public class ChromeParameterizedTest : AbstractUserAgentParameterizedTest {

                // chrome
				[TestCase(
						"Mozilla/5.0 (Windows; U; Windows NT 5.2; en-US) AppleWebKit/532.9 (KHTML, like Gecko) Chrome/5.0.310.0 Safari/532.9",
						"CHROME", "5.0.310.0", "WINDOWS_XP" )]
				[TestCase(
						"Mozilla/5.0 (X11; U; Linux x86_64; en-US) AppleWebKit/532.9 (KHTML, like Gecko) Chrome/5.0.309.0 Safari/532.9",
						"CHROME", "5.0.309.0", "LINUX" )]
				// chrome8
				[TestCase(
						"Mozilla/5.0 (Windows; U; Windows NT 5.2; en-US) AppleWebKit/534.10 (KHTML, like Gecko) Chrome/8.0.558.0 Safari/534.10",
						"CHROME8", "8.0.558.0", "WINDOWS_XP" )]
				[TestCase(
						"Mozilla/5.0 (X11; U; Linux x86_64; en-US) AppleWebKit/540.0 (KHTML, like Gecko) Ubuntu/10.10 Chrome/8.1.0.0 Safari/540.0",
						"CHROME8", "8.1.0.0", "LINUX" )]
				// chrome9

				[TestCase(
						"Mozilla/5.0 (X11; U; Linux x86_64; en-US) AppleWebKit/540.0 (KHTML,like Gecko) Chrome/9.1.0.0 Safari/540.0",
						"CHROME9", "9.1.0.0", "LINUX" )]
				[TestCase(
						"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) AppleWebKit/534.14 (KHTML, like Gecko) Chrome/9.0.600.0 Safari/534.14",
						"CHROME9", "9.0.600.0", "WINDOWS_XP" )]
				// chrome10
				[TestCase(
						"Mozilla/5.0 (X11; U; Linux i686; en-US) AppleWebKit/534.15 (KHTML, like Gecko) Ubuntu/10.10 Chromium/10.0.613.0 Chrome/10.0.613.0 Safari/534.15",
						"CHROME10", "10.0.613.0", "LINUX" )]
				// chrome11
				[TestCase(
						"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/11.0.697.0 Safari/534.24",
						"CHROME11", "11.0.697.0", "WINDOWS_7" )]
				// chrome12
				[TestCase(
						"Mozilla/5.0 (X11; CrOS i686 12.0.742.91) AppleWebKit/534.30 (KHTML, like Gecko) Chrome/12.0.742.93 Safari/534.30",
						"CHROME12", "12.0.742.93", "CHROME_OS" )]
				// chrome13
				[TestCase(
						"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_6_7) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.41 Safari/535.1",
						"CHROME13", "13.0.782.41", "MAC_OS_X" )]
				// chrome14
				[TestCase(
						"Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/14.0.815.0 Safari/535.1",
						"CHROME14", "14.0.815.0", "WINDOWS_XP" )]
				// chrome29
				[TestCase(
						"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.65 Safari/537.36",
						"CHROME29", "29.0.1547.65", "MAC_OS_X" )]
				[TestCase(
							"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.124 Safari/537.36",
						"CHROME43", "43.0.2357.124", "MAC_OS_X" )]
    [Test]
    public void testData(String userAgentValue,
            string expectedBrowserStr, String expectedBrowserVersion,
            string expectedOSStr)
    {
        shouldParseUserAgent(userAgentValue, Browser.valueOf(expectedBrowserStr), expectedBrowserVersion, OperatingSystem.valueOf(expectedOSStr));
    }
}
}
