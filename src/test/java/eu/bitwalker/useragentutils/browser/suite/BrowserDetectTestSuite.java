package eu.bitwalker.useragentutils.browser.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import eu.bitwalker.useragentutils.browser.BlackberryParameterizedTest;
import eu.bitwalker.useragentutils.browser.BotParameterizedTest;
import eu.bitwalker.useragentutils.browser.CFNetworkParameterizedTest;
import eu.bitwalker.useragentutils.browser.CaminoParameterizedTest;
import eu.bitwalker.useragentutils.browser.ChromeMobileParameterizedTest;
import eu.bitwalker.useragentutils.browser.ChromeParameterizedTest;
import eu.bitwalker.useragentutils.browser.FirefoxParameterizedTest;
import eu.bitwalker.useragentutils.browser.InternetExplorerMobileParameterizedTest;
import eu.bitwalker.useragentutils.browser.InternetExplorerParameterizedTest;
import eu.bitwalker.useragentutils.browser.InternetExplorerXboxParameterizedTest;
import eu.bitwalker.useragentutils.browser.KonquerorParameterizedTest;
import eu.bitwalker.useragentutils.browser.LotusParameterizedTest;
import eu.bitwalker.useragentutils.browser.LynxParameterizedTest;
import eu.bitwalker.useragentutils.browser.OperaParameterizedTest;
import eu.bitwalker.useragentutils.browser.OthersParameterizedTest;
import eu.bitwalker.useragentutils.browser.OutlookParameterizedTest;
import eu.bitwalker.useragentutils.browser.SafariParameterizedTest;
import eu.bitwalker.useragentutils.browser.ThunderbirdParameterizedTest;
import eu.bitwalker.useragentutils.browser.ToolParameterizedTest;

@RunWith(Suite.class)
@SuiteClasses({ 
		BlackberryParameterizedTest.class, 
		BotParameterizedTest.class,
		CaminoParameterizedTest.class, 
		CFNetworkParameterizedTest.class,
		ChromeParameterizedTest.class,
		ChromeMobileParameterizedTest.class, 
		FirefoxParameterizedTest.class,
		InternetExplorerMobileParameterizedTest.class,
		InternetExplorerParameterizedTest.class,
		InternetExplorerXboxParameterizedTest.class,
		KonquerorParameterizedTest.class, 
		LotusParameterizedTest.class,
		LynxParameterizedTest.class, 
		OperaParameterizedTest.class,
		OthersParameterizedTest.class, 
		OutlookParameterizedTest.class,
		SafariParameterizedTest.class, 
		ThunderbirdParameterizedTest.class,
		ToolParameterizedTest.class })
public class BrowserDetectTestSuite {

}
