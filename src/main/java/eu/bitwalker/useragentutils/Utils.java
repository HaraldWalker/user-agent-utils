package eu.bitwalker.useragentutils;

public class Utils {

    static String[] toLowerCase(String[] strArr) {
        if (strArr == null) return null;
        String[] res = new String[strArr.length];
        for (int i=0; i<strArr.length; i++) {
          res[i] = strArr[i].toLowerCase();
        }
        return res;
      }

    static boolean contains(String str, String[] strArr) {
        if (strArr == null)
            return false;
        for (String arrStr : strArr) {
            if (str.contains(arrStr)) {
                return true;
            }
        }
        return false;
    }

}
