package com.arthurdo.parser;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class HtmlTagTest {

    private HtmlTag tag;

    @Test
    public void shouldFindH6() throws HtmlException {
        tag = new HtmlTag();
        tag.setTag("h6");
        assertEquals(Tags.m_tags.get("H6"), tag.getTagType());
    }

    @Test
    public void shouldNotFindH7() throws HtmlException {
        tag = new HtmlTag();
        tag.setTag("h7");
        assertEquals(Tags.m_tags.get("UNKNOWN"), tag.getTagType());
    }
}
