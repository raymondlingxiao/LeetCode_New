public class ConsBSTpreInorder_105 {
    /**
     * 1.递归
     * 利用preorder的第一个元素为根节点,找到根节点在inorder中的坐标,从instart到根节点的index的为左子树的大小
     * 由此可以得到preorder的根节点的右节点与左节点,依次递归
     */
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            //recursive way
            return helper(0,0,inorder.length-1,preorder,inorder);

        }

        private TreeNode helper(int prestart, int instart, int inend, int[] preorder, int[] inorder){
            if (prestart >= preorder.length || instart > inend)
                return null;
            TreeNode root = new TreeNode(preorder[prestart]);
            int rootIndex = 0;
            for (int i=0;i<inorder.length;i++){
                if (inorder[i] == root.val){
                    rootIndex = i;
                    break;
                }
            }

            //left
            root.left = helper(prestart +1, instart, rootIndex-1,preorder,inorder);
            //right
            root.right = helper(prestart+rootIndex-instart+1, rootIndex+1,inend,preorder,inorder);
            return root;
        }
    }

    class Solution2 {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            // deal with edge case(s)
            if (preorder.length == 0) {
                return null;
            }

            // build a map of the indices of the values as they appear in the inorder array
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }

            // initialize the stack of tree nodes
            Stack<TreeNode> stack = new Stack<>();
            int value = preorder[0];
            TreeNode root = new TreeNode(value);
            stack.push(root);

            // for all remaining values...
            for (int i = 1; i < preorder.length; i ++) {
                // create a node
                value = preorder[i];
                TreeNode node = new TreeNode(value);

                if (map.get(value) < map.get(stack.peek().val)) {
                    // the new node is on the left of the last node,
                    // so it must be its left child (that's the way preorder works)
                    stack.peek().left = node;
                } else {
                    // the new node is on the right of the last node,
                    // so it must be the right child of either the last node
                    // or one of the last node's ancestors.
                    // pop the stack until we either run out of ancestors
                    // or the node at the top of the stack is to the right of the new node
                    TreeNode parent = null;
                    while(!stack.isEmpty() && map.get(value) > map.get(stack.peek().val)) {
                        parent = stack.pop();
                    }
                    parent.right = node;
                }
                stack.push(node);
            }

            return root;
        }
    }
}
