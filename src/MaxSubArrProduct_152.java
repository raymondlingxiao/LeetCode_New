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

    // o(n)
    class Solution2 {
        public int maxProduct(int[] nums) {
            if (nums.length == 0 || nums == null)
                return -1;
            int max = nums[0];
            int imax = nums[0];
            int imin = nums[0];

            for (int i=1;i<nums.length;i++){
                if (nums[i] < 0){
                    int temp = imax;
                    imax = imin;
                    imin = temp;
                }

                // previous product
                imax = Math.max(nums[i],imax*nums[i]);
                imin = Math.min(nums[i],imin*nums[i]);

                max = Math.max(max,imax);
            }
            return max;
        }
    }
}
