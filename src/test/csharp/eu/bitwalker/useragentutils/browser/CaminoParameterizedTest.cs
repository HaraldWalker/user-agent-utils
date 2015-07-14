using System;
using System.Collections.Generic;
using NUnit.Framework;

namespace eu.bitwalker.useragentutils.browser
{

    public class CaminoParameterizedTest : AbstractUserAgentParameterizedTest
    {

                // camino
				        [TestCase(
                    "Mozilla/5.0 (Macintosh; U; PPC Mac OS X Mach-O; it; rv:1.8.1.21) Gecko/20090327 Camino/1.6.7 (MultiLang) (like Firefox/2.0.0.21pre)",
                    "CAMINO", "1.6.7", "MAC_OS_X"
                )]
				        [TestCase(
                    "Mozilla/5.0 (Macintosh; U; PPC Mac OS X Mach-O; en-US; rv:1.8.0.4) Gecko/20060613 Camino/1.0.2",
                    "CAMINO", "1.0.2", "MAC_OS_X"
                )]
                // camino2
				        [TestCase(
                    "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.6; en; rv:1.9.0.19) Gecko/2010111021 Camino/2.0.6 (MultiLang) (like Firefox/3.0.19)",
                    "CAMINO2", "2.0.6", "MAC_OS_X"
                )]
				        [TestCase(
                    "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.6; en; rv:1.9.0.18) Gecko/2010021619 Camino/2.0.2 (like Firefox/3.0.18)",
                    "CAMINO2", "2.0.2", "MAC_OS_X"
                )]
        [Test]
        public void testData(String userAgentValue,
                string expectedBrowserStr, String expectedBrowserVersion,
                string expectedOSStr)
        {
            shouldParseUserAgent(userAgentValue,Browser.valueOf(expectedBrowserStr), expectedBrowserVersion, OperatingSystem.valueOf(expectedOSStr));
	    }
        
    }
}