package com.arthurdo.parser;

import static com.arthurdo.parser.Chars.C_DOUBLEQUOTE;
import static com.arthurdo.parser.Chars.C_EMPTY;
import static com.arthurdo.parser.Chars.C_SINGLEQUOTE;

import com.arthurdo.utils.CharUtils;
import com.arthurdo.utils.Unescaper;

public class ParamParser {
	
	private CharUtils charUtils;
	private Unescaper unescaper;

	public ParamParser(CharUtils charUtils, Unescaper unescaper){
		this.charUtils = charUtils;
		this.unescaper = unescaper;
	}
	
	public void parseParams(HtmlTag tag, String buf, int idx, boolean m_unescape)
			throws HtmlException {
		int len = buf.length();
		int begin = 0;

		if (len - 1 >= idx) {
			int end = len - 1;
			while (end > idx && charUtils.isSpace(buf.charAt(end)))
				// remove trailing whitespace
				end--;
			// todo: tag.setWhitespaceAtEnd(buf.substring(end, len-1) );
			if (buf.charAt(end) == C_EMPTY) {
				tag.setEmpty(true);
				end--;
			}
			len = end + 1;
		}

		while (idx < len) {
			begin = idx;
			while (idx < len && charUtils.isSpace(buf.charAt(idx)))
				// skip space before attribute name
				idx++;

			if (idx == len)// at end
				continue;

			String whitespaceBefore = buf.substring(begin, idx);

			begin = idx;
			if (buf.charAt(idx) == C_DOUBLEQUOTE) // how often are attribute
													// names quoted??
			{
				idx++;
				while (idx < len && buf.charAt(idx) != C_DOUBLEQUOTE)
					// look for close quote
					idx++;
				if (idx == len)
					continue; // bad name
				idx++;
			} else if (buf.charAt(idx) == C_SINGLEQUOTE) // how often are
															// attribute names
															// quoted??
			{
				idx++;
				while (idx < len && buf.charAt(idx) != C_SINGLEQUOTE)
					// look for close quote
					idx++;
				if (idx == len)
					continue; // bad name
				idx++;
			} else {
				// if not quoted look for whitespace or '=' to terminate
				// attribute name
				while (idx < len && !charUtils.isSpace(buf.charAt(idx))
						&& buf.charAt(idx) != '=')
					idx++;
			}

			String name = buf.substring(begin, idx);

			begin = idx;
			if (idx < len && charUtils.isSpace(buf.charAt(idx)))// skip
																// whitespace
																// after
			// attribute name
			{
				while (idx < len && charUtils.isSpace(buf.charAt(idx)))
					idx++;
			}

			if (idx == len || buf.charAt(idx) != '=') // attribute name only, no
														// value specified
			{
				// name with empty value
				tag.setParam(name, name); // set the attribute name as the value
											// (SGML tag minimalization rule)
				tag.setWhitespace(name, whitespaceBefore, "");
				continue;
			}
			idx++; // skip past the '='

			if (idx == len)
				continue;

			if (charUtils.isSpace(buf.charAt(idx))) {
				while (idx < len && charUtils.isSpace(buf.charAt(idx)))
					// skip past whitespace after '='
					idx++;

				// special case: if value is surrounded by quotes
				// then it can have a space after the '='
				// if (idx == len || (buf.charAt(idx) != C_DOUBLEQUOTE &&
				// buf.charAt(idx) != C_SINGLEQUOTE))
				if (idx == len) {
					// name with empty value
					tag.setParam(name, name); // set the attribute name as the
												// value (SGML tag
												// minimalization rule)
					tag.setWhitespace(name, whitespaceBefore,
							buf.substring(begin, idx));
					continue;
				}
			}

			char quote = buf.charAt(idx);
			int includeQuote = (quote == C_DOUBLEQUOTE || quote == C_SINGLEQUOTE) ? 1
					: 0;
			String whitespaceAfter = buf.substring(begin, idx + includeQuote);

			begin = idx;
			int end = begin;
			if (quote == C_DOUBLEQUOTE) {
				idx++;
				begin = idx;
				while (idx < len && buf.charAt(idx) != C_DOUBLEQUOTE)
					idx++;
				if (idx == len)
					continue; // bad value
				end = idx;
				idx++;
			} else if (quote == C_SINGLEQUOTE) {
				idx++;
				begin = idx;
				while (idx < len && buf.charAt(idx) != C_SINGLEQUOTE)
					idx++;
				if (idx == len)
					continue; // bad value
				end = idx;
				idx++;
			} else {// not quoted, whitespace terminates attribute value
				while (idx < len && !charUtils.isSpace(buf.charAt(idx)))
					idx++;
				end = idx;
			}

			String value = buf.substring(begin, end);

			if (m_unescape) {
				value = unescaper.unescape(value);
			}

			tag.setParam(name, value);
			tag.setWhitespace(name, whitespaceBefore, whitespaceAfter);
		}
	}
}
