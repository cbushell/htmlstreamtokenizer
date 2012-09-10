package com.arthurdo.parser.helper;

import com.arthurdo.parser.HtmlException;
import com.arthurdo.parser.HtmlStreamTokenizer;
import com.arthurdo.parser.HtmlTag;

public class ElementToken extends Token {

	private String value;

	private boolean empty;
	private boolean invalid;

	public ElementToken(int type, HtmlStreamTokenizer tok) {
		super(type);
		try {
			HtmlTag tag = new HtmlTag();
			tok.parseTag(tok.getStringValue(), tag);

			if (tag.getTagType() == HtmlTag.T_UNKNOWN) {
				throw new HtmlException("this will get caught down below");
			}

			if (tag.isEmpty()) {
				empty = true;
			}

			value = tag.toString();
			invalid = false;
		} catch (HtmlException e) {
			invalid = true;
			value = "<" + tok.getStringValue() + ">";
		}
	}

	@Override
	public String getValue() {
		return value;
	}

	public boolean isEmpty() {
		return empty;
	}

	public boolean isInvalid() {
		return invalid;
	}

}
