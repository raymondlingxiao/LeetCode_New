import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule_207 {
    class Solution2 {

        public boolean canFinish(int num, int[][] pre) {

            ArrayList[] graph = new ArrayList[num];
            // 图的入度
            int[] degree = new int[num];
            // bfs， 拓扑排序
            Queue<Integer> queue = new LinkedList<>();
            for (int i=0;i<num;i++){
                graph[i] = new ArrayList<Integer>();
            }

            for (int i=0;i<pre.length;i++){
                degree[pre[i][1]]++;
                graph[pre[i][0]].add(pre[i][1]);
            }

            int cnt = 0;
            for (int k=0;k<degree.length;k++){
                if (degree[k] == 0){
                    queue.offer(k);
                    cnt++;
                }
            }

            // begin topo
            while (!queue.isEmpty()){
                // 删除一个无前驱的node
                int node = queue.poll();
                for (int f =0;f<graph[node].size();f++){
                    int next = (int)graph[node].get(f);
                    // 下一个层次的node的入度都减一
                    degree[next]--;
                    // 如果入度为0，则加入下一个层级
                    if (degree[next] == 0){
                        queue.offer(next);
                        // 最终如果所有的点都能进入排序，则说明该图无环
                        cnt ++;
                    }
                }
            }


            if (cnt == num)
                return true;
            else
                return false;
        }}


    class Solution {
        // 采用邻接链表的方式来存储图
        public boolean canFinish(int num, int[][] pre) {
            boolean[] visited = new boolean[num];
            ArrayList[] graph = new ArrayList[num];
            for (int i=0;i<num;i++){
                graph[i] = new ArrayList<Integer>();
            }

            for (int i=0;i<pre.length;i++){
                graph[pre[i][0]].add(pre[i][1]);
            }
        // 对每一个节点进行dfs，如果有一个节点有环则return
            for (int i=0;i<num;i++){
                if (!dfs(i,graph,visited))
                    return false;
            }
            return true;



        }

        private boolean dfs(int node, ArrayList[] graph, boolean[] visited){
            if (visited[node])
                return false;
            visited[node] = true;
            // 对每一个节点所联通的节点进行dfs遍历，每访问一个节点就更新访问数组
            // 若该节点访问过后是联通的，可以回退一个节点
            for (int i=0;i<graph[node].size();i++){
                if(!dfs((int)graph[node].get(i),graph,visited))
                    return false;
            }
            visited[node] = false;
            return true;
        }
    }
}
