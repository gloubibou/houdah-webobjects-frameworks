/*
 * Modified MIT License
 * 
 * Copyright (c) 2006-2007 Houdah Software s.à r.l.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * Except as contained in this notice, the name(s) of the above copyright holders
 * shall not be used in advertising or otherwise to promote the sale, use or other 
 * dealings in this Software without prior written authorization.
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
**/

package com.houdah.eocontrol.qualifiers;

import com.webobjects.eocontrol.EOClassDescription;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableSet;

/**
 * Qualifier matching no values.<br/>
 * 
 * Used where an actual qualifier is required, yet all objects should be
 * matched.
 * 
 * @author bernard
 */
public class TrueQualifier extends Qualifier
{
	// Private class constants
	
	private static final long	serialVersionUID	= 2252767682526969175L;
	
	
	
	
	// Constructor
	
	public TrueQualifier()
	{
	}
	
	
	
	// Public instance methods
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webobjects.eocontrol.EOQualifier#qualifierWithBindings(com.webobjects.foundation.NSDictionary,
	 *      boolean)
	 */
	public EOQualifier qualifierWithBindings(NSDictionary bindings,
			boolean requireAll)
	{
		return this;
	}
	
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webobjects.eocontrol.EOQualifier#validateKeysWithRootClassDescription(com.webobjects.eocontrol.EOClassDescription)
	 */
	public void validateKeysWithRootClassDescription(
			EOClassDescription classDescription)
	{
	}
	
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webobjects.eocontrol.EOQualifier#addQualifierKeysToSet(com.webobjects.foundation.NSMutableSet)
	 */
	public void addQualifierKeysToSet(NSMutableSet keySet)
	{
	}
	
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webobjects.eocontrol.EOQualifierEvaluation#evaluateWithObject(java.lang.Object)
	 */
	public boolean evaluateWithObject(Object object)
	{
		return true;
	}
}