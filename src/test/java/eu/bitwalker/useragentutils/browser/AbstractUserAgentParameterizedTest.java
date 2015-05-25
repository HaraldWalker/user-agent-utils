package eu.bitwalker.useragentutils.browser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;

/**
 * @author pcollaog
 *
 */
@RunWith(Parameterized.class)
public abstract class AbstractUserAgentParameterizedTest {

	private final String userAgentValue;

	private final Browser expectedBrowser;

	private final String osExpected;

	private final String browserVersionExpected;

	/**
	 * @param userAgentValue
	 * @param browserExpected
	 */
	public AbstractUserAgentParameterizedTest(String userAgentValue,
			Browser expectedBrowser, String browserVersionExpected,
			String osExpected) {
		this.userAgentValue = userAgentValue;
		this.expectedBrowser = expectedBrowser;
		this.browserVersionExpected = browserVersionExpected;
		this.osExpected = osExpected;
	}

	@Test
	public void shouldParseUserAgent() throws Exception {
		UserAgent userAgent = UserAgent
				.parseUserAgentString(this.userAgentValue);
		assertEquals(this.expectedBrowser, userAgent.getBrowser());

		Version browserVersion = userAgent.getBrowserVersion();
		if (null != browserVersion) {
			assertEquals(this.browserVersionExpected, browserVersion.toString());
		} else {
			assertEquals(this.browserVersionExpected, browserVersion);
		}

		OperatingSystem os = userAgent.getOperatingSystem();
		assertEquals(osExpected, os.toString());
	}

}
