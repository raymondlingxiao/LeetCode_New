public class RotateArr_189 {
    class Solution {
        // public void rotate(int[] nums, int k) {
        // ot-3n
        //     while (k > 0){
        //         int mov = nums[nums.length-1];
        //         for(int i=nums.length-1;i>0;i--){
        //             nums[i] = nums[i-1];
        //         }
        //         nums[0] = mov;
        //         k --;
        //     }
        // }

        public void rotate(int[] nums, int k){
            // 这里是防止k过大，多次进行
            k %= nums.length;
            this.reverse(nums,0,nums.length-1);
            this.reverse(nums,0,k-1);
            this.reverse(nums,k,nums.length-1);
        }
        private void reverse(int[] nums, int start,int end){
            while (start < end){
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
                start ++;
                end --;
            }
        }
    }
}
