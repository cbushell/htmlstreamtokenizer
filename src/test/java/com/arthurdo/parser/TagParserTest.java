package com.arthurdo.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
		parse("");
	}

	@Test(expected = HtmlException.class)
	public void itShouldThrowAnExceptionWhenBufferContainsOnlyWhitespace()
			throws HtmlException, IOException {
		parse("    ");
	}

	@Test
	public void itShouldNotThrowAnExceptionWhenBufferIsNotEmpty()
			throws HtmlException, IOException {
		parse("Foo");
	}

	@Test
	public void itShouldSetTheTagsTokenWhenBufferIsNotEmpty()
			throws HtmlException, IOException {
		HtmlTag tag = parse("Foo");
		assertEquals("Foo", tag.getTagString());
		assertEquals(3, tagParser.getIndex());
	}

	@Test(expected = HtmlException.class)
	public void itShouldThrowAnExceptionWhenBufferContainsOnlyBackslash()
			throws HtmlException, IOException {
		parse("/");
	}

	@Test
	public void itShouldIndicateTheTagIsAnHtmlEndTagWhenBufferContainsSomethingAfterBackslash()
			throws HtmlException, IOException {
		HtmlTag tag = parse("/x");
		assertTrue(tag.isEndTag());
		assertEquals(2, tagParser.getIndex());
	}

	@Test
	public void itShouldParseEmptyTags() throws HtmlException, IOException {
		HtmlTag tag = parse("<img></img>");
		assertEquals("<img><", tag.getTagString());
		assertEquals(6, tagParser.getIndex());
	}

	@Test
	public void itShouldParseSelfClosingTags() throws HtmlException,
			IOException {
		HtmlTag tag = parse("<img/>");
		assertEquals("<img", tag.getTagString());
		assertEquals(4, tagParser.getIndex());
	}

	private HtmlTag parse(String string) throws HtmlException {
		StringBuffer stringBuffer = new StringBuffer(string);

		HtmlTag htmlTag = new HtmlTag();
		tagParser.parseTag(stringBuffer, htmlTag);

		return htmlTag;
	}

}
