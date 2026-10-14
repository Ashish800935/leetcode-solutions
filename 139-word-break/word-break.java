class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String>set=new HashSet<>(wordDict);
        int n=s.length();
        if(set.contains(s)) return true;
        boolean []dp=new boolean [n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<n;j++){
                 if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
        
    }
}