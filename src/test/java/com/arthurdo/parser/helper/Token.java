package com.arthurdo.parser.helper;

abstract public class Token {

	final private int type;

	protected Token(int _type) {
		this.type = _type;
	}

	final public int getType() {
		return type;
	}

	abstract public String getValue();
}
