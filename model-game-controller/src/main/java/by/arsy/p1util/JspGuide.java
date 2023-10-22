package by.arsy.p1util;

public final class JspGuide {

    private static final String jspAddress = "/WEB-INF/jsp/";

    public static String to(String packageName, String pageName) {
        return jspAddress + packageName + "/" + pageName + ".jsp";
    }

    public static String to(String pageName) {
        return jspAddress + pageName + ".jsp";
    }
}
