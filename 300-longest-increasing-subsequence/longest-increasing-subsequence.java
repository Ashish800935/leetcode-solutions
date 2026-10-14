class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(nums,0,-1,dp);
        
    }
    int helper(int[]nums,int idx,int pre,int[][]dp){
        if(idx>=nums.length){
            return 0;
        }
        if(dp[idx][pre+1]!=-1) return dp[idx][pre+1];
        int take = 0;

        if (pre == -1 || nums[idx] > nums[pre]) {
            take = 1 + helper(nums, idx + 1, idx,dp);
        }
        int skip=helper(nums,idx+1,pre,dp);
        return dp[idx][pre+1]=Math.max(take,skip);
    }
}