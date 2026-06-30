class Solution {
    public int numberOfSubstrings(String s) {
        int l=0,r=0;
        int[] freq=new int[3];
        int ans=0;
        int lastidx=s.length()-1;
        while(r<s.length()){
            char ch=s.charAt(r);

          freq[ch-'a']=freq[ch-'a']+1;
          while(freq[0]>0 && freq[1]>0 && freq[2]>0){
            ans=ans+lastidx-r+1;
            char chl=s.charAt(l);
            freq[chl-'a']=freq[chl-'a']-1;
            l++;
          }
          r++;
        }
        return ans;
    }
}