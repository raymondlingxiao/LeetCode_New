public class IntersecTwoArray_349 {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set = new HashSet<>();
            Arrays.sort(nums2);
            for (int num:nums1){
                if (binarySearch(num,nums2))
                    set.add(num);
            }
            int[] res = new int[set.size()];
            int i=0;
            for (Integer num:set){
                res[i++] = num;
            }
            return res;

        }

        private boolean binarySearch(int target, int[] nums){
            if (nums == null || nums.length == 0)
                return false;
            int start = 0;
            int end = nums.length-1;

            while (start+1<end){
                int mid = start + (end-start)/2;
                if (nums[mid] == target)
                    return true;
                if (nums[mid] < target)
                    start = mid;
                if (nums[mid] > target)
                    end = mid;
            }

            if (nums[start] == target)
                return true;
            if (nums[end] == target)
                return true;
            else
                return false;
        }
    }
}
