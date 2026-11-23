class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[]ans=new int[2];
        ans[0]=first(nums,target);
        ans[1]=last(nums,target);
        return ans;
        
    }
    int first(int[] nums, int target){
        int l=0;
        int r=nums.length-1;
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                ans=mid;
                r=mid-1;
            }
            else if(nums[mid]>target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }

    int last(int[] nums, int target){
        int l=0;
        int r=nums.length-1;
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                ans=mid;
                l=mid+1;
            }
            else if(nums[mid]>target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
}