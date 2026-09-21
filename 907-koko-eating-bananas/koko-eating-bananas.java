class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int i=0;i<piles.length;i++){ 
            max=Math.max(max,piles[i]);
        }
        int low=1;
        int high=max;
         int ans = max;
        while(high>=low){
            int mid=low+(high-low)/2;
            long hr=possible(piles,mid);
            if(hr<=h){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }

        }
        return ans;
    }

    long possible(int[] arr,int val){
        long hr=0;
        for(int i=0;i<arr.length;i++){
          hr+=(arr[i]+val-1)/val;
        }
        
        return hr;
    }
}