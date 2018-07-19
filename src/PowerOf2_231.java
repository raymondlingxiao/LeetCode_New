public class PowerOf2_231 {
    class Solution {
        // 采用次方的做法
        public boolean isPowerOfTwo(int n) {
            int i = 0;
            while (Math.pow(2,i) < n){
                i++;
            }
            return (Math.pow(2,i)==n);
        }

    }

    //采用bit上的规律来实现
    // eg. 8 = 1000 7 = 0111, 8&7 = 0
    class Solution2 {
        public boolean isPowerOfTwo(int n) {
            return (n>0 && (n&(n-1))==0);
        }
    }
}
