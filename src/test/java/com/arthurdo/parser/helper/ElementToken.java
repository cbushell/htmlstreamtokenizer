package com.arthurdo.parser.helper;

import com.arthurdo.parser.HtmlException;
import com.arthurdo.parser.HtmlStreamTokenizer;
import com.arthurdo.parser.HtmlTag;
import com.arthurdo.parser.Tags;

public class ElementToken extends Token {

    private boolean _empty;
    private String _value;
    private boolean _invalid;

    public ElementToken(int type, HtmlStreamTokenizer tok) {
        super(type);
        try
        {
            HtmlTag tag = new HtmlTag();
            tok.parseTag(tok.getStringValue(), tag);
            if (tag.getTagType() == Tags.tags.UNKNOWN.ordinal())
                throw new HtmlException("this will get caught down below");
            if (tag.isEmpty()) {
                _empty = true;
            }
            _value = tag.toString();
            _invalid = false;
        }
        catch (HtmlException e)
        {
            _invalid = true;
            _value = "<" + tok.getStringValue() + ">";
        }
    }

    @Override
    public String getValue() {
        return _value;
    }

    public boolean isEmpty() {
        return _empty;
    }

    public boolean isInvalid() {
        return _invalid;
    }

}
