class Solution {
    public int strStr(String haystack, String needle) {
        int l=0;
        int r=0;
         int nr=0;
         int ans=-1;
        while(r<haystack.length()){
             if(haystack.charAt(r)==needle.charAt(nr)){
                r++;
                nr++;
             }
             else if (haystack.charAt(r)!=needle.charAt(nr)){
                
                l++;
                r=l;
                nr=0;
             }
             if(nr==needle.length()){
                ans=l;
                break;
             }
        }
        return ans;
    }
}