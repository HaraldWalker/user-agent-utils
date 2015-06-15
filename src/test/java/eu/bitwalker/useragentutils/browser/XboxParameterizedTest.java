package eu.bitwalker.useragentutils.browser;

import static java.util.Arrays.asList;

import java.util.Collection;

import org.junit.runners.Parameterized.Parameters;

import eu.bitwalker.useragentutils.Browser;

public class XboxParameterizedTest extends AbstractUserAgentParameterizedTest {

	public XboxParameterizedTest(String userAgentValue,
			Browser expectedBrowser, String browserVersionExpected,
			String osExpected) {
		super(userAgentValue, expectedBrowser, browserVersionExpected,
				osExpected);
	}

	@Parameters
	public static Collection<Object[]> testData() {
		return asList(new Object[][] {

				{
						"Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Trident/6.0; Xbox; Xbox One)",
						Browser.XBOX, null, "XBOX_OS" },
				{
						"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; Xbox)",
						Browser.XBOX, null, "XBOX_OS" }

		});
	}
}
