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

package com.houdah.eoaccess.qualifiers;

import com.houdah.eocontrol.qualifiers.PiggybackQualifier;
import com.webobjects.eoaccess.EOEntity;
import com.webobjects.eoaccess.EOSQLExpression;
import com.webobjects.eoaccess.EOQualifierSQLGeneration.Support;
import com.webobjects.eocontrol.EOQualifier;

/**
 * Support class for the PiggybackQualifier.
 * 
 * @author bernard
 */
public class PiggybackQualifierSupport extends QualifierGenerationSupport
{
	// Public instance methods
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webobjects.eoaccess.EOQualifierSQLGeneration.Support#sqlStringForSQLExpression(com.webobjects.eocontrol.EOQualifier,
	 *      com.webobjects.eoaccess.EOSQLExpression)
	 */
	public String sqlStringForSQLExpression(EOQualifier qualifier,
			EOSQLExpression expression)
	{
		PiggybackQualifier pbQualifier = (PiggybackQualifier) qualifier;
		EOQualifier subQualifier = pbQualifier.qualifier();
		Support support = supportForClass(subQualifier.getClass());
		
		if (support == null) {
			throw new IllegalArgumentException("Qualifier " + subQualifier
					+ " has no support class");
		}
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("(");
		buffer.append(support.sqlStringForSQLExpression(subQualifier,
				expression));
		buffer.append(")");
		
		return buffer.toString();
	}
	
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webobjects.eoaccess.EOQualifierSQLGeneration.Support#schemaBasedQualifierWithRootEntity(com.webobjects.eocontrol.EOQualifier,
	 *      com.webobjects.eoaccess.EOEntity)
	 */
	public EOQualifier schemaBasedQualifierWithRootEntity(
			EOQualifier qualifier, EOEntity entity)
	{
		PiggybackQualifier pbQualifier = (PiggybackQualifier) qualifier;
		EOQualifier subQualifier = pbQualifier.qualifier();
		Support support = supportForClass(subQualifier.getClass());
		
		if (support == null) {
			throw new IllegalArgumentException("Qualifier " + subQualifier
					+ " has no support class");
		}
		
		EOQualifier schemaBasedSubQualifier = support
				.schemaBasedQualifierWithRootEntity(subQualifier, entity);
		
		if (subQualifier == schemaBasedSubQualifier) {
			return pbQualifier;
		} else {
			PiggybackQualifier schemaBasedQualifier = new PiggybackQualifier(
					schemaBasedSubQualifier);
			
			schemaBasedQualifier.userInfo().addEntriesFromDictionary(
					pbQualifier.userInfo());
			
			return schemaBasedQualifier;
		}
	}
	
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webobjects.eoaccess.EOQualifierSQLGeneration.Support#qualifierMigratedFromEntityRelationshipPath(com.webobjects.eocontrol.EOQualifier,
	 *      com.webobjects.eoaccess.EOEntity, java.lang.String)
	 */
	public EOQualifier qualifierMigratedFromEntityRelationshipPath(
			EOQualifier qualifier, EOEntity entity, String relationshipPath)
	{
		PiggybackQualifier pbQualifier = (PiggybackQualifier) qualifier;
		EOQualifier subQualifier = pbQualifier.qualifier();
		Support support = supportForClass(subQualifier.getClass());
		
		if (support == null) {
			throw new IllegalArgumentException("Qualifier " + subQualifier
					+ " has no support class");
		}
		
		EOQualifier migratedSubQualifier = support
				.qualifierMigratedFromEntityRelationshipPath(subQualifier,
						entity, relationshipPath);
		
		if (subQualifier == migratedSubQualifier) {
			return pbQualifier;
		} else {
			PiggybackQualifier migratedQualifier = new PiggybackQualifier(
					migratedSubQualifier);
			
			migratedQualifier.userInfo().addEntriesFromDictionary(
					pbQualifier.userInfo());
			
			return migratedQualifier;
		}
	}
}