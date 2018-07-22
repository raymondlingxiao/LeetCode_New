public class LowestComAncst_235 {
    /**
     * 利用平衡二叉树的特点，可以得到思路，凡是当q p都大于父节点的值或者其中有一个节点的值
     * 等于父节点的时候，该父节点为所求点
     * 如不是平衡二叉树的结构，则需找到到q p的路径，最后一个共同节点为所求点
     * }
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // recursion
            if ((p.val - root.val) * (q.val - root.val) <= 0)
                return root;
            if (p.val < root.val && q.val < root.val)
                return lowestCommonAncestor(root.left,p,q);
            if (p.val > root.val && q.val > root.val)
                return lowestCommonAncestor(root.right,p,q);
            return null;
        }
    }
}
