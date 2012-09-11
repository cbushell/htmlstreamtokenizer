package com.arthurdo.parser;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.arthurdo.utils.CharUtils;

public class TagParserTest {

	private TagParser tagParser;

	@Before
	public void setup() {
		CharUtils charUtils = new CharUtils();
		tagParser = new TagParser(charUtils);
	}

	@Test(expected = HtmlException.class)
	public void itShouldThrowAnExceptionWhenBufferIsEmpty()
			throws HtmlException, IOException {
		StringBuffer sbuf = new StringBuffer();

		tagParser.parseTag(sbuf, new HtmlTag());
	}

	@Test(expected = HtmlException.class)
	public void itShouldThrowAnExceptionWhenBufferContainsOnlyWhitespace()
			throws HtmlException, IOException {
		StringBuffer sbuf = new StringBuffer("    ");

		tagParser.parseTag(sbuf, new HtmlTag());
	}

	@Test
	public void itShouldNotThrowAnExceptionWhenBufferIsNotEmpty()
			throws HtmlException, IOException {
		StringBuffer sbuf = new StringBuffer("Foo");

		tagParser.parseTag(sbuf, new HtmlTag());
	}

}
