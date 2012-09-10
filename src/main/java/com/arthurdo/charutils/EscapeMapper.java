package com.arthurdo.charutils;

import java.util.Hashtable;

public class EscapeMapper {
	
	private static Hashtable<String, Character> mappings = new Hashtable<String, Character>();

	public EscapeMapper(){
		mappings.put(new String("Aacute"), new Character('\u00c1'));
		mappings.put(new String("aacute"), new Character('\u00e1'));
		mappings.put(new String("Acirc"), new Character('\u00c2'));
		mappings.put(new String("acirc"), new Character('\u00e2'));
		mappings.put(new String("AElig"), new Character('\u00c6'));
		mappings.put(new String("aelig"), new Character('\u00e6'));
		mappings.put(new String("Agrave"), new Character('\u00c0'));
		mappings.put(new String("agrave"), new Character('\u00e0'));
		mappings.put(new String("amp"), new Character('&'));
		mappings.put(new String("aring"), new Character('\u00e5'));
		mappings.put(new String("Atilde"), new Character('\u00c3'));
		mappings.put(new String("atilde"), new Character('\u00e3'));
		mappings.put(new String("Auml"), new Character('\u00c4'));
		mappings.put(new String("auml"), new Character('\u00e4'));
		mappings.put(new String("brvbar"), new Character('\u00a6'));
		mappings.put(new String("Ccedil"), new Character('\u00c7'));
		mappings.put(new String("ccedil"), new Character('\u00e7'));
		mappings.put(new String("cent"), new Character('\u00a2'));
		mappings.put(new String("copy"), new Character('\u00a9'));
		mappings.put(new String("deg"), new Character('\u00b0'));
		mappings.put(new String("Eacute"), new Character('\u00c9'));
		mappings.put(new String("eacute"), new Character('\u00e9'));
		mappings.put(new String("Ecirc"), new Character('\u00ca'));
		mappings.put(new String("ecirc"), new Character('\u00ea'));
		mappings.put(new String("Egrave"), new Character('\u00c8'));
		mappings.put(new String("egrave"), new Character('\u00e8'));
		mappings.put(new String("ETH"), new Character('\u00d0'));
		mappings.put(new String("eth"), new Character('\u00f0'));
		mappings.put(new String("Euml"), new Character('\u00cb'));
		mappings.put(new String("euml"), new Character('\u00eb'));
		mappings.put(new String("frac12"), new Character('\u00bd'));
		mappings.put(new String("frac14"), new Character('\u00bc'));
		mappings.put(new String("frac34"), new Character('\u00be'));
		mappings.put(new String("gt"), new Character('>'));
		mappings.put(new String("iacute"), new Character('\u00ed'));
		mappings.put(new String("Icirc"), new Character('\u00ce'));
		mappings.put(new String("icirc"), new Character('\u00ee'));
		mappings.put(new String("iexcl"), new Character('\u00a1'));
		mappings.put(new String("Igrave"), new Character('\u00cc'));
		mappings.put(new String("igrave"), new Character('\u00ec'));
		mappings.put(new String("iquest"), new Character('\u00bf'));
		mappings.put(new String("Iuml"), new Character('\u00cf'));
		mappings.put(new String("iuml"), new Character('\u00ef'));
		mappings.put(new String("laquo"), new Character('\u00ab'));
		mappings.put(new String("lt"), new Character('<'));
		mappings.put(new String("middot"), new Character('\u00b7'));
		mappings.put(new String("nbsp"), new Character('\u00A0'));
		mappings.put(new String("not"), new Character('\u00ac'));
		mappings.put(new String("Ntilde"), new Character('\u00d1'));
		mappings.put(new String("ntilde"), new Character('\u00f1'));
		mappings.put(new String("Oacute"), new Character('\u00d3'));
		mappings.put(new String("oacute"), new Character('\u00f3'));
		mappings.put(new String("Ocirc"), new Character('\u00d4'));
		mappings.put(new String("ocirc"), new Character('\u00f4'));
		mappings.put(new String("Ograve"), new Character('\u00d2'));
		mappings.put(new String("ograve"), new Character('\u00f2'));
		mappings.put(new String("Oslash"), new Character('\u00d8'));
		mappings.put(new String("oslash"), new Character('\u00f8'));
		mappings.put(new String("Otilde"), new Character('\u00d5'));
		mappings.put(new String("otilde"), new Character('\u00f5'));
		mappings.put(new String("Ouml"), new Character('\u00d6'));
		mappings.put(new String("ouml"), new Character('\u00f6'));
		mappings.put(new String("para"), new Character('\u00b6'));
		mappings.put(new String("plusmn"), new Character('\u00b1'));
		mappings.put(new String("pound"), new Character('\u00a3'));
		mappings.put(new String("quot"), new Character('"'));
		mappings.put(new String("reg"), new Character('\u00ae'));
		mappings.put(new String("sect"), new Character('\u00a7'));
		mappings.put(new String("sup1"), new Character('\u00b9'));
		mappings.put(new String("sup2"), new Character('\u00b2'));
		mappings.put(new String("sup3"), new Character('\u00b3'));
		mappings.put(new String("szlig"), new Character('\u00df'));
		mappings.put(new String("THORN"), new Character('\u00de'));
		mappings.put(new String("thorn"), new Character('\u00fe'));
		mappings.put(new String("Uacute"), new Character('\u00da'));
		mappings.put(new String("uacute"), new Character('\u00fa'));
		mappings.put(new String("Ucirc"), new Character('\u00db'));
		mappings.put(new String("ucirc"), new Character('\u00fb'));
		mappings.put(new String("Ugrave"), new Character('\u00d9'));
		mappings.put(new String("ugrave"), new Character('\u00f9'));
		mappings.put(new String("Uuml"), new Character('\u00dc'));
		mappings.put(new String("uuml"), new Character('\u00fc'));
		mappings.put(new String("Yacute"), new Character('\u00dd'));
		mappings.put(new String("yacute"), new Character('\u00fd'));
		mappings.put(new String("yen"), new Character('\u00a5'));
		mappings.put(new String("yuml"), new Character('\u00ff'));
	}

	public Character get(String string) {
		return mappings.get(string);
	}
}
