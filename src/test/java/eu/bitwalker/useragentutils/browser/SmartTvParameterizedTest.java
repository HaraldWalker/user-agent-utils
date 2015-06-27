/**
 * 
 */
package eu.bitwalker.useragentutils.browser;

import static eu.bitwalker.useragentutils.Browser.*;
import static java.util.Arrays.asList;

import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;

/**
 * @author pcollaog
 *
 */
@RunWith(Parameterized.class)
public class SmartTvParameterizedTest extends
		AbstractUserAgentParameterizedTest {

	/**
	 * @param userAgentValue
	 * @param expectedBrowser
	 * @param expectedBrowserVersion
	 * @param expectedOS
	 */
	public SmartTvParameterizedTest(String userAgentValue,
			Browser expectedBrowser, String expectedBrowserVersion,
			OperatingSystem expectedOS) {
		super(userAgentValue, expectedBrowser, expectedBrowserVersion,
				expectedOS);
	}

	@Parameters
	public static Collection<Object[]> testData() {
		return asList(new Object[][] {

				// http://developer.samsung.com/technical-doc/view.do?v=T000000203
				// Samsung Smart-TV
				// 2011
				{
						"Mozilla/5.0 (SmartHub; SMART-TV; U; Linux/SmartTV) AppleWebKit/531.2 (KHTML, like Gecko) Web Browser/1.0 SmartTV Safari/531.2+",
						SAMSUNG_SMART_TV, null, OperatingSystem.LINUX },
				// 2012
				{
						"Mozilla/5.0 (SMART-TV; X11; Linux i686) AppleWebKit/534.7 (KHTML, like Gecko) Version/5.0 Safari/534.7",
						SAMSUNG_SMART_TV, null, OperatingSystem.LINUX },
				// 2013
				{
						"Mozilla/5.0 (SMART-TV;X11; Linux i686) AppleWebkit/535.20+ (KHTML, like Gecko) Version/5.0 Safari/535.20+",
						SAMSUNG_SMART_TV, null, OperatingSystem.LINUX },
				// 2014
				{
						"Mozilla/5.0 (SMART-TV; X11; Linux armv7l) AppleWebkit/537.42 (KHTML, like Gecko) Safari/537.42",
						SAMSUNG_SMART_TV, null, OperatingSystem.LINUX },
				// 2015
				{
						"Mozilla/5.0 (SMART-TV; Linux; Tizen 2.3) AppleWebkit/538.1 (KHTML, like Gecko) SamsungBrowser/1.0 TV Safari/538.1",
						SAMSUNG_SMART_TV, null, OperatingSystem.LINUX },

				// User Agent Strings for Fire TV
				// https://developer.amazon.com/public/solutions/devices/fire-tv/docs/user-agent-strings
				{
						"Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; AFTB Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30",
						FIRE_TV, null, OperatingSystem.ANDROID4 },

				{
						"Mozilla/5.0 (Linux; Android 4.2.2; AFTB Build/JDQ39) AppleWebKit/537.22 (KHTML, like Gecko) Chrome/25.0.1364.173 Mobile Safari/537.22",
						FIRE_TV, null, OperatingSystem.ANDROID4 },
				{
						"Mozilla/5.0 (Linux; Android 4.2.2; AFTB Build/JDQ39) AppleWebKit/537.22 (KHTML, like Gecko) Chrome/25.0.1364.173 Mobile Safari/537.22 cordova-amazon-fireos/3.4.0 AmazonWebAppPlatform/3.4.0;2.0 ",
						FIRE_TV, null, OperatingSystem.ANDROID4 },

				// http://developer.lge.com/webOSTV/develop/web-app/webos-tv-platform/web-engine/
				// LG webOS TV 2.x
				{
						"Mozilla/5.0 (Web0S; Linux/SmartTV) AppleWebKit/538.2 (KHTML, like Gecko) Large Screen WebAppManager Safari/538.2",
						LG_SMART_TV, null, OperatingSystem.LINUX },
				// LG webOS TV 1.x
				{
						"Mozilla/5.0 (Web0S; Linux/SmartTV) AppleWebKit/537.41 (KHTML, like Gecko) Large Screen WebAppManager Safari/537.41",
						LG_SMART_TV, null, OperatingSystem.LINUX },
				// LG
				{
						"Mozilla/5.0 (Unknown; Linux armv7l) AppleWebKit/537.1+ (KHTML, like Gecko) Safari/537.1+ LG Browser/6.00.00(+mouse+3D+SCREEN+TUNER; LGE; GLOBAL-PLAT5; 03.07.01; 0x00000001;); LG NetCast.TV-2013/03.17.01 (LG, GLOBAL-PLAT4, wired)",
						LG_SMART_TV, null, OperatingSystem.LINUX } });
	}
}
