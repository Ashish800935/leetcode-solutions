class Solution {
public:
    double myPow(double x, int n) {
        if(n==0) return 1.0000;
        long a = n; 
        if (a < 0) {
            a = -a;
            
        }
        double ans=1.0000;
        while(a>0){
            if(a%2==1){
                ans=ans*x;
            }
            x=x*x;
            a=a/2;
        }
        return (n < 0) ? (1.0 / ans) : ans;
    }
};