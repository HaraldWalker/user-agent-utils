package eu.bitwalker.useragentutils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Ios9xTest {

    @Test
    public void testIphone81() {
        String agent = "Mozilla/5.0 (iPad; CPU OS 8_1_2 like Mac OS X) AppleWebKit/600.1.4 (KHTML, like Gecko) Mobile/12B440";
        OperatingSystem operatingSystem = OperatingSystem.parseUserAgentString(agent);
        assertEquals("iOS8_1_IPAD", operatingSystem.name());
    }

    @Test
    public void testIphone91() {
        String agent = "Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1";
        OperatingSystem operatingSystem = OperatingSystem.parseUserAgentString(agent);
        assertEquals("iOS9_1_IPHONE", operatingSystem.name());
    }

    @Test
    public void testIphone92() {
        String agent = "Mozilla/5.0 (iPhone; CPU iPhone OS 9_2 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13C75 Safari/601.1";
        OperatingSystem operatingSystem = OperatingSystem.parseUserAgentString(agent);
        assertEquals("iOS9_2_IPHONE", operatingSystem.name());
    }

    @Test
    public void testIphone93() {
        String agent = "Mozilla/5.0 (iPhone; CPU iPhone OS 9_3 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B5119e Safari/601.1";
        OperatingSystem operatingSystem = OperatingSystem.parseUserAgentString(agent);
        assertEquals("iOS9_3_IPHONE", operatingSystem.name());
    }

    @Test
    public void testIpad91() {
        String agent = "Mozilla/5.0 (iPad; CPU OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1";
        OperatingSystem operatingSystem = OperatingSystem.parseUserAgentString(agent);
        assertEquals("iOS9_1_IPAD", operatingSystem.name());
    }

    @Test
    public void testIpad92() {
        String agent = "Mozilla/5.0 (iPad; CPU OS 9_2 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13C75 Safari/601.1";
        OperatingSystem operatingSystem = OperatingSystem.parseUserAgentString(agent);
        assertEquals("iOS9_2_IPAD", operatingSystem.name());
    }

    @Test
    public void testIpad93() {
        String agent = "Mozilla/5.0 (iPad; CPU OS 9_3 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13E237 Safari/601.1";
        OperatingSystem operatingSystem = OperatingSystem.parseUserAgentString(agent);
        assertEquals("iOS9_3_IPAD", operatingSystem.name());
    }

}
