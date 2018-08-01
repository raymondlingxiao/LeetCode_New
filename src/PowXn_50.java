public class PowXn_50 {
    // BF
    class Solution {
        public double myPow(double x, int n) {
            long N = n;
            if (N<0){
                x = 1/x;
                N = -N;
            }
            double ans = 1;
            for (int i=1;i<=N;i++){
                ans = ans * x;
            }
            return ans;
        }
    }

    // fast pow
    /**
     * 此处利用的是一个性质,当n为偶数时, A= x^n/2, x^n = A*A
     * n为奇数时, X^n = A*A*x;
     * */

    class Solution2 {
        public double myPow(double x, int n) {
            long N = n;
            if (N<0){
                x = 1/x;
                N = -N;
            }
            return fastPow(x,n);
        }

        private double fastPow(double x, int n){
            if (n==0)
                return 1;
            double half = fastPow(x,n/2);
            if (n%2 == 0)
                return half*half;
            else
                return half*half*x;
        }
    }
}
