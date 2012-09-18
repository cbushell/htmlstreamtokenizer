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

public class HtmlTag {

    private String m_tag = null;
    private int m_ttype = Tags.tags.UNKNOWN.ordinal();
    private boolean m_endtag = false;
    private Vector m_names = new Vector();
    private Vector m_values = new Vector();
    private boolean m_empty = false;

    public HtmlTag(){

    }

    public HtmlTag(HtmlTag orig) {
        m_tag = new String(orig.m_tag);
        m_ttype = orig.m_ttype;
        m_endtag = orig.m_endtag;
        m_names = (Vector) orig.m_names.clone();
        m_values = (Vector) orig.m_values.clone();
        m_empty = orig.m_empty;
    }

    public void setTag(String tag) throws HtmlException {
        try {
            m_tag = tag;
            Object value = Tags.m_tags.get(tag.toUpperCase());
            if (value != null)
                m_ttype = ((Integer) value).intValue();
        } catch (StringIndexOutOfBoundsException e) {
            throw new HtmlException("invalid tag");
        }
    }

    public int getTagType() {
        return m_ttype;
    }

    public String getTagString() {
        return m_tag;
    }

    public boolean isEndTag() {
        return m_endtag;
    }

    public String getParam(String name) {
        final int idx = indexOfName(name);
        if (idx != -1)
            return (String) m_values.elementAt(idx);

        return null;
    }

    public String getParamName(int i) {
        return (String) m_names.elementAt(i);
    }

    public String getParamValue(int i) {
        return (String) m_values.elementAt(i);
    }

    public int getIntParam(String name)
            throws NumberFormatException {
        return Integer.parseInt(getParam(name));
    }

    public boolean hasParam(String name) {
        return getParam(name) != null;
    }

    public void setParam(String name, String value) {
        m_names.addElement(name);
        m_values.addElement(value);
    }

    public void setWhitespace(String name, String whitespaceBefore, String whitespaceAfter) {
    }

    public void removeParam(String name) {
        final int idx = indexOfName(name);
        if (idx != -1) {
            m_names.removeElementAt(idx);
            m_values.removeElementAt(idx);
        }
    }

    public Enumeration getParamNames() {
        return m_names.elements();
    }

    public Enumeration getParamValues() {
        return m_values.elements();
    }

    public int getParamCount() {
        return m_names.size();
    }

    public boolean isEmpty() {
        return m_empty;
    }

    public String toString() {
        StringBuffer tag = new StringBuffer();

        tag.append('<');
        if (isEndTag())
            tag.append(HtmlStreamTokenizer.C_ENDTAG);
        tag.append(getTagString());

        final int size = m_names.size();
        for (int i = 0; i < size; i++) {
            String name = (String) m_names.elementAt(i);
            tag.append(" " + name);
            String value = (String) m_values.elementAt(i);
            if (value.length() > 0)
                tag.append("=\"" + value + "\"");
        }
        if (isEmpty())
            tag.append(" /");
        tag.append('>');

        return tag.toString();
    }

    public void reset() {
        m_tag = null;
        m_ttype = Tags.tags.UNKNOWN.ordinal();
        m_endtag = false;
        m_names.removeAllElements();
        m_values.removeAllElements();
        m_empty = false;
    }

    protected void setEndTag(boolean endtag) {
        m_endtag = endtag;
    }

    protected void setEmpty(boolean empty) {
        m_empty = empty;
    }

    private final int indexOfName(String name) {
        final int size = m_names.size();
        for (int i = 0; i < size; i++)
            if (name.equalsIgnoreCase((String) m_names.elementAt(i)))
                return i;

        return -1;
    }

}

