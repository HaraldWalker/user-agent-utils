package eu.bitwalker.useragentutils.browser;

import static java.util.Arrays.asList;

import java.util.Collection;

import org.junit.runners.Parameterized.Parameters;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;

public class ThunderbirdParameterizedTest extends
		AbstractUserAgentParameterizedTest {

	public ThunderbirdParameterizedTest(String userAgentValue,
			Browser expectedBrowser, String browserVersionExpected,
			OperatingSystem osExpected) {
		super(userAgentValue, expectedBrowser, browserVersionExpected,
				osExpected);
	}

	@Parameters
	public static Collection<Object[]> testData() {
		return asList(new Object[][] {
				// thunderbird3
				{
						"Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.2.12) Gecko/20101027 Thunderbird/3.1.6",
						Browser.THUNDERBIRD3, "3.1.6", OperatingSystem.LINUX },
				{
						"Mozilla/5.0 (Windows; U; Windows NT 6.1; sv-SE; rv:1.9.2.8) Gecko/20100802 Thunderbird/3.1.2 ThunderBrowse/3.3.2",
						Browser.THUNDERBIRD3, "3.1.2", OperatingSystem.WINDOWS_7 },
				// thunderbird2
				{
						"Mozilla/5.0 (Windows; U; Windows NT 6.0; en-GB; rv:1.8.1.14) Gecko/20080421 Thunderbird/2.0.0.14",
						Browser.THUNDERBIRD2, "2.0.0.14", OperatingSystem.WINDOWS_VISTA },
				{
						"Mozilla/5.0 (Macintosh; U; Intel Mac OS X; en-US; rv:1.8.1.17) Gecko/20080914 Thunderbird/2.0.0.17",
						Browser.THUNDERBIRD2, "2.0.0.17", OperatingSystem.MAC_OS_X }

		});
	}
}
