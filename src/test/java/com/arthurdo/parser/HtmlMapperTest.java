package com.arthurdo.parser;

import org.junit.Assert;
import org.junit.Test;

public class HtmlMapperTest {

	@Test
	public void itShouldMapHtmlBodyElement(){
		HtmlMapper htmlMapper = new HtmlMapper();
		Assert.assertEquals(new Integer(16), htmlMapper.get("BODY"));
	}
}
