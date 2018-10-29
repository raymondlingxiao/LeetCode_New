public class SerializeandDeserializeBinaryTree_297 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
    /*
      序列化的思想是利用dfs的preorder遍历得到一个完整地序列，遇到null的地方可以直接存储null即可
      反序列化的思想是利用list这个结构，每次都返回list的首元素，作为上一个节点的左节点和右节点，然后依次删除掉list的首元素
    */
        public String serialize(TreeNode root) {
            return serializeHelper(root,"");
        }

        private String serializeHelper(TreeNode root, String str){
            if (root == null){
                str +="null,";
                return str;
            }
            // preorder add node
            str += root.val + ",";
            str = serializeHelper(root.left, str);
            str = serializeHelper(root.right, str);

            return str;


        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] data_ = data.split(",");
            List<String> list = new LinkedList<>(Arrays.asList(data_));
            return desHelper(list);
        }

        private TreeNode desHelper(List<String> list){
            if (list.get(0).equals("null")){
                list.remove(0);
                return null;
            }

            int val = Integer.valueOf(list.get(0));
            TreeNode root = new TreeNode(val);
            list.remove(0);

            root.left = desHelper(list);
            root.right = desHelper(list);

            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
