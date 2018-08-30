public class UniquePath2_63 {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacle) {
            int m= obstacle.length;
            int n = obstacle[0].length;
            if (obstacle[0][0] == 1)
                return 0;
            else
                obstacle[0][0] = 1;
            for (int i=1;i<m;i++){
                if (obstacle[i][0] == 1){
                    obstacle[i][0] = 0;
                }
                else
                    obstacle[i][0] = obstacle[i-1][0];
            }

            for (int j=1;j<n;j++){
                if (obstacle[0][j] == 1)
                    obstacle[0][j] = 0;
                else
                    obstacle[0][j] = obstacle[0][j-1];
            }

            for (int i=1;i<m;i++){
                for (int j=1;j<n;j++){
                    if (obstacle[i][j] == 1)
                        obstacle[i][j] = 0;
                    else
                        obstacle[i][j] = obstacle[i-1][j] + obstacle[i][j-1];
                }
            }

            return obstacle[m-1][n-1];
        }
    }
}
