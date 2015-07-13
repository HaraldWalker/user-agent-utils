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

package eu.bitwalker.useragentutils;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Test class for application detection.
 * 
 * @author harald
 * 
 */
public class ApplicationTest {

	/**
	 * Test method for
	 * {@link eu.bitwalker.useragentutils.Application#isInReferrerString(java.lang.String)}
	 */
	@Test
	public void testIsBrowser() {
		assertTrue(Application.GMAIL
				.isInReferrerString("http://mail.google.com/mail/?ui=1&ik=xx&view=cv&search=inbox&th=xx&ww=xx&cvap=5&qt=&zx=xx"));
	}

	/**
	 * Test if generated id values are unique.
	 */
	@Test
	public void testUniqueIdValues() {
		List<Short> retrievedIdValues = new ArrayList<Short>();

		for (Application application : Application.values()) {
			assertTrue(!retrievedIdValues.contains(application.getId()));
			retrievedIdValues.add(application.getId());
		}
	}

}
