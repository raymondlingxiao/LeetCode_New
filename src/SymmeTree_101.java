public class SymmeTree_101 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            // iterative way
            if (root == null)
                return true;
            if (root.left == null && root.right == null)
                return true;
            if (root.left == null || root.right == null)
                return false;
            Deque<TreeNode> stack1 = new ArrayDeque<TreeNode>();
            Deque<TreeNode> stack2 = new ArrayDeque<TreeNode>();
            stack1.push(root.left);
            stack2.push(root.right);
            while (!stack1.isEmpty()&&!stack2.isEmpty()){
                TreeNode node1 = stack1.pop();
                TreeNode node2 = stack2.pop();
                if (node1.val != node2.val)
                    return false;
                else{
                    if (node1.left != null)
                        stack1.push(node1.left);
                    if (node2.right != null)
                        stack2.push(node2.right);
                    if (stack1.size() != stack2.size())
                        return false;
                    if (node1.right != null)
                        stack1.push(node1.right);
                    if (node2.left != null)
                        stack2.push(node2.left);
                    if (stack1.size() != stack2.size())
                        return false;
                }
            }
            return true;
        }
    }

    class Solution2 {
        public boolean isSymmetric(TreeNode root) {
            // Recursion
            if (root == null)
                return true;
            return isMirror(root.left, root.right);

        }
        private boolean isMirror(TreeNode a, TreeNode b){
            if (a == null && b == null)
                return true;
            if (a == null || b == null)
                return false;
            if (a.val == b.val)
                return isMirror(a.left,b.right) && isMirror(a.right,b.left);
            return false;
        }
    }
}
