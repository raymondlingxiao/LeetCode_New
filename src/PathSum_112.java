public class PathSum_112 {
    class Solution1 {
        //use no recursive solution
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null)
                return false;
            Stack<TreeNode> stackNode = new Stack<>();
            Stack<Integer> stackValue = new Stack<>();

            stackNode.push(root);
            stackValue.push(root.val);
            while (!stackNode.isEmpty()){
                TreeNode node = stackNode.pop();
                int value = stackValue.pop();
                if (node.left == null && node.right == null && value == sum)
                    return true;
                else{
                    if (node.right != null){
                        stackNode.push(node.right);
                        stackValue.push(node.right.val + value);
                    }
                    if (node.left != null){
                        stackNode.push(node.left);
                        stackValue.push(node.left.val + value);
                    }
                }
            }
            return false;
        }
    }

    class Solution2 {

        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null)
                return false;
            if (root.left == null && root.right == null && sum - root.val == 0)
                return true;
            else
                return (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val));
        }
    }
}
