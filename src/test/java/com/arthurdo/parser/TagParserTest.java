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
	}

	@Test
	public void itShouldParseEmptyTags() throws HtmlException, IOException {
		HtmlTag tag = parse("<img></img>");
		assertEquals("<img><", tag.getTagString());
	}

	@Test
	public void itShouldParseSelfClosingTags() throws HtmlException,
			IOException {
		HtmlTag tag = parse("<img/>");
		assertEquals("<img", tag.getTagString());
	}

	private HtmlTag parse(String string) throws HtmlException {
		StringBuffer stringBuffer = new StringBuffer(string);

		HtmlTag htmlTag = new HtmlTag();
		tagParser.parseTag(stringBuffer, htmlTag);

		return htmlTag;
	}

}
