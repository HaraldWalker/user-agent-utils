/**
 * 
 */
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace eu.bitwalker.useragentutils
{

    /**
     * @author harald -- @ported by thunder stumpges
     *
     */
    [TestClass]
    public class UserAgentTest
    {

        /**
	 * Test method for {@link eu.bitwalker.useragentutils.UserAgent#parseUserAgentString(java.lang.String)}.
	 */

        [TestMethod]
        public void testParseUserAgentString()
        {
            UserAgent userAgent =
                UserAgent.parseUserAgentString(
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; SV1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)");
            Assert.AreEqual(OperatingSystem.WINDOWS_XP, userAgent.getOperatingSystem());
            Assert.AreEqual(Browser.IE6, userAgent.getBrowser());
        }

        /**
	 * Test method for {@link eu.bitwalker.useragentutils.UserAgent#parseUserAgentString(java.lang.String)} 
	 * that checks for proper handling of a <code>null</code> userAgentString.
	 */

        [TestMethod]
        public void testParseUserAgentStringNull()
        {
            UserAgent userAgent = UserAgent.parseUserAgentString(null);
            Assert.AreEqual(OperatingSystem.UNKNOWN, userAgent.getOperatingSystem());
            Assert.AreEqual(Browser.UNKNOWN, userAgent.getBrowser());
            Assert.IsNull(userAgent.getBrowserVersion());
        }

        /**
	 * Test method for {@link eu.bitwalker.useragentutils.UserAgent#toString()}.
	 */

        [TestMethod]
        public void testToString()
        {
            UserAgent userAgent =
                UserAgent.parseUserAgentString(
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; SV1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)");
            Assert.AreEqual(OperatingSystem.WINDOWS_XP.ToString() + "-" + Browser.IE6.ToString(), userAgent.ToString());
        }

        /**
	     * Test method for {@link eu.bitwalker.useragentutils.UserAgent#valueOf(int)}.
	     */
        [TestMethod]
        public void testValueOf()
        {
            UserAgent userAgent =
                UserAgent.parseUserAgentString(
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; SV1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)");
            UserAgent retrievedUserAgent = UserAgent.valueOf(userAgent.getId());
            Assert.AreEqual(userAgent, retrievedUserAgent);
        }

        /**
	 * Test method for {@link eu.bitwalker.useragentutils.UserAgent#valueOf(String)}.
	 */

        [TestMethod]
        public void testValueOf2()
        {
            UserAgent userAgent =
                UserAgent.parseUserAgentString(
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; SV1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)");
            UserAgent retrievedUserAgent = UserAgent.valueOf(userAgent.ToString());
            Assert.AreEqual(userAgent, retrievedUserAgent);
        }

    }
}