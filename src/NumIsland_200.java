public class NumIsland_200 {
    /**
     * 1.DFS, 可将其1相连的1看做是一个图的边,这样便于处理
     * */
    class Solution {
        public int numIslands(char[][] grid) {
            // DFS
            if (grid == null || grid.length == 0)
                return 0;
            int ver = grid.length;
            int hor = grid[0].length;
            int count = 0;
            for (int i=0;i<ver;i++){
                for (int j=0;j<hor;j++){
                    if (grid[i][j] != '0'){
                        dfs(grid,i,j);
                        count++;
                    }
                }
            }
            return count;
        }

        private void dfs(char[][]grid,int i, int j){
            if (i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j] == '0')
                return;
            grid[i][j] = '0';

            //search for four directions
            //搜索每个节点的四个方向
            dfs(grid,i+1,j);
            dfs(grid,i-1,j);
            dfs(grid,i,j+1);
            dfs(grid,i,j-1);
        }
    }
}
