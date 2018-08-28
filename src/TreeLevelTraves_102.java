public class TreeLevelTraves_102 {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if (root == null)
                return res;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int count = 1;
            while (!queue.isEmpty()){
                List<Integer> temp = new LinkedList<>();
                while (count != 0){
                    TreeNode node = queue.poll();
                    temp.add(node.val);
                    if (node.left != null){
                        queue.offer(node.left);
                    }
                    if (node.right != null){
                        queue.offer(node.right);
                    }
                    count --;
                }
                count = queue.size();
                res.add(new LinkedList<Integer>(temp));
            }
            return res;

        }
    }
}
