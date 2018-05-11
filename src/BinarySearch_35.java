public class BinarySearch_35 {
    class Solution1 {
        public int searchInsert(int[] nums, int target) {
            // Naive way
            if (nums == null || nums.length == 0)
                return 0;
            for (int i=0; i< nums.length; i++){
                if (target == nums[i])
                    return i;
                if (target > nums[i]){
                    if (i< nums.length-1 && target < nums[i+1] || i == nums.length-1)
                        return i+1;
                }
                else if (target < nums[i]){
                    if (i>0 && target > nums[i-1])
                        return i-1;
                    if (i == 0)
                        return 0;
                }
            }
            return 0;

        }
    }

    public int searchInsert(int[] nums, int target) {
        // Binary Search
        if (nums == null || nums.length == 0)
            return 0;
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = (left + right)/2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target)
                right = mid -1;
            if (nums[mid] < target)
                left = mid + 1;
        }
        return left;
    }

    class Solution2 {
        // Enhanced O(n) Naive
        public int searchInsert(int[] nums, int target) {
            for(int i=0;i<nums.length;i++){
                if(target<=nums[i]) return i;
            }
            return nums.length;
        }
    }


}
