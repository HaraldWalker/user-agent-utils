package eu.bitwalker.useragentutils.browser;

import static java.util.Arrays.asList;

import java.util.Collection;

import org.junit.runners.Parameterized.Parameters;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;

public class ChromeParameterizedTest extends AbstractUserAgentParameterizedTest {

	public ChromeParameterizedTest(String userAgentValue,
			Browser expectedBrowser, String browserVersionExpected,
			OperatingSystem osExpected) {
		super(userAgentValue, expectedBrowser, browserVersionExpected,
				osExpected);
	}

	@Parameters
	public static Collection<Object[]> testData() {
		return asList(new Object[][] {
				// chrome
				{
						"Mozilla/5.0 (Windows; U; Windows NT 5.2; en-US) AppleWebKit/532.9 (KHTML, like Gecko) Chrome/5.0.310.0 Safari/532.9",
						Browser.CHROME, "5.0.310.0", OperatingSystem.WINDOWS_XP },
				{
						"Mozilla/5.0 (X11; U; Linux x86_64; en-US) AppleWebKit/532.9 (KHTML, like Gecko) Chrome/5.0.309.0 Safari/532.9",
						Browser.CHROME, "5.0.309.0", OperatingSystem.LINUX },
				// chrome8
				{
						"Mozilla/5.0 (Windows; U; Windows NT 5.2; en-US) AppleWebKit/534.10 (KHTML, like Gecko) Chrome/8.0.558.0 Safari/534.10",
						Browser.CHROME8, "8.0.558.0", OperatingSystem.WINDOWS_XP },
				{
						"Mozilla/5.0 (X11; U; Linux x86_64; en-US) AppleWebKit/540.0 (KHTML, like Gecko) Ubuntu/10.10 Chrome/8.1.0.0 Safari/540.0",
						Browser.CHROME8, "8.1.0.0", OperatingSystem.UBUNTU },
				// chrome9

				{
						"Mozilla/5.0 (X11; U; Linux x86_64; en-US) AppleWebKit/540.0 (KHTML,like Gecko) Chrome/9.1.0.0 Safari/540.0",
						Browser.CHROME9, "9.1.0.0", OperatingSystem.LINUX },
				{
						"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) AppleWebKit/534.14 (KHTML, like Gecko) Chrome/9.0.600.0 Safari/534.14",
						Browser.CHROME9, "9.0.600.0", OperatingSystem.WINDOWS_XP },
				// chrome10
				{
						"Mozilla/5.0 (X11; U; Linux i686; en-US) AppleWebKit/534.15 (KHTML, like Gecko) Ubuntu/10.10 Chromium/10.0.613.0 Chrome/10.0.613.0 Safari/534.15",
						Browser.CHROME10, "10.0.613.0", OperatingSystem.UBUNTU },
				// chrome11
				{
						"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/11.0.697.0 Safari/534.24",
						Browser.CHROME11, "11.0.697.0", OperatingSystem.WINDOWS_7 },
				// chrome12
				{
						"Mozilla/5.0 (X11; CrOS i686 12.0.742.91) AppleWebKit/534.30 (KHTML, like Gecko) Chrome/12.0.742.93 Safari/534.30",
						Browser.CHROME12, "12.0.742.93", OperatingSystem.CHROME_OS },
				// chrome13
				{
						"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_6_7) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.41 Safari/535.1",
						Browser.CHROME13, "13.0.782.41", OperatingSystem.MAC_OS_X },
				// chrome14
				{
						"Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/14.0.815.0 Safari/535.1",
						Browser.CHROME14, "14.0.815.0", OperatingSystem.WINDOWS_XP },
				// chrome29
				{
						"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.65 Safari/537.36",
						Browser.CHROME29, "29.0.1547.65", OperatingSystem.MAC_OS_X },
				{
							"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.124 Safari/537.36",
						Browser.CHROME43, "43.0.2357.124", OperatingSystem.MAC_OS_X
				}
					
		});
	}
}
