package com.arthurdo.utils;

import junit.framework.Assert;

import org.junit.Test;

import com.arthurdo.utils.EscapeMapper;

public class EscapeMapperTest {

	@Test
	public void foo(){
		EscapeMapper escapeMapper = new EscapeMapper();
		Assert.assertEquals(new Character('\u00c1'), escapeMapper.get("Aacute"));
	}
}
