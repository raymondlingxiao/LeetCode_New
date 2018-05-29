public class CovertedSortedArr_BST_108 {
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            // BF way complete Binary tree
            if (nums.length == 0)
                return null;
            return setNode(nums,0,nums.length-1);
        }

        private TreeNode setNode(int[] nums, int left, int right){
            if (left < 0 || right < 0 || left > right)
                return null;
            int mid = left + (right-left)/2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = setNode(nums, left, mid-1);
            node.right = setNode(nums, mid+1,right);
            return node;
        }
    }
}
