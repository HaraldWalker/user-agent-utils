/*
* Copyright (c) 2008-2014, Harald Walker (bitwalker.eu) and contributing developers
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

using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Reflection;
using System.Text.RegularExpressions;

namespace eu.bitwalker.useragentutils
{
    /**
     * Enum constants for most common operating systems.
     * @author harald -- @ported by thunder stumpges
     */
    public sealed class OperatingSystem {
        #region .NET specific initialization
        /*
         * List of Applications for returning all of them (see method 'values')
         * Populated in decla
         */
        private static readonly List<OperatingSystem> _values;
        static OperatingSystem()
        {
            // populate the list of applications using reflection so we don't have to maintain this list.
            _values = typeof(OperatingSystem).GetFields(BindingFlags.Static | BindingFlags.Public)
                .Where(pi => pi.FieldType == typeof(OperatingSystem))
                .Select(pi => { var p = (OperatingSystem)pi.GetValue(null); p.Key = pi.Name; return p; })
                .ToList();
        }
        /*
         * C# does not allow the Enum type to be Object like Java, so we need to mimic the values() function.
         */
        public static ReadOnlyCollection<OperatingSystem> values()
        {
            return _values.AsReadOnly();
        }
        #endregion .NET specific initialization

	    // the order is important since the agent string is being compared with the aliases
	    /**
	     * Windows Mobile / Windows CE. Exact version unknown.
	     */
	    public static readonly OperatingSystem WINDOWS = new OperatingSystem(		Manufacturer.MICROSOFT,null,1, "Windows", new string[] { "Windows" }, new string[] { "Palm", "ggpht.com"  }, DeviceType.COMPUTER, null ); // catch the rest of older Windows systems (95, NT,...)
		    public static readonly OperatingSystem WINDOWS_10 = new OperatingSystem(		Manufacturer.MICROSOFT,OperatingSystem.WINDOWS,24, "Windows 10", new string[] { "Windows NT 6.4" }, null, DeviceType.COMPUTER, null ); // before Win, yes, Windows 10 is called 6.4 LOL
		    public static readonly OperatingSystem WINDOWS_81 = new OperatingSystem(		Manufacturer.MICROSOFT,OperatingSystem.WINDOWS,23, "Windows 8.1", new string[] { "Windows NT 6.3" }, null, DeviceType.COMPUTER, null ); // before Win, yes, Windows 8.1 is called 6.3 LOL
		    public static readonly OperatingSystem WINDOWS_8 = new OperatingSystem(		Manufacturer.MICROSOFT,OperatingSystem.WINDOWS,22, "Windows 8", new string[] { "Windows NT 6.2" }, null, DeviceType.COMPUTER, null ); // before Win, yes, Windows 8 is called 6.2 LOL
		    public static readonly OperatingSystem WINDOWS_7 = new OperatingSystem(		Manufacturer.MICROSOFT,OperatingSystem.WINDOWS,21, "Windows 7", new string[] { "Windows NT 6.1" }, null, DeviceType.COMPUTER, null ); // before Win, yes, Windows 7 is called 6.1 LOL
		    public static readonly OperatingSystem WINDOWS_VISTA = new OperatingSystem(	Manufacturer.MICROSOFT,OperatingSystem.WINDOWS,20, "Windows Vista", new string[] { "Windows NT 6" }, null, DeviceType.COMPUTER, null ); // before Win
		    public static readonly OperatingSystem WINDOWS_2000 = new OperatingSystem(	Manufacturer.MICROSOFT,OperatingSystem.WINDOWS,15, "Windows 2000", new string[] { "Windows NT 5.0" }, null, DeviceType.COMPUTER, null ); // before Win
		    public static readonly OperatingSystem WINDOWS_XP = new OperatingSystem(		Manufacturer.MICROSOFT,OperatingSystem.WINDOWS,10, "Windows XP", new string[] { "Windows NT 5"}, new string[] { "ggpht.com"  }, DeviceType.COMPUTER, null ); // before Win, 5.1 and 5.2 are basically XP systems
		    public static readonly OperatingSystem WINDOWS_PHONE8_1 = new OperatingSystem(Manufacturer.MICROSOFT,OperatingSystem.WINDOWS, 53, "Windows Phone 8.1", new string[] { "Windows Phone 8.1" },  null, DeviceType.MOBILE, null ); // before Win
		    public static readonly OperatingSystem WINDOWS_PHONE8 = new OperatingSystem(Manufacturer.MICROSOFT,OperatingSystem.WINDOWS, 52, "Windows Phone 8", new string[] { "Windows Phone 8" },  null, DeviceType.MOBILE, null ); // before Win
		    public static readonly OperatingSystem WINDOWS_MOBILE7 = new OperatingSystem(Manufacturer.MICROSOFT,OperatingSystem.WINDOWS, 51, "Windows Phone 7", new string[] { "Windows Phone OS 7" },  null, DeviceType.MOBILE, null ); // should be Windows Phone 7 but to keep it compatible we'll leave the name as is.
		    public static readonly OperatingSystem WINDOWS_MOBILE = new OperatingSystem(	Manufacturer.MICROSOFT,OperatingSystem.WINDOWS, 50, "Windows Mobile", new string[] { "Windows CE" },  null, DeviceType.MOBILE, null ); // before Win
		    public static readonly OperatingSystem WINDOWS_98 = new OperatingSystem(		Manufacturer.MICROSOFT,OperatingSystem.WINDOWS,5, "Windows 98", new string[] { "Windows 98","Win98" },  new string[] { "Palm" }, DeviceType.COMPUTER, null ); // before Win 

	    public static readonly OperatingSystem ANDROID = new OperatingSystem(		Manufacturer.GOOGLE,null, 0, "Android", new string[] { "Android" },  null, DeviceType.MOBILE, null );
            public static readonly OperatingSystem ANDROID5 = new OperatingSystem(		Manufacturer.GOOGLE,OperatingSystem.ANDROID, 5, "Android 5.x", new string[] { "Android 5", "Android-5" },   new string[] { "glass" }, DeviceType.MOBILE, null );
            public static readonly OperatingSystem ANDROID5_TABLET = new OperatingSystem(Manufacturer.GOOGLE,OperatingSystem.ANDROID5, 50, "Android 5.x Tablet", new string[] { "Android 5", "Android-5"}, new string[] { "mobile", "glass" }, DeviceType.TABLET, null );
		    public static readonly OperatingSystem ANDROID4 = new OperatingSystem(		Manufacturer.GOOGLE,OperatingSystem.ANDROID, 4, "Android 4.x", new string[] { "Android 4", "Android-4" },   new string[] { "glass" }, DeviceType.MOBILE, null );
		    public static readonly OperatingSystem ANDROID4_TABLET = new OperatingSystem(Manufacturer.GOOGLE,OperatingSystem.ANDROID4, 40, "Android 4.x Tablet", new string[] { "Android 4", "Android-4"}, new string[] { "mobile", "glass" }, DeviceType.TABLET, null );
		    public static readonly OperatingSystem ANDROID4_WEARABLE = new OperatingSystem(Manufacturer.GOOGLE,OperatingSystem.ANDROID, 400, "Android 4.x", new string[] { "Android 4" }, null, DeviceType.WEARABLE, null );
		    public static readonly OperatingSystem ANDROID3_TABLET = new OperatingSystem(Manufacturer.GOOGLE,OperatingSystem.ANDROID, 30, "Android 3.x Tablet", new string[] { "Android 3" },  null, DeviceType.TABLET, null ); // as long as there are not Android 3.x phones this should be enough
		    public static readonly OperatingSystem ANDROID2 = new OperatingSystem(		Manufacturer.GOOGLE,OperatingSystem.ANDROID, 2, "Android 2.x", new string[] { "Android 2" },  null, DeviceType.MOBILE, null );
		    public static readonly OperatingSystem ANDROID2_TABLET = new OperatingSystem(Manufacturer.GOOGLE,OperatingSystem.ANDROID2, 20, "Android 2.x Tablet", new string[] { "Kindle Fire", "GT-P1000","SCH-I800" },  null, DeviceType.TABLET, null );
		    public static readonly OperatingSystem ANDROID1 = new OperatingSystem(		Manufacturer.GOOGLE,OperatingSystem.ANDROID, 1, "Android 1.x", new string[] { "Android 1" },  null, DeviceType.MOBILE, null );
		    /**
		     * Generic Android mobile device without OS version number information
		     */
		    public static readonly OperatingSystem ANDROID_MOBILE = new OperatingSystem(	Manufacturer.GOOGLE,OperatingSystem.ANDROID, 11, "Android Mobile", new string[] { "Mobile" },  null, DeviceType.MOBILE, null );
		    /**
		     * Generic Android tablet device without OS version number information
		     */
		    public static readonly OperatingSystem ANDROID_TABLET = new OperatingSystem(	Manufacturer.GOOGLE,OperatingSystem.ANDROID, 12, "Android Tablet", new string[] { "Tablet" },  null, DeviceType.TABLET, null );

	    /**
	     * 	Chrome OS by Google, mostly used on Chromebooks and Chromeboxes
	     */
	    public static readonly OperatingSystem CHROME_OS = new OperatingSystem(		Manufacturer.GOOGLE,null, 1000, "Chrome OS", new string[] { "CrOS" },  null, DeviceType.COMPUTER, null );
	    /**
	     * PalmOS, exact version unkown
	     */
	    public static readonly OperatingSystem WEBOS = new OperatingSystem(			Manufacturer.HP,null,11, "WebOS", new string[] { "webOS" },  null, DeviceType.MOBILE, null ); 
	    public static readonly OperatingSystem PALM = new OperatingSystem(			Manufacturer.HP,null,10, "PalmOS", new string[] { "Palm" },  null, DeviceType.MOBILE, null ); 
	    public static readonly OperatingSystem MEEGO = new OperatingSystem(			Manufacturer.NOKIA,null,3, "MeeGo", new string[] { "MeeGo" },  null, DeviceType.MOBILE, null );		

	    /**
	     * iOS4, with the release of the iPhone 4, Apple renamed the OS to iOS.
	     */	
	    public static readonly OperatingSystem IOS = new OperatingSystem(			Manufacturer.APPLE,null, 2, "iOS", new string[] { "iPhone OS", "like Mac OS X" },  null, DeviceType.MOBILE, null ); // before MAC_OS_X_IPHONE for all older versions
		    public static readonly OperatingSystem iOS8_1_IPHONE = new OperatingSystem(	Manufacturer.APPLE,OperatingSystem.IOS, 46, "iOS 8.1 (iPhone)", new string[] { "iPhone OS 8_1" },  null, DeviceType.MOBILE, null ); // before MAC_OS_X_IPHONE for all older versions
		    public static readonly OperatingSystem iOS8_IPHONE = new OperatingSystem(	Manufacturer.APPLE,OperatingSystem.IOS, 45, "iOS 8 (iPhone)", new string[] { "iPhone OS 8_0" },  null, DeviceType.MOBILE, null ); // before MAC_OS_X_IPHONE for all older versions
		    public static readonly OperatingSystem iOS7_IPHONE = new OperatingSystem(	Manufacturer.APPLE,OperatingSystem.IOS, 44, "iOS 7 (iPhone)", new string[] { "iPhone OS 7" },  null, DeviceType.MOBILE, null ); // before MAC_OS_X_IPHONE for all older versions
		    public static readonly OperatingSystem iOS6_IPHONE = new OperatingSystem(	Manufacturer.APPLE,OperatingSystem.IOS, 43, "iOS 6 (iPhone)", new string[] { "iPhone OS 6" },  null, DeviceType.MOBILE, null ); // before MAC_OS_X_IPHONE for all older versions
		    public static readonly OperatingSystem iOS5_IPHONE = new OperatingSystem(	Manufacturer.APPLE,OperatingSystem.IOS, 42, "iOS 5 (iPhone)", new string[] { "iPhone OS 5" },  null, DeviceType.MOBILE, null ); // before MAC_OS_X_IPHONE for all older versions
		    public static readonly OperatingSystem iOS4_IPHONE = new OperatingSystem(	Manufacturer.APPLE,OperatingSystem.IOS, 41, "iOS 4 (iPhone)", new string[] { "iPhone OS 4" },  null, DeviceType.MOBILE, null ); // before MAC_OS_X_IPHONE for all older versions
		    public static readonly OperatingSystem MAC_OS_X_IPAD = new OperatingSystem(	Manufacturer.APPLE, OperatingSystem.IOS, 50, "Mac OS X (iPad)", new string[] { "iPad" },  null, DeviceType.TABLET, null ); // before Mac OS X
		    public static readonly OperatingSystem iOS8_1_IPAD = new OperatingSystem(	Manufacturer.APPLE, OperatingSystem.MAC_OS_X_IPAD, 54, "iOS 8.1 (iPad)", new string[] { "OS 8_1" },  null, DeviceType.TABLET, null ); // before Mac OS X
		    public static readonly OperatingSystem iOS8_IPAD = new OperatingSystem(	Manufacturer.APPLE, OperatingSystem.MAC_OS_X_IPAD, 53, "iOS 8 (iPad)", new string[] { "OS 8_0" },  null, DeviceType.TABLET, null ); // before Mac OS X
		    public static readonly OperatingSystem iOS7_IPAD = new OperatingSystem(	Manufacturer.APPLE, OperatingSystem.MAC_OS_X_IPAD, 52, "iOS 7 (iPad)", new string[] { "OS 7" },  null, DeviceType.TABLET, null ); // before Mac OS X
		    public static readonly OperatingSystem iOS6_IPAD = new OperatingSystem(	Manufacturer.APPLE, OperatingSystem.MAC_OS_X_IPAD, 51, "iOS 6 (iPad)", new string[] { "OS 6" },  null, DeviceType.TABLET, null ); // before Mac OS X
		    public static readonly OperatingSystem MAC_OS_X_IPHONE = new OperatingSystem(Manufacturer.APPLE, OperatingSystem.IOS, 40, "Mac OS X (iPhone)", new string[] { "iPhone" },  null, DeviceType.MOBILE, null ); // before Mac OS X
		    public static readonly OperatingSystem MAC_OS_X_IPOD = new OperatingSystem(	Manufacturer.APPLE, OperatingSystem.IOS, 30, "Mac OS X (iPod)", new string[] { "iPod" },  null, DeviceType.MOBILE, null ); // before Mac OS X
	
	    public static readonly OperatingSystem MAC_OS_X = new OperatingSystem(		Manufacturer.APPLE,null, 10, "Mac OS X", new string[] { "Mac OS X" , "CFNetwork"}, null, DeviceType.COMPUTER, null ); // before Mac	

	    /**
	     * Older Mac OS systems before Mac OS X
	     */
	    public static readonly OperatingSystem MAC_OS = new OperatingSystem(			Manufacturer.APPLE,null, 1, "Mac OS", new string[] { "Mac" }, null, DeviceType.COMPUTER, null ); // older Mac OS systems

	    /**
	     * Linux based Maemo software platform by Nokia. Used in the N900 phone. http://maemo.nokia.com/
	     */
	    public static readonly OperatingSystem MAEMO = new OperatingSystem(			Manufacturer.NOKIA,null, 2, "Maemo", new string[] { "Maemo" },  null, DeviceType.MOBILE, null );

	    /**
	     * Bada is a mobile operating system being developed by Samsung Electronics.
	     */
	    public static readonly OperatingSystem BADA = new OperatingSystem(			Manufacturer.SAMSUNG,null, 2, "Bada", new string[] { "Bada" },  null, DeviceType.MOBILE, null );

        /**
         *  Google TV uses Android 2.x or 3.x but doesn't identify itself as Android.
         */
	    public static readonly OperatingSystem GOOGLE_TV = new OperatingSystem(		Manufacturer.GOOGLE,null, 100, "Android (Google TV)", new string[] { "GoogleTV" }, null, DeviceType.DMR, null );	

	    /**
	     * Various Linux based operating systems.
	     */
	    public static readonly OperatingSystem KINDLE = new OperatingSystem(			Manufacturer.AMAZON,null, 1, "Linux (Kindle)", new string[] { "Kindle" }, null, DeviceType.TABLET, null );	
		    public static readonly OperatingSystem KINDLE3 = new OperatingSystem(		Manufacturer.AMAZON,OperatingSystem.KINDLE, 30, "Linux (Kindle 3)", new string[] { "Kindle/3" }, null, DeviceType.TABLET, null );	
		    public static readonly OperatingSystem KINDLE2 = new OperatingSystem(		Manufacturer.AMAZON,OperatingSystem.KINDLE, 20, "Linux (Kindle 2)", new string[] { "Kindle/2" }, null, DeviceType.TABLET, null );	
	    public static readonly OperatingSystem LINUX = new OperatingSystem(			Manufacturer.OTHER,null, 2, "Linux", new string[] { "Linux" , "CamelHttpStream" }, null, DeviceType.COMPUTER, null ); // CamelHttpStream is being used by Evolution, an email client for Linux

	    /**
	     * Other Symbian OS versions
	     */
	    public static readonly OperatingSystem SYMBIAN = new OperatingSystem(		Manufacturer.SYMBIAN,null, 1, "Symbian OS", new string[] { "Symbian", "Series60"},  null, DeviceType.MOBILE, null );	
		    /**
		     * Symbian OS 9.x versions. Being used by Nokia (N71, N73, N81, N82, N91, N92, N95, ...)
		     */
		    public static readonly OperatingSystem SYMBIAN9 = new OperatingSystem(		Manufacturer.SYMBIAN,OperatingSystem.SYMBIAN, 20, "Symbian OS 9.x", new string[] {"SymbianOS/9", "Series60/3"},  null, DeviceType.MOBILE, null );
		    /**
		     * Symbian OS 8.x versions. Being used by Nokia (6630, 6680, 6681, 6682, N70, N72, N90).
		     */
		    public static readonly OperatingSystem SYMBIAN8 = new OperatingSystem(		Manufacturer.SYMBIAN,OperatingSystem.SYMBIAN, 15, "Symbian OS 8.x", new string[] { "SymbianOS/8", "Series60/2.6", "Series60/2.8"},  null, DeviceType.MOBILE, null );
		    /**
		     * Symbian OS 7.x versions. Being used by Nokia (3230, 6260, 6600, 6620, 6670, 7610), 
		     * Panasonic (X700, X800), Samsung (SGH-D720, SGH-D730) and Lenovo (P930). 
		     */
		    public static readonly OperatingSystem SYMBIAN7 = new OperatingSystem(		Manufacturer.SYMBIAN,OperatingSystem.SYMBIAN, 10, "Symbian OS 7.x", new string[] { "SymbianOS/7"},  null, DeviceType.MOBILE, null );
		    /**
		     * Symbian OS 6.x versions.
		     */
		    public static readonly OperatingSystem SYMBIAN6 = new OperatingSystem(		Manufacturer.SYMBIAN,OperatingSystem.SYMBIAN, 5, "Symbian OS 6.x", new string[] { "SymbianOS/6"},  null, DeviceType.MOBILE, null );
	    /**
	     * Nokia's Series 40 operating system. Series 60 (S60) uses the Symbian OS.
	     */
	    public static readonly OperatingSystem SERIES40 = new OperatingSystem( 		Manufacturer.NOKIA,null, 1, "Series 40", new string[] { "Nokia6300"},  null, DeviceType.MOBILE, null );
	    /**
	     * Proprietary operating system used for many Sony Ericsson phones. 
	     */
	    public static readonly OperatingSystem SONY_ERICSSON = new OperatingSystem( Manufacturer.SONY_ERICSSON, null, 1, "Sony Ericsson", new string[] { "SonyEricsson"},  null, DeviceType.MOBILE, null  ); // after symbian, some SE phones use symbian
	    public static readonly OperatingSystem SUN_OS = new OperatingSystem(			Manufacturer.SUN, null, 1, "SunOS", new string[] { "SunOS" } ,  null, DeviceType.COMPUTER, null );
	    public static readonly OperatingSystem PSP = new OperatingSystem(			Manufacturer.SONY, null, 1, "Sony Playstation", new string[] { "Playstation" }, null, DeviceType.GAME_CONSOLE, null ); 
	    /**
	     * Nintendo Wii game console.
	     */
	    public static readonly OperatingSystem WII = new OperatingSystem(			Manufacturer.NINTENDO,null, 1, "Nintendo Wii", new string[] { "Wii" }, null, DeviceType.GAME_CONSOLE, null ); 
	    /**
	     * BlackBerryOS. The BlackBerryOS exists in different version. How relevant those versions are, is not clear.
	     */
	    public static readonly OperatingSystem BLACKBERRY = new OperatingSystem(		Manufacturer.BLACKBERRY,null, 1, "BlackBerryOS", new string[] { "BlackBerry" }, null, DeviceType.MOBILE, null );	
		    public static readonly OperatingSystem BLACKBERRY7 = new OperatingSystem(	Manufacturer.BLACKBERRY,OperatingSystem.BLACKBERRY, 7, "BlackBerry 7", new string[] { "Version/7" }, null, DeviceType.MOBILE, null );	
		    public static readonly OperatingSystem BLACKBERRY6 = new OperatingSystem(	Manufacturer.BLACKBERRY,OperatingSystem.BLACKBERRY, 6, "BlackBerry 6", new string[] { "Version/6" }, null, DeviceType.MOBILE, null );		

	    public static readonly OperatingSystem BLACKBERRY_TABLET = new OperatingSystem(Manufacturer.BLACKBERRY,null, 100, "BlackBerry Tablet OS", new string[] { "RIM Tablet OS" }, null, DeviceType.TABLET, null );	
	
	    public static readonly OperatingSystem ROKU = new OperatingSystem(			Manufacturer.ROKU,null, 1, "Roku OS", new string[] { "Roku" }, null, DeviceType.DMR, null );
	
	    /**
	     * Proxy server that hides the original user-agent.
	     * ggpht.com = Gmail proxy server
	     */
	    public static readonly OperatingSystem PROXY = new OperatingSystem(			Manufacturer.OTHER,null, 10, "Proxy", new string[] { "ggpht.com" }, null, DeviceType.UNKNOWN, null );

	    public static readonly OperatingSystem UNKNOWN_MOBILE = new OperatingSystem(	Manufacturer.OTHER,null, 3, "Unknown mobile", new string[] {"Mobile"}, null, DeviceType.MOBILE, null );
	    public static readonly OperatingSystem UNKNOWN_TABLET = new OperatingSystem(	Manufacturer.OTHER,null, 4, "Unknown tablet", new string[] {"Tablet"}, null, DeviceType.TABLET, null );
	    public static readonly OperatingSystem UNKNOWN = new OperatingSystem(		Manufacturer.OTHER,null, 1, "Unknown", new string[0], null, DeviceType.UNKNOWN, null );
	
	    private readonly short id;
	    private readonly string name;
	    private readonly string[] aliases;
	    private readonly string[] excludeList; // don't match when these values are in the agent-string
	    private readonly Manufacturer manufacturer;
	    private readonly DeviceType deviceType;
	    private readonly OperatingSystem parent;
	    private List<OperatingSystem> children;
	    private Regex versionRegEx;
	    private static List<OperatingSystem> topLevelOperatingSystems;
	
	    private OperatingSystem(Manufacturer manufacturer, OperatingSystem parent, int versionId, string name, string[] aliases,
		     string[] exclude, DeviceType deviceType, string versionRegexString) {
		    this.manufacturer = manufacturer;
		    this.parent = parent;
		    this.children = new List<OperatingSystem>();
		    // combine manufacturer and version id to one unique id. 
		    this.id =  (short) ( ( manufacturer.getId() << 8) + (byte) versionId);
		    this.name = name;
		    this.aliases = aliases;
		    this.excludeList = exclude;
		    this.deviceType = deviceType;
		    if (versionRegexString != null) { // not implemented yet
			    this.versionRegEx = new Regex(versionRegexString,RegexOptions.Compiled);
		    }
		    if (this.parent == null)
			    addTopLevelOperatingSystem(this);
		    else
			    this.parent.children.Add(this);
	    }

	    // create collection of top level operating systems during initialization
	    private static void addTopLevelOperatingSystem(OperatingSystem os) {
		    if(topLevelOperatingSystems == null)
			    topLevelOperatingSystems = new List<OperatingSystem>();	
		    topLevelOperatingSystems.Add(os);
	    }
	
	    public short getId() {
		    return id;
	    }

	    public string getName() {
		    return name;
	    }

	    public DeviceType getDeviceType() {
		    return deviceType;
	    }
	
	    /*
	     * Gets the top level grouping operating system
	     */
	    public OperatingSystem getGroup() {
		    if (this.parent != null) {
			    return parent.getGroup();
		    }
		    return this;
	    }

	    /**
	     * Returns the manufacturer of the operating system
	     * @return the manufacturer
	     */
	    public Manufacturer getManufacturer() {
		    return manufacturer;
	    }

	    /**
	     * Checks if the given user-agent string matches to the operating system. 
	     * Only checks for one specific operating system. 
	     * @param agentString
	     * @return bool
	     */
	    public bool isInUserAgentString(string agentString)
	    {		
		    foreach (string alias in aliases)
		    {
			    if (agentString != null && agentString.ToLower().IndexOf(alias.ToLower(), System.StringComparison.Ordinal) != -1)
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
	    private bool containsExcludeToken(string agentString)
	    {
		    if (excludeList != null) {
			    foreach (string exclude in excludeList) {
				    if (agentString != null && agentString.ToLower().IndexOf(exclude.ToLower()) != -1)
					    return true;
			    }
		    }
		    return false;
	    }
		
	    private OperatingSystem checkUserAgent(string agentString) {
		    if (this.isInUserAgentString(agentString)) {
			    if (this.children.Count > 0) {
				    foreach (OperatingSystem childOperatingSystem in this.children) {
					    OperatingSystem match = childOperatingSystem.checkUserAgent(agentString);
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
	     * Parses user agent string and returns the best match. 
	     * Returns OperatingSystem.UNKNOWN if there is no match.
	     * @param agentString
	     * @return OperatingSystem
	     */
	    public static OperatingSystem parseUserAgentString(string agentString)
	    {
		    return parseUserAgentString(agentString, topLevelOperatingSystems);
	    }
	
	    /**
	     * Parses the user agent string and returns the best match for the given operating systems. 
	     * Returns OperatingSystem.UNKNOWN if there is no match.
	     * Be aware that if the order of the provided operating systems is incorrect or the set is too limited it can lead to false matches!
	     * @param agentString
	     * @return OperatingSystem
	     */
	    public static OperatingSystem parseUserAgentString(string agentString, List<OperatingSystem> operatingSystems)
	    {
		    foreach (OperatingSystem operatingSystem in operatingSystems)
		    {
			    OperatingSystem match = operatingSystem.checkUserAgent(agentString);
			    if (match != null) {
				    return match; // either current operatingSystem or a child object
			    }
		    }	
		    return OperatingSystem.UNKNOWN;
	    }

        /**
         * Returns the enum constant of this type with the specified id.
         * Throws IllegalArgumentException if the value does not exist.
         * @param id
         * @return 
         */
        public static OperatingSystem valueOf(short id)
        {
            foreach (OperatingSystem operatingSystem in OperatingSystem.values())
            {
                if (operatingSystem.getId() == id)
                    return operatingSystem;
            }
		
            // same behavior as standard valueOf(string) method
            throw new ArgumentException(
                    "No enum const for id " + id);
        }

        #region .NET specific valueOf(key)
        /**
         * Returns the enum constant of this type with the specified key.
         * Throws IllegalArgumentException if the value does not exist.
         * @param key
         * @return 
         */
        public static OperatingSystem valueOf(string key)
        {
            var ret = _values.FirstOrDefault(x => x.Key == key);
            if (ret == null)
                throw new ArgumentException("No item found with that key.");
            return ret;
        }

        /*
         * Override ToString, return the Key property (the static property name, set by the static constructor). This matches the behavior of the Java enum type. 
         */
        public override string ToString()
        {
            return Key;
        }

        /*
         * The name of the property this instance is assigned to. Set by the static constructor and used in ToString.
         */
        private string Key;
        #endregion .NET specific valueOf(key)

    }
}