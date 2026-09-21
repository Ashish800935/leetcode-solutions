class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }
        int ans=high;
        while(high>=low){
            int mid=low+(high-low)/2;
            if(possible(weights,days,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
        
    }
    boolean possible(int[] weights, int days,int minwgt){
        int  d=1;
        int sum=0;
        for(int wt:weights){
            if(sum+wt>minwgt){
                d++;
                sum=0;
            }
            sum+=wt;
        }
        
        
        return d<=days;

    }
}