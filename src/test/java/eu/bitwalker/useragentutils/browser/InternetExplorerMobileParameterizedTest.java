package eu.bitwalker.useragentutils.browser;

import static java.util.Arrays.asList;

import java.util.Collection;

import org.junit.runners.Parameterized.Parameters;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;

public class InternetExplorerMobileParameterizedTest extends
		AbstractUserAgentParameterizedTest {

	public InternetExplorerMobileParameterizedTest(String userAgentValue,
			Browser expectedBrowser, String browserVersionExpected,
			OperatingSystem osExpected) {
		super(userAgentValue, expectedBrowser, browserVersionExpected,
				osExpected);
	}

	@Parameters
	public static Collection<Object[]> testData() {
		return asList(new Object[][] {
				// ieMobile6
				{
						"HTC_TyTN Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 6.12)",
						Browser.IEMOBILE6, "6.0", OperatingSystem.WINDOWS_MOBILE },
				{
						"Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 6.12) Vodafone/1.0/HTC_s710/1.22.172.3",
						Browser.IEMOBILE6, "6.0", OperatingSystem.WINDOWS_MOBILE },
				{
						"Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 6.8) PPC; 240x320; HTC_TyTN/1.0 Profile/MIDP-2.0 Configuration/CLDC-1.1",
						Browser.IEMOBILE6, "6.0", OperatingSystem.WINDOWS_MOBILE },
				// ieMobile7
				{
						"HTC_TouchDual Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 7.6)",
						Browser.IEMOBILE7, "6.0", OperatingSystem.WINDOWS_MOBILE },
				{
						"PPC; 240x320; HTC_P3450/1.0 Profile/MIDP-2.0 Configuration/CLDC-1.1 Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 7.6)",
						Browser.IEMOBILE7, "6.0", OperatingSystem.WINDOWS_MOBILE },
				{
						"Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 7.6) PPC; MDA Vario/3.0 Profile/MIDP-2.0 Configuration/CLDC-1.1",
						Browser.IEMOBILE7, "6.0", OperatingSystem.WINDOWS_MOBILE },
				{
						"Palm750/v0005 Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 7.6) UP.Link/6.3.0.0.0",
						Browser.IEMOBILE7, "6.0", OperatingSystem.WINDOWS_MOBILE },
				// ieMobile9
				{
						"Mozilla/5.0 (compatible; MSIE 9.0; Windows Phone OS 7.5; Trident/5.0; IEMobile/9.0)",
						Browser.IEMOBILE9, "9.0", OperatingSystem.WINDOWS_MOBILE7 },

		});
	}

}
