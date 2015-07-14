using System;
using System.Collections.Generic;
using NUnit.Framework;

namespace  eu.bitwalker.useragentutils.browser {


    public class BotParameterizedTest : AbstractUserAgentParameterizedTest {

	    [Test]
				    // bots
				    [TestCase("Mozilla/5.0 (compatible; Googlebot/2.1; http://www.google.com/bot.html)",
						    "BOT", null, "UNKNOWN" )]
				    [TestCase(
						    "Mozilla/5.0 (compatible; Yahoo! Slurp; http://help.yahoo.com/help/us/ysearch/slurp)",
						    "BOT", null, "UNKNOWN" )]
				    [TestCase( 		"Googlebot-Image/1.0", 
						    "BOT", null, "UNKNOWN" )]
				    [TestCase(
						    "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/536.8 (KHTML, like Gecko; Google Web Preview) Chrome/19.0.1084.36 Safari/536.8",
						    "BOT", null, "UNKNOWN" )]
				    [TestCase(
						    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/600.2.5 (KHTML, like Gecko) Version/8.0.2 Safari/600.2.5 (Applebot/0.1)",
						    "BOT", null, "UNKNOWN" )]
				    [TestCase(
                        "Mediapartners-Google", 
						    "BOT", null, "UNKNOWN" )]
				    [TestCase(
						    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/534+ (KHTML, like Gecko) BingPreview/1.0b",
						    "BOT", null, "UNKNOWN" )]
				    [TestCase(
						    "Mozilla/5.0 (Windows NT 6.3; WOW64; Trident/7.0; rv:11.0; BingPreview/1.0b) like Gecko",
						    "BOT", null, "UNKNOWN" )]
				    [TestCase(
						    "Mozilla/5.0 (iPhone; CPU iPhone OS 7_0 like Mac OS X) AppleWebKit/537.51.1 (KHTML, like Gecko) Version/7.0 Mobile/11A465 Safari/9537.53 BingPreview/1.0b",
						    "BOT", null, "UNKNOWN" )]
				    [TestCase(
						    "Version/7.0 Mobile/11A465 Safari/9537.53 (compatible; bingbot/2.0; +http://www.bing.com/bingbot.htm)",
						    "BOT", null, "UNKNOWN" )]
				    [TestCase(
						    "Mozilla/5.0 (iPad; CPU OS 5_0 like Mac OS X) AppleWebKit/537.36 (KHTML, like Gecko; Google Web Preview) Version/5.1 Mobile/9A334 Safari/7534.48.3",
						    "BOT", null, "UNKNOWN" )]
				    [TestCase(
						    "Mozilla/5.0 (X11; Linux x86_64; rv:10.0.12) Gecko/20100101 Firefox/21.0 WordPress.com mShots",
						    "BOT", null, "UNKNOWN" )]
				    [TestCase(
						    "Mozilla/5.0 (compatible; Seznam screenshot-generator 2.1; +http://fulltext.sblog.cz/screenshot/)",
						    "BOT", null, "UNKNOWN" )]
				    [TestCase(
						    "facebookexternalhit/1.1 (+http://www.facebook.com/externalhit_uatext.php)",
						    "BOT", null, "UNKNOWN" )]
				    [TestCase(
						    "Mozilla/5.0 (compatible; Konqueror/3.5; Linux) KHTML/3.5.5 (like Gecko) (Exabot-Thumbnails)",
						    "BOT", null, "UNKNOWN" )]
				    [TestCase(
						    "Mozilla/5.0 (compatible; YandexMarket/1.0; +http://yandex.com/bots)",
						    "BOT", null, "UNKNOWN" )]
				    [TestCase(
						    "Mozilla/5.0 (compatible; Ask Jeeves/Teoma; +http://about.ask.com/en/docs/about/webmasters.shtml)",
						    "BOT", null, "UNKNOWN" )]
				    [TestCase( 		
                        "ThumbSniper (http://thumbsniper.com)", 
						    "BOT", null, "UNKNOWN" )]
				    [TestCase(
                        "Phantom.js bot", 
						    "BOT", null, "UNKNOWN" )]
        public void testData(String userAgentValue,
                string expectedBrowserStr, String expectedBrowserVersion,
                string expectedOSStr)
        {
            shouldParseUserAgent(userAgentValue,Browser.valueOf(expectedBrowserStr), expectedBrowserVersion, OperatingSystem.valueOf(expectedOSStr));
	    }
    }
}