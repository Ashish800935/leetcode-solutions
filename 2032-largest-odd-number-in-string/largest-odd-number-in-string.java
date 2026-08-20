class Solution {
    public String largestOddNumber(String num) {
        int r=-1;
        for(int i=num.length()-1;i>=0;i--){
            char ch=num.charAt(i);
            if((ch-'0')%2!=0){
                r=i;
                break;
            }
        }
        return num.substring(0,r+1);
    }
}