package eu.bitwalker.useragentutils.browser;

import static java.util.Arrays.asList;

import java.util.Collection;

import org.junit.runners.Parameterized.Parameters;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;

public class OthersParameterizedTest extends AbstractUserAgentParameterizedTest {

	public OthersParameterizedTest(String userAgentValue,
			Browser expectedBrowser, String browserVersionExpected,
			OperatingSystem osExpected) {
		super(userAgentValue, expectedBrowser, browserVersionExpected,
				osExpected);
	}

	@Parameters
	public static Collection<Object[]> testData() {
		return asList(new Object[][] {

				// dolfin
				{
						"Mozilla/5.0 (SAMSUNG; SAMSUNG-GT-S8500/S8500NEJE5; U; Bada/1.0; fr-fr) AppleWebKit/533.1 (KHTML, like Gecko) Dolfin/2.0 Mobile WVGA SMM-MMS/1.2.0 NexPlayer/3.0 profile/MIDP-2.1 configuration/CLDC-1.1 OPN-B",
						Browser.DOLFIN2, null, OperatingSystem.BADA },
				// appleMail
				{
						"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_4; en-us) AppleWebKit/533.18.1 (KHTML, like Gecko)",
						Browser.APPLE_WEB_KIT, null, OperatingSystem.MAC_OS_X },
				// omniWeb
				{
						"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_5_8; en-US) AppleWebKit/531.9+(KHTML, like Gecko, Safari/528.16) OmniWeb/v622.10.0",
						Browser.OMNIWEB, null, OperatingSystem.MAC_OS_X },
				{
						"Mozilla/5.0 (Macintosh; U; Intel Mac OS X; en-US) AppleWebKit/525.18 (KHTML, like Gecko, Safari/525.20) OmniWeb/v622.3.0.105198",
						Browser.OMNIWEB, null, OperatingSystem.MAC_OS_X },

				// flock
				{
						"Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.3) Gecko/2008100716 Firefox/3.0.3 Flock/2.0",
						Browser.FLOCK, "2.0", OperatingSystem.LINUX },
				// seaMonkey
				{
						"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.1.13) Gecko/20100914 Mnenhy/0.8.3 SeaMonkey/2.0.8",
						Browser.SEAMONKEY, "2.0.8", OperatingSystem.WINDOWS_XP },

				// silk
				{
						"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_3; en-us; Silk/1.1.0-80) AppleWebKit/533.16 (KHTML, like Gecko) Version/5.0 Safari/533.16 Silk-Accelerated=true",
						Browser.SILK, "1.1.0-80", OperatingSystem.MAC_OS_X },
				// iTunes
				{
						"iTunes/10.2.2 (Windows; Microsoft Windows XP Home Edition Service Pack 3 (Build 2600)) AppleWebKit/533.21.1",
						Browser.APPLE_ITUNES, null, OperatingSystem.WINDOWS },
				// appStore
				{
						"MacAppStore/1.1.2 (Macintosh; U; Intel Mac OS X 10.7.3; en) AppleWebKit/534.53.11 ",
						Browser.APPLE_APPSTORE, null, OperatingSystem.MAC_OS_X },
				// airApp
				{
						"Mozilla/5.0 (Windows; U; cs-CZ) AppleWebKit/526.9+ (KHTML, like Gecko) AdobeAIR/1.5.1",
						Browser.ADOBE_AIR, null, OperatingSystem.WINDOWS },
				// vivaldi
				{
						"Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.89 Vivaldi/1.0.83.38 Safari/537.36",
						Browser.VIVALDI, "1.0.83.38", OperatingSystem.WINDOWS_8 },
				{
						"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.114 Safari/537.36 Vivaldi/1.0.111.2",
						Browser.VIVALDI, "1.0.111.2", OperatingSystem.MAC_OS_X },
				{
						"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.114 Safari/537.36 Vivaldi/1.0.111.2",
						Browser.VIVALDI, "1.0.111.2", OperatingSystem.WINDOWS_7 }

		});
	}
}
