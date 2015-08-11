package eu.bitwalker.useragentutils.browser;

import static java.util.Arrays.asList;

import java.util.Collection;

import org.junit.runners.Parameterized.Parameters;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;

public class FirefoxParameterizedTest extends
		AbstractUserAgentParameterizedTest {

	public FirefoxParameterizedTest(String userAgentValue,
			Browser expectedBrowser, String browserVersionExpected,
			OperatingSystem osExpected) {
		super(userAgentValue, expectedBrowser, browserVersionExpected,
				osExpected);
	}

	@Parameters
	public static Collection<Object[]> testData() {
		return asList(new Object[][] {
				// firefox3
				{
						"Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.14) Gecko/2009090216 Ubuntu/9.04 (jaunty) Firefox/3.0.14",
						Browser.FIREFOX3, "3.0.14", OperatingSystem.UBUNTU },
				// firefox4
				{
						"Mozilla/5.0 (X11; Linux x86_64; rv:2.0b4) Gecko/20100818 Firefox/4.0b4",
						Browser.FIREFOX4, "4.0b4", OperatingSystem.LINUX },
				{
						"Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:2.0b9pre) Gecko/20101228 Firefox/4.0b9pre",
						Browser.FIREFOX4, "4.0b9pre", OperatingSystem.WINDOWS_7 },
				// firefox5
				{
						"Mozilla/5.0 (Windows NT 6.1; U; ru; rv:5.0.1.6) Gecko/20110501 Firefox/5.0.1 Firefox/5.0.1",
						Browser.FIREFOX5, "5.0.1", OperatingSystem.WINDOWS_7 },
				{
						"Mozilla/5.0 (X11; U; Linux i586; de; rv:5.0) Gecko/20100101 Firefox/5.0",
						Browser.FIREFOX5, "5.0", OperatingSystem.LINUX },
				// firefox6
				{
						"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:6.0a2) Gecko/20110612 Firefox/6.0a2",
						Browser.FIREFOX6, "6.0a2", OperatingSystem.WINDOWS_7 },
				// firefox19
				{
						"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:19.0) Gecko/20100101 Firefox/19.0",
						Browser.FIREFOX19, "19.0", OperatingSystem.MAC_OS_X },
				// firefox20
				{
						"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:20.0) Gecko/20100101 Firefox/20.0",
						Browser.FIREFOX20, "20.0", OperatingSystem.MAC_OS_X },
				// firefox25
				{
						"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.6; rv:25.0) Gecko/20100101 Firefox/25.0",
						Browser.FIREFOX25, "25.0", OperatingSystem.MAC_OS_X },
				// firefox3mobile
				{
						"Mozilla/5.0 (X11; U; Linux armv7l; en-US; rv:1.9.2a1pre) Gecko/20091127 Firefox/3.5 Maemo Browser 1.5.6 RX-51 N900",
						Browser.FIREFOX3MOBILE, "3.5", OperatingSystem.MAEMO },
				// firefoxMobile
				{
						"Mozilla/5.0 (Android; Mobile; rv:13.0) Gecko/13.0 Firefox/13.0",
						Browser.FIREFOX_MOBILE, "13.0", OperatingSystem.ANDROID_MOBILE },
				// firefoxMobile23
				{
						"Mozilla/5.0 (Android; Mobile; rv:23.0) Gecko/23.0 Firefox/23.0",
						Browser.FIREFOX_MOBILE23, "23.0", OperatingSystem.ANDROID_MOBILE } 
			});
	}
}
