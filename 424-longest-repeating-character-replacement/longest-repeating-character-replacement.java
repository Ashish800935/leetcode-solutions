class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int l = 0;
        int r = 0;
        int ans = 0;
        int maxfre = 0;
        while (r < s.length()) {
            freq[s.charAt(r) - 'A']++;
            maxfre = Math.max(maxfre, freq[s.charAt(r) - 'A']);
            while ((r - l + 1) - maxfre > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }

            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;

    }
}