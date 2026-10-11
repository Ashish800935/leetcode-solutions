class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i]=0;
        }
        return helper(n,0,dp);
    }
    public int helper(int n ,int idx,int[]dp){
        if(idx==n) return 1;
        if(idx>n) return 0;
        if(dp[idx]!=0) return dp[idx];
        int a=helper(n,idx+1,dp);
        int b=helper(n,idx+2,dp);
        return dp[idx]=a+b;
    }
}