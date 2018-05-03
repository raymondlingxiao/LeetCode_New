public class BinaryTreeInOrderTrav_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Deque<TreeNode> stack  = new ArrayDeque<>();
        while (root != null || stack.peek()!=null){
            // push all left nodes into stack
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            // get root for every subtree
            // transfer recursion into loops
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    class Solution_Compare {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null)
                return result;
            Deque<TreeNode> stack  = new ArrayDeque<>();
            TreeNode node = root;
            while (node != null || stack.peek() != null){
                // push left nodes
                this.pushLeftNode(stack, node);
                // get the order
                node = stack.pop();
                result.add(node.val);
                node  = node.right;

            }
            return result;
        }

        //push all left nodes
        public void pushLeftNode(Deque<TreeNode> stack, TreeNode node){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
        }
    }

    class Solution_Recursion {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null)
                return result;
            Deque<TreeNode> stack  = new ArrayDeque<>();
            // push left nodes
            this.pushLeftNode(stack, root);
            // get the order
            while (stack.peek() != null){
                TreeNode node = stack.pop();
                result.add(node.val);
                result.addAll(this.inorderTraversal(node.right));
            }
            return result;
        }

        //push all left nodes
        public void pushLeftNode(Deque<TreeNode> stack, TreeNode node){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
        }
    }
}
