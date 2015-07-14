using System;
using NUnit.Framework;

namespace  eu.bitwalker.useragentutils.browser {


public class InternetExplorerMobileParameterizedTest :
		AbstractUserAgentParameterizedTest {
				// ieMobile6
				[TestCase(
						"HTC_TyTN Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 6.12)",
						"IEMOBILE6", "6.0", "WINDOWS_MOBILE" )]
				[TestCase(
						"Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 6.12) Vodafone/1.0/HTC_s710/1.22.172.3",
						"IEMOBILE6", "6.0", "WINDOWS_MOBILE" )]
				[TestCase(
						"Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 6.8) PPC; 240x320; HTC_TyTN/1.0 Profile/MIDP-2.0 Configuration/CLDC-1.1",
						"IEMOBILE6", "6.0", "WINDOWS_MOBILE" )]
				// ieMobile7
				[TestCase(
						"HTC_TouchDual Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 7.6)",
						"IEMOBILE7", "6.0", "WINDOWS_MOBILE" )]
				[TestCase(
						"PPC; 240x320; HTC_P3450/1.0 Profile/MIDP-2.0 Configuration/CLDC-1.1 Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 7.6)",
						"IEMOBILE7", "6.0", "WINDOWS_MOBILE" )]
				[TestCase(
						"Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 7.6) PPC; MDA Vario/3.0 Profile/MIDP-2.0 Configuration/CLDC-1.1",
						"IEMOBILE7", "6.0", "WINDOWS_MOBILE" )]
				[TestCase(
						"Palm750/v0005 Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 7.6) UP.Link/6.3.0.0.0",
						"IEMOBILE7", "6.0", "WINDOWS_MOBILE" )]
				// ieMobile9
				[TestCase(
						"Mozilla/5.0 (compatible; MSIE 9.0; Windows Phone OS 7.5; Trident/5.0; IEMobile/9.0)",
						"IEMOBILE9", "9.0", "WINDOWS_MOBILE7" )]
            [Test]
            public void testData(String userAgentValue,
                    string expectedBrowserStr, String expectedBrowserVersion,
                    string expectedOSStr)
            {
                shouldParseUserAgent(userAgentValue, Browser.valueOf(expectedBrowserStr), expectedBrowserVersion, OperatingSystem.valueOf(expectedOSStr));
            }
        }

}
