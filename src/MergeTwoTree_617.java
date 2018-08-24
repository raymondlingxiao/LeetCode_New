public class MergeTwoTree_617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        // use array in the queue to manipulate at the same time
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.offer(new TreeNode[]{t1, t2});

        while (!queue.isEmpty()) {
            TreeNode[] nodes = queue.poll();
            // merge 2 into 1 when it is not null
            if (nodes[1] == null)
                continue;
            // nodes[0] must not be null
            nodes[0].val += nodes[1].val;
            // make sure nodes[0] will be null
            if (nodes[0].left == null)
                nodes[0].left = nodes[1].left;
            else
                queue.offer(new TreeNode[]{nodes[0].left, nodes[1].left});
            if (nodes[0].right == null)
                nodes[0].right = nodes[1].right;
            else
                queue.offer(new TreeNode[]{nodes[0].right, nodes[1].right});

        }
        return t1;

        public TreeNode mergeTrees (TreeNode t1, TreeNode t2){
            if (t2 == null)
                return t1;
            if (t1 == null)
                return t2;
            TreeNode newNode = new TreeNode(t1.val += t2.val);
            newNode.left = mergeTrees(t1.left, t2.left);
            newNode.right = mergeTrees(t1.right, t2.right);
            return newNode;
        }
    }
}
