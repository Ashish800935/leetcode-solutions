class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length()>s2.length()) return false;
        int[] freq1=new int [26];
         int[] freq2=new int [26];
         for(int i=0;i<s1.length();i++){
            freq1[s1.charAt(i)-'a']++;
            freq2[s2.charAt(i)-'a']++;
         }
         if(match(freq1,freq2)) return true;
         int l=0;
         for(int i=s1.length();i<s2.length();i++){
            freq2[s2.charAt(i)-'a']++;
            freq2[s2.charAt(l)-'a']--;
            l++;
            if(match(freq1,freq2)) return true;


         }
         return false;
    }
    boolean match(int[] arr1,int[] arr2){
        for(int i=0;i<26;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
}