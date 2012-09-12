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

		if (indexOfFirstNonWhitespaceChar == string.length()) {
			throw new HtmlException("parse empty tag");
		}

		int endIndex = getIndexOfCharacterTagOfToken(string,
				indexOfFirstNonWhitespaceChar);

		String token = string
				.substring(indexOfFirstNonWhitespaceChar, endIndex);
		tag.setTag(token);

		this.buf = string;
		this.idx = endIndex;
	}

	private int getIndexOfCharacterTagOfToken(String string,
			int indexOfFirstNonWhitespaceChar) {
		int stringLength = string.length();
		int index = indexOfFirstNonWhitespaceChar;

		while (index < stringLength && !charUtils.isSpace(string.charAt(index))
				&& string.charAt(index) != C_EMPTY) {
			index++;
		}

		return index;
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
