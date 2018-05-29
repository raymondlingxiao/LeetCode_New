public class LevelOrderTrav2_107 {
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> result = new LinkedList<List<Integer>>();
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            if (root == null)
                return result;
            queue.offer(root);
            while (!queue.isEmpty()){
                int size = queue.size();
                List<Integer> layer = new LinkedList<Integer>();
                for (int i=0;i<size;i++){
                    TreeNode node = queue.poll();
                    layer.add(node.val);
                    if (node.left != null)
                        queue.offer(node.left);
                    if (node.right != null)
                        queue.offer(node.right);
                }
                result.add(0,layer);
            }
            return result;

        }
    }
}
