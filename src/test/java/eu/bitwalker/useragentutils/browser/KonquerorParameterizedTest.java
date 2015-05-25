package eu.bitwalker.useragentutils.browser;

import static java.util.Arrays.asList;

import java.util.Collection;

import org.junit.runners.Parameterized.Parameters;

import eu.bitwalker.useragentutils.Browser;

public class KonquerorParameterizedTest extends
		AbstractUserAgentParameterizedTest {

	public KonquerorParameterizedTest(String userAgentValue,
			Browser expectedBrowser, String browserVersionExpected,
			String osExpected) {
		super(userAgentValue, expectedBrowser, browserVersionExpected,
				osExpected);
	}

	@Parameters
	public static Collection<Object[]> testData() {
		return asList(new Object[][] {
				// konqueror
				{
						"Mozilla/5.0 (compatible; konqueror/3.3; linux 2.4.21-243-smp4G) (KHTML, like Geko)",
						Browser.KONQUEROR, null, "LINUX" },
				{
						"Mozilla/6.0 (compatible; Konqueror/4.2; i686 FreeBSD 6.4; 20060308)",
						Browser.KONQUEROR, "4.2", "UNKNOWN" },
				{
						"Mozilla/5.0 (compatible; Konqueror/3.1; Linux 2.4.21-20.0.1.ELsmp; X11; i686; , en_US, en, de)",
						Browser.KONQUEROR, "3.1", "LINUX" } });
	}
}
