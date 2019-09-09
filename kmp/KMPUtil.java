package kmp;

public class KMPUtil {
    private KMPUtil() {}

    private static int[] getNext(String p) {
        int[] next = new int[p.length()];
        int j = -1;
        next[0] = -1;
        for (int i = 1; i < p.length(); i++) {
            while (j != -1 && p.charAt(i) != p.charAt(j + 1)) {
                j = next[j];
            }
            if (p.charAt(i) == p.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static int match(String s, String p) {
        int[] next = getNext(p);
        int j = -1, result = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j != -1 && s.charAt(i) != p.charAt(j + 1)) {
                j = next[j];
            }
            if (s.charAt(i) == p.charAt(j + 1)) {
                j++;
            }
            if (j == p.length() - 1) {
                j = next[j];
                result++;
            }
        }
        return result;
    }
}
