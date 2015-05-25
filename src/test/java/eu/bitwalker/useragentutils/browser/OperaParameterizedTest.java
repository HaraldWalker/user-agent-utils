package eu.bitwalker.useragentutils.browser;

import static java.util.Arrays.asList;

import java.util.Collection;

import org.junit.runners.Parameterized.Parameters;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;

public class OperaParameterizedTest extends AbstractUserAgentParameterizedTest {

	public OperaParameterizedTest(String userAgentValue,
			Browser expectedBrowser, String browserVersionExpected,
			OperatingSystem osExpected) {
		super(userAgentValue, expectedBrowser, browserVersionExpected,
				osExpected);
	}

	@Parameters
	public static Collection<Object[]> testData() {
		return asList(new Object[][] {
				// opera
				{ "Opera/8.0 (Macintosh; PPC Mac OS X; U; en)", 
						Browser.OPERA, "8.0", OperatingSystem.MAC_OS_X },
				// opera9
				{ "Opera/9.52 (Windows NT 5.1; U; en)", 
						Browser.OPERA9, "9.52", OperatingSystem.WINDOWS_XP },
				{ "Opera/9.20 (Macintosh; Intel Mac OS X; U; en)",
						Browser.OPERA9, "9.20", OperatingSystem.MAC_OS_X },
				// opera10
				{
						"Opera/9.80 (Windows NT 5.2; U; en) Presto/2.2.15 Version/10.10",
						Browser.OPERA10, "10.10", OperatingSystem.WINDOWS_XP },
				{
						"Opera/9.80 (Macintosh; Intel Mac OS X; U; en) Presto/2.6.30 Version/10.61",
						Browser.OPERA10, "10.61", OperatingSystem.MAC_OS_X },
				// opera11
				{
						"Opera/9.80 (Windows NT 6.1; WOW64; U; pt) Presto/2.10.229 Version/11.62",
						Browser.OPERA11, "11.62", OperatingSystem.WINDOWS_7 },
				{
						"Opera/9.80 (Windows NT 6.0; U; pl) Presto/2.10.229 Version/11.62",
						Browser.OPERA11, "11.62", OperatingSystem.WINDOWS_VISTA },
				// opera12
				{
						"Opera/9.80 (Windows NT 6.1; U; es-ES) Presto/2.9.181 Version/12.00",
						Browser.OPERA12, "12.00", OperatingSystem.WINDOWS_7 },
				{
						"Opera/12.0(Windows NT 5.1;U;en)Presto/22.9.168 Version/12.00",
						Browser.OPERA12, "12.00", OperatingSystem.WINDOWS_XP },
				// opera15
				{
						"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.52 Safari/537.36 OPR/15.0.1147.100",
						Browser.OPERA15, "15.0.1147.100", OperatingSystem.WINDOWS_7 },
				// opera16
				{
						"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.57 Safari/537.36 OPR/16.0.1196.73",
						Browser.OPERA16, "16.0.1196.73", OperatingSystem.MAC_OS_X },
				// operaMini
				{
						"Opera/9.60 (J2ME/MIDP; Opera Mini/4.2.13337/458; U; en) Presto/2.2.0",
						Browser.OPERA_MINI, "9.60", OperatingSystem.UNKNOWN },
				{
						"Opera/9.80 (J2ME/MIDP; Opera Mini/5.0.16823/1428; U; en) Presto/2.2.0",
						Browser.OPERA_MINI, "9.80", OperatingSystem.UNKNOWN },
				{
						"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.115 Safari/537.36 OPR/27.0.1689.76",
						Browser.OPERA27, "27.0.1689.76", OperatingSystem.WINDOWS_7 },
				// Issue #86
				{
						"Mozilla/5.0 (Linux; Android 4.1.2; HTC One SV Build/JZO54K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.81 Mobile Safari/537.36 OPR/28.0.1764.90386",
						Browser.OPERA_MOBILE, "28.0.1764.90386", OperatingSystem.ANDROID4 }

		});
	}
}
