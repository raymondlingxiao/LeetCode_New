public class ReverseBits_190 {
    public class Solution {
        // you need treat n as an unsigned value
        //每次取出n的最后一位数放到result中，每次放到result中的时候需要先左移动
        //空出位置后，在|最后一位数字
        public int reverseBits(int n) {
            int result = 0;
            for (int i = 0;i<32;i++){
                int end = n & 1;
                n >>= 1;
                result <<=1;
                result |= end;
            }
            return result;
        }
    }
}
