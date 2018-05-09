public class RmvDupSortedArr_26 {
    class Solution1 {
        public int removeDuplicates(int[] nums) {
            if(nums.length == 0)
                return 0;
            int result = 0;
            int last = Integer.MAX_VALUE;
            int index = 0;
            // find the element which is different from the previous one
            for (int i=0;i<nums.length;i++){
                if (nums[i]!=last){
                    result ++;
                    nums[index++] = nums[i];
                    last = nums[i];
                }
            }
            return result;
        }
    }
    class Solution2 {
        public int removeDuplicates(int[] nums) {
            // solve the initial value problem
            if(nums.length == 0)
                return 0;
            int index = 0;
            // find the element which is different from the previous one
            for (int i=1;i<nums.length;i++){
                if (nums[i]!=nums[index]){
                    nums[++index] = nums[i];
                }
            }
            return ++index;
        }
    }
}
