package com.arthurdo.parser.helper;

public class OtherToken extends Token {

	final private String value;

	public OtherToken(int type, String value) {
		super(type);
		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}
}
