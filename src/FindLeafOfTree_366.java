import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class FindLeafOfTree_366 {
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
        /*
         The idea is to find the level for each node
         when the level of each node is found, just add the node value to its level list
        */
        public List<List<Integer>> findLeaves(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            getLevel(root,res);
            return res;

        }

        private int getLevel(TreeNode root, List<List<Integer>> res){
            // level = prev_level+1
            // so level should start from 0
            if (root == null)
                return -1;

            // cur level for this node
            int level = Math.max(getLevel(root.left,res),getLevel(root.right,res))+1;

            // initialize the inner list if not exists
            if (res.size() < level+1)
                res.add(new ArrayList<>());

            // add node to its level list
            res.get(level).add(root.val);

            return level;

        }
    }
}
