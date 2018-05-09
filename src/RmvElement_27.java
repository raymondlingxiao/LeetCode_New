public class RmvElement_27 {
    class Solution {
        public int removeElement(int[] nums, int val) {
            //use two pointers at the front and the end
            //find val from left first, then swap
            // The bad thing is to deal carefully with the crossed field
            // of two pointers
            if (nums.length == 0)
                return 0;
            int count = 0;
            int front = 0;
            int end = nums.length-1;
            while (front <= end){
                if (nums[front] == val){
                    count ++;
                    while (nums[end]==val && front < end){
                        count ++;
                        end --;
                    }
                    nums[front] = nums[end];
                    nums[end] = val;
                    end--;
                }
                front ++;
            }
            return nums.length-count;
        }
    }
    class Solution2 {
        public int removeElement(int[] nums, int val) {
            // same as the No.26
            // two pointers both from the start
            // find the non-target digit
            // put them at the front
            int index = 0;
            for (int i=0;i<nums.length;i++){
                if (nums[i] != val){
                    nums[index++] = nums[i];
                }
            }
            return index;
        }
    }

}
