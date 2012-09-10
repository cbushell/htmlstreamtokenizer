package com.arthurdo.parser;

public class CharUtils {

	private static final int CTYPE_LEN = 256;

	private static final byte CT_WHITESPACE = 1;

	private static byte m_ctype[] = new byte[CTYPE_LEN];
	
	static {
		int len = m_ctype.length;

		for (int i = 0; i < len; i++) {
			m_ctype[i] = 0;
		}

		m_ctype[' '] = CT_WHITESPACE;
		m_ctype['\r'] = CT_WHITESPACE;
		m_ctype['\n'] = CT_WHITESPACE;
		m_ctype['\t'] = CT_WHITESPACE;
		for (int i = 0x0E; i <= 0x1F; i++) {
			m_ctype[i] = CT_WHITESPACE;
		}
	}

	
	public static boolean isSpace(int c) {
		return c >= 0 && c < CTYPE_LEN ? (m_ctype[c] & CT_WHITESPACE) != 0
				: false;
	}

	public static boolean isPunct(char c) {
		return !Character.isLetterOrDigit(c);
	}

}
