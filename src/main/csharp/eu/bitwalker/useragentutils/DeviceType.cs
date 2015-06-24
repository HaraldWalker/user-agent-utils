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
     * Enum contact for the type of used device
     * @author harald -- @ported by thunder stumpges
     *
     */
    public sealed class DeviceType {
        #region .NET specific initialization
        /*
         * List of Applications for returning all of them (see method 'values')
         * Populated in decla
         */
        private static readonly List<DeviceType> _values;
        static DeviceType()
        {
            // populate the list of applications using reflection so we don't have to maintain this list.
            _values = typeof(DeviceType).GetFields(BindingFlags.Static | BindingFlags.Public)
                .Where(pi => pi.FieldType == typeof(DeviceType))
                .Select(pi => { var p = (DeviceType)pi.GetValue(null); p.Key = pi.Name; return p; })
                .ToList();
        }
        /*
         * C# does not allow the Enum type to be Object like Java, so we need to mimic the values() function.
         */
        public static ReadOnlyCollection<DeviceType> values()
        {
            return _values.AsReadOnly();
        }
        #endregion .NET specific initialization
	
	    /**
	     * Standard desktop or laptop computer
	     */
	    public static readonly DeviceType COMPUTER = new DeviceType("Computer");
	    /**
	     * Mobile phone or similar small mobile device
	     */
	    public static readonly DeviceType MOBILE = new DeviceType("Mobile");
	    /**
	     * Small tablet type computer.
	     */
	    public static readonly DeviceType TABLET = new DeviceType("Tablet");
	    /**
	     * Game console like the Wii or Playstation.
	     */
	    public static readonly DeviceType GAME_CONSOLE = new DeviceType("Game console");
	    /**
	     * Digital media receiver like the Google TV.
	     */	
	    public static readonly DeviceType DMR = new DeviceType("Digital media receiver");
	    /**
	     * Miniature device like a smart watch or interactive glasses
	     */	
	    public static readonly DeviceType WEARABLE = new DeviceType("Wearable computer");
	    /**
	     * Other or unknow type of device.
	     */	
	    public static readonly DeviceType UNKNOWN = new DeviceType("Unknown");
	
	    string name;
	
	    private DeviceType(string name) {
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
        public static DeviceType valueOf(string key)
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