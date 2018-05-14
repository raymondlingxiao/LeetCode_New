public class ClimbStairs_70 {
    class Solution1 {
        public int climbStairs(int n) {
            // fib number approach --Memo
            // f(n) = f(n-1) + f(n-2)
            int[] memo = new int[n+1];
            return climbStairs_dp(n,memo);

        }
        // try use memo recursion
        private int climbStairs_dp(int n, int[] memo){
            int result = 0;
            if (memo[n] != 0)
                return memo[n];
            if (n ==1)
                result = 1;
            if (n ==2)
                result = 2;
            if (n != 1 && n!=2)
                result = climbStairs_dp(n-1,memo) + climbStairs_dp(n-2,memo);
            memo[n] = result;
            return result;
        }
    }

    class Solution {
        public int climbStairs(int n) {
            // fib number approach Bottom-up
            // f(n) = f(n-1) + f(n-2)
            if (n == 1)
                return 1;
            if (n ==2 )
                return 2;

            int[] dp_bp = new int[n+1];
            dp_bp[1] = 1;
            dp_bp[2] = 2;

            for (int i=3;i<=n;i++){
                dp_bp[i] = dp_bp[i-1] + dp_bp[i-2];
            }
            return dp_bp[n];

        }
    }
}
