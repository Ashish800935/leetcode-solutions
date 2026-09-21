class Solution {
    public int removeDuplicates(int[] nums) {
        int l=1;
        int count=1;
        for(int i=1;i<nums.length;i++){ 
            if(nums[i]!=nums[i-1]){
                nums[l]=nums[i];
                l++;
                count=1;
            }
            else{
                if(count<2){
                     nums[l]=nums[i];
                l++;
                count++;
                }
            }
        }
        return l;
    }
}