public class DiameterOfBST_543 {
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
        int max = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            maxDepth(root);
            return max;
        }

        private int maxDepth(TreeNode root){
            if (root == null)
                return 0;

            // find the max depth of this root
            // then we should find the left max and right max, then compare them
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);

            // update the max diameter for every node along the path
            max = Math.max(max,left+right);

            // return max depth of a node
            return Math.max(left,right)+1;
        }
    }
}
