public class JumpGame_55 {
    class Solution {
        // 后遍历
        public boolean canJump(int[] nums) {
            int last = nums.length-1;
            for (int i=nums.length-2;i>=0;i--){
                if (nums[i]+i >= last)
                    last = i;
            }
            return last == 0;
        }
    }
    //从前往后看,max为下一个可以到达的最大的位置
    //如果此前位置大于最大位置,并且这个i不是末尾
    //说明无法达到终点
    class Solution2 {
        public boolean canJump(int[] A) {
            int max = 0;
            for(int i=0;i<A.length;i++){
                if(i>max) {return false;}
                max = Math.max(A[i]+i,max);
            }
            return true;
        }
    }
}
