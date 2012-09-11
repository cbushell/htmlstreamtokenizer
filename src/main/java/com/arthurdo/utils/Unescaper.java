package com.arthurdo.utils;


public class Unescaper {

	private CharUtils charUtils;

	private EscapeMapper escapeMapper;

	
	public Unescaper(CharUtils charUtils, EscapeMapper escapeMapper){
		this.charUtils = charUtils;
		this.escapeMapper = escapeMapper;
	}

	/**
	 * Replaces HTML escape sequences with its character equivalent, e.g.
	 * <b>&amp;amp;copy;</b> becomes <b>&amp;copy;</b>.
	 * 
	 * @param buf
	 *            text buffer to unescape
	 * @return a string with all HTML escape sequences removed
	 */
	public String unescape(String buf) {
		// quick check to see if there are any escape characters
		if (buf.indexOf('&') == -1) {
			return buf;
		}

		StringBuffer b = new StringBuffer(buf);
		unescape(b);
		return b.toString();
	}

	/**
	 * Replaces HTML escape sequences with its character equivalent, e.g.
	 * <b>&amp;copy;</b> becomes <b>&copy;</b>.
	 * 
	 * @param buf
	 *            will remove all HTML escape sequences from this buffer
	 */
	public void unescape(StringBuffer buf) {
		int len = buf.length();
		int i = 0;
		int r = i;
		while (i < len) {
			char ch = buf.charAt(i);
			if (ch == '&') {
				int saver = r;
				String esc = "";
				int j = i + 1;
				for (; j < len; j++) {
					buf.setCharAt(r++, ch);
					ch = buf.charAt(j);
					if (ch == ';' || ch == '<' || (charUtils.isPunct(ch) && ch != '#')
							|| charUtils.isSpace(ch)) {
						Character e = parseEscape(esc);
						if (e != null) {
							// found escape sequence
							// as opposed to false or unrecognized escape, e.g.
							// AT&T.
							r = saver;
							char v = e.charValue();
							buf.setCharAt(r++, v);
						}
						i = j;
						// this handles things like &lt&gt
						if (ch != '&')
							i++; // if not '&' then discard char
						break;
					}
					esc += ch;
				}
				if (j == len) {
					Character e = parseEscape(esc);
					if (e != null) {
						r = saver;
						buf.setCharAt(r++, e.charValue());
					}
					break;
				}
			} else {
				buf.setCharAt(r++, ch);
				i++;
			}
		}
		buf.setLength(r);
	}

	private Character parseEscape(String s) {
		int len = s.length();

		if (len == 0) {
			return null;
		}

		Character ch = null;

		if (s.charAt(0) == '#') {
			if (len <= 1) {
				return null;
			}

			int code = 0;
			for (int i = 1; i < len; i++) {
				if (!Character.isDigit(s.charAt(i)))
					return null;
				code = (code * 10) + Character.digit(s.charAt(i), 10);
			}
			ch = new Character((char) code);
		} else {
			ch = escapeMapper.get(s);
		}

		return ch;
	}

}
