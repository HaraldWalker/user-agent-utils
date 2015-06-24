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
     * Enum constants representing manufacturers of operating systems and client software. 
     * Manufacturer could be used for specific handling of browser requests.
     * @author harald -- @ported by thunder stumpges
     */

    public sealed class Manufacturer {
        #region .NET specific initialization
        /*
         * List of Applications for returning all of them (see method 'values')
         * Populated in decla
         */
        private static readonly List<Manufacturer> _values;
        static Manufacturer()
        {
            // populate the list of applications using reflection so we don't have to maintain this list.
            _values = typeof(Manufacturer).GetFields(BindingFlags.Static | BindingFlags.Public)
                .Where(pi => pi.FieldType == typeof(Manufacturer))
                .Select(pi => { var p = (Manufacturer)pi.GetValue(null); p.Key = pi.Name; return p; })
                .ToList();
        }
        /*
         * C# does not allow the Enum type to be Object like Java, so we need to mimic the values() function.
         */
        public static ReadOnlyCollection<Manufacturer> values()
        {
            return _values.AsReadOnly();
        }
        #endregion .NET specific initialization
	
	    /**
	     * Unknow or rare manufacturer
	     */
        public static readonly Manufacturer OTHER = new Manufacturer(1, "Other");
	    /**
	     * Microsoft Corporation
	     */
	    public static readonly Manufacturer MICROSOFT = new Manufacturer(2, "Microsoft Corporation");
	    /**
	     * Apple Inc.
	     */
	    public static readonly Manufacturer APPLE = new Manufacturer(3, "Apple Inc.");
	    /**
	     * Sun Microsystems, Inc.
	     */
	    public static readonly Manufacturer SUN = new Manufacturer(4, "Sun Microsystems, Inc.");
	    /**
	     * Symbian Ltd.
	     */
	    public static readonly Manufacturer SYMBIAN = new Manufacturer(5, "Symbian Ltd.");
	    /**
	     * Nokia Corporation
	     */
	    public static readonly Manufacturer NOKIA = new Manufacturer(6, "Nokia Corporation");
	    /**
	     * Research In Motion Limited
	     */
        public static readonly Manufacturer BLACKBERRY = new Manufacturer(7, "Research In Motion Limited");
	    /**
	     * Hewlett-Packard Company, previously Palm
	     */
	    public static readonly Manufacturer HP = new Manufacturer(8, "Hewlet Packard");
	    /**
	     * Sony Ericsson Mobile Communications AB
	     */
	    public static readonly Manufacturer SONY_ERICSSON = new Manufacturer(9, "Sony Ericsson Mobile Communications AB");
	    /**
	     * Samsung Electronics
	     */
	    public static readonly Manufacturer SAMSUNG = new Manufacturer(20, "Samsung Electronics");
	    /**
	     * Sony Computer Entertainment, Inc.
	     */
	    public static readonly Manufacturer SONY = new Manufacturer(10, "Sony Computer Entertainment, Inc.");
	    /**
	     * Nintendo
	     */
	    public static readonly Manufacturer NINTENDO = new Manufacturer(11, "Nintendo");
	    /**
	     * Opera Software ASA
	     */
	    public static readonly Manufacturer OPERA = new Manufacturer(12, "Opera Software ASA");
	    /**
	     * Mozilla Foundation
	     */
	    public static readonly Manufacturer MOZILLA = new Manufacturer(13, "Mozilla Foundation");
	    /**
	     * Google Inc.
	     */
	    public static readonly Manufacturer GOOGLE = new Manufacturer(15, "Google Inc.");
	    /**
	     * CompuServe Interactive Services, Inc. 
	     */
	    public static readonly Manufacturer COMPUSERVE = new Manufacturer(16, "CompuServe Interactive Services, Inc.");
	    /**
	     * Yahoo Inc.
	     */
	    public static readonly Manufacturer YAHOO = new Manufacturer(17, "Yahoo Inc.");
	    /**
	     * AOL LLC.
	     */
	    public static readonly Manufacturer AOL = new Manufacturer(18, "AOL LLC.");
	    /**
	     * Mail.com Media Corporation
	     */
	    public static readonly Manufacturer MMC = new Manufacturer(19, "Mail.com Media Corporation");
	    /**
	     * Amazon.com, Inc.
	     */
	    public static readonly Manufacturer AMAZON = new Manufacturer(24, "Amazon.com, Inc.");
	    /**
	     * Roku sells home digital media products
	     */
	    public static readonly Manufacturer ROKU = new Manufacturer(21, "Roku, Inc.");
	    /**
	     * Adobe Systems Inc.
	     */
	    public static readonly Manufacturer ADOBE = new Manufacturer(23, "Adobe Systems Inc.");
	
	
	    private readonly short id;
	    private readonly string name;
	
	    private Manufacturer(int id, string name) {
		    this.id = (byte) id;
		    this.name = name;
	    }

	    /**
	     * @return the id
	     */
	    public short getId() {
		    return id;
	    }

	    /**
	     * @return the name
	     */
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
        public static Manufacturer valueOf(string key)
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
