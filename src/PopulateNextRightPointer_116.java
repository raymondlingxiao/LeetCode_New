public class PopulateNextRightPointer_116 {
    /**
     * 1. recursive
     * 2. iterative
     */
    public class Solution {
        public void connect(TreeLinkNode root) {
            if (root == null)
                return;
            if (root.right != null && root.left != null){
                root.left.next = root.right;
                if (root.right.left != null && root.left.right != null){
                    root.left.right.next = root.right.left;
                    root.left.left.next = root.left.right;
                    root.right.left.next = root.right.right;
                }
                connect(root.left);
                connect(root.right);
            }
            else return;
        }
    }

    public class Solution2 {
        public void connect(TreeLinkNode root) {
            if (root == null)
                return;
            TreeLinkNode head = root;
            while (head != null){
                TreeLinkNode cur = head;
                while (cur != null){
                    if (cur.right != null)
                        cur.left.next = cur.right;
                    if (cur.right != null && cur.next != null)
                        cur.right.next = cur.next.left;
                    cur = cur.next;
                }
                head = head.left;
            }

        }
    }
}
