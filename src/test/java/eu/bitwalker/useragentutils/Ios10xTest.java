package eu.bitwalker.useragentutils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Ios10xTest {
	
	@Test
    public void testIphone10() {
        String agent = "Mozilla/5.0 (iPhone; CPU iPhone OS 10 like Mac OS X) AppleWebKit/602.1.4 (KHTML, like Gecko) Mobile/14B100";
        OperatingSystem operatingSystem = OperatingSystem.parseUserAgentString(agent);
        assertEquals("iOS10_IPHONE", operatingSystem.name());
    }
	
    @Test
    public void testIphone10_0() {
        String agent = "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.4 (KHTML, like Gecko) Mobile/14B100";
        OperatingSystem operatingSystem = OperatingSystem.parseUserAgentString(agent);
        assertEquals("iOS10_0_IPHONE", operatingSystem.name());
    }
    
    @Test
    public void testIphone10_0_2() {
        String agent = "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0_2 like Mac OS X) AppleWebKit/602.1.4 (KHTML, like Gecko) Mobile/14B100";
        OperatingSystem operatingSystem = OperatingSystem.parseUserAgentString(agent);
        assertEquals("iOS10_0_IPHONE", operatingSystem.name());
    }
    
    @Test
    public void testIphone10_0_3() {
        String agent = "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0_3 like Mac OS X) AppleWebKit/602.1.4 (KHTML, like Gecko) Mobile/14B100";
        OperatingSystem operatingSystem = OperatingSystem.parseUserAgentString(agent);
        assertEquals("iOS10_0_IPHONE", operatingSystem.name());
    }
    
    @Test
    public void testIphone10_1() {
        String agent = "Mozilla/5.0 (iPhone; CPU iPhone OS 10_1 like Mac OS X) AppleWebKit/602.1.4 (KHTML, like Gecko) Mobile/14B100";
        OperatingSystem operatingSystem = OperatingSystem.parseUserAgentString(agent);
        assertEquals("iOS10_1_IPHONE", operatingSystem.name());
    }
    
    @Test
    public void testIphone10_1_1() {
        String agent = "Mozilla/5.0 (iPhone; CPU iPhone OS 10_1_1 like Mac OS X) AppleWebKit/602.1.4 (KHTML, like Gecko) Mobile/14B100";
        OperatingSystem operatingSystem = OperatingSystem.parseUserAgentString(agent);
        assertEquals("iOS10_1_IPHONE", operatingSystem.name());
    }
    
    @Test
    public void testIphone10_2() {
        String agent = "Mozilla/5.0 (iPhone; CPU iPhone OS 10_2 like Mac OS X) AppleWebKit/602.1.4 (KHTML, like Gecko) Mobile/14B100";
        OperatingSystem operatingSystem = OperatingSystem.parseUserAgentString(agent);
        assertEquals("iOS10_2_IPHONE", operatingSystem.name());
    }
    
    @Test
    public void testIpad10() {
        String agent = "Mozilla/5.0 (iPad; CPU OS 10 like Mac OS X) AppleWebKit/602.1.4 (KHTML, like Gecko) Mobile/14B100";
        OperatingSystem operatingSystem = OperatingSystem.parseUserAgentString(agent);
        assertEquals("iOS10_IPAD", operatingSystem.name());
    }
    
    @Test
    public void testIpad10_0() {
        String agent = "Mozilla/5.0 (iPad; CPU OS 10_0 like Mac OS X) AppleWebKit/602.1.4 (KHTML, like Gecko) Mobile/14B100";
        OperatingSystem operatingSystem = OperatingSystem.parseUserAgentString(agent);
        assertEquals("iOS10_0_IPAD", operatingSystem.name());
    }
    
    @Test
    public void testIpad10_0_2() {
        String agent = "Mozilla/5.0 (iPad; CPU OS 10_0_2 like Mac OS X) AppleWebKit/602.1.4 (KHTML, like Gecko) Mobile/14B100";
        OperatingSystem operatingSystem = OperatingSystem.parseUserAgentString(agent);
        assertEquals("iOS10_0_IPAD", operatingSystem.name());
    }
    
    @Test
    public void testIpad10_0_3() {
        String agent = "Mozilla/5.0 (iPad; CPU OS 10_0_3 like Mac OS X) AppleWebKit/602.1.4 (KHTML, like Gecko) Mobile/14B100";
        OperatingSystem operatingSystem = OperatingSystem.parseUserAgentString(agent);
        assertEquals("iOS10_0_IPAD", operatingSystem.name());
    }
    
    @Test
    public void testIpad10_1() {
        String agent = "Mozilla/5.0 (iPad; CPU OS 10_1 like Mac OS X) AppleWebKit/602.1.4 (KHTML, like Gecko) Mobile/14B100";
        OperatingSystem operatingSystem = OperatingSystem.parseUserAgentString(agent);
        assertEquals("iOS10_1_IPAD", operatingSystem.name());
    }
    
    @Test
    public void testIpad10_1_1() {
        String agent = "Mozilla/5.0 (iPad; CPU OS 10_1_1 like Mac OS X) AppleWebKit/602.1.4 (KHTML, like Gecko) Mobile/14B100";
        OperatingSystem operatingSystem = OperatingSystem.parseUserAgentString(agent);
        assertEquals("iOS10_1_IPAD", operatingSystem.name());
    }
    
    @Test
    public void testIpad10_2() {
        String agent = "Mozilla/5.0 (iPad; CPU OS 10_2 like Mac OS X) AppleWebKit/602.1.4 (KHTML, like Gecko) Mobile/14B100";
        OperatingSystem operatingSystem = OperatingSystem.parseUserAgentString(agent);
        assertEquals("iOS10_2_IPAD", operatingSystem.name());
    }
}
