package com.arthurdo.parser;

import java.util.Hashtable;

public class Escapes {
	private static Hashtable<String, Character> escapes = new Hashtable<String, Character>();

	public Escapes(){
		escapes.put(new String("Aacute"), new Character('\u00c1'));
		escapes.put(new String("aacute"), new Character('\u00e1'));
		escapes.put(new String("Acirc"), new Character('\u00c2'));
		escapes.put(new String("acirc"), new Character('\u00e2'));
		escapes.put(new String("AElig"), new Character('\u00c6'));
		escapes.put(new String("aelig"), new Character('\u00e6'));
		escapes.put(new String("Agrave"), new Character('\u00c0'));
		escapes.put(new String("agrave"), new Character('\u00e0'));
		escapes.put(new String("amp"), new Character('&'));
		escapes.put(new String("aring"), new Character('\u00e5'));
		escapes.put(new String("Atilde"), new Character('\u00c3'));
		escapes.put(new String("atilde"), new Character('\u00e3'));
		escapes.put(new String("Auml"), new Character('\u00c4'));
		escapes.put(new String("auml"), new Character('\u00e4'));
		escapes.put(new String("brvbar"), new Character('\u00a6'));
		escapes.put(new String("Ccedil"), new Character('\u00c7'));
		escapes.put(new String("ccedil"), new Character('\u00e7'));
		escapes.put(new String("cent"), new Character('\u00a2'));
		escapes.put(new String("copy"), new Character('\u00a9'));
		escapes.put(new String("deg"), new Character('\u00b0'));
		escapes.put(new String("Eacute"), new Character('\u00c9'));
		escapes.put(new String("eacute"), new Character('\u00e9'));
		escapes.put(new String("Ecirc"), new Character('\u00ca'));
		escapes.put(new String("ecirc"), new Character('\u00ea'));
		escapes.put(new String("Egrave"), new Character('\u00c8'));
		escapes.put(new String("egrave"), new Character('\u00e8'));
		escapes.put(new String("ETH"), new Character('\u00d0'));
		escapes.put(new String("eth"), new Character('\u00f0'));
		escapes.put(new String("Euml"), new Character('\u00cb'));
		escapes.put(new String("euml"), new Character('\u00eb'));
		escapes.put(new String("frac12"), new Character('\u00bd'));
		escapes.put(new String("frac14"), new Character('\u00bc'));
		escapes.put(new String("frac34"), new Character('\u00be'));
		escapes.put(new String("gt"), new Character('>'));
		escapes.put(new String("iacute"), new Character('\u00ed'));
		escapes.put(new String("Icirc"), new Character('\u00ce'));
		escapes.put(new String("icirc"), new Character('\u00ee'));
		escapes.put(new String("iexcl"), new Character('\u00a1'));
		escapes.put(new String("Igrave"), new Character('\u00cc'));
		escapes.put(new String("igrave"), new Character('\u00ec'));
		escapes.put(new String("iquest"), new Character('\u00bf'));
		escapes.put(new String("Iuml"), new Character('\u00cf'));
		escapes.put(new String("iuml"), new Character('\u00ef'));
		escapes.put(new String("laquo"), new Character('\u00ab'));
		escapes.put(new String("lt"), new Character('<'));
		escapes.put(new String("middot"), new Character('\u00b7'));
		escapes.put(new String("nbsp"), new Character('\u00A0'));
		escapes.put(new String("not"), new Character('\u00ac'));
		escapes.put(new String("Ntilde"), new Character('\u00d1'));
		escapes.put(new String("ntilde"), new Character('\u00f1'));
		escapes.put(new String("Oacute"), new Character('\u00d3'));
		escapes.put(new String("oacute"), new Character('\u00f3'));
		escapes.put(new String("Ocirc"), new Character('\u00d4'));
		escapes.put(new String("ocirc"), new Character('\u00f4'));
		escapes.put(new String("Ograve"), new Character('\u00d2'));
		escapes.put(new String("ograve"), new Character('\u00f2'));
		escapes.put(new String("Oslash"), new Character('\u00d8'));
		escapes.put(new String("oslash"), new Character('\u00f8'));
		escapes.put(new String("Otilde"), new Character('\u00d5'));
		escapes.put(new String("otilde"), new Character('\u00f5'));
		escapes.put(new String("Ouml"), new Character('\u00d6'));
		escapes.put(new String("ouml"), new Character('\u00f6'));
		escapes.put(new String("para"), new Character('\u00b6'));
		escapes.put(new String("plusmn"), new Character('\u00b1'));
		escapes.put(new String("pound"), new Character('\u00a3'));
		escapes.put(new String("quot"), new Character('"'));
		escapes.put(new String("reg"), new Character('\u00ae'));
		escapes.put(new String("sect"), new Character('\u00a7'));
		escapes.put(new String("sup1"), new Character('\u00b9'));
		escapes.put(new String("sup2"), new Character('\u00b2'));
		escapes.put(new String("sup3"), new Character('\u00b3'));
		escapes.put(new String("szlig"), new Character('\u00df'));
		escapes.put(new String("THORN"), new Character('\u00de'));
		escapes.put(new String("thorn"), new Character('\u00fe'));
		escapes.put(new String("Uacute"), new Character('\u00da'));
		escapes.put(new String("uacute"), new Character('\u00fa'));
		escapes.put(new String("Ucirc"), new Character('\u00db'));
		escapes.put(new String("ucirc"), new Character('\u00fb'));
		escapes.put(new String("Ugrave"), new Character('\u00d9'));
		escapes.put(new String("ugrave"), new Character('\u00f9'));
		escapes.put(new String("Uuml"), new Character('\u00dc'));
		escapes.put(new String("uuml"), new Character('\u00fc'));
		escapes.put(new String("Yacute"), new Character('\u00dd'));
		escapes.put(new String("yacute"), new Character('\u00fd'));
		escapes.put(new String("yen"), new Character('\u00a5'));
		escapes.put(new String("yuml"), new Character('\u00ff'));
	}

	public Character get(String string) {
		return escapes.get(string);
	}
}
