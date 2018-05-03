public class BinaryTreePreorderTraversal_144 {

    class RecrusionSolution {
        private List<Integer> list = new LinkedList<>();

        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null)
                return list;
            else
                list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            return list;
        }
    }

    class NormalSolution {
        public List<Integer> preorderTraversal(TreeNode root) {
            LinkedList<Integer> list = new LinkedList<>();
            if (root == null)
                return list;
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            while (!stack.empty()){
                TreeNode node = stack.pop();
                list.add(node.val);
                if (node.right != null)
                    stack.push(node.right);
                if (node.left != null)
                    stack.push(node.left);
            }
            return list;
        }
    }
}
