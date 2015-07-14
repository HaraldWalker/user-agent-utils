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

namespace eu.bitwalker.useragentutils
{
    /**
     * Enum constants classifying the different types of browsers which are common in user-agent strings
     * @author harald -- @ported by thunder stumpges
     *
     */
    public sealed class BrowserType {
        #region .NET specific initialization
        /*
         * List of Applications for returning all of them (see method 'values')
         * Populated in decla
         */
        private static readonly List<BrowserType> _values;
        static BrowserType()
        {
            // populate the list of applications using reflection so we don't have to maintain this list.
            _values = typeof(BrowserType).GetFields(BindingFlags.Static | BindingFlags.Public)
                .Where(pi => pi.FieldType == typeof(BrowserType))
                .Select(pi => { var p = (BrowserType)pi.GetValue(null); p.Key = pi.Name; return p; })
                .ToList();
        }
        /*
         * C# does not allow the Enum type to be Object like Java, so we need to mimic the values() function.
         */
        public static ReadOnlyCollection<BrowserType> values()
        {
            return _values.AsReadOnly();
        }
        #endregion .NET specific initialization

	    /**
	     * Standard web-browser
	     */
	    public static readonly BrowserType WEB_BROWSER = new BrowserType("Browser");
	    /**
	     * Special web-browser for mobile devices
	     */
        public static readonly BrowserType MOBILE_BROWSER = new BrowserType("Browser (mobile)");
	    /**
	     * Text only browser like the good old Lynx
	     */
        public static readonly BrowserType TEXT_BROWSER = new BrowserType("Browser (text only)");
	    /**
	     * Email client like Thunderbird
	     */
        public static readonly BrowserType EMAIL_CLIENT = new BrowserType("Email Client");
	    /**
	     * Search robot, spider, crawler,...
	     */
        public static readonly BrowserType ROBOT = new BrowserType("Robot");
	    /**
	     * Downloading tools
	     */
        public static readonly BrowserType TOOL = new BrowserType("Downloading tool");
	    /**
	     * Application
	     */
        public static readonly BrowserType APP = new BrowserType("Application");
	    public static readonly BrowserType UNKNOWN = new BrowserType("unknown");
	
	    private string name;
	
	    private BrowserType(string name) {
		    this.name = name;
	    }

	    public string getName() {
		    return name;
	    }

        #region .NET specific valueOf(key)
        /**
         * Returns the enum constant of this type with the specified key.
         * Throws IllegalArgumentException if the value does not exist.
         * @param key
         * @return 
         */
        public static BrowserType valueOf(string key)
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