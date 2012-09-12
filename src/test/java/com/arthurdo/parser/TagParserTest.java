package com.arthurdo.parser;

import static org.junit.Assert.assertEquals;

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
		parseTag("");
	}

	@Test(expected = HtmlException.class)
	public void itShouldThrowAnExceptionWhenBufferContainsOnlyWhitespace()
			throws HtmlException, IOException {
		parseTag("    ");
	}

	@Test
	public void itShouldNotThrowAnExceptionWhenBufferIsNotEmpty()
			throws HtmlException, IOException {
		parseTag("Foo");
	}

	@Test
	public void itShouldSetTheTagsTokenWhenBufferIsNotEmpty()
			throws HtmlException, IOException {
		HtmlTag tag = parseTag("Foo");
		verify(tag, "Foo", 3, "Foo", false);
	}

	@Test(expected = HtmlException.class)
	public void itShouldThrowAnExceptionWhenBufferContainsOnlyBackslash()
			throws HtmlException, IOException {
		parseTag("/");
	}

	@Test
	public void itShouldIndicateTheTagIsAnHtmlEndTagWhenBufferContainsSomethingAfterBackslash()
			throws HtmlException, IOException {
		HtmlTag tag = parseTag("/x");
		verify(tag, "x", 2, "/x", true);
	}

	@Test
	public void itShouldParseEmptyTags() throws HtmlException, IOException {
		HtmlTag tag = parseTag("<img></img>");
		verify(tag, "<img><", 6, "<img></img>", false);
	}

	@Test
	public void itShouldParseSelfClosingTags() throws HtmlException,
			IOException {
		HtmlTag tag = parseTag("<img/>");
		verify(tag, "<img", 4, "<img/>", false);
	}

	private HtmlTag parseTag(String string) throws HtmlException {
		StringBuffer stringBuffer = new StringBuffer(string);

		HtmlTag htmlTag = new HtmlTag();
		tagParser.parseTag(stringBuffer, htmlTag);

		return htmlTag;
	}

	public void verify(HtmlTag tag, String tagString, int index, String buffer,
			boolean isEndTag) {
		assertEquals(index, tagParser.getIndex());
		assertEquals(buffer, tagParser.getBuffer());
		assertEquals(isEndTag, tag.isEndTag());
		assertEquals(tagString, tag.getTagString());
	}
}
