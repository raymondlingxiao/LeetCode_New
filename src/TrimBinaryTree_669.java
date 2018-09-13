public class TrimBinaryTree_669 {
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
        private List<Integer> list = new ArrayList<>();
        public TreeNode trimBST(TreeNode root, int L, int R) {
            // build inorder nodes
            inorder(root);
            List<Integer> list2 = new ArrayList<>();
            for (Integer num:list){
                if (num>=L && num<=R)
                    list2.add(num);
            }
            // build bst tree
            return buildBst(0,list2.toArray().length-1,list2.toArray());
        }

        private TreeNode buildBst(int s, int t, Object[] nums){
            if (s > t)
                return null;
            int mid = s + (t-s)/2;
            TreeNode node = new TreeNode((int)nums[mid]);
            node.left = buildBst(s,mid-1,nums);
            node.right = buildBst(mid+1,t,nums);

            return node;
        }

        private void inorder(TreeNode root){
            if (root == null)
                return;
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
    }
}
