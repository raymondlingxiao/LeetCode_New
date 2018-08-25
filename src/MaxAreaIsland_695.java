public class MaxAreaIsland_695 {
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int max = 0;
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    int count = 0;
                    if (grid[i][j] == 0)
                        continue;
                    // search for four directions
                    count = dfs(grid,i,j,count);

                    if (count > max)
                        max = count;
                }


            }
            return max;
        }

        private int dfs(int[][] grid,int row,int col, int count){
            if (row >= grid.length || col >= grid[0].length||row<0||col<0||grid[row][col] == 0)
                return count;
            else{
                count ++;
                // filp or stack overflows
                grid[row][col] = 0;
                count = dfs(grid,row+1,col,count);
                count = dfs(grid,row-1,col,count);
                count = dfs(grid,row,col+1,count);
                count = dfs(grid,row,col-1,count);
                return count;
            }
        }
    }
}
