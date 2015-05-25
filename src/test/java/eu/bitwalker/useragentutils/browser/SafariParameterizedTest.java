package eu.bitwalker.useragentutils.browser;

import static java.util.Arrays.asList;

import java.util.Collection;

import org.junit.runners.Parameterized.Parameters;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;

public class SafariParameterizedTest extends AbstractUserAgentParameterizedTest {

	public SafariParameterizedTest(String userAgentValue,
			Browser expectedBrowser, String browserVersionExpected,
			OperatingSystem osExpected) {
		super(userAgentValue, expectedBrowser, browserVersionExpected,
				osExpected);
	}

	@Parameters
	public static Collection<Object[]> testData() {
		return asList(new Object[][] {
				// safari
				{
						"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_5_7; en-us) AppleWebKit/525.28.3 (KHTML, like Gecko) Version/3.2.3 Safari/525.28.3",
						Browser.SAFARI, "3.2.3", OperatingSystem.MAC_OS_X },
				{
						"Mozilla/5.0 (Macintosh; U; Intel Mac OS X; en-gb) AppleWebKit/523.10.6 (KHTML, like Gecko) Version/3.0.4 Safari/523.10.6",
						Browser.SAFARI, "3.0.4", OperatingSystem.MAC_OS_X },
				// safari6
				{
						"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_3) AppleWebKit/536.28.10 (KHTML, like Gecko) Version/6.0.3 Safari/536.28.10",
						Browser.SAFARI6, "6.0.3", OperatingSystem.MAC_OS_X },
				// safari5
				{
						"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_4; en-us) AppleWebKit/533.16 (KHTML, like Gecko) Version/5.0 Safari/533.16",
						Browser.SAFARI5, "5.0", OperatingSystem.MAC_OS_X },
				{
						"Mozilla/5.0 (Windows; U; Windows NT 6.1; ja-JP) AppleWebKit/533.16 (KHTML, like Gecko) Version/5.0 Safari/533.16",
						Browser.SAFARI5, "5.0", OperatingSystem.WINDOWS_7 },
				{
						"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_5; en-us) AppleWebKit/533.19.4 (KHTML, like Gecko) Version/5.0.3 Safari/533.19.4",
						Browser.SAFARI5, "5.0.3", OperatingSystem.MAC_OS_X },
				{
						"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_7; da-dk) AppleWebKit/533.21.1 (KHTML, like Gecko) Version/5.0.5 Safari/533.21.1",
						Browser.SAFARI5, "5.0.5", OperatingSystem.MAC_OS_X },
				// safari4
				{
						"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_2; en-us) AppleWebKit/531.21.8 (KHTML, like Gecko) Version/4.0.4 Safari/531.21.10",
						Browser.SAFARI4, "4.0.4", OperatingSystem.MAC_OS_X },
				{
						"Mozilla/5.0 (Windows; U; Windows NT 6.1; es-ES) AppleWebKit/531.22.7 (KHTML, like Gecko) Version/4.0.5 Safari/531.22.7",
						Browser.SAFARI4, "4.0.5", OperatingSystem.WINDOWS_7 },
				{
						"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_5_7; en-us) AppleWebKit/531.2+ (KHTML, like Gecko) Version/4.0.1 Safari/530.18",
						Browser.SAFARI4, "4.0.1", OperatingSystem.MAC_OS_X },
				// mobileSafari
				{
						"Mozilla/5.0 (Linux; U; Android 2.1; en-us; Nexus One Build/ERD62) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Mobile Safari/530.17",
						Browser.MOBILE_SAFARI, "4.0", OperatingSystem.ANDROID2 },
				{
						"Mozilla/5.0 (iPod; U; CPU iPhone OS 2_0 like Mac OS X; de-de) AppleWebKit/525.18.1 (KHTML, like Gecko) Version/3.1.1 Mobile/5A347 Safari/525.20",
						Browser.MOBILE_SAFARI, "3.1.1", OperatingSystem.MAC_OS_X_IPHONE },
				{
						"Mozilla/5.0 (iPod; U; CPU like Mac OS X; en) AppleWebKit/420.1 (KHTML, like Gecko) Version/3.0 Mobile/3A101a Safari/419.3",
						Browser.MOBILE_SAFARI, "3.0", OperatingSystem.MAC_OS_X_IPOD },
				{
						"Mozilla/5.0 (iPad; U; CPU OS 3_2 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Version/4.0.4 Mobile/7B367 Safari/531.21.10",
						Browser.MOBILE_SAFARI, "4.0.4", OperatingSystem.MAC_OS_X_IPAD },
				{
						"Mozilla/5.0 (iPod; U; CPU iPhone OS 4_1 like Mac OS X; en-us) AppleWebKit/532.9 (KHTML, like Gecko) Version/4.0.5 Mobile/8B117 Safari/6531.22.7",
						Browser.MOBILE_SAFARI, "4.0.5", OperatingSystem.iOS4_IPHONE },
				{
						"Mozilla/5.0 (iPhone; CPU iPhone OS 5_0 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9A334 Safari/7534.48.3",
						Browser.MOBILE_SAFARI, "5.1", OperatingSystem.iOS5_IPHONE },
				{
						"Mozilla/5.0 (iPhone; CPU iPhone OS 5_1_1 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9B206 Safari/7534.48.3",
						Browser.MOBILE_SAFARI, "5.1", OperatingSystem.iOS5_IPHONE } 
			});
	}
}
