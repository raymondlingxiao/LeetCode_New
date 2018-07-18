public class HouseRobber_198 {
    class Solution {
        public int rob(int[] nums) {
            // DP formular must be known at first
            // 此处要计算n个数最大的和，先求得n-1个数的和与n-2个数加上最后一个数的和
            // 由此采用bottom-up，先求一个数递增
            // fn = max{fn-1,fn-2+num[n-1]}
            if (nums.length == 0)
                return 0;
            if (nums.length == 1)
                return nums[0];
            //store value
            int[] result = new int[nums.length];
            result[0] = nums[0];
            result[1] = Math.max(nums[0],nums[1]);

            for (int i=2;i<nums.length;i++){
                result[i] = Math.max(result[i-1],result[i-2]+nums[i]);
            }
            return result[result.length-1];


        }
    }
}
