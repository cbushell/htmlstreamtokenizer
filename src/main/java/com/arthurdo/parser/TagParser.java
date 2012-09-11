package com.arthurdo.parser;

import static com.arthurdo.parser.Chars.C_EMPTY;
import static com.arthurdo.parser.Chars.C_ENDTAG;

import com.arthurdo.utils.CharUtils;

public class TagParser {

	private CharUtils charUtils;
	private int idx;
	private String buf;

	public TagParser(CharUtils charUtils) {
		this.charUtils = charUtils;
	}

	public void parseTag(StringBuffer sbuf, HtmlTag tag) throws HtmlException {
		tag.reset();

		String buf = sbuf.toString();
		int len = buf.length();
		int idx = 0;
		int begin = 0;

		// parse tag
		while (idx < len && charUtils.isSpace(buf.charAt(idx))) {
			idx++;
		}

		if (idx == len) {
			throw new HtmlException("parse empty tag");
		}

		if (buf.charAt(idx) == C_ENDTAG) {
			tag.setEndTag(true);
			idx++;
		}

		if (idx == len) {
			throw new HtmlException("parse empty tag");
		}

		begin = idx;
		// deal with empty tags like <img/>
		while (idx < len && !charUtils.isSpace(buf.charAt(idx))
				&& buf.charAt(idx) != C_EMPTY) {
			idx++;
		}

		String token = buf.substring(begin, idx);
		tag.setTag(token);
		
		this.buf = buf;
		this.idx = idx;
	}

	public int getIndex() {
		return idx;
	}

	public String getBuffer() {
		return buf;
	}
}
