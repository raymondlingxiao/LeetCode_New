public class IntegerToString {
    class Solution {
        private final String[] Less_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

        public String numberToWords(int num) {
            if (num == 0)
                return "Zero";
            int i = 0;
            String word = "";
            // 最大的情况单独处理
            while (num > 0){
                // largest num set
                if (num%1000 !=0)
                    word = helper(num % 1000) + THOUSANDS[i] + " " +word;
                i++;
                num/= 1000;
            }
            return word.trim();
        }

        //利用一个helper来递归处理小于1000的数字
        private String helper (int num){
            if (num == 0)
                return "";
            if (num < 20)
                return Less_20[num] + " ";
            if (num < 100)
                return TENS[num/10] + " " +helper(num%10);
            else
                return Less_20[num/100] + " Hundred " + helper(num%100);
        }
    }
}
