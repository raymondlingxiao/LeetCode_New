public class SearchRotatedArr_33 {
    class Solution {
        public int search(int[] nums, int target) {
            if (nums.length == 0)
                return -1;
            int low = 0;
            int hi = nums.length-1;

            // 这里取=，最后就不需要在-1那里加另外的判断low是不是等于target
            while (low <= hi){
                int mid = low+(hi-low)/2;

                if (nums[mid] == target)
                    return mid;
                // 这里是可以取等于的，因为并不是传统的二分的mid与target进行比较
                // 所有mid与target都不能去等于
                if (nums[low] <= nums[mid]){
                    if (target < nums[mid] && target >= nums[low])
                        hi = mid -1;
                    else
                        low = mid + 1;
                }
                else{
                    if (target > nums[mid] && target <= nums[hi])
                        low =mid +1;
                    else
                        hi = mid -1;
                }
            }
//            if (target == nums[low])
//                return low;
            return -1;
        }
    }
}
