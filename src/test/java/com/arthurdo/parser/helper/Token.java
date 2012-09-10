package com.arthurdo.parser.helper;


abstract public class Token {

    final private int _type;

    protected Token(int _type) {
        this._type = _type;
    }

    final public int getType() {
        return _type;
    }

    abstract public String getValue();
}
