package com.arthurdo.parser;

import java.util.Hashtable;

public class Tags {

    public enum tags {
        UNKNOWN,
        A,
        ABBREV,
        ACRONYM,
        ADDRESS,
        APPLET,
        AREA,
        AU,
        B,
        BANNER,
        BASE,
        BASEFONT,
        BGSOUND,
        BIG,
        BLINK,
        BLOCKQUOTE,
        BODY,
        BR,
        CAPTION,
        CENTER,
        CITE,
        CODE,
        COL,
        COLGROUP,
        CREDIT,
        DD,
        DEL,
        DFN,
        DIR,
        DIV,
        DL,
        DT,
        EM,
        EMBED,
        FIG,
        FN,
        FONT,
        FORM,
        FRAME,
        FRAMESET,
        H1,
        H2,
        H3,
        H4,
        H5,
        H6,
        HEAD,
        HTML,
        HR,
        I,
        IMG,
        INPUT,
        INS,
        ISINDEX,
        KBD,
        LANG,
        LH,
        LI,
        LINK,
        MAP,
        MARQUEE,
        MENU,
        META,
        NEXTID,
        NOBR,
        NOEMBED,
        NOFRAME,
        NOFRAMES,
        NOTE,
        OBJECT,
        OL,
        OPTION,
        OVERLAY,
        P,
        PARAM,
        PERSON,
        PRE,
        Q,
        RANGE,
        S,
        SAMP,
        SCRIPT,
        SELECT,
        SMALL,
        SPOT,
        STRONG,
        STYLE,
        SUB,
        SUP,
        TAB,
        TABLE,
        TBODY,
        TD,
        TEXTAREA,
        TFOOT,
        TH,
        THEAD,
        TITLE,
        TR,
        TT,
        U,
        UL,
        VAR,
        WBR,
        IFRAME,
        _DOCTYPE,
    }

    public static final String P_COLSPAN = new String("colspan");
    public static final String P_ROWSPAN = new String("rowspan");

    static Hashtable m_tags = new Hashtable();

    static {
        m_tags.put("A", tags.A.ordinal());
        m_tags.put("ABBREV", tags.ABBREV.ordinal());
        m_tags.put("ACRONYM", tags.ACRONYM.ordinal());
        m_tags.put("ADDRESS", tags.ADDRESS.ordinal());
        m_tags.put("APPLET", tags.APPLET.ordinal());
        m_tags.put("AREA", tags.AREA.ordinal());
        m_tags.put("AU", tags.AU.ordinal());
        m_tags.put("B", tags.B.ordinal());
        m_tags.put("BANNER", tags.BANNER.ordinal());
        m_tags.put("BASE", tags.BASE.ordinal());
        m_tags.put("BASEFONT", tags.BASEFONT.ordinal());
        m_tags.put("BGSOUND", tags.BGSOUND.ordinal());
        m_tags.put("BIG", tags.BIG.ordinal());
        m_tags.put("BLINK", tags.BLINK.ordinal());
        m_tags.put("BLOCKQUOTE", tags.BLOCKQUOTE.ordinal());
        m_tags.put("BODY", tags.BODY.ordinal());
        m_tags.put("BR", tags.BR.ordinal());
        m_tags.put("CAPTION", tags.CAPTION.ordinal());
        m_tags.put("CENTER", tags.CENTER.ordinal());
        m_tags.put("CITE", tags.CITE.ordinal());
        m_tags.put("CODE", tags.CODE.ordinal());
        m_tags.put("COL", tags.COL.ordinal());
        m_tags.put("COLGROUP", tags.COLGROUP.ordinal());
        m_tags.put("CREDIT", tags.CREDIT.ordinal());
        m_tags.put("DD", tags.DD.ordinal());
        m_tags.put("DEL", tags.DEL.ordinal());
        m_tags.put("DFN", tags.DFN.ordinal());
        m_tags.put("DIR", tags.DIR.ordinal());
        m_tags.put("DIV", tags.DIV.ordinal());
        m_tags.put("DL", tags.DL.ordinal());
        m_tags.put("!DOCTYPE", tags._DOCTYPE.ordinal());
        m_tags.put("DT", tags.DT.ordinal());
        m_tags.put("EM", tags.EM.ordinal());
        m_tags.put("EMBED", tags.EMBED.ordinal());
        m_tags.put("FIG", tags.FIG.ordinal());
        m_tags.put("FN", tags.FN.ordinal());
        m_tags.put("FONT", tags.FONT.ordinal());
        m_tags.put("FORM", tags.FORM.ordinal());
        m_tags.put("FRAME", tags.FRAME.ordinal());
        m_tags.put("FRAMESET", tags.FRAMESET.ordinal());
        m_tags.put("H1", tags.H1.ordinal());
        m_tags.put("H2", tags.H2.ordinal());
        m_tags.put("H3", tags.H3.ordinal());
        m_tags.put("H4", tags.H4.ordinal());
        m_tags.put("H5", tags.H5.ordinal());
        m_tags.put("H6", tags.H6.ordinal());
        m_tags.put("HEAD", tags.HEAD.ordinal());
        m_tags.put("HTML", tags.HTML.ordinal());
        m_tags.put("HR", tags.HR.ordinal());
        m_tags.put("I", tags.I.ordinal());
        m_tags.put("IMG", tags.IMG.ordinal());
        m_tags.put("INPUT", tags.INPUT.ordinal());
        m_tags.put("INS", tags.INS.ordinal());
        m_tags.put("ISINDEX", tags.ISINDEX.ordinal());
        m_tags.put("KBD", tags.KBD.ordinal());
        m_tags.put("LANG", tags.LANG.ordinal());
        m_tags.put("LH", tags.LH.ordinal());
        m_tags.put("LI", tags.LI.ordinal());
        m_tags.put("LINK", tags.LINK.ordinal());
        m_tags.put("MAP", tags.MAP.ordinal());
        m_tags.put("MARQUEE", tags.MARQUEE.ordinal());
        m_tags.put("MENU", tags.MENU.ordinal());
        m_tags.put("META", tags.META.ordinal());
        m_tags.put("NEXTID", tags.NEXTID.ordinal());
        m_tags.put("NOBR", tags.NOBR.ordinal());
        m_tags.put("NOEMBED", tags.NOEMBED.ordinal());
        m_tags.put("NOFRAME", tags.NOFRAME.ordinal());
        m_tags.put("NOFRAMES", tags.NOFRAMES.ordinal());
        m_tags.put("NOTE", tags.NOTE.ordinal());
        m_tags.put("OBJECT", tags.OBJECT.ordinal());
        m_tags.put("OL", tags.OL.ordinal());
        m_tags.put("OPTION", tags.OPTION.ordinal());
        m_tags.put("OVERLAY", tags.OVERLAY.ordinal());
        m_tags.put("P", tags.P.ordinal());
        m_tags.put("PARAM", tags.PARAM.ordinal());
        m_tags.put("PERSON", tags.PERSON.ordinal());
        m_tags.put("PRE", tags.PRE.ordinal());
        m_tags.put("Q", tags.Q.ordinal());
        m_tags.put("RANGE", tags.RANGE.ordinal());
        m_tags.put("S", tags.S.ordinal());
        m_tags.put("SAMP", tags.SAMP.ordinal());
        m_tags.put("SCRIPT", tags.SCRIPT.ordinal());
        m_tags.put("SELECT", tags.SELECT.ordinal());
        m_tags.put("SMALL", tags.SMALL.ordinal());
        m_tags.put("SPOT", tags.SPOT.ordinal());
        m_tags.put("STRONG", tags.STRONG.ordinal());
        m_tags.put("STYLE", tags.STYLE.ordinal());
        m_tags.put("SUB", tags.SUB.ordinal());
        m_tags.put("SUP", tags.SUP.ordinal());
        m_tags.put("TAB", tags.TAB.ordinal());
        m_tags.put("TABLE", tags.TABLE.ordinal());
        m_tags.put("TBODY", tags.TBODY.ordinal());
        m_tags.put("TD", tags.TD.ordinal());
        m_tags.put("TEXTAREA", tags.TEXTAREA.ordinal());
        m_tags.put("TFOOT", tags.TFOOT.ordinal());
        m_tags.put("TH", tags.TH.ordinal());
        m_tags.put("THEAD", tags.THEAD.ordinal());
        m_tags.put("TITLE", tags.TITLE.ordinal());
        m_tags.put("TR", tags.TR.ordinal());
        m_tags.put("TT", tags.TT.ordinal());
        m_tags.put("U", tags.U.ordinal());
        m_tags.put("UL", tags.UL.ordinal());
        m_tags.put("VAR", tags.VAR.ordinal());
        m_tags.put("WBR", tags.WBR.ordinal());
        m_tags.put("UNKNOWN", tags.UNKNOWN.ordinal());

        m_tags.put("IFRAME", tags.IFRAME.ordinal());
    }

    public static int get(String tagName) {
        return (Integer)m_tags.get(tagName);
    }


}
