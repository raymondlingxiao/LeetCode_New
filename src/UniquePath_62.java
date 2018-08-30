public class UniquePath_62 {
    class Solution {
        public int uniquePaths(int m, int n) {
            // bottom-up
            int[][] board = new int[m][n];
            for (int i=0;i<m;i++){
                board[i][0] = 1;
            }

            for (int j=0;j<n;j++){
                board[0][j] = 1;
            }

            for (int i=1;i<m;i++){
                for (int j=1;j<n;j++){
                    board[i][j] = board[i-1][j] + board[i][j-1];
                }
            }

            return board[m-1][n-1];
        }
    }
}
