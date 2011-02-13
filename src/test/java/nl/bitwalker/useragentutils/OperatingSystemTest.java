/*
* Copyright (c) 2008-2010, Harald Walker (bitwalker.nl) 
* All rights reserved.
* 
* Redistribution and use in source and binary forms, with or
* without modification, are permitted provided that the
* following conditions are met:
* 
* * Redistributions of source code must retain the above
* copyright notice, this list of conditions and the following
* disclaimer.
* 
* * Redistributions in binary form must reproduce the above
* copyright notice, this list of conditions and the following
* disclaimer in the documentation and/or other materials
* provided with the distribution.
* 
* * Neither the name of bitwalker nor the names of its
* contributors may be used to endorse or promote products
* derived from this software without specific prior written
* permission.
* 
* THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND
* CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
* INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
* MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
* DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
* CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
* SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
* NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
* LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
* HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
* CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
* OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
* SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package nl.bitwalker.useragentutils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author harald
 *
 */
public class OperatingSystemTest {

	String[] tablets = {
			"Mozilla/5.0 (Linux; U; Android 2.2; es-es; GT-P1000 Build/FROYO) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1",
			"Mozilla/5.0 (Linux; U; Android 2.2; en-us; SCH-I800 Build/FROYO) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1",
			"Mozilla/5.0 (iPad; U; CPU iPhone OS 3_2 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7D11"
	};
	
	String[] gameconsoles = {
			"Mozilla/5.0 (PLAYSTATION 3; 1.00)",
			"Opera/9.30 (Nintendo Wii; U; ; 2071; Wii Shop Channel/1.0; en)"
	};
	
	String[] windowsCEdivices = {
			"Mozilla/4.0 (compatible; MSIE 4.01; Windows CE; O2 Xda 2mini; PPC; 240x320)",
			"Mozilla/4.0 (compatible; MSIE 4.01; Windows CE; PPC; MDA Compact/1.0 Profile/MIDP-2.0 Configuration/CLDC-1.1",
			"HPiPAQhw6900/1.0/Mozilla/4.0 (compatible; MSIE 4.01; Windows CE; PPC; 240x240)",
			"Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 6.8) PPC; 240x320; HTC_P3300/1.0 Profile/MIDP-2.0 Configuration/CLDC-1.1",
			"PPC; 240x320; HTC_P3450/1.0 Profile/MIDP-2.0 Configuration/CLDC-1.1 Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 6.12)",
			"Mozilla/4.0 (compatible; MSIE 4.01; Windows CE; PPC; MDA compact/3.0 Profile/MIDP-2.0 Configuration/CLDC-1.1)",
			"Mozilla/4.0 (compatible; MSIE 4.01; Windows CE; PPC; MDA Vario/1.2 Profile/MIDP-2.0 Configuration/CLDC-1.1)",
			"HTC_S620 Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 6.12)",
			"HTCS620-Mozilla/4.0 (compatible; MSIE 4.01; Windows CE; Smartphone; 320x240)",
			"Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; PPC)",
			"SAMSUNG-SGH-i600/1.0 (compatible; MSIE 6.0; Windows CE; IEMobile 6.8)",
			"Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; Smartphone)",
			"HTC_TouchDual Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 7.6)",
			"Palm750/v0005 Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 7.6) UP.Link/6.3.0.0.0"
	};
	
	String[] palmOsDevices = {
			"Mozilla/4.0 (compatible; MSIE 6.0; Windows 98; PalmSource/Palm-TunX; Blazer/4.3) 16;320x320", // Palm LiveDrive
			"Mozilla/4.0 (compatible; MSIE 6.0; Windows 98; PalmSource/Palm-D050; Blazer/4.3) 16;320x320)", // Palm TX PDA
			"Mozilla/4.76 (compatible; MSIE 6.0; U; Windows 95; PalmSource; PalmOS; WebPro; Tungsten Proxyless 1.1 320x320x16)"
	};
	
	String[] webOS = {
			"Mozilla/5.0 (webOS/1.3; U; en-US) AppleWebKit/525.27.1 (KHTML, like Gecko) Version/1.0 Safari/525.27.1 Desktop/1.0",
			"Mozilla/5.0 (webOS/1.0; U; en-US) AppleWebKit/525.27.1 (KHTML, like Gecko) Version/1.0 Safari/525.27.1 Pre/1.0"
	};
	
	String[] symbian9phones = {
			"Mozilla/5.0 (SymbianOS/9.2; U; Series60/3.1 NokiaN95/10.0.018; Profile/MIDP-2.0 Configuration/CLDC-1.1 ) AppleWebKit/413 (KHTML, like Gecko) Safari/413",
			"Mozilla/5.0 (SymbianOS/9.1; U; en-us) AppleWebKit/413 (KHTML, like Gecko) Safari/413",
			// No symbian in string. from 3.0 on it is Symbian OS 9.
			"NokiaN80-3/1.0552.0.7Series60/3.0Profile/MIDP-2.0Configuration/CLDC-1.1",
			"NokiaN73-1/3.0638.0.0.1 Series60/3.0 Profile/MIDP-2.0 Configuration/CLDC-1.1",
			"Mozilla/5.0 (SymbianOS/9.2; U; Series60/3.1 NokiaE90-1/07.40.1.2; Profile/MIDP-2.0 Configuration/CLDC-1.1 ) AppleWebKit/413 (KHTML, like Gecko) Safari/413"
	}; 
	
	String[] symbian8phones = {
			// No Symbian in string, but we know, that 2.6. and 2.8 are Symbian OS 8 phones.
			"NokiaN90-1/3.0545.5.1 Series60/2.8 Profile/MIDP-2.0 Configuration/CLDC-1.1" 			
	}; 
	
	String[] symbian7phones = {	
			"Nokia3230/2.0 (5.0614.0) SymbianOS/7.0s Series60/2.1 Profile/MIDP-2.0Configuration/CLDC-1.0"
	};
	
	String[] symbianPhones = {
			// One of the SE phones with Symbian OS
			"SonyEricssonP1i/R100 Mozilla/4.0 (compatible; MSIE 6.0; Symbian OS; 661) Opera 8.65 [nl]"
	};
	
	String[] sonyEricssonPhones = {
			"SonyEricssonK550i/R1JD Browser/NetFront/3.3 Profile/MIDP-2.0 Configuration/CLDC-1.1",
			"SonyEricssonK610i/R1CB Browser/NetFront/3.3 Profile/MIDP-2.0 Configuration/CLDC-1.1"
	};
	
	String[] iPhones = 
	{
			"Mozilla/5.0 (iPhone; U; CPU like Mac OS X; nl-nl) AppleWebKit/420.1 (KHTML, like Gecko)",
			"Mozilla/5.0 (iPhone; U; CPU like Mac OS X; en) AppleWebKit/420+ (KHTML, like Gecko)",
			"Mozilla/5.0 (iPhone; U; CPU like Mac OS X; en) AppleWebKit/420.1 (KHTML, like Gecko) Version/3.0 Mobile/4A93 Safari/419.3"
	};
	
	String[] iPhone4 = 
	{
			"Mozilla/5.0 (iPhone Simulator; U; CPU iPhone OS 4_0 like Mac OS X; en-us) AppleWebKit/532.9 (KHTML, like Gecko) Version/4.0.5 Mobile/8A293 Safari/6531.22.7",
			"Mozilla/5.0 (iPhone; U; CPU iPhone OS 4_0 like Mac OS X; en-us) AppleWebKit/532.9 (KHTML, like Gecko) Version/4.0.5 Mobile/8A293 Safari/6531.22.7"
	};
	
	String[] iPods = {
			"Mozilla/5.0 (iPod; U; CPU like Mac OS X; nl-nl) AppleWebKit/420.1 (KHTML, like Gecko)",
			"Mozilla/5.0 (iPod; U; CPU like Mac OS X; en) AppleWebKit/420.1 (KHTML, like Gecko)",
			"Mozilla/5.0 (iPod; U; CPU like Mac OS X; en) AppleWebKit/420.1 (KHTML, like Gecko) Version/3.0 Mobile/3A101a Safari/419.3"
	};
	
	String[] iPad = {
			"Mozilla/5.0 (iPad; U; CPU OS 3_2 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Version/4.0.4 Mobile/7B367 Safari/531.21.10", // final iPad Simulator
			"Mozilla/5.0 (iPad; U; CPU OS 3_2 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Version/4.0.4 Mobile/7B334b Safari/531.21.10",
			"Mozilla/5.0 (iPad; U; CPU OS 4_2_1 like Mac OS X; ja-jp) AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8C148 Safari/6533.18.5"
	};
	
	String[] blackberries = {
				"BlackBerry8700/4.1.0 Profile/MIDP-2.0 Configuration/CLDC-1.1 VendorID/150",
				"BlackBerry8707/4.1.0 Profile/MIDP-2.0 Configuration/CLDC-1.1 VendorID/139",
				"BlackBerry7290/4.0.2 Profile/MIDP-2.0 Configuration/CLDC-1.1",
				"BlackBerry8310/4.2.2 Profile/MIDP-2.0 Configuration/CLDC-1.1 VendorID/120",
				"BlackBerry8100/4.2.0 Profile/MIDP-2.0 Configuration/CLDC-1.1 VendorID/150"			
	};
	
	String[] blackberry6 = {
			"Mozilla/5.0 (BlackBerry; U; BlackBerry 9800; en-US) AppleWebKit/534.1+ (KHTML, like Gecko) Version/6.0.0.141 Mobile Safari/534.1+"
	};

	String[] android1g = {
			"Mozilla/5.0 (Linux; U; Android 1.6; nl-nl; T-Mobile G1 Build/DRC92) AppleWebKit/528.5+ (KHTML, like Gecko) Version/3.1.2 Mobile Safari/525.20.1",
			"Mozilla/5.0 (Linux; U; Android 1.5; nl-nl; HTC Hero Build/CUPCAKE) AppleWebKit/528.5+ (KHTML, like Gecko) Version/3.1.2 Mobile Safari/525.20.1"
	};
	
	String[] android2g = {
			"Mozilla/5.0 (Linux; U; Android 2.1; en-gb; Nexus One Build/ERD79) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Mobile Safari/530.17",
			"Mozilla/5.0 (Linux; U; Android 2.0; en-gb; Milestone Build/SHOLS_U2_01.03.1) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Mobile Safari/530.17"
	};
	
	String[] windows98 = { 
			"Mozilla/4.0 (compatible; MSIE 6.0; Windows 98; Rogers Hi·Speed Internet; (R1 1.3))",
			"Mozilla/5.0 (Windows; U; Win98; en-US; rv:1.8b3) Gecko/20050713 SeaMonkey/1.0a"
	};	
	
	String[] windowsXP = {
			"Mozilla/5.0 (Windows; U; Windows NT 5.1; de; rv:1.9.2.8) Gecko/20100722 Firefox/3.6.8 ( .NET CLR 3.5.30729)",
			"Mozilla/5.0 (compatible; MSIE 7.0; Windows NT 5.2; WOW64; .NET CLR 2.0.50727)"
	};
	
	String[] windowsVista = {
			"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; SLCC1; .NET CLR 2.0.50727; .NET CLR 3.0.04506)"
	};
	
	String[] windows7 = {
			"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.1; WOW64; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; MDDC; MSOffice 12)",
			"Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; Trident/4.0; Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1) ; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; Media Center PC 5.0; SLCC1; InfoPath.2)"
	};
	
	String[] windowsMobile7 = {
			"Mozilla/4.0 (compatible; MSIE 7.0; Windows Phone OS 7.0; Trident/3.1; IEMobile/7.0) Asus;Galaxy6"
	};
	
	String[] maemo = {
			"Mozilla/5.0 (X11; U; Linux armv7l; en-US; rv:1.9.2a1pre) Gecko/20091127 Firefox/3.5 Maemo Browser 1.5.6 RX-51 N900"
	};
	
	/**
	 * Test method for {@link nl.bitwalker.useragentutils.OperatingSystem#isInUserAgentString(java.lang.String)}.
	 */
	@Test
	public void testIsInUserAgentString() {
		assertTrue(OperatingSystem.SYMBIAN9.isInUserAgentString(symbian9phones[0]));
	}

	/**
	 * Test method for {@link nl.bitwalker.useragentutils.OperatingSystem#parseUserAgentString(java.lang.String)}.
	 */
	@Test
	public void testParseUserAgentString() {
		testAgents(windowsCEdivices, OperatingSystem.WINDOWS_MOBILE);
		testAgents(windowsMobile7, OperatingSystem.WINDOWS_MOBILE7);
		testAgents(windowsVista, OperatingSystem.WINDOWS_VISTA);
		testAgents(windows7, OperatingSystem.WINDOWS_7);
		testAgents(windowsXP, OperatingSystem.WINDOWS_XP);
		testAgents(windows98, OperatingSystem.WINDOWS_98);
		testAgents(palmOsDevices, OperatingSystem.PALM);
		testAgents(webOS, OperatingSystem.WEBOS);
		testAgents(symbian9phones, OperatingSystem.SYMBIAN9);
		testAgents(symbian8phones, OperatingSystem.SYMBIAN8);
		testAgents(symbian7phones, OperatingSystem.SYMBIAN7);
		testAgents(symbianPhones, OperatingSystem.SYMBIAN);
		testAgents(sonyEricssonPhones, OperatingSystem.SONY_ERICSSON);
		testAgents(iPhones, OperatingSystem.MAC_OS_X_IPHONE);
		testAgents(iPhone4, OperatingSystem.iOS4_IPHONE);
		testAgents(iPods, OperatingSystem.MAC_OS_X_IPOD);
		testAgents(iPad, OperatingSystem.MAC_OS_X_IPAD);
		testAgents(blackberries, OperatingSystem.BLACKBERRY);
		testAgents(blackberry6, OperatingSystem.BLACKBERRY6);
		testAgents(android1g, OperatingSystem.ANDROID1);
		testAgents(android2g, OperatingSystem.ANDROID2);
		testAgents(maemo, OperatingSystem.MAEMO);
	}
	
	@Test
	public void testDeviceTypes() {
		testDeviceTypes(windowsCEdivices, DeviceType.MOBILE);
		testDeviceTypes(windowsMobile7, DeviceType.MOBILE);
		testDeviceTypes(windowsVista, DeviceType.COMPUTER);
		testDeviceTypes(palmOsDevices, DeviceType.MOBILE);
		testDeviceTypes(tablets, DeviceType.TABLET);
		testDeviceTypes(gameconsoles, DeviceType.GAME_CONSOLE);
	}
	
	public void testGroupRecursion() {
		assertEquals(OperatingSystem.ANDROID2_TABLET.getGroup(),OperatingSystem.ANDROID); // 2 levels deep
		assertEquals(OperatingSystem.BLACKBERRY6.getGroup(),OperatingSystem.BLACKBERRY); // one level
		assertEquals(OperatingSystem.MAC_OS.getGroup(),OperatingSystem.MAC_OS); // no children
	}

	/**
	 * Test method for {@link nl.bitwalker.useragentutils.OperatingSystem#valueOf(short)} 
	 */
	@Test
	public void testValueOf() {
		OperatingSystem operatingSystem = OperatingSystem.parseUserAgentString(symbian9phones[0]);
		assertEquals(OperatingSystem.valueOf(operatingSystem.getId()), operatingSystem);	
		try
		{
			operatingSystem = OperatingSystem.valueOf((short)0);
			fail("Should have thrown IllegalArgumentException");			
		}
		catch (IllegalArgumentException e)
		{
			// good
		}
	}
	
	/**
	 * Test method for {@link nl.bitwalker.useragentutils.OperatingSystem#valueOf(String)} 
	 */
	@Test
	public void testValueOfString() {
		OperatingSystem operatingSystem = OperatingSystem.parseUserAgentString(symbian9phones[0]);
		assertEquals(OperatingSystem.valueOf(operatingSystem.toString()), operatingSystem);	
		try
		{
			operatingSystem = OperatingSystem.valueOf("illegal");
			fail("Should have thrown IllegalArgumentException");			
		}
		catch (IllegalArgumentException e)
		{
			// good
		}
	}
	
	/**
	 * Test if generated id values are unique.
	 */
	@Test
	public void testUniqueIdValues() {
		
		List<Short> retrievedIdValues = new ArrayList<Short>();
		
		for (OperatingSystem operatingSystem : OperatingSystem.values())
		{
			assertTrue(!retrievedIdValues.contains(operatingSystem.getId()));
			retrievedIdValues.add(operatingSystem.getId());
		}
		
	}
	
	private void testDeviceTypes(String[] agentStrings, DeviceType expectedDeviceType)
	{
		for (String agentString : agentStrings)
		{
			assertEquals(expectedDeviceType, OperatingSystem.parseUserAgentString(agentString).getDeviceType());
		}		
	}
	
	private void testAgents(String[] agentStrings, OperatingSystem expectedOperatingSystem)
	{
		for (String agentString : agentStrings)
		{
			assertEquals(expectedOperatingSystem, OperatingSystem.parseUserAgentString(agentString));
		}		
	}

}
