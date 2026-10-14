class Solution {
    Boolean[][] memo;
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        memo = new Boolean[s.length()][s.length()];
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
         if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (s.charAt(i) == s.charAt(j)) {
            return  memo[i][j]=palin(s, i + 1, j - 1);
        }
        return  memo[i][j]=false;
    }
}