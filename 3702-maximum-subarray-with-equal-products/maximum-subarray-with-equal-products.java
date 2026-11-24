class Solution {
    public int maxLength(int[] nums) {
        int maxlength=1;
        int maxlimit=25200;

        for(int i=0;i<nums.length;i++){
            int prod=1;
            int GCD=0;
            int lcm=1;
            for(int j=i;j<nums.length;j++){
                prod *= nums[j];
                if (prod > maxlimit) {
                    break;
                }

                GCD = (j == i) ? nums[j] : gcd(GCD, nums[j]);
                lcm = LCM(lcm, nums[j]);

                if (prod == lcm * GCD) {
                    maxlength = Math.max(maxlength, j - i + 1);
                }

            }
        }
        return maxlength;

        
    }
    int gcd(int a,int b){
        while(b!=0){
            int remainder=a%b;
            a=b;
            b=remainder;
        }
        return a;
    }

    int LCM(int a, int b) {
        if (a == 0 || b == 0) return 0;
        return (a / gcd( a, b)) * b;
    }
}