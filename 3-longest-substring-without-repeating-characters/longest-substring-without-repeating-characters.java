class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int right=0;
        int ans=0;
        Set<Character>set=new HashSet<>();
        while(right<s.length()){
            char ch=s.charAt(right);
            while(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            ans=Math.max(ans,right-left+1);
            right++;
        }
        return ans;

        
    }
}