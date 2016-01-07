package eu.bitwalker.useragentutils;

import java.util.regex.Pattern;

public class Utils {

    static String[] toLowerCase(String[] strArr) {
        if (strArr == null) return null;
        String[] res = new String[strArr.length];
        for (int i=0; i<strArr.length; i++) {
          res[i] = strArr[i].toLowerCase();
        }
        return res;
      }

    /**
     * Checks if str matches strToBeContained with the rules:
     * <ul>
     * 	<li>numbers at the end must fully match ("firefox/4" does not match "foo firefox/43 baz", but "firefox/43" does)
     * 	<li>numbers after the last dot can be ignored ("bar/2" matches "foo bar/2.3 baz" and "bar/2.3" matches "foo bar/2.3.4 baz")
     *  <li>zeros at the end after a dot are ignored ("bar/2.3" matches "foo bar/2.30" baz)
     * </ul>
     * @param str string to be checked
     * @param strToBeContained string that should be contained/matched in the given str
     * @return {@code true} if str matched strToBeContained
     */
    static boolean matchesWithVersion(String str, String strToBeContained) {
        if (str.equals(strToBeContained)) {
            return true;
        }
        return Pattern.matches(".*" + Pattern.quote(strToBeContained) + "(\\.\\d+)?(0+|\\D).*", str);
    }

    static boolean contains(String str, String[] strArr) {
        if (strArr == null)
            return false;
        for (String arrStr : strArr) {
            if (arrStr.isEmpty()) {
                continue;
            }
            if (Character.isDigit(arrStr.charAt(arrStr.length() - 1))) {
                // If the string to compare ends in a number, the full
                // number must match to that the (unkown) version "firefox/43"
                // is not matched against firefox/4"
                if (matchesWithVersion(str, arrStr)) {
                    return true;
                }
            } else {
                if (str.contains(arrStr)) {
                    return true;
                }
            }
        }
        return false;
    }

}
