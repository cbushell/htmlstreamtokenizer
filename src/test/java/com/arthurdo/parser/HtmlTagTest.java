package com.arthurdo.parser;

import com.arthurdo.parser.HtmlException;
import com.arthurdo.parser.HtmlTag;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class HtmlTagTest {

    private HtmlTag tag;

    @Before
    public void setup() {
        tag = new HtmlTag();
    }

    @Test
    public void shouldFindH6() throws HtmlException {
        tag.setTag("h6");
        assertEquals(HtmlMapper.T_H6, tag.getTagType());
    }

    @Test
    public void shouldNotFindH7() throws HtmlException {
        tag.setTag("h7");
        assertEquals(HtmlTag.T_UNKNOWN, tag.getTagType());
    }
    
    @Test
    public void shouldFindBody() throws HtmlException {
    	tag.setTag("Body");
        assertEquals(HtmlMapper.T_BODY, tag.getTagType());    	
    }
}
