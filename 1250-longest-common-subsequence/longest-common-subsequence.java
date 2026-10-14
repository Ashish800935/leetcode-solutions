class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][]dp=new int[text1.length()][text2.length()];
        for(int[]rows:dp){
            Arrays.fill(rows,-1);
        }
        return helper(text1,text2,0,0,dp);
        
    }
    int helper(String t1, String t2,int idx1,int idx2,int[][]dp){
        if(idx1==t1.length() || idx2==t2.length()){
            return 0;
        }
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
        if(t1.charAt(idx1)==t2.charAt(idx2)){
            return dp[idx1][idx2]=1+helper(t1,t2,idx1+1,idx2+1,dp);
        }
        int left=helper(t1,t2,idx1+1,idx2,dp);
        int right=helper(t1,t2,idx1,idx2+1,dp);
        return dp[idx1][idx2]=Math.max(left,right);
    }
}