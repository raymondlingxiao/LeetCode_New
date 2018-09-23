public class BST2DoubleLinkedList_426 {
    /*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
    class Solution {
        public Node treeToDoublyList(Node root) {
            if (root == null)
                return root;
            convert(root);
            Node leftNode = root;
            // find head
            while (leftNode.left != null){
                leftNode = leftNode.left;
            }

            // find tail
            Node rightNode = root;
            while (rightNode.right != null){
                rightNode = rightNode.right;
            }

            // link to cycle
            rightNode.right = leftNode;
            leftNode.left = rightNode;

            // return head
            return leftNode;

        }

        // find max of left
        private Node maxOfLeft(Node node){
            if (node == null)
                return null;
            while (node.right != null){
                node = node.right;
            }
            return node;
        }

        // find min of right
        private Node minOfRight(Node node){
            if (node == null)
                return null;
            while (node.left != null){
                node = node.left;
            }
            return node;
        }

        private void convert(Node node){
            if (node == null || (node.left == null && node.right == null))
                return ;
            // store original unprocessed value
            Node tempLeft = node.left;
            Node tempRight = node.right;

            // get new left and right
            node.left = maxOfLeft(node.left);
            node.right = minOfRight(node.right);

            // process on the remainings
            convert(tempLeft);
            convert(tempRight);

            // after done with the remainings, connect nodes to their previous (upper) nodes
            if (node.right != null)
                node.right.left = node;
            if (node.left != null)
                node.left.right = node;
        }
    }
}
