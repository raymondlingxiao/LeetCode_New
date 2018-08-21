public class MinInRotateArr_153 {
    class Solution {
        public int findMin(int[] nums) {
            int leftMin = nums[0];
            int left = 0;
            int right = nums.length-1;
            while (left < right){
                int mid = left +(right - left)/2;
                if (nums[mid] >= leftMin){
                    left = mid +1;
                    continue;
                }
                if (nums[mid] < nums[right])
                    right = mid;
            }
            return Math.min(leftMin,nums[left]);
        }
    }
}
