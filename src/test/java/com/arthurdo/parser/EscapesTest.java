package com.arthurdo.parser;

import junit.framework.Assert;

import org.junit.Test;

public class EscapesTest {

	@Test
	public void foo(){
		Escapes escapes = new Escapes();
		Assert.assertEquals(new Character('\u00c1'), escapes.get("Aacute"));
	}
}
