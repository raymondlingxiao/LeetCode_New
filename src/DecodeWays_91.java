public class DecodeWays_91 {
    class Solution {
        public int numDecodings(String s) {
            int m = s.length();
            int[] memo = new int[m+1];
            // bottom-up, m represents how many chars in processing from right end to the left
            // the formular should change into fm = fm+1 + fm+2, since the index starts from the max
            memo[m] = 1;
            if (s.charAt(m-1) == '0')
                memo[m-1] = 0;
            else
                memo[m-1] = 1;

            // to avoid IndexOutOfBounds, use substring instead of charAt
            for (int i=m-2;i>=0;i--){
                Integer oneChar = Integer.valueOf(s.substring(i,i+1));
                Integer twoChars = Integer.valueOf(s.substring(i,i+2));
                // dp
                if (oneChar <=9 && oneChar >0)
                    memo[i] += memo[i+1];
                if (twoChars <= 26 && twoChars  >= 10)
                    memo[i] += memo[i+2];

            }

            return memo[0];
        }
    }
}
