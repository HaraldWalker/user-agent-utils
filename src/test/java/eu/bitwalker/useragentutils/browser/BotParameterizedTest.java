package eu.bitwalker.useragentutils.browser;

import static eu.bitwalker.useragentutils.Browser.BOT;
import static java.util.Arrays.asList;

import java.util.Collection;

import org.junit.runners.Parameterized.Parameters;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;

public class BotParameterizedTest extends AbstractUserAgentParameterizedTest {

	public BotParameterizedTest(String userAgentValue, Browser expectedBrowser,
			String browserVersionExpected, OperatingSystem osExpected) {
		super(userAgentValue, expectedBrowser, browserVersionExpected,
				osExpected);
	}

	@Parameters
	public static Collection<Object[]> testData() {
		return asList(new Object[][] {

				// bots
				{
						"Mozilla/5.0 (compatible; Googlebot/2.1; http://www.google.com/bot.html)",
						BOT, null, OperatingSystem.UNKNOWN },
				{
						"Mozilla/5.0 (compatible; Yahoo! Slurp; http://help.yahoo.com/help/us/ysearch/slurp)",
						BOT, null, OperatingSystem.UNKNOWN },
				{ 		"Googlebot-Image/1.0", 
						Browser.BOT, null, OperatingSystem.UNKNOWN },
				{
						"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/536.8 (KHTML, like Gecko; Google Web Preview) Chrome/19.0.1084.36 Safari/536.8",
						BOT, null, OperatingSystem.UNKNOWN },
				{
						"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/600.2.5 (KHTML, like Gecko) Version/8.0.2 Safari/600.2.5 (Applebot/0.1)",
						Browser.BOT, null, OperatingSystem.UNKNOWN },
				{ 		"Mediapartners-Google", 
						Browser.BOT, null, OperatingSystem.UNKNOWN },
				{
						"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/534+ (KHTML, like Gecko) BingPreview/1.0b",
						Browser.BOT, null, OperatingSystem.UNKNOWN },
				{
						"Mozilla/5.0 (Windows NT 6.3; WOW64; Trident/7.0; rv:11.0; BingPreview/1.0b) like Gecko",
						Browser.BOT, null, OperatingSystem.UNKNOWN },
				{
						"Mozilla/5.0 (iPhone; CPU iPhone OS 7_0 like Mac OS X) AppleWebKit/537.51.1 (KHTML, like Gecko) Version/7.0 Mobile/11A465 Safari/9537.53 BingPreview/1.0b",
						Browser.BOT, null, OperatingSystem.UNKNOWN },
				{
						"Version/7.0 Mobile/11A465 Safari/9537.53 (compatible; bingbot/2.0; +http://www.bing.com/bingbot.htm)",
						Browser.BOT, null, OperatingSystem.UNKNOWN },
				{
						"Mozilla/5.0 (iPad; CPU OS 5_0 like Mac OS X) AppleWebKit/537.36 (KHTML, like Gecko; Google Web Preview) Version/5.1 Mobile/9A334 Safari/7534.48.3",
						Browser.BOT, null, OperatingSystem.UNKNOWN },
				{
						"Mozilla/5.0 (X11; Linux x86_64; rv:10.0.12) Gecko/20100101 Firefox/21.0 WordPress.com mShots",
						Browser.BOT, null, OperatingSystem.UNKNOWN },
				{
						"Mozilla/5.0 (compatible; Seznam screenshot-generator 2.1; +http://fulltext.sblog.cz/screenshot/)",
						Browser.BOT, null, OperatingSystem.UNKNOWN },
				{
						"facebookexternalhit/1.1 (+http://www.facebook.com/externalhit_uatext.php)",
						Browser.BOT, null, OperatingSystem.UNKNOWN },
				{
						"Mozilla/5.0 (compatible; Konqueror/3.5; Linux) KHTML/3.5.5 (like Gecko) (Exabot-Thumbnails)",
						Browser.BOT, null, OperatingSystem.UNKNOWN },
				{
						"Mozilla/5.0 (compatible; YandexMarket/1.0; +http://yandex.com/bots)",
						Browser.BOT, null, OperatingSystem.UNKNOWN },
				{
						"Mozilla/5.0 (compatible; Ask Jeeves/Teoma; +http://about.ask.com/en/docs/about/webmasters.shtml)",
						Browser.BOT, null, OperatingSystem.UNKNOWN },
				{ 		"ThumbSniper (http://thumbsniper.com)", 
						Browser.BOT, null, OperatingSystem.UNKNOWN },
				{ 		"Phantom.js bot", 
						Browser.BOT, null, OperatingSystem.UNKNOWN },
		});
	}
}