class Solution {
    public int change(int amount, int[] coins) {
        int[] []dp = new int[coins.length][amount + 1];
       for(int[]row:dp){
        Arrays.fill(row,-1);
       }

        return helper(coins, amount,0, dp);
        
    }
     int helper(int[] coins, int amount,int idx,int[][]dp) {
        if (amount == 0) {
            return 1;
        }

        if (amount < 0 || idx>=coins.length) {
            return 0;
        }
        if(dp[idx][amount]!=-1)return dp[idx][amount];

        int take = helper(coins, amount - coins[idx], idx, dp);
         int skip = helper(coins, amount, idx+1, dp);
           
        return dp[idx][amount]=take+skip;
    }
}