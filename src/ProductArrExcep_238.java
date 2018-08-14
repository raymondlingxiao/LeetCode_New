public class ProductArrExcep_238 {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            // traverse back and forth

            int prefix = 1;
            int[] res = new int[nums.length];
            for (int i=0;i<res.length;i++){
                res[i] = prefix;
                prefix *= nums[i];
            }

            int back = 1;
            for (int i=res.length-1;i>=0;i--){
                res[i] = res[i] * back;
                back *= nums[i];
            }

            return res;
        }
    }
}
