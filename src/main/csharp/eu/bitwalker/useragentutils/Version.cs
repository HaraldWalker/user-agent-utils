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
namespace eu.bitwalker.useragentutils
{

    /**
     * Container for general version information.
     * All version information is stored as string as sometimes version information includes alphabetical characters.
     * @author harald -- @ported by thunder stumpges
     */
    public class Version : IComparable<Version>
    {

        private readonly string version;
        private readonly string majorVersion;
        private readonly string minorVersion;

        public Version(string version, string majorVersion, string minorVersion)
        {
            this.version = version;
            this.majorVersion = majorVersion;
            this.minorVersion = minorVersion;
        }

        public string getVersion()
        {
            return version;
        }

        public string getMajorVersion()
        {
            return majorVersion;
        }

        public string getMinorVersion()
        {
            return minorVersion;
        }

        public override string ToString()
        {
            return version;
        }

        public override int GetHashCode()
        {
            const int prime = 31;
            int result = 1;
            result = prime*result
                     + ((majorVersion == null) ? 0 : majorVersion.GetHashCode());
            result = prime*result
                     + ((minorVersion == null) ? 0 : minorVersion.GetHashCode());
            result = prime*result + ((version == null) ? 0 : version.GetHashCode());
            return result;
        }

        // overload of == to compare DateTimeWrapper and DateTime
        public static bool operator ==(Version a, Version b)
        {
            if (object.ReferenceEquals(a, null))
            {
                return object.ReferenceEquals(b, null);
            }

            return a.Equals(b);
        }

        public static bool operator !=(Version a, Version b)
        {
            return !(a == b);
        }

        public override bool Equals(Object obj)
        {
            if (object.ReferenceEquals(this,obj))
                return true;
            if (object.ReferenceEquals(obj,null))
                return false;
            if (GetType() != obj.GetType())
                return false;
            Version other = (Version) obj;
            if (majorVersion == null)
            {
                if (other.majorVersion != null)
                    return false;
            }
            else if (!majorVersion.Equals(other.majorVersion))
                return false;
            if (minorVersion == null)
            {
                if (other.minorVersion != null)
                    return false;
            }
            else if (!minorVersion.Equals(other.minorVersion))
                return false;
            if (version == null)
            {
                if (other.version != null)
                    return false;
            }
            else if (!version.Equals(other.version))
                return false;
            return true;
        }

        public int CompareTo(Version other)
        {
            if (other == null)
            {
                return 1;
            }

            string[] versionParts = version.Split(new [] { "." }, StringSplitOptions.None);
            string[] otherVersionParts = other.version.Split(new [] {"."}, StringSplitOptions.None);

            for (int i = 0; i < Math.Min(versionParts.Length, otherVersionParts.Length); i++)
            {
                if (versionParts[i].Length == otherVersionParts[i].Length)
                {
                    int comparisonResult = String.Compare(versionParts[i], otherVersionParts[i], StringComparison.Ordinal);
                    if (comparisonResult == 0)
                    {
                        continue;
                    }
                    else
                    {
                        return comparisonResult;
                    }
                }
                else
                {
                    return versionParts[i].Length > otherVersionParts[i].Length ? 1 : -1;
                }
            }

            if (versionParts.Length > otherVersionParts.Length)
            {
                return 1;
            }
            else if (versionParts.Length < otherVersionParts.Length)
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }

    }
}