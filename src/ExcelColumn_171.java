public class ExcelColumn_171 {
    class Solution {
        public int titleToNumber(String s) {
            // 看作是26为进为的规则
            StringBuilder str = new StringBuilder(s);
            int sum = 0;
            for (int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                int n = str.length()-i-1;
                sum += (int)(ch-'A'+1) * Math.pow(26,n);
            }

            return sum;
        }
    }
}
