class Solution {
    public int maxArea(int[] height) {
        int ans=0;
        int left=0;
        int right=height.length-1;
        while(left<right){
            int width=right-left;
            int ht=Math.min(height[left],height[right]);
            ans=Math.max(ans,width*ht);
            if(height[left]>height[right]){
                right--;
            }
            else{
                left++;
            }
        }
        return ans;
        
    }
}