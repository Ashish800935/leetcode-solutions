class Solution {
    public int rob(int[] nums) {
         if (nums.length == 1) return nums[0];
        int[]dp=new int[nums.length];
        Arrays.fill(dp,-1);
        int a=helper(nums,0,nums.length-2,dp);
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp2, -1);

        int b = helper(nums, 1, nums.length-1, dp2);
        return Math.max(a,b);
        
    }
    int helper(int[]nums,int idx,int n,int[]dp){
        if(idx>n) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int steal=nums[idx]+helper(nums,idx+2,n,dp);
        int free=helper(nums,idx+1,n,dp);
        return dp[idx]= Math.max(steal,free);
    }
}