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
     * Enum constants for internet applications like web-application and rich
     * internet application.
     * 
     * @author harald -- @ported by thunder stumpges
     * 
     */
    public sealed class Application
    {
        #region .NET specific initialization
        /*
         * List of Applications for returning all of them (see method 'values')
         * Populated in decla
         */
        private static readonly List<Application> _values;
        static Application()
        {
            // populate the list of applications using reflection so we don't have to maintain this list.
            _values = typeof (Application).GetFields(BindingFlags.Static|BindingFlags.Public)
                .Where(pi => pi.FieldType == typeof (Application))
                .Select(pi => { var p = (Application) pi.GetValue(null); p.Key = pi.Name; return p; })
                .ToList();
        }
        /*
         * C# does not allow the Enum type to be Object like Java, so we need to mimic the values() function.
         */
        public static ReadOnlyCollection<Application> values()
        {
            return _values.AsReadOnly();
        }
        #endregion .NET specific initialization

        public static readonly Application HOTMAIL = new Application(Manufacturer.MICROSOFT, 1, "Windows Live Hotmail", 
			    new string[] { "mail.live.com", "hotmail.msn" }, ApplicationType.WEBMAIL);
	    public static readonly Application GMAIL = new Application( Manufacturer.GOOGLE, 5, "Gmail",
			    new string[] { "mail.google.com" }, ApplicationType.WEBMAIL);
	    public static readonly Application YAHOO_MAIL = new Application( Manufacturer.YAHOO, 10, "Yahoo Mail",
			    new string[] { "mail.yahoo.com" }, ApplicationType.WEBMAIL);
	    public static readonly Application COMPUSERVE = new Application( Manufacturer.COMPUSERVE, 20, "Compuserve",
			    new string[] { "csmail.compuserve.com" }, ApplicationType.WEBMAIL);
	    public static readonly Application AOL_WEBMAIL = new Application( Manufacturer.AOL, 30, "AOL webmail",
			    new string[] { "webmail.aol.com" }, ApplicationType.WEBMAIL);
	    /**
	    * MobileMe webmail client by Apple. Previously known as .mac.
	    */
	    public static readonly Application MOBILEME = new Application( Manufacturer.APPLE, 40, "MobileMe",
			    new string[] { "www.me.com" }, ApplicationType.WEBMAIL);		
	    /**
	    * Mail.com
	    * Mail.com provides consumers with web-based e-mail services
	    */
	    public static readonly Application MAIL_COM = new Application( Manufacturer.MMC, 50, "Mail.com", 
			    new string[] { ".mail.com" }, ApplicationType.WEBMAIL);
	    /**
	     * Popular open source webmail client. Often installed by providers or privately.
	     */
	    public static readonly Application HORDE = new Application(	Manufacturer.OTHER, 50, "horde", 
			    new string[] { "horde" }, ApplicationType.WEBMAIL);
	    public static readonly Application OTHER_WEBMAIL = new Application(Manufacturer.OTHER, 60, "Other webmail client", 
			    new string[] { "webmail", "webemail" }, ApplicationType.WEBMAIL);
	    public static readonly Application UNKNOWN = new Application(Manufacturer.OTHER, 0, "Unknown", 
			    new string[0], ApplicationType.UNKNOWN);

	    private readonly short id;
	    private readonly string name;
	    private readonly string[] aliases;
	    private readonly ApplicationType applicationType;
	    private readonly Manufacturer manufacturer;

	    private Application(Manufacturer manufacturer, int versionId, string name,
			    string[] aliases, ApplicationType applicationType) {
		    this.id = (short) ((manufacturer.getId() << 8) + (byte) versionId);
		    this.name = name;
		    this.aliases = aliases;
		    this.applicationType = applicationType;
		    this.manufacturer = manufacturer;
	    }

	    public short getId() {
		    return id;
	    }

	    public string getName() {
		    return name;
	    }

	    /**
	     * @return the applicationType
	     */
	    public ApplicationType getApplicationType() {
		    return applicationType;
	    }

	    /**
	     * @return the manufacturer
	     */
	    public Manufacturer getManufacturer() {
		    return manufacturer;
	    }

	    /*
	     * Checks if the given referrer string matches to the application. Only
	     * checks for one specific application.
	     */
	    public bool isInReferrerString(string referrerString) {
		    foreach (string alias in aliases) {
			    if (referrerString.ToLower().IndexOf(alias.ToLower()) != -1)
				    return true;
		    }
		    return false;
	    }

	    /*
	     * Iterates over all Application to compare the signature with the referrer
	     * string. If no match can be found Application.UNKNOWN will be returned.
	     */
	    public static Application parseReferrerString(string referrerString) {
		    // skip the empty and "-" referrer
		    if (referrerString != null && referrerString.Length > 1) {
			    foreach (Application applicationInList in Application.values()) {
				    if (applicationInList.isInReferrerString(referrerString))
					    return applicationInList;
			    }
		    }
		    return Application.UNKNOWN;
	    }

        /**
	     * Returns the enum constant of this type with the specified id. Throws
	     * IllegalArgumentException if the value does not exist.
	     * 
	     * @param id
	     * @return
	     */
	    public static Application valueOf(short id) {
		    foreach (Application application in Application.values()) {
			    if (application.getId() == id)
				    return application;
		    }

		    // same behavior as standard valueOf(string) method
		    throw new ArgumentException("No enum const for id " + id);
	    }

        #region .NET specific valueOf(key)
        /**
         * Returns the enum constant of this type with the specified key.
         * Throws IllegalArgumentException if the value does not exist.
         * @param key
         * @return 
         */
        public static Application valueOf(string key)
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