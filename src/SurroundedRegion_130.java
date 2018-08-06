public class SurroundedRegion_130 {
    /**
     * 此题与island不同之处在于,如果O紧邻边界,且边界相邻元素也为O
     * 则不可将其看做为是被包围的元素
     * 所以此题从边界出发,遇到O就用dfs去查找相邻的O,并且将这些O暂时换为一个Y值
     * 最后剩下的没有变化的O都是被包围的(与边界不通),需要变为X
     * */
    class Solution {
        public void solve(char[][] board) {
            if (board == null || board.length == 0)
                return;
            int rows = board.length;
            int cols = board[0].length;

            //check first and last col
            for (int i=0;i<rows;i++){
                if (board[i][0] == 'O')
                    dfs(i,1,board);
                if (board[i][cols-1] == 'O')
                    dfs(i,cols-2,board);
            }

            // check first row and last row
            for (int i=0;i<cols;i++){
                if (board[0][i] == 'O')
                    dfs(1,i,board);
                if (board[rows-1][i] == 'O')
                    dfs(rows-2,i,board);
            }

            // flip O to X, '*' to 'O',
            // skip the boulders
            for (int i=1;i<rows-1;i++){
                for (int j=1;j<cols-1;j++){
                    if (board[i][j] == '*')
                        board[i][j] = 'O';
                    else if (board[i][j] == 'O')
                        board[i][j] = 'X';
                }
            }
        }

        public void dfs(int i,int j, char[][]board){
            if (i<=0 || j<=0||i>=board.length-1||j>=board[0].length-1||board[i][j] == 'X')
                return;
            if (board[i][j] == '*')
                return;
            if (board[i][j] == 'O')
                board[i][j] = '*';


            dfs(i+1,j,board);
            dfs(i-1,j,board);
            dfs(i,j+1,board);
            dfs(i,j-1,board);
        }
    }

    /**
     * Union Find方法
     * 寻找与边界属于同一集合的点,这些点如果为O也不变为X
     * */
    class Solution2 {
        public void solve(char[][] board) {
            if (board == null || board.length == 0)
                return;
            int rows = board.length;
            int cols = board[0].length;
            UnionFind uf = new UnionFind(rows,cols,board);

            for (int i=0;i<rows;i++){
                for (int j=0;j<cols;j++){
                    if ((i==0||j==0||i==rows-1||j==cols-1)&&board[i][j] == 'O')
                        // 这里是设置了一个dummy node作为启动点
                        uf.union(i*cols+j,rows*cols);
                    else if (board[i][j] == 'O'){
                        if (i>0 && board[i-1][j] == 'O')
                            uf.union((i-1)*cols+j,i*cols+j);
                        if (i<rows-1 && board[i+1][j] == 'O')
                            uf.union((i+1)*cols+j,i*cols+j);
                        if (j>0 && board[i][j-1] == 'O')
                            uf.union(i*cols+j-1,i*cols+j);
                        if (j<cols-1 && board[i][j+1] == 'O')
                            uf.union(i*cols+j+1,i*cols+j);
                    }
                }
            }

            // check
            for (int i=0;i<rows;i++){
                for (int j=0;j<cols;j++){
                    if ((uf.find(i*cols+j) != uf.find(rows*cols)))
                        board[i][j] = 'X';
                }
            }


        }

        private class UnionFind {


            public int count = 0;
            public int[] index = null;

            // m n 为长宽
            public UnionFind(int m, int n, char[][]grid){
                // initialize index array
                // count nodes

                count =m*n+1;
                // initial index array
                index = new int[m*n+1];
                for (int i=0;i<index.length;i++){
                    index[i] = i;
                }
            }

            // find with compression
            public int find (int node){
                // index[root] == root
                while (node != index[node]){
                    //compress, father node point to grandpa
                    index[node] = find(index[node]);
                    node = index[node];
                }
                return node;
            }
            // union without ranking
            public void union(int p, int q){
                int pf = find(p);
                int qf = find(q);
                if (pf == qf)
                    return;
                index[pf] = qf;
                /**
                 *     // ranking, 将小树作为大树的子树
                 *     if (sz[i] < sz[j])
                 *     { id[i] = j; sz[j] += sz[i]; }
                 *     else { id[j] = i; sz[i] += sz[j]; }
                 * */
                count--;
            }
        }
    }
}
