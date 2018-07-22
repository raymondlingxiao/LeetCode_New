public class BinTreePath_257 {
    /**
     * 对于递归问题，思路应该开阔一些，如不能使用return来得到最终的结果
     * 可以将需要更新的参数，通过传参的方式来进行更新
     * }
     */
    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<String>();
            if (root == null)
                return result;
            String path = "";
            this.helper(root,path,result);
            return result;
        }

        private void helper(TreeNode root, String path, List<String> result){
            if (root.left == null && root.right == null){
                path += root.val;
                result.add(path);
            }
            if (root.left != null)
                this.helper(root.left, path + root.val +"->", result);
            if (root.right != null)
                this.helper(root.right, path + root.val + "->", result);

        }
    }
}
