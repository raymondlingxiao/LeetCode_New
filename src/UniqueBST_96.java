public class UniqueBST_96 {
    // 此题是将2d数组转为1d的典型
    // 将区间拼接，转换为点拼接
    class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n+1];
            // the empty tree is also a BST
            dp[0] = 1;
            dp[1] = 1;
            // f(i,n) = dp[i-1] * dp[n-i];
            // dp[n] = sum(f(i,n));
            for (int i=2;i<=n;i++){
                for (int j=1;j<=i;j++){
                    dp[i] += dp[j-1]*dp[i-j];
                }
            }

            return dp[n];
        }
    }
}
