package eu.bitwalker.useragentutils.browser;

import static java.util.Arrays.asList;

import java.util.Collection;

import org.junit.runners.Parameterized.Parameters;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;

public class InternetExplorerParameterizedTest extends
		AbstractUserAgentParameterizedTest {

	public InternetExplorerParameterizedTest(String userAgentValue,
			Browser expectedBrowser, String browserVersionExpected,
			OperatingSystem osExpected) {
		super(userAgentValue, expectedBrowser, browserVersionExpected,
				osExpected);
	}

	@Parameters
	public static Collection<Object[]> testData() {
		return asList(new Object[][] {
				// Internet explorer 6.0
				{
						"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; SV1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)",
						Browser.IE6, "6.0", OperatingSystem.WINDOWS_XP },
				{
						"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0; T312461)",
						Browser.IE6, "6.0", OperatingSystem.WINDOWS_2000 },
				{
						"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 1.1.4322; XMPP Tiscali Communicator v.10.0.2; .NET CLR 2.0.50727)",
						Browser.IE6, "6.0", OperatingSystem.WINDOWS_XP },
				{
						"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; SV1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)",
						Browser.IE6, "6.0", OperatingSystem.WINDOWS_XP },
				// Internet explorer 7
				{
						"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; SV1; .NET CLR 2.0.50727)",
						Browser.IE7, "7.0", OperatingSystem.WINDOWS_XP },
				{
						"Mozilla/4.0 (compatible; MSIE 7.0b; Windows NT 6.0 ; .NET CLR 2.0.50215; SL Commerce Client v1.0; Tablet PC 2.0",
						Browser.IE7, "7.0b", OperatingSystem.WINDOWS_VISTA },
				{
						"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)",
						Browser.IE7, "7.0", OperatingSystem.WINDOWS_XP },
				{
						"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; SLCC1; .NET CLR 2.0.50727; .NET CLR 3.0.04506)",
						Browser.IE7, "7.0", OperatingSystem.WINDOWS_VISTA },
				// Internet Explorer 8
				{
						"Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0; WOW64; SLCC1; .NET CLR 2.0.50727; .NET CLR 3.0.04506; Media Center PC 5.0; .NET CLR 1.1.4322)",
						Browser.IE8, "8.0", OperatingSystem.WINDOWS_VISTA },
				{
						"Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0; Win64; x64; .NET CLR 2.0.50727; SLCC1; Media Center PC 5.0; .NET CLR 3.0.04506)",
						Browser.IE8, "8.0", OperatingSystem.WINDOWS_VISTA },
				// Internet Explorer 9
				{
						"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; Zune 4.0; InfoPath.3; MS-RTC LM 8; .NET4.0C; .NET4.0E)",
						Browser.IE9, "9.0", OperatingSystem.WINDOWS_7 },
				{
						"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0",
						Browser.IE9, "9.0", OperatingSystem.WINDOWS_7 },
				// Internet Explorer 10
				{
						"Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; Trident/6.0)",
						Browser.IE10, "10.0", OperatingSystem.WINDOWS_7 },
				{
						"Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Trident/6.0)",
						Browser.IE10, "10.0", OperatingSystem.WINDOWS_8 },
				// Internet Explorer 11
				{
						"Mozilla/5.0 (Windows NT 6.3; WOW64; Trident/7.0; rv:11.0) like Gecko",
						Browser.IE11, "11.0", OperatingSystem.WINDOWS_81 },
				// Internet Explorer 5
				{
						"Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0; .NET CLR 1.1.4322)",
						Browser.IE5_5, "5.5", OperatingSystem.WINDOWS_2000 },
				{ "Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0)",
						Browser.IE5_5, "5.5", OperatingSystem.WINDOWS_2000 },
				{ "Mozilla/4.0 (compatible; MSIE 5.5; Windows 95)",
						Browser.IE5_5, "5.5", OperatingSystem.WINDOWS },
				// IE old
				{ "Mozilla/4.0 (compatible; MSIE 4.01; Windows 95)",
						Browser.IE, "4.01", OperatingSystem.WINDOWS },
				{
						"Mozilla/4.0 (compatible; MSIE 4.0; Windows 95; .NET CLR 1.1.4322; .NET CLR 2.0.50727)",
						Browser.IE, "4.0", OperatingSystem.WINDOWS },
				{ "Mozilla/2.0 (compatible; MSIE 3.03; Windows 3.1)",
						Browser.IE, "3.03", OperatingSystem.WINDOWS } });
	}

}
