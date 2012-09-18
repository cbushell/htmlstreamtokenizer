package com.arthurdo.parser;

import java.util.Hashtable;

public class Tags {

    public enum tags {
        T_UNKNOWN,
        T_A,
        T_ABBREV,
        T_ACRONYM,
        T_ADDRESS,
        T_APPLET,
        T_AREA,
        T_AU,
        T_B,
        T_BANNER,
        T_BASE,
        T_BASEFONT,
        T_BGSOUND,
        T_BIG,
        T_BLINK,
        T_BLOCKQUOTE,
        T_BODY,
        T_BR,
        T_CAPTION,
        T_CENTER,
        T_CITE,
        T_CODE,
        T_COL,
        T_COLGROUP,
        T_CREDIT,
        T_DD,
        T_DEL,
        T_DFN,
        T_DIR,
        T_DIV,
        T_DL,
        T_DT,
        T_EM,
        T_EMBED,
        T_FIG,
        T_FN,
        T_FONT,
        T_FORM,
        T_FRAME,
        T_FRAMESET,
        T_H1,
        T_H2,
        T_H3,
        T_H4,
        T_H5,
        T_H6,
        T_HEAD,
        T_HTML,
        T_HR,
        T_I,
        T_IMG,
        T_INPUT,
        T_INS,
        T_ISINDEX,
        T_KBD,
        T_LANG,
        T_LH,
        T_LI,
        T_LINK,
        T_MAP,
        T_MARQUEE,
        T_MENU,
        T_META,
        T_NEXTID,
        T_NOBR,
        T_NOEMBED,
        T_NOFRAME,
        T_NOFRAMES,
        T_NOTE,
        T_OBJECT,
        T_OL,
        T_OPTION,
        T_OVERLAY,
        T_P,
        T_PARAM,
        T_PERSON,
        T_PRE,
        T_Q,
        T_RANGE,
        T_S,
        T_SAMP,
        T_SCRIPT,
        T_SELECT,
        T_SMALL,
        T_SPOT,
        T_STRONG,
        T_STYLE,
        T_SUB,
        T_SUP,
        T_TAB,
        T_TABLE,
        T_TBODY,
        T_TD,
        T_TEXTAREA,
        T_TFOOT,
        T_TH,
        T_THEAD,
        T_TITLE,
        T_TR,
        T_TT,
        T_U,
        T_UL,
        T_VAR,
        T_WBR,
        T_IFRAME,
        T__DOCTYPE,
    }

    public static final String P_ALIGN = new String("align");
    public static final String P_BACKGROUND = new String("background");
    public static final String P_BORDER = new String("border");
    public static final String P_CHECKED = new String("checked");
    public static final String P_CLEAR = new String("clear");
    public static final String P_CODE = new String("code");
    public static final String P_COLS = new String("cols");
    public static final String P_COLSPAN = new String("colspan");
    public static final String P_FACE = new String("face");
    public static final String P_HEIGHT = new String("height");
    public static final String P_HREF = new String("href");
    public static final String P_LANGUAGE = new String("language");
    public static final String P_LOWSRC = new String("lowsrc");
    public static final String P_MAXLENGTH = new String("maxlength");
    public static final String P_MULTIPLE = new String("multiple");
    public static final String P_NAME = new String("name");
    public static final String P_ROWS = new String("rows");
    public static final String P_ROWSPAN = new String("rowspan");
    public static final String P_SIZE = new String("size");
    public static final String P_SRC = new String("src");
    public static final String P_TARGET = new String("target");
    public static final String P_TYPE = new String("type");
    public static final String P_VALUE = new String("value");
    public static final String P_VALUETYPE = new String("valuetype");
    public static final String P_WIDTH = new String("width");

    public static final String P_CITE = new String("cite");
    public static final String P_PROFILE = new String("profile");
    public static final String P_ACTION = new String("action");
    public static final String P_LONGDESC = new String("longdesc");
    public static final String P_FOR = new String("for");
    public static final String P_USEMAP = new String("usemap");
    public static final String P_CODEBASE = new String("codebase");
    public static final String P_DATA = new String("data");
    public static final String P_ARCHIVE = new String("archive");
    public static final String P_REL = new String("rel");
    public static final String P_REV = new String("rev");

    static Hashtable m_tags = new Hashtable();

    static {
        m_tags.put("A", tags.T_A.ordinal());
        m_tags.put("ABBREV", tags.T_ABBREV.ordinal());
        m_tags.put("ACRONYM", tags.T_ACRONYM.ordinal());
        m_tags.put("ADDRESS", tags.T_ADDRESS.ordinal());
        m_tags.put("APPLET", tags.T_APPLET.ordinal());
        m_tags.put("AREA", tags.T_AREA.ordinal());
        m_tags.put("AU", tags.T_AU.ordinal());
        m_tags.put("B", tags.T_B.ordinal());
        m_tags.put("BANNER", tags.T_BANNER.ordinal());
        m_tags.put("BASE", tags.T_BASE.ordinal());
        m_tags.put("BASEFONT", tags.T_BASEFONT.ordinal());
        m_tags.put("BGSOUND", tags.T_BGSOUND.ordinal());
        m_tags.put("BIG", tags.T_BIG.ordinal());
        m_tags.put("BLINK", tags.T_BLINK.ordinal());
        m_tags.put("BLOCKQUOTE", tags.T_BLOCKQUOTE.ordinal());
        m_tags.put("BODY", tags.T_BODY.ordinal());
        m_tags.put("BR", tags.T_BR.ordinal());
        m_tags.put("CAPTION", tags.T_CAPTION.ordinal());
        m_tags.put("CENTER", tags.T_CENTER.ordinal());
        m_tags.put("CITE", tags.T_CITE.ordinal());
        m_tags.put("CODE", tags.T_CODE.ordinal());
        m_tags.put("COL", tags.T_COL.ordinal());
        m_tags.put("COLGROUP", tags.T_COLGROUP.ordinal());
        m_tags.put("CREDIT", tags.T_CREDIT.ordinal());
        m_tags.put("DD", tags.T_DD.ordinal());
        m_tags.put("DEL", tags.T_DEL.ordinal());
        m_tags.put("DFN", tags.T_DFN.ordinal());
        m_tags.put("DIR", tags.T_DIR.ordinal());
        m_tags.put("DIV", tags.T_DIV.ordinal());
        m_tags.put("DL", tags.T_DL.ordinal());
        m_tags.put("!DOCTYPE", tags.T__DOCTYPE.ordinal());
        m_tags.put("DT", tags.T_DT.ordinal());
        m_tags.put("EM", tags.T_EM.ordinal());
        m_tags.put("EMBED", tags.T_EMBED.ordinal());
        m_tags.put("FIG", tags.T_FIG.ordinal());
        m_tags.put("FN", tags.T_FN.ordinal());
        m_tags.put("FONT", tags.T_FONT.ordinal());
        m_tags.put("FORM", tags.T_FORM.ordinal());
        m_tags.put("FRAME", tags.T_FRAME.ordinal());
        m_tags.put("FRAMESET", tags.T_FRAMESET.ordinal());
        m_tags.put("H1", tags.T_H1.ordinal());
        m_tags.put("H2", tags.T_H2.ordinal());
        m_tags.put("H3", tags.T_H3.ordinal());
        m_tags.put("H4", tags.T_H4.ordinal());
        m_tags.put("H5", tags.T_H5.ordinal());
        m_tags.put("H6", tags.T_H6.ordinal());
        m_tags.put("HEAD", tags.T_HEAD.ordinal());
        m_tags.put("HTML", tags.T_HTML.ordinal());
        m_tags.put("HR", tags.T_HR.ordinal());
        m_tags.put("I", tags.T_I.ordinal());
        m_tags.put("IMG", tags.T_IMG.ordinal());
        m_tags.put("INPUT", tags.T_INPUT.ordinal());
        m_tags.put("INS", tags.T_INS.ordinal());
        m_tags.put("ISINDEX", tags.T_ISINDEX.ordinal());
        m_tags.put("KBD", tags.T_KBD.ordinal());
        m_tags.put("LANG", tags.T_LANG.ordinal());
        m_tags.put("LH", tags.T_LH.ordinal());
        m_tags.put("LI", tags.T_LI.ordinal());
        m_tags.put("LINK", tags.T_LINK.ordinal());
        m_tags.put("MAP", tags.T_MAP.ordinal());
        m_tags.put("MARQUEE", tags.T_MARQUEE.ordinal());
        m_tags.put("MENU", tags.T_MENU.ordinal());
        m_tags.put("META", tags.T_META.ordinal());
        m_tags.put("NEXTID", tags.T_NEXTID.ordinal());
        m_tags.put("NOBR", tags.T_NOBR.ordinal());
        m_tags.put("NOEMBED", tags.T_NOEMBED.ordinal());
        m_tags.put("NOFRAME", tags.T_NOFRAME.ordinal());
        m_tags.put("NOFRAMES", tags.T_NOFRAMES.ordinal());
        m_tags.put("NOTE", tags.T_NOTE.ordinal());
        m_tags.put("OBJECT", tags.T_OBJECT.ordinal());
        m_tags.put("OL", tags.T_OL.ordinal());
        m_tags.put("OPTION", tags.T_OPTION.ordinal());
        m_tags.put("OVERLAY", tags.T_OVERLAY.ordinal());
        m_tags.put("P", tags.T_P.ordinal());
        m_tags.put("PARAM", tags.T_PARAM.ordinal());
        m_tags.put("PERSON", tags.T_PERSON.ordinal());
        m_tags.put("PRE", tags.T_PRE.ordinal());
        m_tags.put("Q", tags.T_Q.ordinal());
        m_tags.put("RANGE", tags.T_RANGE.ordinal());
        m_tags.put("S", tags.T_S.ordinal());
        m_tags.put("SAMP", tags.T_SAMP.ordinal());
        m_tags.put("SCRIPT", tags.T_SCRIPT.ordinal());
        m_tags.put("SELECT", tags.T_SELECT.ordinal());
        m_tags.put("SMALL", tags.T_SMALL.ordinal());
        m_tags.put("SPOT", tags.T_SPOT.ordinal());
        m_tags.put("STRONG", tags.T_STRONG.ordinal());
        m_tags.put("STYLE", tags.T_STYLE.ordinal());
        m_tags.put("SUB", tags.T_SUB.ordinal());
        m_tags.put("SUP", tags.T_SUP.ordinal());
        m_tags.put("TAB", tags.T_TAB.ordinal());
        m_tags.put("TABLE", tags.T_TABLE.ordinal());
        m_tags.put("TBODY", tags.T_TBODY.ordinal());
        m_tags.put("TD", tags.T_TD.ordinal());
        m_tags.put("TEXTAREA", tags.T_TEXTAREA.ordinal());
        m_tags.put("TFOOT", tags.T_TFOOT.ordinal());
        m_tags.put("TH", tags.T_TH.ordinal());
        m_tags.put("THEAD", tags.T_THEAD.ordinal());
        m_tags.put("TITLE", tags.T_TITLE.ordinal());
        m_tags.put("TR", tags.T_TR.ordinal());
        m_tags.put("TT", tags.T_TT.ordinal());
        m_tags.put("U", tags.T_U.ordinal());
        m_tags.put("UL", tags.T_UL.ordinal());
        m_tags.put("VAR", tags.T_VAR.ordinal());
        m_tags.put("WBR", tags.T_WBR.ordinal());

        m_tags.put("IFRAME", tags.T_IFRAME.ordinal());
    }

    public static int get(String tagName){
        return Integer.parseInt((String) m_tags.get(tagName));
    }


}
