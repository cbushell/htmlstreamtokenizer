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

	public void parseTag(StringBuffer stringBuffer, HtmlTag tag)
			throws HtmlException {
		tag.reset();

		String string = stringBuffer.toString();

		int indexOfFirstNonWhitespaceChar = getIndexOfFirstNonWhitespaceChar(string);

		if (isHtmlEndTag(string, indexOfFirstNonWhitespaceChar)) {
			tag.setEndTag(true);
			indexOfFirstNonWhitespaceChar++;
		}

		int stringLength = string.length();

		if (indexOfFirstNonWhitespaceChar == stringLength) {
			throw new HtmlException("parse empty tag");
		}

		int begin = indexOfFirstNonWhitespaceChar;

		// deal with empty tags like <img/>
		while (indexOfFirstNonWhitespaceChar < stringLength
				&& !charUtils.isSpace(string
						.charAt(indexOfFirstNonWhitespaceChar))
				&& string.charAt(indexOfFirstNonWhitespaceChar) != C_EMPTY) {
			indexOfFirstNonWhitespaceChar++;
		}

		String token = string.substring(begin, indexOfFirstNonWhitespaceChar);
		tag.setTag(token);

		this.buf = string;
		this.idx = indexOfFirstNonWhitespaceChar;
	}

	private boolean isHtmlEndTag(String string,
			int indexOfFirstNonWhitespaceChar) {
		return string.charAt(indexOfFirstNonWhitespaceChar) == C_ENDTAG;
	}

	private int getIndexOfFirstNonWhitespaceChar(String string)
			throws HtmlException {
		int index = 0;

		for (char c : string.toCharArray()) {
			if (charUtils.isSpace(c)) {
				index++;
			} else {
				break;
			}
		}

		if (index == string.length()) {
			throw new HtmlException("parse empty tag");
		}

		return index;
	}

	public int getIndex() {
		return idx;
	}

	public String getBuffer() {
		return buf;
	}
}
