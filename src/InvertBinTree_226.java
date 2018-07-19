public class InvertBinTree_226 {
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
        // 很典型的递归的例子
        // 找到返回点是关键
        public TreeNode invertTree(TreeNode root) {
            if (root == null)
                return root;
            TreeNode temp = invertTree(root.left);
            root.left = invertTree(root.right);
            root.right = temp;
            return root;

        }
    }
}
