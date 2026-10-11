class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int []dp=new int[cost.length];
        Arrays.fill(dp, -1);
        int Startwithzero=helper(cost,0,dp);
        int StartwithOne=helper(cost,1,dp);
        return Math.min(Startwithzero,StartwithOne);
        
    }
    public int helper(int[] cost,int idx,int[]dp){
        if(idx>=cost.length)return 0;
        if(dp[idx]!=-1)return dp[idx];
       int a=  helper(cost,idx+1,dp);
       int b=  helper(cost,idx+2,dp);
       return dp[idx]= Math.min(a,b)+cost[idx];
    }
}