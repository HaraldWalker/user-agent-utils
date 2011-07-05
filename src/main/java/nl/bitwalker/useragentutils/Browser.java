/*
* Copyright (c) 2011, Harald Walker (bitwalker.nl) 
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

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Enum constants for most common browsers, including e-mail clients and bots.
 * @author harald
 * 
 */

public enum Browser {

	OPERA(			Manufacturer.OPERA, null, 1, "Opera", new String[] { "Opera" }, null, BrowserType.WEB_BROWSER, RenderingEngine.PRESTO, "Opera\\/(([\\d]+)\\.([\\w]+))"),   // before MSIE
	OPERA_MINI(		Manufacturer.OPERA, Browser.OPERA, 20, "Opera Mini", new String[] { "Opera Mini"}, null, BrowserType.MOBILE_BROWSER, RenderingEngine.PRESTO, null), // Opera for mobile devices
	/**
	 * For some strange reason Opera uses 9.80 in the user-agent string.
	 */
	OPERA10(		Manufacturer.OPERA, Browser.OPERA, 10, "Opera 10", new String[] { "Opera/9.8" }, null, BrowserType.WEB_BROWSER, RenderingEngine.PRESTO, "Version\\/(([\\d]+)\\.([\\w]+))"),  
	OPERA9(			Manufacturer.OPERA, Browser.OPERA, 5, "Opera 9", new String[] { "Opera/9" }, null, BrowserType.WEB_BROWSER, RenderingEngine.PRESTO, null),  
	KONQUEROR(		Manufacturer.OTHER, null, 1, "Konqueror", new String[] { "Konqueror"}, null, BrowserType.WEB_BROWSER, RenderingEngine.KHTML, "Konqueror\\/(([0-9]+)\\.?([\\w]+)?(-[\\w]+)?)" ),  

	/**
	 * Outlook email client
	 */
	OUTLOOK(	Manufacturer.MICROSOFT, null, 100, "Outlook", new String[] {"MSOffice"}, null, BrowserType.EMAIL_CLIENT, RenderingEngine.WORD, "MSOffice (([0-9]+))"), // before IE7
	/**
	 * Microsoft Outlook 2007 identifies itself as MSIE7 but uses the html rendering engine of Word 2007.
	 * Example user agent: Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; SLCC1; .NET CLR 2.0.50727; .NET CLR 3.0.04506; .NET CLR 1.1.4322; MSOffice 12)
	 */
	OUTLOOK2007(	Manufacturer.MICROSOFT, Browser.OUTLOOK, 107, "Outlook 2007", new String[] {"MSOffice 12"}, null, BrowserType.EMAIL_CLIENT, RenderingEngine.WORD, null), // before IE7
	/**
	 * Outlook 2010 is still using the rendering engine of Word. http://www.fixoutlook.org
	 */
	OUTLOOK2010(	Manufacturer.MICROSOFT, Browser.OUTLOOK, 108, "Outlook 2010", new String[] {"MSOffice 14"}, null, BrowserType.EMAIL_CLIENT, RenderingEngine.WORD, null), // before IE7

	/**
	 * Family of Internet Explorer browsers
	 */
	IE( 			Manufacturer.MICROSOFT, null, 1, "Internet Explorer", new String[] { "MSIE"}, null, BrowserType.WEB_BROWSER, RenderingEngine.TRIDENT, "MSIE (([\\d]+)\\.([\\w]+))" ), // before Mozilla
	/**
	 * Since version 7 Outlook Express is identifying itself. By detecting Outlook Express we can not 
	 * identify the Internet Explorer version which is probably used for the rendering.
	 * Obviously this product is now called Windows Live Mail Desktop or just Windows Live Mail.
	 */
	OUTLOOK_EXPRESS7(	Manufacturer.MICROSOFT, Browser.IE, 110, "Windows Live Mail", new String[] {"Outlook-Express/7.0"}, null, BrowserType.EMAIL_CLIENT, RenderingEngine.TRIDENT, null), // before IE7, previously known as Outlook Express. First released in 2006, offered with different name later
	/**
	 * Since 2007 the mobile edition of Internet Explorer identifies itself as IEMobile in the user-agent. 
	 * If previous versions have to be detected, use the operating system information as well.
	 */
	IEMOBILE9(		Manufacturer.MICROSOFT, Browser.IE, 123, "IE Mobile 9", new String[] { "IEMobile/9" }, null, BrowserType.MOBILE_BROWSER, RenderingEngine.TRIDENT, null), // before MSIE strings
	IEMOBILE7(		Manufacturer.MICROSOFT, Browser.IE, 121, "IE Mobile 7", new String[] { "IEMobile 7" }, null, BrowserType.MOBILE_BROWSER, RenderingEngine.TRIDENT, null), // before MSIE strings
	IEMOBILE6(		Manufacturer.MICROSOFT, Browser.IE, 120, "IE Mobile 6", new String[] { "IEMobile 6" }, null, BrowserType.MOBILE_BROWSER, RenderingEngine.TRIDENT, null), // before MSIE
	IE9(			Manufacturer.MICROSOFT, Browser.IE, 90, "Internet Explorer 9", new String[] { "MSIE 9" }, null, BrowserType.WEB_BROWSER, RenderingEngine.TRIDENT, null ),   // before MSIE
	IE8(			Manufacturer.MICROSOFT, Browser.IE, 80, "Internet Explorer 8", new String[] { "MSIE 8" }, null, BrowserType.WEB_BROWSER, RenderingEngine.TRIDENT, null ),   // before MSIE
	IE7(			Manufacturer.MICROSOFT, Browser.IE, 70, "Internet Explorer 7", new String[] { "MSIE 7" }, null, BrowserType.WEB_BROWSER, RenderingEngine.TRIDENT, null),   // before MSIE
	IE6(			Manufacturer.MICROSOFT, Browser.IE, 60, "Internet Explorer 6", new String[] { "MSIE 6" }, null, BrowserType.WEB_BROWSER, RenderingEngine.TRIDENT, null ),   // before MSIE
	IE5_5(			Manufacturer.MICROSOFT, Browser.IE, 55, "Internet Explorer 5.5", new String[] { "MSIE 5.5" }, null, BrowserType.WEB_BROWSER, RenderingEngine.TRIDENT, null), // before MSIE
	IE5(			Manufacturer.MICROSOFT, Browser.IE, 50, "Internet Explorer 5", new String[] { "MSIE 5" }, null, BrowserType.WEB_BROWSER, RenderingEngine.TRIDENT, null ), // before MSIE

	/**
	 * Google Chrome browser
	 */
	CHROME( 		Manufacturer.GOOGLE, null, 1, "Chrome", new String[] { "Chrome" }, null, BrowserType.WEB_BROWSER, RenderingEngine.WEBKIT, "Chrome\\/(([0-9]+)\\.?([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)" ), // before Mozilla
	CHROME10( 		Manufacturer.GOOGLE, Browser.CHROME, 15, "Chrome 10", new String[] { "Chrome/10" }, null, BrowserType.WEB_BROWSER, RenderingEngine.WEBKIT, null ), // before Mozilla
	CHROME9( 		Manufacturer.GOOGLE, Browser.CHROME, 10, "Chrome 9", new String[] { "Chrome/9" }, null, BrowserType.WEB_BROWSER, RenderingEngine.WEBKIT, null ), // before Mozilla
	CHROME8( 		Manufacturer.GOOGLE, Browser.CHROME, 5, "Chrome 8", new String[] { "Chrome/8" }, null, BrowserType.WEB_BROWSER, RenderingEngine.WEBKIT, null ), // before Mozilla

	OMNIWEB(		Manufacturer.OTHER, null, 2, "Omniweb", new String[] { "OmniWeb" }, null, BrowserType.WEB_BROWSER, RenderingEngine.WEBKIT, null), // 

	SAFARI(			Manufacturer.APPLE, null, 1, "Safari", new String[] { "Safari" }, null, BrowserType.WEB_BROWSER, RenderingEngine.WEBKIT, "Version\\/(([0-9]+)\\.?([\\w]+)?(\\.[\\w]+)?)" ),  // before AppleWebKit
	SAFARI5(		Manufacturer.APPLE, Browser.SAFARI, 3, "Safari 5", new String[] { "Version/5" }, null, BrowserType.WEB_BROWSER, RenderingEngine.WEBKIT, null ),  // before AppleWebKit
	MOBILE_SAFARI(	Manufacturer.APPLE, Browser.SAFARI, 2, "Mobile Safari", new String[] { "Mobile Safari","Mobile/" }, null, BrowserType.MOBILE_BROWSER, RenderingEngine.WEBKIT, null ),  // before Safari
	SAFARI4(		Manufacturer.APPLE, Browser.SAFARI, 4, "Safari 4", new String[] { "Version/4" }, null, BrowserType.WEB_BROWSER, RenderingEngine.WEBKIT, null ),  // before AppleWebKit

	DOLFIN2( 		Manufacturer.SAMSUNG, null, 1, "Samsung Dolphin 2", new String[] { "Dolfin/2" }, null, BrowserType.MOBILE_BROWSER, RenderingEngine.WEBKIT, null ), // webkit based browser for the bada os
	
	APPLE_MAIL(		Manufacturer.APPLE, null, 50, "Apple Mail", new String[] { "AppleWebKit" }, null, BrowserType.EMAIL_CLIENT, RenderingEngine.WEBKIT, null), // Microsoft Entrourage/Outlook 2010 also only identifies itself as AppleWebKit 
	LOTUS_NOTES( 	Manufacturer.OTHER, null, 3, "Lotus Notes", new String[] { "Lotus-Notes" }, null, BrowserType.EMAIL_CLIENT, RenderingEngine.OTHER, "Lotus-Notes\\/(([\\d]+)\\.([\\w]+))"),  // before Mozilla

	/*
	 * Thunderbird email client, based on the same Gecko engine Firefox is using.
	 */
	THUNDERBIRD( 	Manufacturer.MOZILLA, null, 110, "Thunderbird", new String[] { "Thunderbird" }, null, BrowserType.EMAIL_CLIENT, RenderingEngine.GECKO, "Thunderbird\\/(([0-9]+)\\.?([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)" ),  // using Gecko Engine
	THUNDERBIRD3(  	Manufacturer.MOZILLA, Browser.THUNDERBIRD, 130, "Thunderbird 3", new String[] { "Thunderbird/3" }, null, BrowserType.EMAIL_CLIENT, RenderingEngine.GECKO, null ),  // using Gecko Engine
	THUNDERBIRD2(  	Manufacturer.MOZILLA, Browser.THUNDERBIRD, 120, "Thunderbird 2", new String[] { "Thunderbird/2" }, null, BrowserType.EMAIL_CLIENT, RenderingEngine.GECKO, null ),  // using Gecko Engine

	CAMINO(			Manufacturer.OTHER, null, 5, "Camino", new String[] { "Camino" }, null, BrowserType.WEB_BROWSER, RenderingEngine.GECKO, "Camino\\/(([0-9]+)\\.?([\\w]+)?(\\.[\\w]+)?)" ),  // using Gecko Engine
	CAMINO2(		Manufacturer.OTHER, Browser.CAMINO, 17, "Camino 2", new String[] { "Camino/2" }, null, BrowserType.WEB_BROWSER, RenderingEngine.GECKO, null ),  // using Gecko Engine
	FLOCK(			Manufacturer.OTHER, null, 4, "Flock", new String[]{"Flock"}, null, BrowserType.WEB_BROWSER, RenderingEngine.GECKO, "Flock\\/(([0-9]+)\\.?([\\w]+)?(\\.[\\w]+)?)"),
	
	FIREFOX(		Manufacturer.MOZILLA, null, 10, "Firefox", new String[] { "Firefox" }, null, BrowserType.WEB_BROWSER, RenderingEngine.GECKO, "Firefox\\/(([0-9]+)\\.?([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)"),  // using Gecko Engine
	FIREFOX3MOBILE(	Manufacturer.MOZILLA, Browser.FIREFOX, 31, "Firefox 3 Mobile", new String[] { "Firefox/3.5 Maemo" }, null, BrowserType.MOBILE_BROWSER, RenderingEngine.GECKO, null ),  // using Gecko Engine
	FIREFOX5(		Manufacturer.MOZILLA, Browser.FIREFOX, 50, "Firefox 5", new String[] { "Firefox/5" }, null, BrowserType.WEB_BROWSER, RenderingEngine.GECKO, null ),  // using Gecko Engine
	FIREFOX4(		Manufacturer.MOZILLA, Browser.FIREFOX, 40, "Firefox 4", new String[] { "Firefox/4" }, null, BrowserType.WEB_BROWSER, RenderingEngine.GECKO, null ),  // using Gecko Engine
	FIREFOX3(		Manufacturer.MOZILLA, Browser.FIREFOX, 30, "Firefox 3", new String[] { "Firefox/3" }, null, BrowserType.WEB_BROWSER, RenderingEngine.GECKO, null ),  // using Gecko Engine
	FIREFOX2(		Manufacturer.MOZILLA, Browser.FIREFOX, 20, "Firefox 2", new String[] { "Firefox/2" }, null, BrowserType.WEB_BROWSER, RenderingEngine.GECKO, null ),  // using Gecko Engine
	FIREFOX1_5(		Manufacturer.MOZILLA, Browser.FIREFOX, 15, "Firefox 1.5", new String[] { "Firefox/1.5" }, null, BrowserType.WEB_BROWSER, RenderingEngine.GECKO, null ),  // using Gecko Engine
	
	SEAMONKEY(		Manufacturer.OTHER, null, 15, "SeaMonkey", new String[]{"SeaMonkey"}, null, BrowserType.WEB_BROWSER, RenderingEngine.GECKO, "SeaMonkey\\/(([0-9]+)\\.?([\\w]+)?(\\.[\\w]+)?)"), // using Gecko Engine
	
	BOT(			Manufacturer.OTHER, null,12, "Robot/Spider", new String[]{"Googlebot","bot", "spider", "crawler", "Feedfetcher", "Slurp", "Twiceler", "Nutch", "BecomeBot"}, null, BrowserType.ROBOT, RenderingEngine.OTHER, null),
	
	MOZILLA(		Manufacturer.MOZILLA, null, 1, "Mozilla", new String[] { "Mozilla", "Moozilla" }, null, BrowserType.WEB_BROWSER, RenderingEngine.OTHER, null), // rest of the mozilla browsers
	
	CFNETWORK(		Manufacturer.OTHER, null, 6, "CFNetwork", new String[] { "CFNetwork" }, null, BrowserType.UNKNOWN, RenderingEngine.OTHER, null ), // Mac OS X cocoa library
	
	EUDORA(			Manufacturer.OTHER, null, 7, "Eudora", new String[] { "Eudora", "EUDORA" }, null, BrowserType.EMAIL_CLIENT, RenderingEngine.OTHER, null ),  // email client by Qualcomm
	
	POCOMAIL(		Manufacturer.OTHER, null, 8, "PocoMail", new String[] { "PocoMail" }, null, BrowserType.EMAIL_CLIENT, RenderingEngine.OTHER, null ),
	
	THEBAT(			Manufacturer.OTHER, null, 9, "The Bat!", new String[]{"The Bat"}, null, BrowserType.EMAIL_CLIENT, RenderingEngine.OTHER, null), // Email Client
	
	NETFRONT(		Manufacturer.OTHER, null, 10, "NetFront", new String[]{"NetFront"}, null, BrowserType.MOBILE_BROWSER, RenderingEngine.OTHER, null), // mobile device browser
	
	EVOLUTION(		Manufacturer.OTHER, null, 11, "Evolution", new String[]{"CamelHttpStream"}, null, BrowserType.EMAIL_CLIENT, RenderingEngine.OTHER, null), // http://www.go-evolution.org/Camel.Stream
    
	LYNX(			Manufacturer.OTHER, null, 13, "Lynx", new String[]{"Lynx"}, null, BrowserType.TEXT_BROWSER, RenderingEngine.OTHER, "Lynx\\/(([0-9]+)\\.([\\d]+)\\.?([\\w-+]+)?\\.?([\\w-+]+)?)"),
    
	DOWNLOAD(   	Manufacturer.OTHER, null, 16, "Downloading Tool", new String[]{"cURL","wget"}, null, BrowserType.TEXT_BROWSER, RenderingEngine.OTHER, null),
    
	UNKNOWN(		Manufacturer.OTHER, null, 14, "Unknown", new String[0], null, BrowserType.UNKNOWN, RenderingEngine.OTHER, null ); 
	
	
	private final short id;
	private final String name;
	private final String[] aliases;
	private final String[] excludeList; // don't match when these values are in the agent-string
	private final BrowserType browserType;
	private final Manufacturer manufacturer;
	private final RenderingEngine renderingEngine;
	private final Browser parent;
	private List<Browser> children;
	private Pattern versionRegEx;
	
	private Browser(Manufacturer manufacturer, Browser parent, int versionId, String name, String[] aliases, String[] exclude, BrowserType browserType, RenderingEngine renderingEngine, String versionRegexString) {
		this.id =  (short) ( ( manufacturer.getId() << 8) + (byte) versionId);
		this.name = name;
		this.parent = parent;
		this.children = new ArrayList<Browser>();
		if (this.parent != null) {
			this.parent.children.add(this);
		}
		this.aliases = aliases;
		this.excludeList = exclude;
		this.browserType = browserType;
		this.manufacturer = manufacturer;
		this.renderingEngine = renderingEngine;
		if (versionRegexString != null) {
			this.versionRegEx = Pattern.compile(versionRegexString);
		}
	}
	
	public short getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	private Pattern getVersionRegEx() {
		if (this.versionRegEx == null) {
			if (this.getGroup() != this)
				return this.getGroup().getVersionRegEx();
			else
				return null;
		}
		return this.versionRegEx;
	}
	
	/**
	 * Detects the detailed version information of the browser. Depends on the userAgent to be available. 
	 * Returns null if it can not detect the version information.
	 * @return Version
	 */
	public Version getVersion(String userAgentString) {
		Pattern pattern = this.getVersionRegEx();
		if (userAgentString != null && pattern != null) {
			Matcher matcher = pattern.matcher(userAgentString);
			if (matcher.find()) {
				String fullVersionString = matcher.group(1);
				String majorVersion = matcher.group(2);
				String minorVersion = "0";
				if (matcher.groupCount() > 2) // usually but not always there is a minor version
					minorVersion = matcher.group(3);
				return new Version (fullVersionString,majorVersion,minorVersion);
			}
		}
		return null;
	}
	
	/**
	 * @return the browserType
	 */
	public BrowserType getBrowserType() {
		return browserType;
	}

	/**
	 * @return the manufacturer
	 */
	public Manufacturer getManufacturer() {
		return manufacturer;
	}
	
	/**
	 * @return the rendering engine
	 */
	public RenderingEngine getRenderingEngine() {
		return renderingEngine;
	}

	/**
	 * @return top level browser family
	 */
	public Browser getGroup() {
		if (this.parent != null) {
			return parent.getGroup();
		}
		return this;
	}

	/*
	 * Checks if the given user-agent string matches to the browser. 
	 * Only checks for one specific browser. 
	 */
	public boolean isInUserAgentString(String agentString)
	{
		for (String alias : aliases)
		{
			if (agentString.toLowerCase().indexOf(alias.toLowerCase()) != -1)
				return true;
		}
		return false;
	}
	
	/**
	 * Checks if the given user-agent does not contain one of the tokens which should not match.
	 * In most cases there are no excluding tokens, so the impact should be small.
	 * @param agentString
	 * @return
	 */
	private boolean containsExcludeToken(String agentString)
	{
		if (excludeList != null) {
			for (String exclude : excludeList) {
				if (agentString.toLowerCase().indexOf(exclude.toLowerCase()) != -1)
					return true;
			}
		}
		return false;
	}
	
	private Browser checkUserAgent(String agentString) {
		if (this.isInUserAgentString(agentString)) {
			if (this.children.size() > 0) {
				for (Browser childBrowser : this.children) {
					Browser match = childBrowser.checkUserAgent(agentString);
					if (match != null) { 
						return match;
					}
				}
			}
			// if children didn't match we continue checking the current to prevent false positives
			if (!this.containsExcludeToken(agentString)) {
				return this;
			}
			
		}
		return null;
	}
	
	/**
	 * Iterates over all Browsers to compare the browser signature with 
	 * the user agent string. If no match can be found Browser.UNKNOWN will
	 * be returned.
	 * @param agentString
	 * @return Browser
	 */
	public static Browser parseUserAgentString(String agentString)
	{
		for (Browser browser : Browser.values())
		{
			// only check top level objects
			if (browser.parent == null) {
				Browser match = browser.checkUserAgent(agentString);
				if (match != null) {
					return match; // either current operatingSystem or a child object
				}
			}
		}
		return Browser.UNKNOWN;
	}
		
	/**
	 * Returns the enum constant of this type with the specified id.
	 * Throws IllegalArgumentException if the value does not exist.
	 * @param id
	 * @return 
	 */
	public static Browser valueOf(short id)
	{
		for (Browser browser : Browser.values())
		{
			if (browser.getId() == id)
				return browser;
		}
		
		// same behavior as standard valueOf(string) method
		throw new IllegalArgumentException(
	            "No enum const for id " + id);
	}
	
	
	
}
