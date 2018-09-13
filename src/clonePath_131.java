public class clonePath_131 {
    /**
     * Definition for undirected graph.
     * class UndirectedGraphNode {
     *     int label;
     *     List<UndirectedGraphNode> neighbors;
     *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
     * };
     */
    public class Solution {

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        //Queue<Integer> queue = new LinkedList<>();
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            if(node == null) return null;
            if(map.containsKey(node)) return map.get(node);
            UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
            map.put(node, clone);

            for(UndirectedGraphNode child : node.neighbors) {
                clone.neighbors.add(cloneGraph(child));
            }
            return clone;
        }


        private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            return clone(node);
        }

        private UndirectedGraphNode clone(UndirectedGraphNode node){
            if (node == null)
                return null;

            if (map.containsKey(node.label))
                return map.get(node.label);
            // 如果没有copy当前的元素，则开始拷贝
            UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
            // 在进入下一层的dfs之前，先将当前的状态保存起来，避免死循环
            map.put(copy.label,copy);

            for (UndirectedGraphNode neighbor: node.neighbors){
                copy.neighbors.add(clone(neighbor));
            }

            return copy;
        }
    }
}
