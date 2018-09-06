public class DP_Triangle_120 {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int m = triangle.size();
            // use null to distinguish whether it is empty
            Integer[][] memo = new Integer[m][m];
            List<Integer> bottom = triangle.get(m-1);
            for (int i=0;i<bottom.size();i++){
                memo[m-1][i] = bottom.get(i);
            }

            return getMemo(0,0,memo,triangle);


        }

        private int getMemo(int x, int y, Integer[][]memo, List<List<Integer>> triangle ){
            if (x>=triangle.size() || y >=triangle.get(x).size())
                return 0;
            // Key point
            if (memo[x][y] != null)
                return memo[x][y];

            int self = triangle.get(x).get(y);
            int left = getMemo(x+1,y,memo,triangle) + self;
            int right = getMemo(x+1,y+1,memo,triangle) + self;

            return memo[x][y] = Math.min(left,right);

        }
    }


    class Solution2 {
        public int minimumTotal(List<List<Integer>> triangle) {
            int[] dp = new int[triangle.size()+1];
            for(int i=triangle.size()-1;i>=0;i--){
                for(int j=0;j<=i;j++){
                    dp[j] = Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
                }
            }
            return dp[0];
        }
    }
}
