class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=0;
        for(int val:nums){
            high=Math.max(val,high);
        }
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(possible(nums,threshold,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
            
        }
        return ans;
        
    }
    boolean possible(int[] nums, int threshold,int divisor){
        int result=0;
        for(int val:nums){
            result+=(val+divisor-1)/divisor;
        }
         return result<=threshold;
    }
}