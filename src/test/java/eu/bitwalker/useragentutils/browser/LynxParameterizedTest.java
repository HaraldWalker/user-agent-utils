package eu.bitwalker.useragentutils.browser;

import static java.util.Arrays.asList;

import java.util.Collection;

import org.junit.runners.Parameterized.Parameters;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;

public class LynxParameterizedTest extends AbstractUserAgentParameterizedTest {

	public LynxParameterizedTest(String userAgentValue,
			Browser expectedBrowser, String browserVersionExpected,
			OperatingSystem osExpected) {
		super(userAgentValue, expectedBrowser, browserVersionExpected,
				osExpected);
	}

	@Parameters
	public static Collection<Object[]> testData() {
		return asList(new Object[][] {
				// lynxClient
				{ "Lynx/2.8.5rel.1 libwww-FM/2.14 SSL-MM/1.4.1 OpenSSL/0.9.7d",
						Browser.LYNX, "2.8.5rel.1", OperatingSystem.UNKNOWN },
				{ "Lynx/2.7.1ac-0.102+intl+csuite libwww-FM/2.14",
						Browser.LYNX, "2.7.1ac-0.102+intl+csuite", OperatingSystem.UNKNOWN } 
		});
	}
}
