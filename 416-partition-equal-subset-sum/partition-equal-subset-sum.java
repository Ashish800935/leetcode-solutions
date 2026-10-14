class Solution {
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        for(int a:nums){
            sum+=a;
        }
        if(sum%2!=0)return false;
        int target=sum/2;
        Boolean[][] dp = new Boolean[nums.length][target + 1];
        
        return helper(nums,target,0,dp);
        
    }
    boolean helper(int[]arr,int target,int idx,Boolean[][]dp){
        if(target==0){
            return true;
        }
        if(target<0 || idx>=arr.length) return false;
        if(dp[idx][target]!=null) return dp[idx][target];
        boolean take=helper(arr,target-arr[idx],idx+1,dp);
        boolean skip=helper(arr,target,idx+1,dp);
        return dp[idx][target]=take|| skip;
    }
}