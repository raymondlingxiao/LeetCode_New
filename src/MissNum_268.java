public class MissNum_268 {
    class Solution {
        public int missingNumber(int[] nums) {
            if (nums.length == 0)
                return -1;
            int n = nums.length;
            int total = (0+n)*(1+n)/2;
            for (int num: nums){
                total -= num;
            }
            return total;
        }
    }
}
