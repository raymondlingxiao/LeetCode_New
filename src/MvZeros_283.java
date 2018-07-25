public class MvZeros_283 {

    /**
     * On2
    * */
    public void moveZeroes(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                for(int j=i; j<nums.length; j++){
                    if(nums[j]!=0){
                        int tmp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = tmp;
                        break;
                    }
                }
            }
        }
    }
    /**
     * On 这个方法利用j指针，永远指向左边第一个0，最后i指针将遇到的所有非0元素
     * 与第一个0替换，这样就实现了交换的功能
     * */
    class Solution {
        public void moveZeroes(int[] nums) {
            int j = 0;
            for(int i=0; i<nums.length; i++){
                if(nums[i]!=0){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    j++;
                }
            }
        }
    }
    /**
     * On 将所有非零的元素依次和0元素的位置覆盖
     * 同时先暂时不改变非零元素位置的值，统一最后覆盖
     * */
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

}
