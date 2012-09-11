package com.arthurdo.parser;

import java.util.Hashtable;

public class HtmlMapper {

	private Hashtable<String, Integer> mappings = new Hashtable<String, Integer>();

	public static final int T_A = 1;
	public static final int T_ABBREV = 2;
	public static final int T_ACRONYM = 3;
	public static final int T_ADDRESS = 4;
	public static final int T_APPLET = 5;
	public static final int T_AREA = 6;
	public static final int T_AU = 7;
	public static final int T_B = 8;
	public static final int T_BANNER = 9;
	public static final int T_BASE = 10;
	public static final int T_BASEFONT = 11;
	public static final int T_BGSOUND = 12;
	public static final int T_BIG = 13;
	public static final int T_BLINK = 14;
	public static final int T_BLOCKQUOTE = 15;
	public static final int T_BODY = 16;
	public static final int T_BR = 17;
	public static final int T_CAPTION = 18;
	public static final int T_CENTER = 19;
	public static final int T_CITE = 20;
	public static final int T_CODE = 21;
	public static final int T_COL = 22;
	public static final int T_COLGROUP = 23;
	public static final int T_CREDIT = 24;
	public static final int T_DD = 25;
	public static final int T_DEL = 26;
	public static final int T_DFN = 27;
	public static final int T_DIR = 28;
	public static final int T_DIV = 29;
	public static final int T_DL = 30;
	public static final int T_DT = 31;
	public static final int T_EM = 32;
	public static final int T_EMBED = 33;
	public static final int T_FIG = 34;
	public static final int T_FN = 35;
	public static final int T_FONT = 36;
	public static final int T_FORM = 37;
	public static final int T_FRAME = 38;
	public static final int T_FRAMESET = 39;
	public static final int T_H1 = 40;
	public static final int T_H2 = 41;
	public static final int T_H3 = 42;
	public static final int T_H4 = 43;
	public static final int T_H5 = 44;
	public static final int T_H6 = 45;
	public static final int T_HEAD = 46;
	public static final int T_HTML = 47;
	public static final int T_HR = 48;
	public static final int T_I = 49;
	public static final int T_IMG = 50;
	public static final int T_INPUT = 51;
	public static final int T_INS = 52;
	public static final int T_ISINDEX = 53;
	public static final int T_KBD = 54;
	public static final int T_LANG = 55;
	public static final int T_LH = 56;
	public static final int T_LI = 57;
	public static final int T_LINK = 58;
	public static final int T_MAP = 59;
	public static final int T_MARQUEE = 60;
	public static final int T_MENU = 61;
	public static final int T_META = 62;
	public static final int T_NEXTID = 63;
	public static final int T_NOBR = 64;
	public static final int T_NOEMBED = 65;
	public static final int T_NOFRAME = 66;
	public static final int T_NOFRAMES = 67;
	public static final int T_NOTE = 68;
	public static final int T_OBJECT = 69;
	public static final int T_OL = 70;
	public static final int T_OPTION = 71;
	public static final int T_OVERLAY = 72;
	public static final int T_P = 73;
	public static final int T_PARAM = 74;
	public static final int T_PERSON = 75;
	public static final int T_PRE = 76;
	public static final int T_Q = 77;
	public static final int T_RANGE = 78;
	public static final int T_S = 79;
	public static final int T_SAMP = 80;
	public static final int T_SCRIPT = 81;
	public static final int T_SELECT = 82;
	public static final int T_SMALL = 83;
	public static final int T_SPOT = 84;
	public static final int T_STRONG = 85;
	public static final int T_STYLE = 86;
	public static final int T_SUB = 87;
	public static final int T_SUP = 88;
	public static final int T_TAB = 89;
	public static final int T_TABLE = 90;
	public static final int T_TBODY = 91;
	public static final int T_TD = 92;
	public static final int T_TEXTAREA = 93;
	public static final int T_TFOOT = 94;
	public static final int T_TH = 95;
	public static final int T_THEAD = 96;
	public static final int T_TITLE = 97;
	public static final int T_TR = 98;
	public static final int T_TT = 99;
	public static final int T_U = 100;
	public static final int T_UL = 101;
	public static final int T_VAR = 102;
	public static final int T_WBR = 103;
	public static final int T_IFRAME = 104;
	public static final int T_DOCTYPE = 105;

	public HtmlMapper() {
		mappings.put(new String("A"), new Integer(T_A));
		mappings.put(new String("ABBREV"), new Integer(T_ABBREV));
		mappings.put(new String("ACRONYM"), new Integer(T_ACRONYM));
		mappings.put(new String("ADDRESS"), new Integer(T_ADDRESS));
		mappings.put(new String("APPLET"), new Integer(T_APPLET));
		mappings.put(new String("AREA"), new Integer(T_AREA));
		mappings.put(new String("AU"), new Integer(T_AU));
		mappings.put(new String("B"), new Integer(T_B));
		mappings.put(new String("BANNER"), new Integer(T_BANNER));
		mappings.put(new String("BASE"), new Integer(T_BASE));
		mappings.put(new String("BASEFONT"), new Integer(T_BASEFONT));
		mappings.put(new String("BGSOUND"), new Integer(T_BGSOUND));
		mappings.put(new String("BIG"), new Integer(T_BIG));
		mappings.put(new String("BLINK"), new Integer(T_BLINK));
		mappings.put(new String("BLOCKQUOTE"), new Integer(T_BLOCKQUOTE));
		mappings.put(new String("BODY"), new Integer(T_BODY));
		mappings.put(new String("BR"), new Integer(T_BR));
		mappings.put(new String("CAPTION"), new Integer(T_CAPTION));
		mappings.put(new String("CENTER"), new Integer(T_CENTER));
		mappings.put(new String("CITE"), new Integer(T_CITE));
		mappings.put(new String("CODE"), new Integer(T_CODE));
		mappings.put(new String("COL"), new Integer(T_COL));
		mappings.put(new String("COLGROUP"), new Integer(T_COLGROUP));
		mappings.put(new String("CREDIT"), new Integer(T_CREDIT));
		mappings.put(new String("DD"), new Integer(T_DD));
		mappings.put(new String("DEL"), new Integer(T_DEL));
		mappings.put(new String("DFN"), new Integer(T_DFN));
		mappings.put(new String("DIR"), new Integer(T_DIR));
		mappings.put(new String("DIV"), new Integer(T_DIV));
		mappings.put(new String("DL"), new Integer(T_DL));
		mappings.put(new String("!DOCTYPE"), new Integer(T_DOCTYPE));
		mappings.put(new String("DT"), new Integer(T_DT));
		mappings.put(new String("EM"), new Integer(T_EM));
		mappings.put(new String("EMBED"), new Integer(T_EMBED));
		mappings.put(new String("FIG"), new Integer(T_FIG));
		mappings.put(new String("FN"), new Integer(T_FN));
		mappings.put(new String("FONT"), new Integer(T_FONT));
		mappings.put(new String("FORM"), new Integer(T_FORM));
		mappings.put(new String("FRAME"), new Integer(T_FRAME));
		mappings.put(new String("FRAMESET"), new Integer(T_FRAMESET));
		mappings.put(new String("H1"), new Integer(T_H1));
		mappings.put(new String("H2"), new Integer(T_H2));
		mappings.put(new String("H3"), new Integer(T_H3));
		mappings.put(new String("H4"), new Integer(T_H4));
		mappings.put(new String("H5"), new Integer(T_H5));
		mappings.put(new String("H6"), new Integer(T_H6));
		mappings.put(new String("HEAD"), new Integer(T_HEAD));
		mappings.put(new String("HTML"), new Integer(T_HTML));
		mappings.put(new String("HR"), new Integer(T_HR));
		mappings.put(new String("I"), new Integer(T_I));
		mappings.put(new String("IMG"), new Integer(T_IMG));
		mappings.put(new String("INPUT"), new Integer(T_INPUT));
		mappings.put(new String("INS"), new Integer(T_INS));
		mappings.put(new String("ISINDEX"), new Integer(T_ISINDEX));
		mappings.put(new String("KBD"), new Integer(T_KBD));
		mappings.put(new String("LANG"), new Integer(T_LANG));
		mappings.put(new String("LH"), new Integer(T_LH));
		mappings.put(new String("LI"), new Integer(T_LI));
		mappings.put(new String("LINK"), new Integer(T_LINK));
		mappings.put(new String("MAP"), new Integer(T_MAP));
		mappings.put(new String("MARQUEE"), new Integer(T_MARQUEE));
		mappings.put(new String("MENU"), new Integer(T_MENU));
		mappings.put(new String("META"), new Integer(T_META));
		mappings.put(new String("NEXTID"), new Integer(T_NEXTID));
		mappings.put(new String("NOBR"), new Integer(T_NOBR));
		mappings.put(new String("NOEMBED"), new Integer(T_NOEMBED));
		mappings.put(new String("NOFRAME"), new Integer(T_NOFRAME));
		mappings.put(new String("NOFRAMES"), new Integer(T_NOFRAMES));
		mappings.put(new String("NOTE"), new Integer(T_NOTE));
		mappings.put(new String("OBJECT"), new Integer(T_OBJECT));
		mappings.put(new String("OL"), new Integer(T_OL));
		mappings.put(new String("OPTION"), new Integer(T_OPTION));
		mappings.put(new String("OVERLAY"), new Integer(T_OVERLAY));
		mappings.put(new String("P"), new Integer(T_P));
		mappings.put(new String("PARAM"), new Integer(T_PARAM));
		mappings.put(new String("PERSON"), new Integer(T_PERSON));
		mappings.put(new String("PRE"), new Integer(T_PRE));
		mappings.put(new String("Q"), new Integer(T_Q));
		mappings.put(new String("RANGE"), new Integer(T_RANGE));
		mappings.put(new String("S"), new Integer(T_S));
		mappings.put(new String("SAMP"), new Integer(T_SAMP));
		mappings.put(new String("SCRIPT"), new Integer(T_SCRIPT));
		mappings.put(new String("SELECT"), new Integer(T_SELECT));
		mappings.put(new String("SMALL"), new Integer(T_SMALL));
		mappings.put(new String("SPOT"), new Integer(T_SPOT));
		mappings.put(new String("STRONG"), new Integer(T_STRONG));
		mappings.put(new String("STYLE"), new Integer(T_STYLE));
		mappings.put(new String("SUB"), new Integer(T_SUB));
		mappings.put(new String("SUP"), new Integer(T_SUP));
		mappings.put(new String("TAB"), new Integer(T_TAB));
		mappings.put(new String("TABLE"), new Integer(T_TABLE));
		mappings.put(new String("TBODY"), new Integer(T_TBODY));
		mappings.put(new String("TD"), new Integer(T_TD));
		mappings.put(new String("TEXTAREA"), new Integer(T_TEXTAREA));
		mappings.put(new String("TFOOT"), new Integer(T_TFOOT));
		mappings.put(new String("TH"), new Integer(T_TH));
		mappings.put(new String("THEAD"), new Integer(T_THEAD));
		mappings.put(new String("TITLE"), new Integer(T_TITLE));
		mappings.put(new String("TR"), new Integer(T_TR));
		mappings.put(new String("TT"), new Integer(T_TT));
		mappings.put(new String("U"), new Integer(T_U));
		mappings.put(new String("UL"), new Integer(T_UL));
		mappings.put(new String("VAR"), new Integer(T_VAR));
		mappings.put(new String("WBR"), new Integer(T_WBR));
		mappings.put(new String("IFRAME"), new Integer(T_IFRAME));
	}

	public Integer get(String htmlTag) {
		return mappings.get(htmlTag);
	}
}
