public class UnionFind {
    /**
     * 整个算法的优化流程,都在Link:https://www.cnblogs.com/wxgblogs/p/5707503.html
     * 以下为path compression 没加rank的和加rank的实现
     * */

    public int count = 0;
    public int[] index = null;

    // m n 为长宽
    public UnionFind(int m, int n, char[][]grid){
        // initialize index array
        // count nodes
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                // 计算root的个数,初始化都为root
                if(grid[i][j] == '1')
                    count++;
            }
        }
        // initial index array
        index = new int[m*n];
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
