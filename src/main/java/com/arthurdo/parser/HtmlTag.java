/*
 * Copyright (c) 1996, 2001 by Arthur Do <arthur@cs.stanford.edu>.
 * All Rights Reserved.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package com.arthurdo.parser;

import java.util.Enumeration;
import java.util.Vector;

/**
 * HtmlTag is a helper class to store parsed tag information.
 * 
 * @version 2.01 09/12/97
 * @author Arthur Do <arthur@cs.stanford.edu>
 * @see com.arthurdo.parser.HtmlStreamTokenizer
 */
public class HtmlTag {

	public static final int T_UNKNOWN = 0;

	public HtmlTag() {
	}

	public HtmlTag(HtmlTag orig) {
		m_tag = new String(orig.m_tag);
		m_ttype = orig.m_ttype;
		m_endtag = orig.m_endtag;
		m_names = (Vector<String>) orig.m_names.clone();
		m_values = (Vector<String>) orig.m_values.clone();
		// m_params = (Hashtable)orig.m_params.clone();
		// m_originalParamNames = (Hashtable)orig.m_originalParamNames.clone();
		m_empty = orig.m_empty;
	}

	/**
	 * Sets the tag name.
	 * 
	 * @param tag
	 *            name of tag, e.g. "img"
	 * @exception HtmlException
	 *                if malformed tag.
	 */
	public void setTag(String tag) throws HtmlException {
		try {
			m_tag = tag;
			Object value = mapper.get(tag.toUpperCase());

			if (value != null) {
				m_ttype = ((Integer) value).intValue();
			}
		} catch (StringIndexOutOfBoundsException e) {
			throw new HtmlException("invalid tag");
		}
	}

	/**
	 * @return tag type, e.g. one of the <b>T_</b> constants.
	 */
	public int getTagType() {
		return m_ttype;
	}

	/**
	 * @return tag name, the same name as passed to the constructor.
	 */
	public String getTagString() {
		return m_tag;
	}

	/**
	 * @return this is an end tag or not, i.e. if the tag has a slash before the
	 *         name.
	 */
	public boolean isEndTag() {
		return m_endtag;
	}

	/**
	 * Looks up a tag param name and returns the associated value, if any. Try
	 * to use the predefined <b>P_</b> constants.
	 * 
	 * @param name
	 *            name of param
	 * @return the value associated with the name, or null.
	 */
	public String getParam(String name) {
		final int idx = indexOfName(name);
		if (idx != -1)
			return m_values.elementAt(idx);

		return null;
	}

	/**
	 * Looks up a tag param name (by position)
	 * 
	 * @param i
	 *            The index of the param in the list (starting at 0).
	 * @return The name of the indexed param
	 */
	public String getParamName(int i) {
		return m_names.elementAt(i);
	}

	/**
	 * Looks up a tag param value (by position)
	 * 
	 * @param i
	 *            The index of the param in the list (starting at 0).
	 * @return The value of the indexed param
	 */
	public String getParamValue(int i) {
		return m_values.elementAt(i);
	}

	/**
	 * Looks up a tag param name and returns the associated value, if any. Try
	 * to use the predefined <b>P_</b> constants.
	 * 
	 * @param name
	 *            name of param, must be lowercase
	 * @return the integer value associated with the name.
	 * @exception NumberFormatException
	 *                if value is not a number.
	 */
	public int getIntParam(String name) throws NumberFormatException {
		return Integer.parseInt(getParam(name));
	}

	/**
	 * Determines if tag has a particular parameter.
	 * 
	 * @param name
	 *            name of param, must be lowercase
	 * @return true if tag contains parameter, false otherwise.
	 */
	public boolean hasParam(String name) {
		return getParam(name) != null;
	}

	/**
	 * Associates a param name with a value.
	 * 
	 * @param name
	 *            name of param
	 * @param value
	 *            value associated with name
	 */
	public void setParam(String name, String value) {
		m_names.addElement(name);
		m_values.addElement(value);
	}

	public void setWhitespace(String name, String whitespaceBefore,
			String whitespaceAfter) {
	}

	/**
	 * Remove association of a param name with a value.
	 * 
	 * @param name
	 *            name of param to remove
	 */
	public void removeParam(String name) {
		final int idx = indexOfName(name);
		if (idx != -1) {
			m_names.removeElementAt(idx);
			m_values.removeElementAt(idx);
		}
	}

	/**
	 * @return an enumeration of the parameter names.
	 */
	public Enumeration<String> getParamNames() {
		return m_names.elements();
	}

	/**
	 * @return an enumeration of the parameter values.
	 */
	public Enumeration<String> getParamValues() {
		return m_values.elements();
	}

	/**
	 * @return the number of params.
	 */
	public int getParamCount() {
		return m_names.size();
	}

	/**
	 * An empty tag ends with a '/'.
	 * 
	 * @return true if empty tag, false otherwise.
	 */
	public boolean isEmpty() {
		return m_empty;
	}

	/**
	 * @return string representation of tag
	 */
	public String toString() {
		StringBuffer tag = new StringBuffer();

		tag.append('<');
		if (isEndTag())
			tag.append(HtmlStreamTokenizer.C_ENDTAG);
		tag.append(getTagString());

		final int size = m_names.size();
		for (int i = 0; i < size; i++) {
			String name = m_names.elementAt(i);
			tag.append(" " + name);
			String value = m_values.elementAt(i);
			if (value.length() > 0)
				tag.append("=\"" + value + "\"");
		}
		if (isEmpty())
			tag.append(" /");
		tag.append('>');

		return tag.toString();
	}

	/**
	 * Reset tag to original state, as if it was just constructed.
	 */
	public void reset() {
		m_tag = null;
		m_ttype = T_UNKNOWN;
		m_endtag = false;
		m_names.removeAllElements();
		m_values.removeAllElements();
		m_empty = false;
	}

	public static final String P_ALIGN = new String("align");
	public static final String P_BACKGROUND = new String("background");
	public static final String P_BORDER = new String("border");
	public static final String P_CHECKED = new String("checked");
	public static final String P_CLEAR = new String("clear");
	public static final String P_CODE = new String("code");
	public static final String P_COLS = new String("cols");
	public static final String P_COLSPAN = new String("colspan");
	public static final String P_FACE = new String("face");
	public static final String P_HEIGHT = new String("height");
	public static final String P_HREF = new String("href");
	public static final String P_LANGUAGE = new String("language");
	public static final String P_LOWSRC = new String("lowsrc");
	public static final String P_MAXLENGTH = new String("maxlength");
	public static final String P_MULTIPLE = new String("multiple");
	public static final String P_NAME = new String("name");
	public static final String P_ROWS = new String("rows");
	public static final String P_ROWSPAN = new String("rowspan");
	public static final String P_SIZE = new String("size");
	public static final String P_SRC = new String("src");
	public static final String P_TARGET = new String("target");
	public static final String P_TYPE = new String("type");
	public static final String P_VALUE = new String("value");
	public static final String P_VALUETYPE = new String("valuetype");
	public static final String P_WIDTH = new String("width");

	public static final String P_CITE = new String("cite");
	public static final String P_PROFILE = new String("profile");
	public static final String P_ACTION = new String("action");
	public static final String P_LONGDESC = new String("longdesc");
	public static final String P_FOR = new String("for");
	public static final String P_USEMAP = new String("usemap");
	public static final String P_CODEBASE = new String("codebase");
	public static final String P_DATA = new String("data");
	public static final String P_ARCHIVE = new String("archive");
	public static final String P_REL = new String("rel");
	public static final String P_REV = new String("rev");

	// ////////////////////////////////////////////////////////////////////

	/**
	 * Sets whether a tag is an end tag or not.
	 */
	protected void setEndTag(boolean endtag) {
		m_endtag = endtag;
	}

	/**
	 * Sets whether a tag is empty or not. An empty tag ends with a '/'.
	 */
	protected void setEmpty(boolean empty) {
		m_empty = empty;
	}

	private final int indexOfName(String name) {
		final int size = m_names.size();
		for (int i = 0; i < size; i++)
			if (name.equalsIgnoreCase(m_names.elementAt(i)))
				return i;

		return -1;
	}

	private String m_tag = null;
	private int m_ttype = T_UNKNOWN;
	private boolean m_endtag = false;
	private Vector<String> m_names = new Vector<String>();
	private Vector<String> m_values = new Vector<String>();
	private static HtmlMapper mapper = new HtmlMapper();
	private boolean m_empty = false;

}
