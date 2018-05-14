public class MaxSubArr_53 {
    class Solution1 {
        public int maxSubArray(int[] nums) {
            // BF
            if (nums.length == 0 || nums == null)
                return 0;
            int lastSum;
            int maxSum = nums[0];
            for (int i= 0; i<nums.length;i++ ){
                lastSum = 0;
                for (int j= i; j<nums.length;j++){
                    lastSum += nums[j];
                    maxSum = Math.max(lastSum, maxSum);
                }

            }
            return maxSum;

        }
    }

    class Solution2 {
        public int maxSubArray(int[] nums) {
            // Kadane Algo
            // find the max of cur+lastMax,cur
            // or can be seen as find sum<0
            if (nums.length == 0 || nums == null)
                return 0;
            int lastSum = nums[0];
            int maxSum = nums[0];
            for (int i=1;i<nums.length;i++){
                lastSum = Math.max(nums[i],nums[i]+lastSum);
                if (lastSum > maxSum)
                    maxSum = lastSum;
            }
            return maxSum;
        }
    }
}
