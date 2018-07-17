public class Num1Bits_191 {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int cnt = 0;
            // 这里不能是n>0,因为2147483648在java中是最大的数，表示为-2147483648作为输入
            while (n != 0){
                int digit = n & 1;
                if (digit == 1)
                    cnt ++;
                //由于这里有负数，所以得用unsigned operation >>>
                n>>>=1;
            }
            return cnt;
        }
    }
}
