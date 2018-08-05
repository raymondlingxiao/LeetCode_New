public class CountBits_338 {
    /**
     * 1.popCount去计算每一个数字的1有多少个
     * 2.利用规律,一个数的个数px = p(x/2) + (x%2);
     * */
    class Solution {
        public int[] countBits(int num) {
            int[] res = new int[num+1];
            for (int i=0;i<=num;i++){
                res[i] = popCount(i);
            }
            return res;

        }

        private int popCount(int x){
            int count = 0;
            while ( x != 0){
                int digit = x&1;
                if (digit == 1)
                    count ++;
                x>>=1;
            }
            return count;
        }
    }

    class Solution2 {
        public int[] countBits(int num) {
            int[] res = new int[num+1];

            for (int i=1;i<=num;i++){
                //P(x) = P(x/2) + (x%2)
                res[i] = res[i>>1] + (i&1);
            }
            return res;
        }

    }
}
