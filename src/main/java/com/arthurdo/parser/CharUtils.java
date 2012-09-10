package com.arthurdo.parser;

public class CharUtils {

	private static final int CTYPE_LEN = 256;

	private static final byte CT_WHITESPACE = 1;

	private static byte m_ctype[] = new byte[CTYPE_LEN];
	

	public static boolean isSpace(int c) {
		return c >= 0 && c < CTYPE_LEN ? (m_ctype[c] & CT_WHITESPACE) != 0
				: false;
	}

	public static boolean isPunct(char c) {
		return !Character.isLetterOrDigit(c);
	}

}
