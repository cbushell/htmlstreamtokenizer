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
		int stringLength = string.length();

		int indexOfFirstNonWhitespaceChar = getIndexOfFirstNonWhitespaceChar(string);


		if (string.charAt(indexOfFirstNonWhitespaceChar) == C_ENDTAG) {
			tag.setEndTag(true);
			indexOfFirstNonWhitespaceChar++;
		}

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

		String token = string.substring(begin,
				indexOfFirstNonWhitespaceChar);
		tag.setTag(token);

		this.buf = string;
		this.idx = indexOfFirstNonWhitespaceChar;
	}

	private int getIndexOfFirstNonWhitespaceChar(String string) throws HtmlException {
		int stringLength = string.length();
		
		int indexOfFirstNonWhitespaceCharacter = 0;

		while (indexOfFirstNonWhitespaceCharacter < stringLength
				&& charUtils.isSpace(string
						.charAt(indexOfFirstNonWhitespaceCharacter))) {
			indexOfFirstNonWhitespaceCharacter++;
		}
		
		if (indexOfFirstNonWhitespaceCharacter == stringLength) {
			throw new HtmlException("parse empty tag");
		}

		
		return indexOfFirstNonWhitespaceCharacter;
	}

	public int getIndex() {
		return idx;
	}

	public String getBuffer() {
		return buf;
	}
}
