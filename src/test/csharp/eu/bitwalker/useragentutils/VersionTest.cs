using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace eu.bitwalker.useragentutils
{
    [TestClass]
    public class VersionTest
    {

        [TestMethod]
        public void shouldCompareCorrectly()
        {
            Assert.IsTrue(new Version("2.5", "2", "5").CompareTo(new Version("3.1", "3", "1")) < 0);
            Assert.IsTrue(new Version("7.0.1", "7", "0.1").CompareTo(new Version("7.0", "7", "0")) > 0);
            Assert.IsTrue(new Version("7.0.1", "7", "0.1").CompareTo(new Version("7.0.1", "7", "0.1")) == 0);
            Assert.IsTrue(new Version("7.0.a", "7", "0.a").CompareTo(new Version("7.0.b", "7", "0.b")) < 0);
            Assert.IsTrue(new Version("25.0", "25", "0").CompareTo(new Version("3.1", "3", "1")) > 0);
        }
    }
}