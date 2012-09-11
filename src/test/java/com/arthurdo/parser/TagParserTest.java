package com.arthurdo.parser;

import java.io.IOException;

import org.junit.Test;

import com.arthurdo.utils.CharUtils;

public class TagParserTest {

	@Test(expected = HtmlException.class)
	public void itShouldThrowAnExceptionWhenBufferIsEmpty() throws HtmlException, IOException {
		CharUtils charUtils = new CharUtils();
		TagParser tagParser = new TagParser(charUtils);
		
		HtmlTag tag = new HtmlTag();
		StringBuffer sbuf = new StringBuffer();
		
		tagParser.parseTag(sbuf , tag);
	}

}
