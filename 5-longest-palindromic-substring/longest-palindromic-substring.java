class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0;
        int maxlen = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (palin(s, i, j)) {
                    if (maxlen < j - i + 1) {
                        maxlen = j - i + 1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxlen);

    }

    boolean palin(String s, int i, int j) {
        if (i >= j) {
            return true;
        }
        if (s.charAt(i) == s.charAt(j)) {
            return palin(s, i + 1, j - 1);
        }
        return false;
    }
}