public class MaxSubArrProduct_152 {
    class Solution {
        public int maxProduct(int[] nums) {
            if (nums.length == 0 || nums == null)
                return -1;
            int max = Integer.MIN_VALUE;
            for(int i=0;i<nums.length;i++){
                int product = nums[i];
                for (int j=i+1;j<nums.length;j++){
                    if (product > max)
                        max = product;
                    product *= nums[j];
                }
                max = Math.max(product,max);
            }
            return max;
        }
    }
}
